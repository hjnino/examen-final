import java.util.InputMismatchException;
import java.util.Scanner;

public class Funciones {


    public static void numeroNoValido() {
        System.out.println("Número no válido, por favor verifique.");
    }

    public static void funcionSalir() {
        System.out.println("\n!Gracias¡");
        System.exit(0);
    }

    public static void funcionScannerEnter(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void funcionDigiteSuOpcion() {
        System.out.print("Digite su opción: ");
    }

    public static void funcionOpcionNoValida() {

        System.out.println("La opcion que ingresada no existe, intentalo nuevamente");
        System.out.print("Digite su opción: ");

    }

    public static void volviendoAlMenuPrincipal() {
        System.out.println("Volviendo al menú principal...");
    }
    public static Integer validacionInteger() {

        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;
        int opcion = -1;

        while (!entradaValida) {
            //System.out.print("Introduce una valor numerico: ");
            String input = scanner.nextLine();

            try {
                opcion = Integer.parseInt(input);
                entradaValida = true;  // Si la conversión es exitosa, salimos del bucle
            } catch (NumberFormatException e) {
                System.out.println("La entrada debe ser un número entero. Inténtalo nuevamente.");
                System.out.print("Digite su opción: ");
            }
        }

        return opcion;
    }

    public static double validaciondoouble() {

        Scanner scanner = new Scanner(System.in);
        double opcion = -1;

        while (true) {
            //System.out.print("Introduce una valor numerico: ");
            String input = scanner.nextLine();

            try {
                opcion = Double.parseDouble(input);
                break; // Si la conversión es exitosa, salimos del bucle
            } catch (NumberFormatException e) {
                System.out.println("La entrada debe ser un número. Inténtalo nuevamente.");
                System.out.print("Digite su opción: ");

            }
        }

        return opcion;
    }

}