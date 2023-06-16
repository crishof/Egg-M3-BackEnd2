package servicio;

import entidad.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CineServicio {

    public ArrayList<Espectador> crearPersonas() {

        Espectador espectador;
        Random random = new Random();
        List espectadores = new ArrayList<>();

        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía", "Miguel", "Lucía", "Manuel", "Isabella", "Javier", "Valentina", "Andrés", "Camila", "Diego", "Daniela", "Francisco", "Martina", "José", "Paula", "Alejandro", "Emma", "Ricardo", "Victoria", "Fernando", "Juana", "Gabriel", "Valeria", "Antonio", "Luciana", "Raúl", "Clara", "Roberto", "Catalina", "Alberto", "Gabriela", "Jorge", "Olivia", "Gustavo", "Natalia", "Emilio", "Marina", "Sebastián", "Elena", "Hugo", "Adriana", "Felipe", "Isabel"};

        for (int i = 0; i < nombres.length; i++) {
            espectadores.add(new Espectador(nombres[i], random.nextInt(8, 45), random.nextInt(500, 5000)));
        }
        return (ArrayList<Espectador>) espectadores;
    }

    public Pelicula elegirPelicula() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese la Pelicula a la que desea acceder");
        String nombre = leer.next();
        double duracion = 0;
        int edadMinima = 0;
        String director = "";

        switch (nombre) {
            case "La comunidad del anillo":
                duracion = 3.2;
                edadMinima = 13;
                director = "Peter Jackson";
            case "Las dos torres":
                duracion = 2.5;
                edadMinima = 8;
                director = "Peter Jackson";
            case "El retorno del Rey":
                duracion = 2.1;
                edadMinima = 16;
                director = "Peter Jackson";
        }
        return new Pelicula(nombre, duracion, edadMinima, director);
    }

    public Sala crearSala() {

        Sala sala = new Sala();
        Asiento[][] asientos = new Asiento[8][6];
        int reverse = 8;
        String letra = "";
        boolean ocupado = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                switch (j) {
                    case 0 -> letra = "A";
                    case 1 -> letra = "B";
                    case 2 -> letra = "C";
                    case 3 -> letra = "D";
                    case 4 -> letra = "E";
                    case 5 -> letra = "F";
                }
                asientos[i][j] = new Asiento((reverse + letra), false, null);
            }
            reverse--;
        }
        return new Sala(asientos);

    }

    public void mostrarSala(Asiento[][] asientos) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(asientos[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void ocuparAsientos(Cine cine, Sala sala, ArrayList<Espectador> espectadores, Pelicula pelicula) {

        Asiento[][] aforo = sala.getAsientos();
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (espectadores.get(k).getDinero() > cine.getPrecioEntrada() && espectadores.get(k).getEdad() >= cine.getPelicula().getEdadMinima()) {
                    aforo[i][j].setOcupado(true);
                    aforo[i][j].setEspectador(espectadores.get(k));

                }
                k++;
            }
        }
        sala.setAsientos(aforo);
    }

    public void mostrarPersonas(ArrayList<Espectador> espectadores) {

        System.out.println("Las personas que están haciendo fila para entrar son: ");
        for (Object personas : espectadores) {
            System.out.println(personas);
        }
    }

    public void menu() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        Random random = new Random();

        ArrayList<Espectador> espectadores = crearPersonas();
        var sala = crearSala();
        Cine cine = new Cine(null, random.nextInt(1000,2500), sala);

        do {
            System.out.println("""
                    ------------------------
                    -----------MENU---------
                    ------------------------
                    Ingrese la opcion deseada
                     - - - - - - - - - - 
                     1. Elegir película
                     2. Ver personas en puerta
                     3. Mostrar ocupación de sala
                     4. Abrir puertas
                     0. SALIR""");

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 -> cine.setPelicula(elegirPelicula());
                case 2 -> mostrarPersonas(espectadores);
                case 3 -> mostrarSala(sala.getAsientos());
                case 4 -> ocuparAsientos(cine, sala, espectadores, cine.getPelicula());
                default -> System.out.println("Opcion incorrecta, reingrese");
            }
        } while (opcion != 0);
    }
}

