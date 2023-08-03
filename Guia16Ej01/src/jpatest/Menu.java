package jpatest;

import java.util.Scanner;
import servicios.AutorService;
import servicios.EditorialService;
import servicios.LibroService;

public class Menu {

    AutorService as = new AutorService();
    EditorialService es = new EditorialService();
    LibroService ls = new LibroService();

    public void general() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        do {

            System.out.println("""
                               
                               = = = = = MENU = = = = = 
                                                             
                               1 - Alta
                               2 - Baja
                               3 - Editar
                               4 - Buscar Autor
                               5 - Buscar Libro
                               5 - Creacion de un Cliente nuevo
                               6 - Registrar el prestamo de un libro
                               7 - Devolucion de un libro
                               8 - Busqueda de todos los prestamos de un Cliente
                               0 - SALIR
                               
                               = = = = = = = = = = = = = = =
                               
                               Ingrese la opcion deseada: """);

            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    alta();
                case 2:
                    baja();
                case 3:
                    modificar();
                case 4:
                    as.buscarAutorNombre();
                case 5:
                    buscarLibro();
                case 0:
                    System.out.println("Programa finalizado");

            }

        } while (opcion != 0);
    }

    public void alta() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion2;

        do {
            System.out.println("""
                               
                               = = = Menu alta = = = 
                               Ingrese la opcion deseada
                               1 - Alta de Libro
                               2 - Alta de Autor
                               3 - Alta de Editorial
                               0 - Volver al menu anterior
                               """);

            opcion2 = leer.nextInt();

            switch (opcion2) {

                case 1 ->
                    ls.guardarLibro();

                case 2 ->
                    as.guardarAutor();

                case 3 ->
                    es.guardarEditorial();

                default ->
                    System.out.println("Opcion incorrecta, reingrese");
            }

        } while (opcion2 != 0);
    }

    public void baja() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        do {
            System.out.println("""
                               
                               = = = Menu alta = = = 
                               Ingrese la opcion deseada
                               1 - Baja de Libro
                               2 - Baja de Autor
                               3 - Baja de Editorial
                               0 - Volver al menu anterior
                               """);

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 ->
                    ls.bajaLibro();

                case 2 ->
                    as.bajaAutor();

                case 3 ->
                    es.bajaEditorial();

                default ->
                    System.out.println("Opcion incorrecta, reingrese");
            }

        } while (opcion != 0);
    }

    public void modificar() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        do {
            System.out.println("""
                               
                               = = = Menu modificar Estado = = = 
                               Ingrese la opcion deseada
                               1 - Modificar Libro
                               2 - Modificar Autor
                               3 - Modificar Editorial
                               0 - Volver al menu anterior
                               """);

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 ->
                    ls.modificarLibro();

                case 2 ->
                    as.modificarAutor();

                case 3 ->
                    es.modificarEditorial();

                default ->
                    System.out.println("Opcion incorrecta, reingrese");
            }

        } while (opcion != 0);
    }

    public void buscarLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        do {
            System.out.println("Ingrese la opcion deseada"
                    + "1 - buscar por ISBN"
                    + "2 - buscar por Titulo"
                    + "3 - buscar por Autor"
                    + "4 - buscar por Editorial"
                    + "0 - volver");

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 -> {
                    ls.buscarLibroIsbn();
                }

                case 2 -> {
                    ls.buscarLibroTitulo();
                }

                case 3 -> {
                    ls.buscarLibroAutor();
                }

                case 4 -> {
                    ls.buscarLibroEditorial();
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                }
            }
        } while (opcion != 0);
    }
}
