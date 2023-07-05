package servicios;

import entidades.*;
import uttilidades.Comparadores;

import java.util.ArrayList;
import java.util.Scanner;

public class AlojamientoServicio {
    public ArrayList<Alojamiento> crearAlojamientos() {

        ArrayList<Alojamiento> alojamientos = new ArrayList<>();

        alojamientos.add(new Camping("El campo", "Los robles 31", "Carlos Paz", "Juan Carlos", false, 2500, 80, 5, true));
        alojamientos.add(new Camping("San Martin", "Camino Alto 4", "Rio grande", "Pepa Pig", true, 1800, 40, 3, false));
        alojamientos.add(new Residencia("Los Arboles", "Ruta provincial 3", "Mendoza", "Coqui", true, 5000, 20, true, true));
        alojamientos.add(new Residencia("Los Tamales", "Costanera 1", "Bariloche", "Saruman", false, 3200, 15, false, false));
        alojamientos.add(new HotelCuatro("NH", "9 de julio 25", "Buenos Aires", "Pablo Escobar", 40, 80, 8, 0, 'A', "La frita", 45));
        alojamientos.add(new HotelCuatro("Continental", "Av Santos 31", "Jujuy", "Tom Hanks", 22, 80, 3, 0, 'B', "La llama", 20));
        alojamientos.add(new HotelCinco("Arvis", "Franco suizo 33", "Malaga", "Paco Rabane", 60, 150, 14, 0, 'A', "Mar Isco", 50, 5, 10, 15));
        alojamientos.add(new HotelCinco("Ramada", "Av Costanera", "Miramar", "Carlos Suarez", 35, 60, 9, 0, 'B', "El pulpo manco", 34, 2, 6, 8));


        return alojamientos;
    }

    public void mostrarAlojamientos(ArrayList<Alojamiento> alojamientos) {

        System.out.println("= = = = ALOJAMIENTOS DISPONIBLES  = = = =");
        System.out.println();
        for (Alojamiento aux : alojamientos) {
            System.out.println(aux);
            System.out.println("________________________________");
        }
    }

    public void campingsConResto(ArrayList<Alojamiento> alojamientos) {

        System.out.println("= = = = CAMPINGS CON RESTO  = = = =");
        System.out.println();
        for (Alojamiento aux : alojamientos) {
            if (aux instanceof Camping) {
                if (((Camping) aux).isResto()) {
                    System.out.println(aux);
                }
            }
        }
    }

    public void residenciaDescuento(ArrayList<Alojamiento> alojamientos) {

        System.out.println("= = = = RESIDENCIAS CON DESCUENTO GREMIO  = = = =");
        System.out.println();
        for (Alojamiento aux : alojamientos) {
            if (aux instanceof Residencia) {
                if (((Residencia) aux).isDescuentoGremio()) {
                    System.out.println(aux);
                }
            }
        }
    }

    public int valorRestaurante(int restoCapacidad) {
        int precio = 0;
        if (restoCapacidad < 30) precio = 10;
        if (restoCapacidad >= 30 && restoCapacidad <= 50) precio = 30;
        if (restoCapacidad > 50) precio = 50;
//        System.out.println("precio resto: " + precio);
        return precio;
    }

    public int valorGimnasio(char gimnasioTipo) {
        int precio = 0;
        if (gimnasioTipo == 'A') precio = 50;
        if (gimnasioTipo == 'B') precio = 50;
//        System.out.println("precio gim: " + precio);
        return precio;
    }

    public void calcularPrecioHabitacion(ArrayList<Alojamiento> alojamientos) {

        int precioHabitacion = 50;

        for (Alojamiento aux : alojamientos) {
//            System.out.println();
            if (aux instanceof Hotel) {
//            System.out.println("Detalle de precio del Alojamiento: " + aux.getName());}
                if (aux instanceof HotelCuatro) {
                    ((Hotel) aux).setPrecioHabitacion(precioHabitacion + (((HotelCuatro) aux).getCamasCant()));
//                System.out.println("Precio base + capacidad: " + ((HotelCuatro) aux).getPrecioHabitacion());
                    ((HotelCuatro) aux).setPrecioHabitacion(((HotelCuatro) aux).getPrecioHabitacion() + valorRestaurante(((HotelCuatro) aux).getRestoCapacidad()));
//                System.out.println("Precio sumando resto: " + ((HotelCuatro) aux).getPrecioHabitacion());
                    ((HotelCuatro) aux).setPrecioHabitacion(((HotelCuatro) aux).getPrecioHabitacion() + valorGimnasio(((HotelCuatro) aux).getGimnasioTipo()));
//                System.out.println("Precio sumando gim: " + ((HotelCuatro) aux).getPrecioHabitacion());
                }
                if (aux instanceof HotelCinco) {
                    ((HotelCinco) aux).setPrecioHabitacion(((HotelCinco) aux).getPrecioHabitacion() + (((HotelCinco) aux).getLimo() * 15));
//                System.out.println("Precio sumando limosinas: " + ((HotelCinco) aux).getPrecioHabitacion());
                }
            }
//            System.out.println("- - - - - - - - - - - -");
//            System.out.println();

        }
    }

    public void ordenarHotelesNombre(ArrayList<Alojamiento> alojamientos) {

        System.out.println("= = = = HOTELES ORDEN ALFABETICO  = = = =");
        System.out.println();
        alojamientos.sort(Comparadores.ordenarPorNombre);

        for (Alojamiento aux : alojamientos) {
            if (aux instanceof Hotel) System.out.println("aux = " + aux);
        }
    }

    public void ordenarHPrecioMayor(ArrayList<Alojamiento> alojamientos) {

        ArrayList<Hotel> hoteles = new ArrayList<>();
        for (Alojamiento aux : alojamientos) {
            if (aux instanceof Hotel) {
                hoteles.add((Hotel) aux);
            }
        }
        System.out.println("= = = = HOTELES POR MAYOR PRECIO = = = =");
        System.out.println();
        hoteles.sort(Comparadores.ordenarPorPrecio);

        for (Hotel aux : hoteles) {
            System.out.println("aux = " + aux);
        }
    }

    public void menu(ArrayList<Alojamiento> alojamientos){

        int opcion = 0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        do{
            System.out.println("""
                = = = MENU  = = = 
                Ingrese la opción que desea realizar
                1 - Ver todos los Alojamientos
                2 - Ver Campings con restaurant
                3 - Ver Residencias con descuento al gremio
                4 - Ver Hoteles ordenados por nombre
                5 - Ver Hoteles ordenados por precio mayor
                0 - SALIR""");

            opcion = scanner.nextInt();

            switch (opcion){

                case 1 -> mostrarAlojamientos(alojamientos);
                case 2 -> campingsConResto(alojamientos);
                case 3 -> residenciaDescuento(alojamientos);
                case 4 -> ordenarHotelesNombre(alojamientos);
                case 5 -> ordenarHPrecioMayor(alojamientos);
                default -> System.out.println("Opcion incorrecta, reingrese");
            }


        }while (opcion != 0);

    }
}