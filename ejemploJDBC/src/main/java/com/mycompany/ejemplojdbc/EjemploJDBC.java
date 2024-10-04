/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplojdbc;
import java.sql.*;
/**
 *
 * @author Víctor
 */
public class EjemploJDBC {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection conexion;
        Statement sentencia;
        ResultSet resultado;

        System.out.println("Iniciando programa.");

        // Se carga el driver JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se pudo cargar el driver JDBC");
            return;
        }

        try {
            // Se establece la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            sentencia = conexion.createStatement();
            try {
                // Se elimina la tabla en caso de que ya existiese
                sentencia.execute("CREATE DATABASE ejemplojdbc");
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
            };

        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println("Creacion finalizada.");

    }
}
