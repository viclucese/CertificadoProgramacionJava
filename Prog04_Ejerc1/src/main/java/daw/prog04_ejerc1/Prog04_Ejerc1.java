/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog04_ejerc1;
import java.util.Scanner;
/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Prog04_Ejerc1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limite, num1, num2, resultado;

        System.out.print("Introduce el límite que se debe superar: ");
        limite = sc.nextInt();

        System.out.print("Introduce un número: ");
        num1 = sc.nextInt();

        System.out.print("Introduce otro número: ");
        num2 = sc.nextInt();

        resultado = num1 * num2;
        while (resultado <= limite) {
            System.out.println("Resultado: " + resultado);
            System.out.print("Introduce otro número: ");
            num1 = num2;
            num2 = sc.nextInt();
            resultado = num1 * num2;
        }

        System.out.println("El resultado final es " + resultado + " mayor que " + limite);

        sc.close();
    }
}
