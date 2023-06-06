import entidad.Pelicula;
import servicio.PeliculaServicio;

import java.util.ArrayList;

//        Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
//        tendremos una clase Pelicula con el título, director y duración de la película (en horas).
//        Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
//        que se pide a continuación:
//        En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
//        todos sus datos y guardándolos en el objeto Pelicula.
//        Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
//        crear otra Pelicula o no.
//        Después de ese bucle realizaremos las siguientes acciones:
//
public class Main {

    public static void main(String[] args) {

        PeliculaServicio ps = new PeliculaServicio();
//      ArrayList<Pelicula> peliculas = ps.cargarPelicula();
        ArrayList<Pelicula> peliculas = ps.cargarPeliculaAutom();
        ps.menu(peliculas);

    }
}
