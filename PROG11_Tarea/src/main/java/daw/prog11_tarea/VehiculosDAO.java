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
public class VehiculosDAO {
    
    public boolean insertarVehiculo(Connection con, String matricula, String bastidor, String marca, String modelo, int anio_mat, int dni_propietario){
        boolean resultado = false;
        Statement stmt = null;
        try {    
            stmt = con.createStatement();
            String sql = "INSERT INTO vehiculos (matricula, bastidor, marca, modelo, anio_mat, dni_propietario) "
                    + "VALUES ('" + matricula + "', '" + bastidor + "', '" + marca + "', '" + modelo + "', " + anio_mat + ", " + dni_propietario + ");";
            resultado = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean actualizarPropietario(Connection con, String matricula, int dni_propietario){
        boolean resultado = false;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "UPDATE vehiculos SET dni_propietario = " + dni_propietario + " "
                    + "WHERE matricula = '" + matricula + "';";
            stmt.executeUpdate(sql);
            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean eliminarVehiculo(Connection con, String matricula){
        boolean resultado = false;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "DELETE FROM vehiculos WHERE matricula = '" + matricula + "';";
            resultado = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public List<String> getInfoVehiculos(Connection con){
        List<String> informacion = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql = "SELECT matricula, bastidor, marca, modelo, anio_mat, vehiculos.dni_propietario, nombre, apellidos "
                    + "FROM vehiculos JOIN propietarios ON vehiculos.dni_propietario = propietarios.dni_propietario;";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String info = "";
                info += "[Matricula: " + rs.getString("matricula");
                info += ", bastidor: " + rs.getString("bastidor");
                info += ", marca: " + rs.getString("marca");
                info += ", modelo: " + rs.getString("modelo");
                info += ", anio_mat: " + rs.getInt("anio_mat");
                info += ", dni_propietario: " + rs.getInt("dni_propietario");
                info += ", nombre: " + rs.getString("nombre");
                info += ", apellidos: " + rs.getString("apellidos") + "]\n";
                informacion.add(info);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return informacion;
    }
    
    public List<String> getVehiculosPorMarca (Connection con, String marca){
        List<String> informacion = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql = "SELECT matricula, bastidor, marca, modelo, anio_mat, vehiculos.dni_propietario, nombre, apellidos "
                    + "FROM vehiculos JOIN propietarios ON vehiculos.dni_propietario = propietarios.dni_propietario "
                    + "WHERE marca = '" + marca + "';";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String info = "";
                info += "[Matricula: " + rs.getString("matricula");
                info += ", bastidor: " + rs.getString("bastidor");
                info += ", marca: " + rs.getString("marca");
                info += ", modelo: " + rs.getString("modelo");
                info += ", anio_mat: " + rs.getInt("anio_mat");
                info += ", dni_propietario: " + rs.getInt("dni_propietario");
                info += ", nombre: " + rs.getString("nombre");
                info += ", apellidos: " + rs.getString("apellidos") + "]\n";
                informacion.add(info);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return informacion;
    }
}
