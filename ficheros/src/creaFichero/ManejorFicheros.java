/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaFichero;

import java.io.*;

/**
 *
 * @author Víctor
 */
public class ManejorFicheros {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void agregarArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try {
            try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))){
                salida.println(contenido);
            }
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivo(String nombreArchivo){
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}
