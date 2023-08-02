package jpatest;

import entidades.Libro;
import java.util.Scanner;
import persistencia.LibroDAO;
import servicios.AutorService;
import servicios.EditorialService;
import servicios.LibroService;

public class JpaTest {

    public static void main(String[] args) {

        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        LibroDAO ld = new LibroDAO();

        Menu menu = new Menu();

//        menu.general();

//Libro libro = ls.buscarLibroTitulo("hobbit");
//        System.out.println("libro = " + libro.toString());
        
        
//Alta de Libro
//ls.guardarLibro();

//Alta de Autor
//as.guardarAutor();

//Alta de Editorial
//es.guardarEditorial();

//Baja de Libro
//ls.BajaLibro();

//Baja de Autor
//as.bajaAutor();

//Baja de Editorial
es.BajaEditorial();
//Editar Libro
//Editar Autor
//Editar Editorial
//Busqueda de un Autor por nombre
//Busqueda de un libro por ISBN
//Busqueda de un libro por T\u00edtulo
//Busqueda de un libro/s por nombre de Autor
//Buasqueda de un libro/s por nombre de Editorial
//Crear cliente nuevo
//Registrar el prestamo de un libro
//Devolver un libro
//Busqueda de todos los prestamos de un Cliente



        /*
Crear los métodos para dar de alta/bajo o editar dichas entidades.
        
        "3) Crear entidad Préstamo\n" +

• Agregar validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
• No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
No se podrán prestar libros con fecha anterior a la fecha actual, etc.
         */
    }

}
