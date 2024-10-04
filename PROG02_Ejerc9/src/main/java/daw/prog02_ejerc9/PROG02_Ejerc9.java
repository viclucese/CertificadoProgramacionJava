/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc9;
import java.util.Scanner;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        // Pedir el año a evaluar
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un año: ");
        int year = sc.nextInt();

        // Verificar si el año es bisiesto
        boolean bisiesto = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    bisiesto = true;
                }
            } else {
                bisiesto = true;
            }
        }

        // Mostrar el resultado
        if (bisiesto) {
            System.out.println(year + " es un año bisiesto.");
        } else {
            System.out.println(year + " no es un año bisiesto.");
        }
    }
}
