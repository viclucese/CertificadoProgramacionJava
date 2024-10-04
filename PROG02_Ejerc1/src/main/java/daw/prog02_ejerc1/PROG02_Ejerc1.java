/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc1;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc1 {

    public static void main(String[] args) {
        /* Escojo un int porque es el mínimo tipo de variable 
        *posible para almacenar al menos 35000       
        */
        final int maximo = 35000;
        
        //Escojo un string para mostrar el sí tiene carnet
        String carnet = "Sí"; //decido que tiene carnet en un principio
        
        //mes en numérico y como cadena
        String mes = "12";
        
        //Un string para el nombre y apellidos
        String nomyap = "Víctor Luis Cerrato Segovia";
        
        //un char para el sexo
        char sexo = 'V';
        
        //Milisegundos desde 1920, un long para almacenar un número entero
        long milisegundos = 1672949592; //corresponde a jueves, 05. enero 2023, 20:13:12
        
        //para el saldo de la cuenta un float por los decimales
        float saldoCuenta = 3456.78f;
        
        //un Long para la Distancia Júpiter - Tierra
        // La distancia total es 590.000.000 de km
        
        long distancia = 590000000;
        
        
        System.out.printf("El número máximo es %d \n", maximo);
        System.out.printf("El trabajador tiene carnet: %s \n", carnet);
        System.out.printf("Estamos en el mes número: %s \n", mes);
        System.out.printf("Mi nombre y apellidos es: %s \n", nomyap);
        System.out.printf("Soy de sexo: %s \n", sexo);
        System.out.printf("Los milisegundos desde el 01/01/1970 son: %d \n", milisegundos);
        System.out.printf("El salid de mi cuenta bancaria es: %.2f \n", saldoCuenta);
        System.out.printf("La distancia de la tierra a Júpiter es: %d \n", distancia);
    }
}
