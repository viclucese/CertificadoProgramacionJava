/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog08_tarea;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class PROG08_Tarea {
    
    private Concesionario concesionario;
    
    public PROG08_Tarea(){
        this.concesionario = new Concesionario();
    }

    public void  pantallaPrincipal(){
        System.out.println("-------------------------------------------");
        System.out.println("Elija la opción deseada:");
        System.out.println("(1) Nuevo cliente");
        System.out.println("(2) Listar clientes");
        System.out.println("(3) Ventas vehículos");
        System.out.println("(4) Listar vehículos vendidos a un cliente");
        System.out.println("(5) Buscar vehículo");
        System.out.println("(6) Borrar vehículo");
        System.out.println("(7) Salir");
        System.out.println("-------------------------------------------");
    }
    
    public void nuevoCliente(){
        Cliente c = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Introduzca el nombre del cliente:");
        String nombre = scan.nextLine();
        System.out.println("Introduzca los apellidos del cliente:");
        String apellidos = scan.nextLine();
        System.out.println("Introduzca el dni del cliente:");
        String dni = scan.nextLine();
        c = new Cliente(nombre, apellidos, dni);
        
        System.out.println("Comprobando datos...");
        
        boolean datosCorrectos = true;
        String expReg = "[XYxy]?[0-9]{1,9}[A-Za-z]";
        Pattern p = Pattern.compile(expReg);
        Matcher m = p.matcher(dni);
        if(!m.matches()){
            System.out.println("ERROR! El formato del DNI no es correcto");
            datosCorrectos = false;
        }else if(nombre.length()>0){
            String [] numApellidos = apellidos.split(" ");
            if(numApellidos.length < 2){
                System.out.println("ERROR! Debe haber dos apellidos");
                datosCorrectos = false;
            }else{
                int numCaracteres = 0;
                for (String apellido : numApellidos){
                    numCaracteres += apellido.length();
                }
                numCaracteres += c.getNombre().length();
                if(numCaracteres > 40){
                    System.out.println("ERROR! El nombre y apellidos deben tener una longitud máxima de 40 caracteres");
                    datosCorrectos = false;
                }               
            }
        }
        
        if(datosCorrectos){
            System.out.println("Los datos introducidos son correctos.");
            System.out.println("Intentando insertar el nuevo cliente...");
            int resultado = this.concesionario.insertarCliente(c);
            switch(resultado){
                case 0:
                    System.out.println("El cliente ha sido insertado correctamente.");
                    break;
                case -1:
                    System.out.println("ERROR: El concesionario no acepta más clientes en este momento.");
                    break;
                case -2:
                    System.out.println("ERROR: Ya existe un cliente con dicho DNI.");
                    break;
            }
        }
        System.out.println("-------------------------------------------");
    }
    
    public void listarClientes(){
        System.out.println("-------------------------------------------");
        this.concesionario.listarClientes();
        System.out.println("-------------------------------------------");
    }
    
    public void listarVehiculosPorCliente(){
        System.out.println("-------------------------------------------");
        System.out.println("Escriba el dni del cliente:");
        Scanner scan = new Scanner(System.in);
        String dni = scan.nextLine();
        System.out.println("Comprobando existencia del cliente...");
        String resultado = this.concesionario.buscarCliente(dni);
        if(resultado == null){
            System.out.println("ERROR: No existe ningun cliente con ese dni.");
        }else{
            System.out.println("Cliente encontrado. Buscando vehículos asociados...");
            boolean enc = this.concesionario.listarVehiculos(dni);
            if(enc == false){
                System.out.println("ERROR: El cliente no tiene vehículos asociados.");
            }
        }
        System.out.println("-------------------------------------------");
    }
    
    public void ventasVehiculo(){
        System.out.println("-------------------------------------------");
        System.out.println("Introduzca el dni del propietario:");
        Scanner scan = new Scanner(System.in);
        String dni = scan.nextLine();
        String resultado = this.concesionario.buscarCliente(dni);
        if(dni == null){
            System.out.println("ERROR: No existe ningún cliente con dicho dni.");
        }else{
            System.out.println("Inserte la marca del vehículo:");
            String marca = scan.nextLine();
            System.out.println("Inserte la matrícula del vehículo:");
            String matricula = scan.nextLine();
            System.out.println("Comprobando matricula...");
            String expReg = "[0-9]{4}[A-Za-z]{3}";
            Pattern p = Pattern.compile(expReg);
            Matcher m = p.matcher(matricula);
            if(!m.matches()){
                System.out.println("ERROR: El formato de la matricula no es correcto.");
            }else{
                System.out.println("Isertando el nuevo vehículo...");
                Vehiculo v = new Vehiculo(dni, marca, matricula);
                int result = this.concesionario.insertarVehiculo(v);
                switch(result){
                    case 0:
                        System.out.println("El vehículo se ha insertado correctamente.");
                        break;
                    case -1:
                        System.out.println("ERROR: Se ha encontrado la matrícula en el registro.");
                        break;
                }
            } 
        }
        System.out.println("-------------------------------------------");
    }
    
    public void buscarVehiculo(){
        System.out.println("-------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca la matrícula del vehículo a buscar:");
        String matricula = scan.nextLine();
        System.out.println("Buscando vehículo...");
        String resultado = this.concesionario.buscarVehiculo(matricula);
        if(resultado == null){
            System.out.println("ERROR: No existe ningun vehiculo con dicha matricula.");
        }else{
            System.out.println(resultado);
        }
        System.out.println("-------------------------------------------");
    }
    
    public void borrarVehiculo(){
        System.out.println("-------------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca la matrícula del vehiculo a buscar:");
        String matricula = scan.nextLine();
        System.out.println("Buscando vehiculo...");
        if(this.concesionario.eliminarVehiculo(matricula)){
            System.out.println("Vehiculo eliminado correctamente.");
        }else{
            System.out.println("ERROR: No existe ningun vehiculo con dicha matricula.");
        }
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        PROG08_Tarea menu = new PROG08_Tarea();
        Cliente c = new Cliente("Irene", "Carrasco Santano", "76048517Y");
        Vehiculo v1 = new Vehiculo("76048517Y", "Nissan", "6754JCX");
        Vehiculo v2 = new Vehiculo("76048517Y", "Seat", "1691GYW");
        Vehiculo v3 = new Vehiculo("76048517Y", "Volkswagen", "2022DBZ");
        menu.concesionario.insertarCliente(c);
        menu.concesionario.insertarVehiculo(v1);
        menu.concesionario.insertarVehiculo(v3);
        menu.concesionario.insertarVehiculo(v2);
        int op = 0;
        Scanner scan = new Scanner(System.in);
        while(op != 7){
           menu.pantallaPrincipal();
           op = scan.nextInt();
            System.out.println("------------------> " + String.valueOf(op));
           switch(op){
               case 1:
                   menu.nuevoCliente();
                   break;
                
               case 2:
                   menu.listarClientes();
                   break;
                   
               case 3:
                   menu.ventasVehiculo();
                   break;
                   
               case 4:
                   menu.listarVehiculosPorCliente();
                   break;
                   
               case 5:
                   menu.buscarVehiculo();
                   break;
                   
               case 6:
                   menu.borrarVehiculo();
                   break;
                   
               default:
                   System.out.println("Saliendo del menú....");
                   break;
           }
        }       
    }
}
