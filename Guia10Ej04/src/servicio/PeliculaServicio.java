package servicio;

import entidad.Pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Collections.reverse;

public class PeliculaServicio {

    public ArrayList<Pelicula> cargarPelicula() {

        Scanner scn = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Pelicula pelicula = new Pelicula();
        String check;
        do {
            System.out.println("Ingrese el titulo de la película");
            pelicula.setTitulo(scn.next());
            System.out.println("Ingrese el nombre del director");
            pelicula.setDirector(scn.next());
            System.out.println("Ingrese la duración");
            pelicula.setDuracion(scn.nextDouble());

            peliculas.add(pelicula);
            System.out.println("Desea cargar otra película? S/N");
            check = scn.next();
            while (!check.equalsIgnoreCase("N") && !check.equalsIgnoreCase("S")) {
                System.out.println("Opcion incorrecta, reingrese S/N");
                check = scn.next();
            }
        } while (check.equalsIgnoreCase("S"));

        return peliculas;
    }

    public ArrayList<Pelicula> cargarPeliculaAutom() {

        Scanner scn = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Pelicula pelicula = new Pelicula();
        Pelicula pelicula2 = new Pelicula();
        Pelicula pelicula3 = new Pelicula();
        Pelicula pelicula4 = new Pelicula();

        pelicula.setTitulo("El Hobbit");
        pelicula.setDirector("Bilbo");
        pelicula.setDuracion(2.8);
        peliculas.add(pelicula);

        pelicula2.setTitulo("La comunidad del Anillo");
        pelicula2.setDirector("Gandalf");
        pelicula2.setDuracion(3.5);
        peliculas.add(pelicula2);

        pelicula3.setTitulo("Las dos torres");
        pelicula3.setDirector("Sauron");
        pelicula3.setDuracion(0.9);
        peliculas.add(pelicula3);

        pelicula4.setTitulo("El retorno del Rey");
        pelicula4.setDirector("Aragorn");
        pelicula4.setDuracion(1.9);
        peliculas.add(pelicula4);


        return peliculas;
    }

    public void menu(ArrayList<Pelicula> peliculas) {

        Scanner scn = new Scanner(System.in).useDelimiter("\n");

        int opcion;
        do {
            System.out.println(" = = = MENU = = =");
            System.out.println("Ingrese la opcion que desea relizar");
            System.out.println("Digite 1 para ver todas las peliculas");
            System.out.println("Digite 2 para ver todas las peliculas que duran mas de 1 hora");
            System.out.println("Digite 3 para ordenar por mayor duracion");
            System.out.println("Digite 4 para ordeanr por menor duracion");
            System.out.println("Digite 5 para ordenar por titulo");
            System.out.println("Digite 6 para ordenar por director");
            System.out.println("Digite 7 para SALIR");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1 -> mostrarPeliculas(peliculas);
                case 2 -> mostrarPeliculasMayor(peliculas);
                case 3 -> ordenarMayor(peliculas);
                case 4 -> ordenarMenor(peliculas);
                case 5 -> ordenarTitulo(peliculas);
                case 6 -> ordenarDirector(peliculas);
                case 7 -> System.out.println("Programa finalizado");
                default -> System.out.println("Opcion incorrecta");
            }
        } while (opcion != 7);
    }

    //    • Mostrar en pantalla todas las películas.
    public void mostrarPeliculas(ArrayList<Pelicula> peliculas) {

        System.out.println();
        System.out.println("Las peliculas en cartelera son: ");
        for (Pelicula peli : peliculas) {
            System.out.println(peli);
        }
    }

    //    • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.

    public void mostrarPeliculasMayor(ArrayList<Pelicula> peliculas) {

        System.out.println();
        System.out.println("Las peliculas que duran mas de una hora son: ");
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion() > 1) {
                System.out.println(pelicula);
            }
        }
    }

    //   • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
//        pantalla.
    public void ordenarMayor(ArrayList<Pelicula> peliculas) {

        System.out.println("Las peliculas por mayor duracion son: ");
        peliculas.sort(Pelicula.compareDuration);

        mostrarPeliculas(peliculas);

    }

    //        • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
//        pantalla.

    public void ordenarMenor(ArrayList<Pelicula> peliculas) {

        System.out.println();
        System.out.println("Las peliculas por menor duracion son: ");
        reverse(peliculas);

        mostrarPeliculas(peliculas);

    }

    //        • Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.


    public void ordenarTitulo(ArrayList<Pelicula> peliculas) {

        System.out.println("Las peliculas en orden alfabético son: ");
        peliculas.sort(Pelicula.compareTitle);
        mostrarPeliculas(peliculas);

    }

    //        • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.

    public void ordenarDirector(ArrayList<Pelicula> peliculas) {

        System.out.println("Las peliculas por director son: ");
        peliculas.sort(Pelicula.compareDirector);
        mostrarPeliculas(peliculas);
    }
}

