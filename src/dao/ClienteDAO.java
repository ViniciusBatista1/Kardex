package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 * @author Ricardo Drudi
 */
public class ClienteDAO {
    
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public int insert(Cliente reg) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Cliente ");
        sql.append("(CPF,Nome,Celular,Email) ");
        sql.append("VALUES (?,?,?,?) ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, reg.getCpf());
            pst.setString(2, reg.getNome());
            pst.setString(3, reg.getCelular());
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
        
    public boolean update(Cliente c) {
        boolean ok = true;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Cliente SET ");
        sql.append("CPF = ?, Nome = ?, Telefone = ?, Email = ? ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, c.getCpf());
            pst.setString(2, c.getNome());
            pst.setString(3, c.getCelular());
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

    public void delete(Cliente c) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Cliente ");
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

    public Cliente selectByCodigo(int codigo) {
        Cliente c = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Cliente ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCPF = rs.getString("CPF");
                String rsNome = rs.getString("Nome");
                String rsCelular = rs.getString("Celular");
                String rsEmail = rs.getString("Email");
                c = new Cliente(rsCodigo, rsCPF, rsNome, rsCelular, rsEmail);
            }
        } catch (SQLException ex) {
            c = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }

    public List<Cliente> selectByNome(String nome) {
        List<Cliente> lista = new ArrayList<Cliente>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Codigo,CPF,Nome,Celular,Email FROM Cliente ");
        sql.append("WHERE Nome LIKE ? ");
        sql.append("ORDER BY Nome ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1,"%"+nome+"%");
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCPF = rs.getString("CPF");
                String rsNome = rs.getString("Nome");
                String rsCelular = rs.getString("Celular");
                String rsEmail = rs.getString("Email");
                lista.add(new Cliente(rsCodigo, rsCPF, rsNome, rsCelular, rsEmail));
            }
        } catch (SQLException ex) {
            lista = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return lista;
    }

    public List<Cliente> selectAll() {
        return (selectAll("Nome"));
    }
    public List<Cliente> selectAll(String ordem) {
        List<Cliente> lista = new ArrayList<Cliente>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT Codigo,CPF,Nome,Celular,Email FROM Cliente ");
        sql.append("ORDER BY ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1,ordem);
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsCPF = rs.getString("CPF");
                String rsNome = rs.getString("Nome");
                String rsCelular = rs.getString("Celular");
                String rsEmail = rs.getString("Email");
                Cliente c = new Cliente(rsCodigo,rsCPF,rsNome,rsCelular,rsEmail);
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
