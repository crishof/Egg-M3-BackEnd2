
package servicios;

import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroService {

    private final LibroDAO dao = new LibroDAO();

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void guardarLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean bucle;
        do {
            bucle = false;
            System.out.println("Ingrese el titulo del título");
            String nombre = leer.next();
            Libro libro = buscarLibroTitulo();

            if (libro == null) {
                libro.setTitulo(nombre);
                do {
                    try {
                        System.out.println("Ingrese el ISBN del libro");
                        long isbn = leer.nextLong();
                        break;

                    } catch (Exception e) {
                        System.out.println("El isbn no es válido");
                        leer.next();
                    }

                } while (true);

                libro.setAlta(true);

                do {
                    try {
                        System.out.println("Ingrese la cantidad de ejemplares");
                        int ejemplares = leer.nextInt();
                        libro.setEjemplares(ejemplares);
                        libro.setEjemplaresRestantes(ejemplares);
                        libro.setEjemplaresPrestados(0);
                        break;
                    } catch (Exception e) {
                        System.out.println("El numero de ejemplares no es válido");
                        leer.next();
                    }
                } while (true);
                boolean noEncontrado = true;

                do {
                    System.out.println("Ingrese la editorial");
                    String nombreEditorial = leer.next();
                    List<Editorial> editoriales = dao.consultaGenerica("editorial", "nombre", nombreEditorial);
                    for (Editorial editorial : editoriales) {
                        if (editorial.getNombre().equalsIgnoreCase(nombreEditorial)) {
                            libro.setEditorial(editorial);
                            noEncontrado = false;
                        }
                    }
                    if (noEncontrado) {
                        System.out.println("Editorial no encontrada");
                    }
                } while (noEncontrado);

                dao.persistirLibro(libro);
                System.out.println("Desea cargar otro libro? S/N");
                if (leer.next().equalsIgnoreCase("S")) {
                    bucle = true;
                }
            } else {
                System.out.println("Libro ya cargado");

            }
        } while (bucle);
    }
    
    public void BajaLibro() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Libro libro = null;
        boolean bucle;
        do {
            System.out.println("1. Buscar libro por ISBN");
            System.out.println("2. Buscar libro por Título");
            System.out.println("3. Buscar libro/s por nombre de Autor");
            System.out.println("4. Buscar libro/s por nombre de Editorial");
            int option = leer.nextInt();
            bucle = false;
            switch (option) {
                case 1 -> libro = buscarLibroIsbn();
                case 2 -> libro = buscarLibroTitulo();
                case 3 -> {
                    System.out.println("Ingrese el nombre del autor:");
                    String autor = leer.next();
                    List<Libro> librosAutor = buscarLibroAutor(autor);
                    if (librosAutor.isEmpty()) {
                        System.out.println("No se encontraron libros de " + autor);
                    } else {
                        System.out.println("Libros de " + autor + ":");
                        for (int i = 0; i < librosAutor.size(); i++) {
                            System.out.println((i + 1) + ". " + librosAutor.get(i));
                        }
                        System.out.println("Seleccione un libro (1-" + librosAutor.size() + "):");
                        int indiceAutor = leer.nextInt() - 1;
                        libro = librosAutor.get(indiceAutor);
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el nombre de la editorial:");
                    String editorial = leer.next();
                    List<Libro> librosEditorial = buscarLibroEditorial(editorial);
                    if (librosEditorial.isEmpty()) {
                        System.out.println("No se encontraron libros de la editorial " + editorial);
                    } else {
                        System.out.println("Libros de la editorial " + editorial + ":");
                        for (int i = 0; i < librosEditorial.size(); i++) {
                            System.out.println((i + 1) + ". " + librosEditorial.get(i));
                        }
                        System.out.println("Seleccione un libro (1-" + librosEditorial.size() + "):");
                        int indiceEditorial = leer.nextInt() - 1;
                        libro = librosEditorial.get(indiceEditorial);
                    }
                }
                default -> {
                    System.out.println("Opción no reconocida");
                    bucle = true;
                }
            }
        } while (bucle);

        boolean noEncontrado = true;
        if (libro != null) {
            boolean alta = true;
            boolean bucle2;
            do {
                bucle2 = false;
                System.out.println("1- Darlo de baja");
                System.out.println("2- Darlo de alta");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        alta = false;
                        break;
                    case 2:
                        alta = true;
                        break;
                    default:
                        System.out.println("Opción no reconocida");
                        bucle2 = true;
                }
            } while (bucle2);
            libro.setAlta(alta);
            noEncontrado = false;
            dao.actualizarLibro(libro);
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }
    }

    public void prestarLibro(Libro libro) {
        if (libro.getEjemplaresPrestados() < libro.getEjemplaresRestantes()) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            dao.actualizarLibro(libro);
        } else {
            System.out.println("No hay más libros para prestar");
        }
    }

    public void devolverLibro(Libro libro) {
        if (libro.getEjemplaresPrestados() > 0) {
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
            dao.actualizarLibro(libro);
        } else {
            System.out.println("No hay ningún libro que devolver");
        }
    }

    public List<Libro> buscarLibroAutor(String autor) {
        return dao.consultaGenerica("Libro", "autor", autor);
    }
    
    public void buscarLibroAutor() {
        System.out.println("Ingrese el nombre del autor");
        String nombreAutor = leer.next();
        List<Libro> librosCoincidentes = dao.consultaGenerica("Libro", "autor", nombreAutor);
        if (librosCoincidentes.isEmpty()) {
            System.out.println("No se encontraron libros de " + nombreAutor);
        } else {
            System.out.println("Libros de " + nombreAutor + ":");
            for (Libro libro : librosCoincidentes) {
                System.out.println(libro);
            }
        }
    }

    public List<Libro> buscarLibroEditorial(String editorial) {
        return dao.consultaGenerica("Libro", "editorial", editorial);
    }

    public Libro buscarLibroIsbn() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el ISBN del libro");
        long isbn = leer.nextLong();
        Libro libro = (Libro) dao.buscarPorIsbn(isbn);
        if (libro != null) {
            System.out.println("Libro encontrado");
            System.out.println(libro);
            noEncontrado = false;
        }

        if (noEncontrado) {
            System.out.println("Libro no encontrado");
            leer.next();
        }

        return libro;
    }

    public Libro buscarLibroTitulo() {
        boolean noEncontrado = true;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el titulo del libro");
        String tituloLibro = leer.next();
        List<Libro> libros = dao.consultaGenerica("Libro", "titulo", tituloLibro);
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                System.out.println("Libro encontrado");
                System.out.println(libro);
                return libro;
            }
        }
        if (noEncontrado) {
            System.out.println("Libro no encontrado");
        }
        return null;
    }

    
}
