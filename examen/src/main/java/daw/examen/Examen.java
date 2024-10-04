/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.examen;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Examen {
    
    private Connection connection;
    private Hospital hospital;
    
    public Examen(){
        this.hospital = new Hospital();
    }
    
    public void menuPrincipal(){
        System.out.println("---------------------------------------------");
        System.out.println("(1) Entrada Medicos ");
        System.out.println("(2) Entrada Cita");
        System.out.println("(3) Listado de las citas ordenadas por especialidades");
        System.out.println("(4) Salir");
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Examen Programación Víctor Cerrato Septiembre 2023");
        Examen exam = new Examen();
        exam.connection = ConnectionDB.openConnection();
        Scanner scan = new Scanner(System.in);
        int op = -1;
        while (op != 4){
            exam.menuPrincipal();
            op = scan.nextInt();
            switch(op){
                case 1:
                    System.out.println("Insertando médico");
                    System.out.println("Introduzca el nombre:");
                    String nombre = scan.next();
                    System.out.println("Introduzca el puesto:");
                    String puesto = scan.next();
                    System.out.println("Introduzca el id de la especialidad:");
                    int id_especialidad = scan.nextInt();
                    exam.hospital.insertarMedico(exam.connection, nombre, puesto, id_especialidad);
                    break;

                case 2:
                    System.out.println("Segunda opcion");
                    break;
                case 3:
                    System.out.println("Listado de Personas por compañias");
                    exam.hospital.mostrarListado(exam.connection);
                    List<String> personas = exam.hospital.mostrarListado(exam.connection);
                    for(String persona : personas){
                        System.out.println(persona);
                    }
                    break;
                default:
                    System.out.println("Saliendo del programa");
                    break;
                    
            }
        }
        
        ConnectionDB.closeConnection(exam.connection);
    }
}
