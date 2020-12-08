package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ricardo Drudi
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Kardex?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void closeConnection(Connection con, PreparedStatement pst) {
        try {
            if (pst != null) pst.close();
            closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            closeConnection(con,pst);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
