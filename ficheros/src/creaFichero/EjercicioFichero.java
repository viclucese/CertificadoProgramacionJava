/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaFichero;

import static creaFichero.ManejorFicheros.agregarArchivo;
import static creaFichero.ManejorFicheros.crearArchivo;
import static creaFichero.ManejorFicheros.escribirArchivo;
import static creaFichero.ManejorFicheros.leerArchivo;

/**
 *
 * @author Víctor
 */
public class EjercicioFichero {
    
    
    public static void main(String[] args) {
        
        //System.out.println("Introduce el nombre del fichero a crear");
        //Scanner sc = new Scanner(System.in);
        //String nombre = sc.nextLine();
        
        //crearArchivo(nombre);
        //System.out.println("Introduce ahora el contenido en el archivo");
        //String contenido = sc.nextLine();
        
        var nombre = "prueba1.txt";
        var contenido = "Adios Mundo";
        
        crearArchivo(nombre);
        
        escribirArchivo(nombre, "Hola Mundo");
        
        agregarArchivo(nombre, contenido);
        
        leerArchivo(nombre);
        
    }
    
}
