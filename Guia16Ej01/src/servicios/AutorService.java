/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Autor;
import java.util.Scanner;
import persistencia.AutorDAO;

/**
 *
 * @author cristian
 */
public class AutorService {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO dao = new AutorDAO();
    
    public void crearAutor() {
        
        Autor autor = new Autor();
        System.out.println("Ingrese nombre del autor");
        String nombre = leer.next();
        autor.setNombre(nombre);
        autor.setAlta(true);
        
        dao.persistirEntidad(autor);
        System.out.println("Autor guardado exitosamente");
    }
    
}
