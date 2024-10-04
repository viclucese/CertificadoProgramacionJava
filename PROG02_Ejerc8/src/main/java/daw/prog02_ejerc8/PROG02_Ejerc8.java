/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw.prog02_ejerc8;
import java.util.Scanner;

/**
 *
 * @author Víctor
 */
public class PROG02_Ejerc8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el número de alumnos matriculados en Programación: ");
        int prog = sc.nextInt();
        
        System.out.print("Introduce el número de alumnos matriculados en Entornos de Desarrollo: ");
        int entornos = sc.nextInt();
        
        System.out.print("Introduce el número de alumnos matriculados en Base de datos: ");
        int bd = sc.nextInt();
        
        int total_alumnos = prog + entornos + bd;
        
        double porcentaje_prog = (prog * 100.0) / total_alumnos;
        double porcentaje_entornos = (entornos * 100.0) / total_alumnos;
        double porcentaje_bd = (bd * 100.0) / total_alumnos;
        
        System.out.printf("Porcentaje de alumnos matriculados en Programación: %.1f%%\n", porcentaje_prog);
        System.out.printf("Porcentaje de alumnos matriculados en Entornos de Desarrollo: %.1f%%\n", porcentaje_entornos);
        System.out.printf("Porcentaje de alumnos matriculados en Base de datos: %.1f%%\n", porcentaje_bd);
    }
}
