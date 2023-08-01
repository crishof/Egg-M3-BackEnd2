
package jpatest;

import servicios.AutorService;
import servicios.EditorialService;
import servicios.LibroService;

public class JpaTest {

    public static void main(String[] args) {
        
        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        
        as.crearAutor();
        
    }
    
}
