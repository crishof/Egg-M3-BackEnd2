package servicio;

import entidad.CantanteFamoso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CantanteServicio {

    public void mostrarLista(ArrayList<CantanteFamoso> cantantes) {

        for (CantanteFamoso singer : cantantes) {
            System.out.println(singer);
        }
    }

    public void menu(ArrayList<CantanteFamoso> cantantes){

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int opcion;
        do {
            System.out.println(" = = = MENU = = =");
        System.out.println("Ingrese la opcion deseada");
        System.out.println("1 para agregar un cantante");
        System.out.println("2 para mostrar todos los cantantes");
        System.out.println("3 para eliminar un cantante");
        System.out.println("4 para SALIR");
        System.out.println(" - - - - - - - - - - - - - - - - - ");
        opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    agregarCantante(cantantes);
                    break;
                case 2:
                    mostrarLista(cantantes);
                    break;
                case 3:
                    eliminarCantante(cantantes);
                    break;
                case 4:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion Incorrecta, reingrese");
                    opcion = leer.nextInt();
            }
        }while (opcion !=4);
    }

    public static void agregarCantante(ArrayList<CantanteFamoso> cantantes){

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String confirmacion;
        do {

            System.out.println("Ingrese el nombre del cantante que desea agregar");
            String nombre = leer.next();
            System.out.println("Ingrese el disco mas vendido del cantante");
            String disco = leer.next();
            cantantes.add(new CantanteFamoso(nombre, disco));
            System.out.println("Desea ingresar otro cantante? S/N");
            confirmacion = leer.next();

            if (!confirmacion.equalsIgnoreCase("S") && !confirmacion.equalsIgnoreCase("N")){
                System.out.println("Opcion incorrecta, reingrese");
                confirmacion = leer.next();
            }

        }while (!confirmacion.equalsIgnoreCase("N"));
    }

    public static void eliminarCantante(ArrayList<CantanteFamoso> cantantes){

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el cantante que desea eliminar");
        String borrar = leer.next();

        Iterator<CantanteFamoso> iterator = cantantes.iterator();

        while (iterator.hasNext()){
            CantanteFamoso singer = iterator.next();
            if ( singer.getNombre().equalsIgnoreCase(borrar)){
                iterator.remove();
                break;
            }
        }


    }
}
