package jpatest;

import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.LibroDAO;
import servicios.AutorService;
import servicios.ClienteService;
import servicios.EditorialService;
import servicios.LibroService;
import servicios.PrestamoService;

public class JpaTest {

    public static void main(String[] args) {

        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        LibroDAO ld = new LibroDAO();
        ClienteService cs = new ClienteService();
        PrestamoService ps = new PrestamoService();

        Menu menu = new Menu();

//        menu.general();
//        ps.prestarLibro();
        ps.devolverLibro();

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
