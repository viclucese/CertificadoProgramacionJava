/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.prog11_tarea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class PropietariosDAO {
    
    public boolean insertarPropietario(Connection con, int dni, String nombre, String apellidos, String direccion, String poblacion, String cod_postal){
        boolean resultado = false;
        Statement stmt = null;
        try {    
            stmt = con.createStatement();
            String sql = "INSERT INTO propietarios (dni_propietario, nombre, apellidos, direccion, poblacion, cod_postal) "
                    + "VALUES (" + dni + ", '" + nombre+ "', '" + apellidos + "', '" + direccion + "', '" + poblacion + "', '" + cod_postal + "');";
            resultado = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public List<String> getVehiculosDePropietario(Connection con, int dni){
        List<String> vehiculos = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql = "SELECT matricula, marca, modelo, anio_mat FROM vehiculos "
                    + "WHERE dni_propietario = " + dni + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String vehiculo = "";
                vehiculo += "[Matricula: " + rs.getString("matricula");
                vehiculo += ", marca: " + rs.getString("marca");
                vehiculo += ", modelo: " + rs.getString("modelo");
                vehiculo += ", anio_mat: " + rs.getInt("anio_mat") + "]\n";
                vehiculos.add(vehiculo);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    
    public int eliminarPropietario(Connection con, String dni){
        int eliminados = 0;
        Statement stmt = null;        
        try {
            stmt = con.createStatement();
            String sql = "DELETE FROM propietarios WHERE dni_propietario = " + dni +";";
            eliminados = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminados;
    }
}
