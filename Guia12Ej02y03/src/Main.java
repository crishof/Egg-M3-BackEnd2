import entidades.Electrodomestico;
import entidades.Lavadora;
import entidades.Televisor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("= = = = MENU = = = = ");
        System.out.println("Ingrese el numero de ejercicio que desea ejecutar (2/3)");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 2 -> {

                Lavadora lavadora1 = new Lavadora();
                Televisor tv1 = new Televisor();

                System.out.println("========== Lavadora ==========");
                lavadora1.crearLavadora();
                lavadora1.precioFinal();

                System.out.println("========== Televisor ==========");
                tv1.crearTelevisor();
                tv1.precioFinal();

                System.out.println("\n" + "Precio final:");
                System.out.println("Lavadora: $" + lavadora1.getPrecio());
                System.out.println("Televisor: $" + tv1.getPrecio());
            }
            case 3 -> {

                ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

                electrodomesticos.add(new Lavadora(500, "Rojo", 'A', 45, 30));
                electrodomesticos.add(new Lavadora(200, "Blanco", 'C', 34, 28));
                electrodomesticos.add(new Televisor(100, "Negro", 'E', 14, 32, true));
                electrodomesticos.add(new Televisor(200, "Azul", 'D', 34, 60, false));

                int i = 0;
                int j = 0;
                int precioTv = 0;
                int precioLavadora = 0;
                int precioElectro = 0;

                for (Electrodomestico aux : electrodomesticos) {

                    if (aux instanceof Televisor) {
                        i++;
                        aux.precioFinal();
                        System.out.println("Televisor " + i + " Precio final: " + aux.getPrecio());
                        precioTv += aux.getPrecio();
                        precioElectro += aux.getPrecio();
                    }
                    if (aux instanceof Lavadora) {
                        j++;
                        aux.precioFinal();
                        System.out.println("Lavadora " + j + " Precio final: " + aux.getPrecio());
                        precioLavadora += aux.getPrecio();
                        precioElectro += aux.getPrecio();
                    }
                }

                System.out.println("precioElectro = " + precioElectro);
                System.out.println("precioLavadora = " + precioLavadora);
                System.out.println("precioTv = " + precioTv);
            }
            default -> System.out.println("Opcion incorrecta");
        }
    }
}