/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog05_tarea;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class PROG05_Tarea {
    
    public static void mostrarMenuPrincipal(){
        System.out.println("---------------------------------");
        System.out.println("1) Nuevo cliente");
        System.out.println("2) Nuevo vehículo");
        System.out.println("3) Ver vehíchulos de un cliente");
        System.out.println("4) Listado de todos los clientes y sus vehículos");
        System.out.println("5) Salir");
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("TAREA PROG05");
        int op = 0;
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Validar validacion = new Validar();
        Scanner sc = new Scanner(System.in);
        while(op != 5){
            mostrarMenuPrincipal();
            op = sc.nextInt();
            switch(op){
                case 1 -> {
                    //Nuevo cliente
                    if(clientes.size() < 2){
                        boolean dniOK = false;
                        String dni = "";
                        while(!dniOK){
                            System.out.println("Introduzca el DNI:");
                            dni = sc.next();
                            dniOK = validacion.validarDNI(dni);
                            if(!dniOK){
                                throw new Exception ("El DNI introducido no es correcto.");
                            }
                        }
                        System.out.println("Introduzca el nombre:");
                        String nombre = sc.next();
                        System.out.println("Introduzca los apellidos:");
                        String apellidos = sc.next();
                        System.out.println("Introduzca su dirección:");
                        String direccion = sc.next();
                        System.out.println("Introduzca la población:");
                        String poblacion = sc.next();
                        System.out.println("Introduzca el codigo postal:");
                        int cp = sc.nextInt();
                        System.out.println("Introduzca el número de vehículos:");
                        int num_vehiculos = sc.nextInt();

                        Cliente nuevo = new Cliente(dni, nombre, apellidos, direccion, poblacion, cp, num_vehiculos);
                        clientes.add(nuevo);
                    }else{
                        System.out.println("Ya no hay espacio para más clientes");
                    }
                }
                case 2 -> {
                    //Nuevo vehiculo
                    boolean dniOK = false;
                    String dni_cliente = "";
                    while(!dniOK){
                        System.out.println("Introduzca el DNI del cliente asociado:");
                        dni_cliente = sc.next();
                        dniOK = validacion.validarDNI(dni_cliente);
                        if(!dniOK){
                            throw new Exception ("El DNI introducido no es correcto.");
                        }
                    }
                    boolean enc = false;
                    int max_veh = 0;
                    for (Cliente c : clientes){
                        if(c.getDni().equals(dni_cliente)){
                            enc = true;
                            max_veh = c.getNum_vehiculos();
                        }
                    }
                    
                    int totalVehiculos = 0;
                    for(Vehiculo v : vehiculos){
                        if(dni_cliente.equals(v.getDni_propietario())){
                            totalVehiculos++;
                        }
                    }
                    
                    if(enc && totalVehiculos < max_veh){
                        System.out.println("Introduzca la marca del vehículo:");
                        String marca = sc.next();
                        System.out.println("Introduzca la matricula del vehiculo:");
                        String matricula = sc.next();
                        System.out.println("Introduzca el numero de kilometros:");
                        int num_kil = sc.nextInt(1);
                        System.out.println("Introduzca la fecha de matriculacion:");
                        String fecha = sc.next();
                        Date conversion = Date.valueOf(fecha); //yyyy-mm-dd
                        System.out.println("Introduzca una descripcion del vehiculo:");
                        String desc = sc.nextLine();
                        System.out.println("Introduzca el precio del vehiculo:");
                        double precio = sc.nextDouble();
                        System.out.println("Introduzca el nombre del propietario:");
                        String nombre = sc.next();
                        
                        Vehiculo nuevo = new Vehiculo(marca,matricula,num_kil,conversion,desc,precio,nombre,dni_cliente);
                        vehiculos.add(nuevo);
                        
                    }else{
                        System.out.println("Lo sentimos, no existe ningún cliente con ese DNI o ya ha alcanzado el máximo numero de vehiculos");
                    }
                }
                case 3 -> {
                    //Ver vehiculos de un cliente
                    boolean dniOK = false;
                    String dni_cliente = "";
                    while(!dniOK){
                        System.out.println("Introduzca el DNI del cliente asociado:");
                        dni_cliente = sc.next();
                        dniOK = validacion.validarDNI(dni_cliente);
                        if(!dniOK){
                            throw new Exception ("El DNI introducido no es correcto.");
                        }
                    }
                    boolean enc = false;
                    for(Cliente c : clientes){
                        if(c.getDni().equals(dni_cliente)){
                            enc = true;
                        }
                    }
                    if(enc){
                        for(Vehiculo v : vehiculos){
                            if(v.getDni_propietario().equals(dni_cliente)){
                                System.out.println(v.toString());
                            }
                        }
                    }else{
                        System.out.println("No existe ningún cliente con ese DNI");
                    }
                }
                case 4 -> {
                    //Ver listado
                    for(Cliente c : clientes){
                        System.out.println(c.toString());
                        for(Vehiculo v : vehiculos){
                            if(v.getDni_propietario().equals(c.getDni())){
                                System.out.println(v.toString());
                            }
                        }
                    }
                }
                default -> {
                    op = 5;
                }
            }  
        }
        
    }
}
