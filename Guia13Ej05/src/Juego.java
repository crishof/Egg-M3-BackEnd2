import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        JuegoAdivinanza juego = new JuegoAdivinanza();
        juego.iniciarJuego();
    }
}

class JuegoAdivinanza {
    private final int numeroAdivinar;
    private int intentos;

    public JuegoAdivinanza() {
        Random random = new Random();
        numeroAdivinar = random.nextInt(500) + 1;
        intentos = 0;
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("Intenta adivinar un número entre 1 y 500.");

        while (true) {
            try {
                System.out.print("Ingrese un número: ");
                int numeroIngresado = scanner.nextInt();
                intentos++;

                if (numeroIngresado == numeroAdivinar) {
                    System.out.println("¡Felicitaciones! Has adivinado el número.");
                    System.out.println("Número de intentos: " + intentos);
                    break;
                } else if (numeroIngresado < numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else {
                    System.out.println("El número a adivinar es menor.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: El valor ingresado no es un número válido.");
                intentos++;
                scanner.next(); // Limpiar el valor inválido del scanner
            }
        }

        scanner.close();
    }

}
