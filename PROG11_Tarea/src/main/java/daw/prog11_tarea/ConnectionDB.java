/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog11_tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class ConnectionDB {
    
    public static Connection openConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/concesionario?user=admin&password=vacia";
            con = DriverManager.getConnection(connectionURL);
        }catch (SQLException e){
            System.out.println("SQL Exception: " + e.toString());
        }catch (ClassNotFoundException ce){
            System.out.println("Exception: " + ce.toString());
        }
        return con;
    }
    
    public static void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
