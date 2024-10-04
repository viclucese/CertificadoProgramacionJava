/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc7;
import java.util.Scanner;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el valor de C1: ");
        double c1 = sc.nextDouble();
        
        System.out.print("Introduce el valor de C2: ");
        double c2 = sc.nextDouble();
        
        double x = -c2 / c1;
        
        System.out.printf("El resultado es: %.4f%n", x);
    }
}
