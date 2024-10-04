package daw.prog04_ejerc3;
import java.util.Scanner;

/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Prog04_Ejerc3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Dame un número: ");
            numeros[i] = scanner.nextInt();

            System.out.print("Números primos: ");

            for (int j = 2; j <= numeros[i]; j++) {
                boolean esPrimo = true;

                for (int k = 2; k < j; k++) {
                    if (j % k == 0) {
                        esPrimo = false;
                        break;
                    }
                }

                if (esPrimo) {
                    System.out.print(j + "-");
                }
            }

            System.out.println();
        }
    }
}
