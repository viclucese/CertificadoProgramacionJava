package daw.prog04_ejerc4;
import java.util.Scanner;
/**
 *
 * @author Víctor Luis Cerrato Segovia | DAW - @vanza 2022-2023
 */
public class Prog04_Ejerc4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInt = 5;
        int numMax = 10;
        int opcion;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Configurar");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el numero maximo generado: ");
                    numMax = scanner.nextInt();
                    System.out.print("Introduce el numero de intentos permitidos: ");
                    numInt = scanner.nextInt();
                    break;

                case 2:
                    int numOculto = (int) Math.floor(Math.random() * numMax + 1);
                    int intentos = 0;
                    int numIntroducido;

                    do {
                        intentos++;
                        System.out.print("Introduce un numero: ");
                        numIntroducido = scanner.nextInt();

                        if (numIntroducido < numOculto) {
                            System.out.println("El numero oculto es mayor.");
                        } else if (numIntroducido > numOculto) {
                            System.out.println("El numero oculto es menor.");
                        }

                    } while (numIntroducido != numOculto && intentos < numInt);

                    if (numIntroducido == numOculto) {
                        System.out.println("Has ganado!. Has necesitado " + intentos + " intentos.");
                    } else {
                        System.out.println("Perdiste!. Intentos consumidos.");
                    }

                    break;

                case 3:
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 3);
    }
}
