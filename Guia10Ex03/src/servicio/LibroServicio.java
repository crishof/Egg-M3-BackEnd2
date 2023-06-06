package servicio;

import entidad.Libro;

import java.util.HashSet;
import java.util.Scanner;

public class LibroServicio {

    public void menu(HashSet<Libro> libros) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        int opcion;
        do {
            System.out.println(" : : : : MENU : : : : ");
            System.out.println("Ingrese la opcion deseada");
            System.out.println("Ingrese 1 para agregar libro");
            System.out.println("Ingrese 2 para cargar libros automaticamente");
            System.out.println("Ingrese 3 para prestar libro");
            System.out.println("Ingrese 4 para devolver libro");
            System.out.println("Ingrese 5 para mostrar todos los libros");
            System.out.println("Ingrese 6 para SALIR");

            opcion = leer.nextInt();
            String cargaMas;

            switch (opcion) {
                case 1 -> {
                    do {
                        cargarLibro();
                        System.out.println("Desea ingresar otro libro? S/N");
                        cargaMas = leer.next();
                        libros.add(cargarLibro());
                    } while (cargaMas.equalsIgnoreCase("S"));
                    System.out.println("Ingreso finalizado");
                }
                case 2 -> cargarLibroAutom(libros);
                case 3 -> prestarLibro(libros);
                case 4 -> devolverLibro(libros);
                case 5 -> mostrarLibros(libros);
                case 6 -> System.out.println("Programa finalizado");
                default -> System.out.println("Opcion incorrecta");
            }
        } while (opcion != 6);
    }

    public Libro cargarLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String titulo;
        String autor;
        int ejemplaresCant;
        int prestadosCant = 0;
        System.out.println("Ingreso de Libro");
        System.out.println("Ingrese el título");
        titulo = leer.next();
        System.out.println("Ingrese Autor");
        autor = leer.next();
        System.out.println("Ingrese cantidad de ejemplares disponibles");
        ejemplaresCant = leer.nextInt();

        return new Libro(titulo, autor, ejemplaresCant, prestadosCant);
    }

    public void mostrarLibros(HashSet<Libro> libros) {
        System.out.println("= = = = LIBROS = = = =");
        for (Libro librosStock : libros) {
            System.out.println(librosStock);
        }
        System.out.println(" = = = == = = = = = = = ");
    }

    public void cargarLibroAutom(HashSet<Libro> libros) {

        libros.add(new Libro("La comunidad del anillo", "Tolkien", 22, 0));
        libros.add(new Libro("Las dos Torres", "Gandalf", 23, 0));
        libros.add(new Libro("El retorno del Rey", "Legolas", 1, 0));
        libros.add(new Libro("El hobbit", "Sauron", 25, 0));

    }

    public void prestarLibro(HashSet<Libro> libros) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el libro que desea prestar");
        String libroPrestar = leer.next();
        String confirma;

        /*
        Comparator Expresion Lambda y anonima

         */
        boolean bandera = false;

        for (Libro prestado : libros) {
            if (prestado.getTitulo().equalsIgnoreCase(libroPrestar)) {
                bandera = true;

                if (prestado.getEjemplaresCant() > 0) {
                    System.out.println("Hay " + prestado.getEjemplaresCant() + " unidades disponibles");
                    System.out.println("Desea prestar el libro? S/N");
                    confirma = leer.next();
                    while (!confirma.equalsIgnoreCase("N") && !confirma.equalsIgnoreCase("S")) {
                        System.out.println("Respuesta incorrecta, reingrese");
                        confirma = leer.next();
                    }
                    if (confirma.equalsIgnoreCase("S")){
                        prestado.setPrestadosCant(prestado.getPrestadosCant() + 1);
                        prestado.setEjemplaresCant(prestado.getEjemplaresCant() - 1);
                    }
                } else {
                    System.out.println("No quedan unidades disponibles");
                }

            }
        } if (!bandera) {
            System.out.println("El libro ingresado no se encuentra disponible ");
        }
    }

    public void devolverLibro(HashSet<Libro> libros) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el libro que va a devolver");
        String devolucion = leer.next();

        for (Libro libros1 : libros) {
            if (devolucion.equalsIgnoreCase(libros1.getTitulo())) {
                if (libros1.getPrestadosCant() > 0) {
                    libros1.setEjemplaresCant(libros1.getEjemplaresCant() + 1);
                    libros1.setPrestadosCant(libros1.getPrestadosCant() - 1);
                } else {
                    System.out.println("El libro no ha sido prestado, se lo choreo de otro lado");
                }
                break;
            }
        }
    }
}



