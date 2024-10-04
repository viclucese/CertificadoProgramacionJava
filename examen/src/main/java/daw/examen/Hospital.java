/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.examen;

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
public class Hospital {
    public void funcion(){
        System.out.println("Probando conexion");
    }
    
    public boolean insertarMedico(Connection con, String nombre, String puesto, int id_especialidad ){
        boolean resultado = false;
        Statement stmt = null;
        
        if (consultaEspecialidad(con, id_especialidad)){
            
            try {
            stmt = con.createStatement();
            String sql = "INSERT INTO medicos (nombre, puesto, id_especialidad) "
                    + "VALUES ('" + nombre + "', '" + puesto + "', " + id_especialidad + ");";
            resultado = stmt.execute(sql);
            } catch (SQLException ex){
                Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
            }

            return resultado;
            
        } else {
            System.out.println("La especialidad no existe o no está dada de alta.");
        }
       
        return resultado;
    }
    
    public boolean consultaEspecialidad(Connection con, int id_especialidad){
        boolean resultado;
        Statement stmt = null;
        ResultSet rs = null;
        int contador = 0;
        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM especialidad WHERE id_especialidad = " + id_especialidad + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                contador++;
            }
        } catch (SQLException ex){
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultado = contador > 0;
        return resultado;
    }
    
    public List<String> mostrarListado(Connection con){
        List<String> informacion = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = """
                         SELECT `especialidad`.`denominacion`, `citas`.`fecha`, `citas`.`hora`, `pacientes`.`nombre`, `medicos`.`nombre`
                         FROM `especialidad`
                         \t, `citas`
                         \t, `pacientes`
                         \t, `medicos`; """;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String info = "";
                info += "[Especialidad: " + rs.getString("especialidad.denominacion");
                info += ", fecha de cita: " + rs.getString("citas.fecha");
                info += ", hora de cita: " + rs.getString("citas.hora");
                info += ", Nombre paciente: " + rs.getString("pacientes.nombre");
                info += ", Nombre medico: " + rs.getString("medicos.nombre")+ "]\n";
                informacion.add(info);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Examen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return informacion;
    }
}
