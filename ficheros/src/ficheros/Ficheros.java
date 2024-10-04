/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

/**
 *
 * @author Víctor
 */

import java.io.*;
import java.util.*;

public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        File archivo = new File ("prueba.txt");
//        
//        if(archivo.exists()){
//            System.out.println("El archivo existe");
//            if(archivo.canRead()){
//                System.out.println("El fichero se puede leer");
//            } else {
//                System.out.println("el fichero no se puede leer");
//            }
//        } else {
//            System.out.println("el fichero no existe");
//        }
        
//        try{
//            FileWriter F = new FileWriter("numeros.txt");
//            PrintWriter P = new PrintWriter(F);
//            for (int i = 0; i < 10; i++) {
//                P.println(i);
//            }
//            F.close();
//        } catch (Exception e){
//            System.err.println("Ha ocurrido un error");
//        }
            
        try {
            FileWriter archivo = new FileWriter ("salida.txt");
            Scanner sc = new Scanner(System.in);
            int valor;
            for (int i = 0; i < 10; i++) {
                System.out.println("Introduce un numero: ");
                valor = sc.nextInt();
                if (valor == 0) break;
                archivo.write(valor+"\n");
            }
            archivo.close();
        } catch (Exception e) {
            System.err.println("Error");
        }
        
    }
    
}
