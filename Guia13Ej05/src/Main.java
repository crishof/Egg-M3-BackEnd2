import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Escribir un programa en Java que juegue con el usuario a adivinar un número.

        La computadora debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo.

        Para ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
número que tiene que adivinar es mayor o menor que el que ha introducido el usuario.

Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
ha intentado adivinar el número.

Si el usuario introduce algo que no es un número, se debe controlar esa excepción e indicarlo por pantalla.

En este último caso también se debe contar el carácter fallido como un intento.

         */

        Random random = new Random();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int numeroUsuario = 0;
        int numeroPc = random.nextInt(1, 500);
        System.out.println("numeroPc = " + numeroPc);
        int i = 0;

        do {
            System.out.println("Ingrese un numero");
            i++;
            try {
                System.out.println();
                numeroUsuario = leer.nextInt();

                if (numeroUsuario < numeroPc) {
                    System.out.println("El numero es mayor");
                } else if (numeroUsuario == numeroPc) {
                    System.out.println("Has adivinado!!");
                    break;
                } else {
                    System.out.println("El numero es menor");
                }

            } catch (InputMismatchException e) {
                System.out.println("Dato incorrecto " + e.getMessage());
                            leer.next();

            }
//            numeroUsuario = 0;
            System.out.println("Intentos realizados: " + i);
            System.out.println("numeroUsuario = " + numeroUsuario);
        } while (numeroUsuario != numeroPc);
    }
}