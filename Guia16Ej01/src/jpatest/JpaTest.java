
package jpatest;

import servicios.AutorService;
import servicios.EditorialService;
import servicios.LibroService;

public class JpaTest {

    public static void main(String[] args) {
        
        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        
        as.guardarAutor();
//        es.guardarEditorial();
//        ls.guardarLibro();

as.buscarA();

/*
Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.

EJ 2

2) Creación de un Cliente nuevo
3) Crear entidad Préstamo
4) Registrar el préstamo de un libro.
5) Devolución de un libro
6) Búsqueda de todos los préstamos de un Cliente.
• Agregar validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
• No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
No se podrán prestar libros con fecha anterior a la fecha actual, etc.
*/
        
    }
   
}
