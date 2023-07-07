import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionNumero {

    public static void main(String[] args) {
        /*
Defina una clase llamada DivisionNumero.
En el método main utilice un Scanner para leer dos números en forma de cadena.
A continuación, utilice el método parseInt() de la clase Integer,
para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int.
Por ultimo realizar una división con los dos numeros y mostrar el resultado.

Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
causar una excepción de tipo InputMismatchException,
el método Integer.parseInt() si la cadena no puede convertirse a entero, arroja una NumberFormatException y
además, al dividir un número por cero surge una ArithmeticException.
Manipule todas las posibles excepciones utilizando bloques try/catch para las distintas excepciones
         */

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        try {
            System.out.print("Ingrese el primer número: ");
            String numero1Str = scanner.next();

            System.out.print("Ingrese el segundo número: ");
            String numero2Str = scanner.next();

            int numero1 = Integer.parseInt(numero1Str);
            int numero2 = Integer.parseInt(numero2Str);

            int resultado = dividirNumeros(numero1, numero2);
            System.out.println("El resultado de la división es: " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingreso inválido. Debe ingresar números enteros.");
        } catch (NumberFormatException e) {
            System.out.println("Error: No se pudo convertir una cadena a entero.");
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        }
    }

    public static int dividirNumeros(int numero1, int numero2) {
        return numero1 / numero2;
    }
}