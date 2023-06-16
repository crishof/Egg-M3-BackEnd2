package servicio;

import entidades.Perro;
import entidades.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class Servicio {

    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Perro> perros = new ArrayList<>();

    public void crearPersonas() {

        personas.add(new Persona("Sara", "Quiroga", 24, 33000123));
        personas.add(new Persona("Juan", "Merino", 20, 29224000));
        personas.add(new Persona("Paula", "Noval", 34, 39443434));
        personas.add(new Persona("Omar", "Villa", 52, 23554384));
        personas.add(new Persona("Pablo", "Salas", 45, 19398543));

    }

    public void agregarPersona() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese su nombre");
        String nombre = leer.next();
        System.out.println("Ingrese su apellido");
        String apellido = leer.next();
        System.out.println("Ingrese edad");
        int edad = leer.nextInt();
        System.out.println("Ingrese numero de DNI");
        long dni = leer.nextLong();

        personas.add(new Persona(nombre, apellido, edad, dni));

    }

    public void mostrarPersonas() {
        int i = 1;
        for (Persona aux : personas) {
            System.out.println("Persona " + i + ": " + aux);
            i++;
        }
    }

    public void crearPerros() {

        perros.add(new Perro("Frida", "Golden", 8, "Mediano"));
        perros.add(new Perro("Gordon", "Labrador", 8, "Mediano"));
        perros.add(new Perro("Toy", "Caniche", 8, "Chico"));
        perros.add(new Perro("Astor", "Ovejero", 8, "Grande"));
        perros.add(new Perro("Tasha", "Beagle", 8, "Mediano"));
    }

    public void agregarPerro() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese nombre");
        String nombre = leer.next();
        System.out.println("Ingrese raza");
        String raza = leer.next();
        System.out.println("Ingrese edad");
        int edad = leer.nextInt();
        System.out.println("Ingrese tamaño");
        String size = leer.next();

        perros.add(new Perro(nombre, raza, edad, size));

    }

    public void mostrarPerros() {
        int i = 1;
        for (Perro perroAux : perros) {
            System.out.println("perro " + i + ": " + perroAux);
            i++;
        }
    }

    public void perrosDisponibles() {

        int i = 1;
        System.out.println("Los perros disponibles para adopción son: ");
        for (Perro perroAux : perros) {
            if (perroAux.getOwner() == null) {
                System.out.println("perro " + i + ": " + perroAux);
            }
            i++;
        }
    }

    public void adoptarPerro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese su DNI");
        long dni = leer.nextLong();
        boolean okPersona = validarPersona(dni);
        System.out.println("Ingrese el nombre del perro que desea adoptar");
        String nombrePerro = leer.next();
        boolean okPerro = validarPerro(nombrePerro);

        Perro perroDiponible = null;
        Persona personaInscripta = null;

        if (okPersona && okPerro) {
            for (Perro perro : perros) {
                if (perro.getNombre().equalsIgnoreCase(nombrePerro)) {
                    perroDiponible = perro;
                    break;
                }
            }

            for (Persona persona : personas) {
                if (persona.getDni() == dni) {
                    personaInscripta = persona;
                    break;
                }
            }

            perroDiponible.setOwner(personaInscripta);
            personaInscripta.setPerro(perroDiponible);
            System.out.println("personaInscripta = " + personaInscripta);
            System.out.println("perroDiponible = " + perroDiponible);
        }
    }

    public boolean validarPersona(long dni) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean tienePerro = false;
        boolean check = false;
        for (Persona persona : personas) {

            if (persona.getDni() == dni) {
                tienePerro = persona.getPerro() == null;
                check = true;
                break;
            }
        }
        if (check) {
            if (tienePerro) {
                System.out.println("La persona ya tiene perro adoptado");
            }
        } else {
            System.out.println("La persona no está inscripta");
            System.out.println("Debe ingresar la persona antes de adoptar un perro");
            System.out.println("Desea cargar una nueva persona? S/N");
            String opcion = leer.next();
            if (opcion.equalsIgnoreCase("S")) {
                agregarPersona();
            }
        }
        return check;
    }

    public boolean validarPerro(String nombrePerro) {

        boolean check = false;
        for (Perro perro : perros) {
            if (perro.getNombre().equalsIgnoreCase(nombrePerro) && perro.getOwner() == null) {
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("El perro no existe o ya tiene dueño");
        }
        return check;
    }

    public void menu() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        do {
            System.out.println("Ingrese la opcion deseada");
            System.out.println("""
                    1 . Mostrar Perros
                    2 . Mostrar Personas
                    3 . Mostrar Perros disponibles
                    4 . Adoptar Perro
                    5 . Salir""");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1 -> mostrarPerros();
                case 2 -> mostrarPersonas();
                case 3 -> perrosDisponibles();
                case 4 -> adoptarPerro();
                case 5 -> System.out.println("Hasta luego");
                default -> System.out.println("Opcion incorrecta, reingrese");
            }
        } while (opcion != 5);
    }
}
