package Model;

/**
 *
 * @author Víctor
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/victorias_alonso";
    private static final String USER="root";
    private static final String PASS="";

    public Conexion() {
    }
    
    public static Connection obtenerConexion(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Conectado a la base de datos.");
            return conn;
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        } catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return null;
    }
    
    public static void cerrarConexion(Connection conn){
        if (conn != null){
            try{
                conn.close();
                System.out.println("Cerrando la conexion a la base de datos");
            } catch (SQLException ex){
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
