package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Saida;

/**
 * @author Ricardo Drudi
 */
public class SaidaDAO {
    
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dmy = new SimpleDateFormat("ddd-MM-yyyy");
    private SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
    public int insert(Saida reg) {
        int codigo = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Saida ");
        sql.append("(Data,Produto,Cliente,Qtde,Valor) ");
        sql.append("VALUES (?,?,?,?,?) ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, ymd.format(reg.getData()));
            pst.setInt(2, reg.getProduto().getCodigo());
            pst.setInt(3, reg.getCliente().getCodigo());
            pst.setInt(4, reg.getQtde());
            pst.setDouble(5, reg.getValor());
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
    
    public List<Saida> selectAll() {
        List<Saida> lista = new ArrayList<Saida>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM Saida ");
        sql.append("ORDER BY Data ");
        try {
            con = ConnectionFactory.getConnection();
            pst = con.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                int rsCodigo = rs.getInt("Codigo");
                Date rsData;
                try {
                    rsData = ymdhms.parse(rs.getString("Data"));
                } catch (ParseException ex) {
                    rsData = null;  // erro na conversão da data do BD
                }
                int rsQtde = rs.getInt("Qtde");
                double rsValor = rs.getDouble("Valor");
                int rsProduto = rs.getInt("Produto");
                int rsCliente = rs.getInt("Cliente");
                lista.add(new Saida(rsCodigo,rsData,
                          new ProdutoDAO().selectByCodigo(rsProduto),
                          new ClienteDAO().selectByCodigo(rsCliente),
                          rsQtde,rsValor));
            }
        } catch (SQLException ex) {
            lista = null;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return lista;
    }    
    
    
}
