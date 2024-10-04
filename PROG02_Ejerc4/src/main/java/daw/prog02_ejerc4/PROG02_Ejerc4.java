/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc4;

import java.util.Scanner;
/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc4 {

    public static void main(String[] args) {
        int edad;
        String mayor;
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduzca su edad y pulse intro:");
        edad = leer.nextInt();
        //boolean mayor = edad > 18;
        mayor=(edad>18)?"Mayor de edad":"Menor de edad";
        System.out.println(mayor);
    }
}
