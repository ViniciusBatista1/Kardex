/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;
/**
 *
 * @author vinni
 */
public class FornecedorDAO {
    
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null; 

    public int insert(Fornecedor reg) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Fornecedor ");
        sql.append("(CNPJ,Nome,Telefone,Email) ");
        sql.append("VALUES (?,?,?,?) ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, reg.getCnpj());
            pst.setString(2, reg.getNome());
            pst.setString(3, reg.getTelefone());
            pst.setString(4, reg.getEmail());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        return codigo;
    }
        public boolean update(Fornecedor c) {
        boolean ok = true;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Fornecedor SET ");
        sql.append("CNPJ = ?, Nome = ?, Telefone = ?, Email = ? ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, c.getCnpj());
            pst.setString(2, c.getNome());
            pst.setString(3, c.getTelefone());
            pst.setString(4, c.getEmail());
            pst.setInt(5, c.getCodigo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ok = false;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return ok;
    }

        public void delete(Fornecedor c) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Fornecedor ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, c.getCodigo());
            pst.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
    }
        public Fornecedor selectByCodigo(int codigo) {
        Fornecedor c = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Fornecedor ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCnpj = rs.getString("CNPJ");
                String rsNome = rs.getString("Nome");
                String rsTelefone = rs.getString("Telefone");
                String rsEmail = rs.getString("Email");
                c = new Fornecedor(rsCodigo, rsCnpj, rsNome, rsTelefone, rsEmail);
            }
        } catch (SQLException ex) {
            c = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }

    public List<Fornecedor> selectByNome(String nome) {
        List<Fornecedor> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Codigo,CNPJ,Nome,Telefone,Email FROM Fornecedor ");
        sql.append("WHERE Nome LIKE ? ");
        sql.append("ORDER BY Nome ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1,"%"+nome+"%");
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCnpj = rs.getString("CNPJ");
                String rsNome = rs.getString("Nome");
                String rsTelefone = rs.getString("Telefone");
                String rsEmail = rs.getString("Email");
                lista.add(new Fornecedor(rsCodigo, rsCnpj, rsNome, rsTelefone, rsEmail));
            }
        } catch (SQLException ex) {
            lista = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return lista;
    }

    public List<Fornecedor> selectAll() {
        return (selectAll("Nome"));
    }
    public List<Fornecedor> selectAll(String ordem) {
        List<Fornecedor> lista = new ArrayList<Fornecedor>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Codigo,CNPJ,Nome,Telefone,Email FROM Fornecedor ");
        sql.append("ORDER BY ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1,ordem);
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCnpj = rs.getString("Cnpj");
                String rsNome = rs.getString("Nome");
                String rsTelefone = rs.getString("Telefone");
                String rsEmail = rs.getString("Email");
                Fornecedor c = new Fornecedor(rsCodigo,rsCnpj,rsNome,rsTelefone,rsEmail);
                lista.add(c);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        return lista;
    }
}
