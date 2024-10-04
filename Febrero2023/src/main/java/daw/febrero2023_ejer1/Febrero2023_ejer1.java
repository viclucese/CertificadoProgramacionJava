/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.febrero2023_ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Febrero2023_ejer1 {
    
    public static void main(String[] args) throws IOException {
        boolean condicionSalida = false;
        int iteraciones = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!condicionSalida){
            iteraciones++;
            System.out.println("Escriba la cadena:");
            String cadena = br.readLine();
            String[] palabras = cadena.split(" ");
            int firstWordLength = palabras[0].length();
            int lastWordLength = palabras[palabras.length - 1].length();
            if(firstWordLength > lastWordLength){
                condicionSalida = true;
            }
            
            String[] fragmentos = cadena.toLowerCase().split("la");
            int ocurrencias = fragmentos.length -1;
            if(cadena.endsWith("la")){
                ocurrencias++;
            }
            //Si "la" está una vez, tendremos 2 framentos,
            //si "la" está dos veces, tendremos 3... y así...
            System.out.println("La cadena " + iteraciones + " tiene " + ocurrencias + " la");
        }
        br.close();
    }
}
