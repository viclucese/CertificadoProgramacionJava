/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc5;
import java.util.Scanner;
/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de segundos: ");
        int segundos = sc.nextInt();

        int minutos = segundos / 60;
        int horas = minutos / 60;
        int dias = horas / 24;

        System.out.println(segundos + " segundos son " + minutos + " minutos, " + horas + " horas y " + dias + " días.");
    }
}
