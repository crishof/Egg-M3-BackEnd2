package servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AgendaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void agregarContacto(HashMap<String, Integer> agenda) {

        String nombre;
        int telefono;
        String check;
        do {
            System.out.println("Ingrese el nombre del contacto");
            nombre = leer.next();
            System.out.println("ingrese el numero de telefono");
            telefono = leer.nextInt();

            agenda.put(nombre, telefono);

            System.out.println("Desea agregar otro contacto? S/N");
            check = leer.next();

            if (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")) {
                System.out.println("Opcion incorrecta, reingrese S/N");
                check = leer.next();
            }

        } while (check.equalsIgnoreCase("S"));


    }

    public void mostrarAgenda(HashMap<String, Integer> agenda) {

        for (Map.Entry<String, Integer> entry : agenda.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", telefono: " + entry.getValue());
        }

    }

    public void buscarContacto(HashMap<String, Integer> agenda) {
        System.out.println("Ingrese el contacto que desea buscar");
        String contacto = leer.next();

        for (Map.Entry<String, Integer> contactobuscar : agenda.entrySet()) {
            if (agenda.containsKey(contacto)) {
                System.out.println("Nombre: " + contactobuscar.getKey() + "Telefono: " + contactobuscar.getValue());
                break;
            }
        }
    }

    public void ordenarContacto(HashMap<String, Integer> agenda) {

        TreeMap<String, Integer> agendaOrdenada = new TreeMap<>(agenda);

        for (Map.Entry<String, Integer> orden : agendaOrdenada.entrySet()) {
            System.out.println("Nombre: " + orden.getKey() + "Telefono: " + orden.getValue());
        }
    }

    public void menu(HashMap<String, Integer> agenda) {

        int opcion;
        do {
            System.out.println("= = = MENU = = =");
            System.out.println("Ingrese la opcion deseada");
            System.out.println("1 - agregar contacto");
            System.out.println("2 - mostrar Agenda");
            System.out.println("3 - buscar contacto");
            System.out.println("4 - ordenar alfabeticamente");
            System.out.println("5 - SALIR");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> agregarContacto(agenda);
                case 2 -> mostrarAgenda(agenda);
                case 3 -> buscarContacto(agenda);
                case 4 -> ordenarContacto(agenda);
                case 5 -> System.out.println("Programa finalizado");
                default -> {
                    System.out.println("Opcion Incorrecta, reingrese");
                    opcion = leer.nextInt();
                }
            }
        } while (opcion != 5);
    }
}
