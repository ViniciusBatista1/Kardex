package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 * @author Ricardo Drudi
 */
public class ProdutoDAO {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public int insert(Produto reg) {
        int codigo =0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PRODUTO");
        sql.append("(Descricao,Qtde,CustoMedio) ");
        sql.append("VALUES (?,?,?) ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, reg.getDescricao());
            pst.setInt(2, reg.getQtde());
            pst.setDouble(3, reg.getCustoMedio());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return codigo;
    }
    public boolean update(Produto c) {
        boolean ok = true;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Produto SET ");
        sql.append("Descricao = ?, Qtde = ?, CustoMedio = ?, ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1, c.getDescricao());
            pst.setInt(2, c.getQtde());
            pst.setDouble(3, c.getCustoMedio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ok = false;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return ok;
    }
    
     public void delete(Produto c) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM Produto ");
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
    
    public Produto selectByCodigo(int codigo) {
        Produto p = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Produto ");
        sql.append("WHERE Codigo = ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            if (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsDescricao = rs.getString("Descricao");
                int rsQtde = rs.getInt("Qtde");
                double rsCustoMedio = rs.getDouble("CustoMedio");
                p = new Produto(rsCodigo,rsDescricao,rsQtde,rsCustoMedio);
            }
        } catch (SQLException ex) {
            p = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return p;
    }
    
    public List<Produto> selectAll() {
        return (selectAll("Descricao"));
    }
    public List<Produto> selectAll(String ordem) {
        List<Produto> lista = new ArrayList<Produto>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Produto ");
        sql.append("ORDER BY ? ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setString(1,ordem);
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                String rsDescricao = rs.getString("Descricao");
                int rsQtde = rs.getInt("Qtde");
                double rsCustoMedio = rs.getDouble("CustoMedio");
                Produto c = new Produto(rsCodigo,rsDescricao,rsQtde,rsCustoMedio);
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
