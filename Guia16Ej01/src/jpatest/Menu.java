/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpatest;

import java.util.Scanner;
import servicios.AutorService;
import servicios.EditorialService;
import servicios.LibroService;

/**
 *
 * @author cristian
 */
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
                                                             
                               1 - Alta - ok
                               2 - Baja
                               3 - Editar
                               4 - Busqueda de un Autor por nombre
                               a - B\u00fasqueda de un libro por ISBN
                               b - B\u00fasqueda de un libro por T\u00edtulo
                               c - B\u00fasqueda de un libro/s por nombre de Autor
                               d - B\u00fasqueda de un libro/s por nombre de Editorial
                               5 -  Creaci\u00f3n de un Cliente nuevo
                               6 - Registrar el pr\u00e9stamo de un libro
                               7 - Devoluci\u00f3n de un libro
                               8 - B\u00fasqueda de todos los pr\u00e9stamos de un Cliente
                               0 - SALIR
                               
                               = = = = = = = = = = = = = = =
                               
                               Ingrese la opcion deseada: """);

            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    alta();
                case 2: baja();
                case 4: as.buscarAutorNombre();

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
                               0 - Volver al men\u00fa anterior
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
                               0 - Volver al men\u00fa anterior
                               """);

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 ->
                    ls.guardarLibro();

                case 2 ->
                    as.guardarAutor();

                case 3 ->
                    es.guardarEditorial();

                default ->
                    System.out.println("Opcion incorrecta, reingrese");
            }

        } while (opcion != 0);
    }

}
