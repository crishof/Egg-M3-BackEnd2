package entidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baraja {

    ArrayList<Carta> cartas = new ArrayList<>();
    ArrayList<Carta> cartasEnMano = new ArrayList<>();


    public void crearCartas() {

        String palo = "";

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 -> palo = "Espada";
                case 1 -> palo = "Oro";
                case 2 -> palo = "Copa";
                case 3 -> palo = "Basto";
            }
            for (int j = 1; j < 13; j++) {
                if (j == 8 || j == 9) {
                    continue;
                }
                cartas.add(new Carta(j, palo));
            }
        }
    }

    public void mostrarCartas() {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("Carta " + (i + 1) + ": " + cartas.get(i));
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
        System.out.println("Cartas mezcladas");
    }

    public void siguienteCarta() {

        if (cartas.size() > 0 ){
            Carta carta = cartas.get(0);
            System.out.println("Entrega: " + carta);
            cartasEnMano.add(carta);
            cartas.remove(carta);
        }
    }

    public void cartasDisponibles() {

        System.out.println("En el mazo quedan " + cartas.size() + " cartas disponibles");

    }

    public void darCartas() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese la cantidad de cartas que desea recibir");
        int cantidad = leer.nextInt();

        if (cantidad < cartas.size()) {

            for (int i = 0; i < cantidad; i++) {

                siguienteCarta();

            }
        } else {
            System.out.println("Cantidad de cartas insuficiente. Quedan " + cartas.size() + " cartas disponibles");
        }
    }

    public void cartasMonton() {

        System.out.println("Las cartas que ud tiene en mano son: ");
        for (Carta cartaAux : cartasEnMano) {
            System.out.println(cartaAux);

        }
    }

    public void menu() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int opcion;
        do {
            System.out.println(" = = = = MENU = = = = ");
            System.out.println("""
                    Ingrese la opcion deseada:
                    1. Barajar
                    2. Ver siguiente carta
                    3. Mostrar cartas disponibles
                    4. Dar cartas
                    5. Ver cartas entregadas
                    6. Ver cartas del mazo
                    0. SALIR""");

            System.out.println("________________________");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1 -> barajar();
                case 2 -> siguienteCarta();
                case 3 -> cartasDisponibles();
                case 4 -> darCartas();
                case 5 -> cartasMonton();
                case 6 -> mostrarCartas();
                case 0 -> System.out.println("Programa finalizado");

                default -> System.out.println("Opción invalida");

            }
        } while (opcion != 0);
    }

}
