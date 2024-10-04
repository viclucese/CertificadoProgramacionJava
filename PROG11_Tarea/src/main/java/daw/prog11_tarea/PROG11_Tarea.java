/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog11_tarea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class PROG11_Tarea {
    
    private Connection connection;
    private PropietariosDAO propDAO;
    private VehiculosDAO vehiDAO;
    
    public PROG11_Tarea(){
        this.propDAO = new PropietariosDAO();
        this.vehiDAO = new VehiculosDAO();
    }
    
    public boolean createTablePropietarios(){
        Statement stmt = null;
        boolean result = false;
        try {    
            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS propietarios ("
                    + "dni_propietario int(11) NOT NULL AUTO_INCREMENT,"
                    + "nombre varchar(30) NOT NULL,"
                    + "apellidos varchar(50) NOT NULL,"
                    + "direccion varchar(40) NOT NULL,"
                    + "poblacion varchar(40) NOT NULL,"
                    + "cod_postal varchar(6) NOT NULL,"
                    + "PRIMARY KEY (dni_propietario)"
                    + ") ENGINE = InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3;";
            result = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean createTableVehiculos(){
        Statement stmt = null;
        boolean result = false;
        try {    
            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS vehiculos("
                    + "matricula varchar(7) NOT NULL,"
                    + "bastidor varchar(17) NOT NULL,"
                    + "marca varchar(25) NOT NULL,"
                    + "modelo varchar(30) NOT NULL,"
                    + "anio_mat int(11) NOT NULL,"
                    + "dni_propietario int(11) NOT NULL,"
                    + "PRIMARY KEY (matricula),"
                    + "KEY dni_propietario (dni_propietario)"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
            result = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean alterTableVehiculos(){
        Statement stmt = null;
        boolean result = false;
        try {    
            stmt = connection.createStatement();
            String sql = "ALTER TABLE vehiculos "
                    + "ADD CONSTRAINT vehiculos_ibfk_1 FOREIGN KEY "
                    + "(dni_propietario) REFERENCES propietarios (dni_propietario);";
            result = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean insertIntoPropietarios(){
        Statement stmt = null;
        boolean result = false;
        try {    
            stmt = connection.createStatement();
            String sql = "INSERT INTO propietarios (dni_propietario, nombre, apellidos, direccion, poblacion, cod_postal) "
                    + "VALUES (1, 'Ramón', 'Sánchez Carrero', 'C/ Mayor, 5', 'Mérida', '06800'), "
                    + "(2, 'Juan', 'Sánchez González', 'C/ Menor, 34', 'Mérida', '06800');";
            result = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean insertIntoVehiculos(){
        Statement stmt = null;
        boolean result = false;
        try {    
            stmt = connection.createStatement();
            String sql = "INSERT INTO vehiculos (matricula, bastidor, marca, modelo, anio_mat, dni_propietario) "
                    + "VALUES ('3333DDD', '12356664', 'Ford', 'Focus blanco', 2015, 1), "
                    + "('4444DDD', '6558955', 'Audi', 'A6 azul cobalto', 2020, 2), "
                    + "('5555DDD', '4558955', 'Renault', 'Kangoo negro TDI', 2012, 2);";
            result = stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PROG11_Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) {
        PROG11_Tarea tarea = new PROG11_Tarea();
        tarea.connection = ConnectionDB.openConnection();
        
        /*
        CREACION E INICIALIZACIÓN DE LAS TABLAS
        
        tarea.createTablePropietarios();
        System.out.println("Tabla PROPIETARIOS creada correctamente.");
        tarea.createTableVehiculos();
        System.out.println("Tabla VEHICULOS creada correctamente.");
        tarea.alterTableVehiculos();
        System.out.println("Modificación de la tabla VEHICULOS realizada correctamente.");
        tarea.insertIntoPropietarios();
        System.out.println("Información de los propietarios insertada correctamente.");
        tarea.insertIntoVehiculos();
        System.out.println("Información de los vehículos insertada correctamente.");
        */
        
        Scanner scanner = new Scanner(System.in);
        //Insertar nuevo propietario
        //dni, nombre, apellidos, direccion, poblacion, cod_postal
        /*System.out.println("--------------------------------------------");
        System.out.println("INSERTAR NUEVO PROPIETARIO");
        System.out.println("Introduzca el DNI:");
        int dni = 3;
        System.out.println("Introduzca el nombre:");
        String nombre = "Irene";
        System.out.println("Introduzca los apellidos:");
        String apellidos = "Carrasco Santano";
        System.out.println("Introduzca la dirección:");
        String direccion = "Calle Manuel Castillo 72";
        System.out.println("Introduzca la poblacion:");
        String poblacion = "Cáceres";
        System.out.println("Introduzca el codigo postal:");
        String cod_postal = "10004";
        tarea.propDAO.insertarPropietario(tarea.connection, dni, nombre, apellidos, direccion, poblacion, cod_postal);
        System.out.println("--------------------------------------------");
        System.out.println();
        
       System.out.println("--------------------------------------------");
        System.out.println("RECUPERAR VEHICULOS DE PROPIETARIO");
        System.out.println("Introduzca el DNI:");
        int dni = 1;
        List<String> vehiculos = tarea.propDAO.getVehiculosDePropietario(tarea.connection, dni);
        for(String vehiculo : vehiculos){
            System.out.println(vehiculo);
        }
        System.out.println("--------------------------------------------");
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("INSERTAR VEHICULO");
        //matricula, bastidor, marca, modelo, anio_mat, dni_propietario
        System.out.println("Introduzca la matrícula:");
        String matricula = "6754JCX";
        System.out.println("Introduzca el bastidor:");
        String bastidor = "1234567";
        System.out.println("Introduzca la marca:");
        String marca = "Nissan";
        System.out.println("Introduzca el modelo:");
        String modelo = "Note";
        System.out.println("Introduzca el año de matriculación:");
        int anio_mat = 2015;
        System.out.println("Introduzca el dni del propietario:");
        int dni = 3;
        tarea.vehiDAO.insertarVehiculo(tarea.connection, matricula, bastidor, marca, modelo, anio_mat, dni);
        System.out.println("--------------------------------------------");
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("ACTUALIZAR PROPIETARIO DE VEHICULO");
        System.out.println("Introduzca la matricula:");
        String matricula = "3333DDD";
        System.out.println("Introduzca el nuevo dni:");
        int dni = 1;
        tarea.vehiDAO.actualizarPropietario(tarea.connection, matricula, dni);
        System.out.println("--------------------------------------------");
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("ELIMINAR VEHICULO");
        System.out.println("Introduzca la matricula:");
        String matricula = "6754JCX";
        tarea.vehiDAO.eliminarVehiculo(tarea.connection, matricula);
        System.out.println("--------------------------------------------");
        System.out.println();
        
        System.out.println("--------------------------------------------");
        System.out.println("VEHICULOS POR MARCA");
        System.out.println("Introduzca la marca del vehiculo:");
        String marca = "Ford";
        List<String> vehiculos = tarea.vehiDAO.getVehiculosPorMarca(tarea.connection, marca);
        for(String vehiculo : vehiculos){
            System.out.println(vehiculo);
        }
        System.out.println("--------------------------------------------");
        System.out.println();*/
        
        System.out.println("--------------------------------------------");
        System.out.println("REGISTRO COMPLETO DE VEHICULOS");
        List<String> vehiculos = tarea.vehiDAO.getInfoVehiculos(tarea.connection);
        for(String vehiculo : vehiculos){
            System.out.println(vehiculo);
        }
        System.out.println("--------------------------------------------");
        ConnectionDB.closeConnection(tarea.connection);
    }
}
