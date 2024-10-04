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
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        System.out.println("Hola mundo!");
        
        Connection conexion;
        Statement sentencia;

        System.out.println("Iniciando programa.");

        // Se carga el driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver JDBC");
            return;
        }

        try {
            // Se establece la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplojdbc", "root", "");
            sentencia = conexion.createStatement();
            try {
                // Se elimina la tabla en caso de que ya existiese
                sentencia.execute("DROP TABLE persona1");
            } catch (SQLException e) {
            };

            // Esto es código SQL
            sentencia.execute("CREATE TABLE persona ("
                    + "id_persona int not null,"
                    + " NOMBRE VARCHAR(15) NOT NULL, "
                    + " APELLIDO VARCHAR(30) NOT NULL, "
                    + " email varchar(45),"
                    + "telefono varchar (45)) ");
            sentencia.execute("INSERT INTO persona "
                    + "VALUES('1','JOSE','GONZALEZ','jg@correo.com','111222333')");
            sentencia.execute("INSERT INTO persona "
                    + "VALUES('2','PEDRO','GOMEZ','pg@correo.com','444555666')");
            sentencia.execute("INSERT INTO persona "
                    + "VALUES('3','ANA','PEREZ','ap@correo.com','777888999')");
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Creacion finalizada.");

    }
}
