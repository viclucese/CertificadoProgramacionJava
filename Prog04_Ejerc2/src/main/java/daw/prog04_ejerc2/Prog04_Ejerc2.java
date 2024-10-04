package daw.prog04_ejerc2;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
import java.util.Scanner;

public class Prog04_Ejerc2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int mayorPrimo = 0;
        int sumaPrimos = 0;

        do {
            System.out.print("Introduce un número: ");
            numero = scanner.nextInt();

            if (numero == 0) {
                System.out.println("El número es cero");
            } else if (numero > 0) {
                boolean esPrimo = true;

                for (int i = 2; i < numero; i++) {
                    if (numero % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }

                if (esPrimo) {
                    System.out.println(numero + " es primo");
                    sumaPrimos += numero;

                    if (numero > mayorPrimo) {
                        mayorPrimo = numero;
                    }
                } else {
                    System.out.println(numero + " no es primo");
                }
            }

        } while (numero >= 0);

        System.out.println("El mayor número primo obtenido es: " + mayorPrimo);
        System.out.println("La suma de los números primos introducidos es: " + sumaPrimos);
    }
}
