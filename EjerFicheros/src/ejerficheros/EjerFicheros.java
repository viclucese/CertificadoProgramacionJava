/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerficheros;

import java.io.*;
import java.util.*;
/**
 *
 * @author Víctor
 */
public class EjerFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            File O = new File(args[0]);
            Scanner s = new Scanner(O);
            try (FileWriter D = new FileWriter(args[1])){
                PrintWriter P = new PrintWriter(D);
                String linea;
                while(s.hasNextLine()){
                    linea = s.nextLine();
                    P.println(linea);
                }
            }
            System.out.println("Ficheros Creados");
        } catch (Exception e){
            System.err.println("Ocurrio un error al procesar ficheros");
        }
    }
    
}
