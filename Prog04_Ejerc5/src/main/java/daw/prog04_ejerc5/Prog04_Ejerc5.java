/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog04_ejerc5;
import java.util.Scanner;
/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Prog04_Ejerc5 {

    public static void main(String[] args) {
        int dividendo, divisor, divisiones = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Introduce el dividendo (-1 para salir): ");
            dividendo = sc.nextInt();
            if (dividendo == -1) break;

            System.out.print("Introduce el divisor (-1 para salir): ");
            divisor = sc.nextInt();
            if (divisor == -1) break;

            try {
                int resultado = dividendo / divisor;
                System.out.println("El resultado de la división es: " + resultado);
                divisiones++;
            } catch (ArithmeticException e) {
                System.out.println("Error: No se puede dividir entre cero.");
            }
        } while (true);

        System.out.println("Se han realizado " + divisiones + " divisiones.");
    }
}
