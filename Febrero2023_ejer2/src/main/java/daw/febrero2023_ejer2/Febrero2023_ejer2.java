/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.febrero2023_ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Febrero2023_ejer2 {
    
    private  int maxAsignaturas;
    private int maxProfesores;
    private List<Asignatura> asignaturas; 
    private List<Profesor> profesores;
    //Estos dos últimso podrían sustituirse por arrays también
    
    public Febrero2023_ejer2(){
        this.maxAsignaturas = 50;
        this.maxProfesores = 30;
        this.asignaturas = new ArrayList<>();
        this.profesores = new ArrayList<>();
    }
    
    public boolean comprobarNIF(String NIF){ //no se si es necesario, pero por si acaso lo dejamos hecho
        String expresionRegular = "[0-9]{8}[A-Za-z]{1}";
        Pattern p = Pattern.compile(expresionRegular);
        Matcher m = p.matcher(NIF);
        return m.matches();
    }
    
    public void menuPrincipal(){
        System.out.println("-------------------------------------");
        System.out.println("Elija la opción deseada:");
        System.out.println("(1) Entrar Asignatura");
        System.out.println("(2) Entrar Profesor");
        System.out.println("(3) Listar asignaturas de una especialidad con sus profesores");
        System.out.println("(4) Salir");
        System.out.println("-------------------------------------");
    }
    
    public void entrarAsignatura(BufferedReader br) throws IOException{
        System.out.println("-------------------------------------");
        if(this.asignaturas.size() == this.maxAsignaturas){
            System.out.println("ERROR: No se pueden introducir más asignaturas en el sistema.");
        }else{
            System.out.println("Introduzca el codigo de la asignatura:");
            int codigo = Integer.parseInt(br.readLine());
            System.out.println("Comprobando asignaturas...");
            boolean enc = false;
            for(Asignatura as : this.asignaturas){
                if(as.getCodigo() == codigo){
                    enc = true;
                }
            }
            if(enc){
                System.out.println("ERROR: Ya existe una asignatura con dicho codigo.");
            }else{
                System.out.println("El código introducido es válido.");
                System.out.println("Introduzca el nombre de la asignatura:");
                String nombre = br.readLine();
                System.out.println("Introduzca el curso al que pertenece:");
                int curso = Integer.parseInt(br.readLine());
                System.out.println("Introduzca el número de horas que ocupa:");
                int horas = Integer.parseInt(br.readLine());
                System.out.println("Introduzca la especialidad a la que pertenece:");
                String especialidad = br.readLine();
                System.out.println("Introduzca el NIF del profesor que imparte la asignatura:");
                String nif = br.readLine();
                if(comprobarNIF(nif)){
                    System.out.println("El formato es correcto.");
                    System.out.println("Comprobando el registro de profesores...");
                    enc = false;
                    String espe = "";
                    for(Profesor p : this.profesores){
                        if(p.getNif_profesor().equals(nif)){
                            enc = true;
                            espe = p.getEspecialidad();
                        }
                    }
                    if(enc){
                        System.out.println("Profesor con NIF " + nif + " encontrado");
                        System.out.println("Comprobando especialidad del profesor...");
                        if(especialidad.equals(espe)){
                            System.out.println("Las especialidades coinciden.");
                            System.out.println("Introduciendo asignatura en el sistema...");
                            Asignatura a = new Asignatura(codigo, nombre, curso, horas, especialidad, nif);
                            this.asignaturas.add(a);
                            System.out.println("Asignatura añadida correctamente.");
                        }else{
                            System.out.println("ERROR: Las especialidades no coinciden.");
                        }
                    }else{
                        System.out.println("ERROR: no existe ningún profesor con dicho NIF.");
                    }
                }else{
                    System.out.println("ERROR: el formado del NIF introducido no es correcto.");
                }
            } 
        } 
        System.out.println("-------------------------------------");
    }
    
    public void entrarProfesor(BufferedReader br) throws IOException{
        System.out.println("-------------------------------------");
        if(this.profesores.size() == this.maxProfesores){
            System.out.println("ERROR: Ya no pueden introducirse más profesores.");
        }else{
            System.out.println("Introduzca el nif del profesor:");
            String nif = br.readLine();
            System.out.println("Comprobando formato del nif introducido...");
            if(comprobarNIF(nif)){
                System.out.println("El nif introducido tiene un formato correcto.");
                System.out.println("Comprobando registro de profesores...");
                boolean enc = false;
                for(Profesor p : this.profesores){
                    if(p.getNif_profesor().equals(nif)){
                        enc = true;
                    }
                }
                if(enc){
                    System.out.println("ERROR: Ya existe un profesor con dicho NIF en el sistema.");
                }else{
                    System.out.println("No existe ningún profesor con dicho NIF. Continuando con el proceso...");
                    System.out.println("Introduzca el nombre y apellidos del profesor:");
                    String nombre = br.readLine();
                    System.out.println("Introduzca la especialidad del profesor:");
                    String especialidad = br.readLine();
                    System.out.println("Introduzca la edad del profesor:");
                    int edad = Integer.parseInt(br.readLine());
                    System.out.println("Añadiendo un nuevo profesor a la lista...");
                    Profesor pf = new Profesor(nif, nombre, especialidad, edad);
                    this.profesores.add(pf);
                    System.out.println("Profesor añadido al sistema correctamente");
                }
            }else{
                System.out.println("ERROR: El formato del nif introducido no es correcto.");
            }
        }
        System.out.println("-------------------------------------");
    }
    
    public void listarPorEspecialidad(BufferedReader br) throws IOException{
        System.out.println("-------------------------------------");
        System.out.println("Introduzca la especialidad por la que filtrar:");
        String especialidad = br.readLine();
        System.out.println("Comprobando registro del sistema...");
        for(Asignatura a : this.asignaturas){
            if(a.getEspecialidad().equals(especialidad)){
                System.out.println("###############################");
                System.out.println(a.toString());
                System.out.print("Impartida por: ");
                for(Profesor p : this.profesores){
                    if(a.getNif_profesor().equals(p.getNif_profesor())){
                        System.out.println(p.toString());
                    }
                }
                System.out.println("###############################");
            }
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) throws IOException {
        Febrero2023_ejer2 main = new Febrero2023_ejer2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = -1;
        while(op != 4){
            main.menuPrincipal();
            op = Integer.parseInt(br.readLine());
            System.out.println("------------------> " + op);
            switch(op){
                case 1:
                    //Insertar nueva asignatura
                    main.entrarAsignatura(br);
                    break;
                case 2:
                    //Insertar nuevo profesor
                    main.entrarProfesor(br);
                    break;
                case 3:
                    //Listar asginaturas y profesores de una misma especialidad
                    main.listarPorEspecialidad(br);
                    break;
                case 4:
                default:
                    break;
            }
        }
        br.close();
    }
}
