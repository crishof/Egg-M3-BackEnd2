package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorService {

    AutorDAO dao = new AutorDAO();

    public void guardarAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean loop;
        do {
            loop = false;
            Autor autor = new Autor();
            System.out.println("Ingrese nombre del Autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            autor.setAlta(true);

//                        Valida si hay otro autor con el mismo nombre
            List<Autor> autores = dao.buscarAutoresPorNombre(nombre);
            if (!autores.isEmpty()) {
                System.out.println("Ya existe un autor con el mismo nombre");
                loop = true;
                continue;
            }

            dao.persistirAutor(autor);
            System.out.println("Autor guardado exitosamente");

            System.out.println("Desea ingresar otro Autor? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                loop = true;
            }
        } while (loop);
    }

    public Autor guardarAutor(String nombre) {

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);

        dao.persistirAutor(autor);
        System.out.println("Autor guardado exitosamente");

        return autor;
    }

    public void bajaAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean noEncontrado = true;
        boolean alta = true;
        boolean loop;

        Autor autor = buscarAutorNombre();
        if (autor != null) {
            do {
                System.out.println("1 - Dar de baja");
                System.out.println("2 - Dar de Alta");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1 -> {
                        alta = false;
                        loop = false;
                    }
                    case 2 -> {
                        alta = true;
                        loop = false;
                    }
                    default -> {
                        System.out.println("Opcion incorrecta");
                        loop = true;
                    }
                }

            } while (loop);
            autor.setAlta(alta);
            noEncontrado = false;
            dao.actualizarAutor(autor);

        }
        if (noEncontrado) {
            System.out.println("Autor no encontrado");
            leer.next();
        }
    }

    public Autor buscarAutorNombre() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.next();
        List<Autor> autores = dao.buscarAutoresPorNombre(nombre);

        Autor ret = null;
        for (Autor aux : autores) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Autor encontrado");
                System.out.println(aux.toString());
                ret = aux;

            } else {

                System.out.println("Autor no encontrado");
                ret = null;
            }
        }
        return ret;
    }

    public void modificarAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Autor autor = null;

        autor = buscarAutorNombre();

        boolean noEncontrado = true;
        if (autor != null) {
            boolean alta = true;
            boolean bucle2;
            do {
                bucle2 = false;
                System.out.println("1- Darlo de baja");
                System.out.println("2- Darlo de alta");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1 ->
                        alta = false;
                    case 2 ->
                        alta = true;
                    default -> {
                        System.out.println("Opción no reconocida");
                        bucle2 = true;
                    }
                }
            } while (bucle2);
            autor.setAlta(alta);
            noEncontrado = false;
            dao.actualizarAutor(autor);
        }

        if (noEncontrado) {
            System.out.println("Autor no encontrado");
            leer.next();
        }
    }

}
