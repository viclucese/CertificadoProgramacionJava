package datos;
import java.sql.*;
/**
 *
 * @author Víctor
 */
public class conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ejemplojdbc"; 
    
    private static final String JDBC_USER = "root";
    
    private static final String JDBC_PASSWORD = "";
    
    //Metodo para realizar la conexion
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,JDBC_PASSWORD);
    }
    
    //Metodos para cerrar los objetos del tipo resultset, statement, y connection
    //sobrecargamos el metodo close (se llama igual pero recibe distintos parámetros)
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    //un objeto de tipo PreparedStatement se utiliza para ejecutar sentencias sql
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
