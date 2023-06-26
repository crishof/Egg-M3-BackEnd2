package servicio;

import entidad.Alumno;
import entidad.Voto;

import java.util.*;

public class Simulador {
    public ArrayList<String> crearNombres() {

        Random random = new Random();

        String[] apellidos = {"González", "Rodríguez", "López", "Martínez", "Pérez", "Gómez", "Sánchez", "Fernández", "Torres", "Ramírez", "Hernández", "Flores", "Vargas", "Rojas", "Morales", "Navarro", "Jiménez", "Silva", "Ortega", "Reyes", "Giménez", "Mendoza", "Castillo", "Guerrero", "Ramos", "Acosta", "Romero", "Álvarez", "Moreno", "Núñez", "Medina", "Suárez", "Aguilar", "Castro", "Chávez", "Vega", "Herrera", "Valdez", "Delgado", "Campos", "Molina", "Cabrera", "Guzmán", "Paredes", "Ponce", "Ibarra", "Fuentes"};
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía", "Miguel", "Lucía", "Manuel", "Isabella", "Javier", "Valentina", "Andrés", "Camila", "Diego", "Daniela", "Francisco", "Martina", "José", "Paula", "Alejandro", "Emma", "Ricardo", "Victoria", "Fernando", "Juana", "Gabriel", "Valeria", "Antonio", "Luciana", "Raúl", "Clara", "Roberto", "Catalina", "Alberto", "Gabriela", "Jorge", "Olivia", "Gustavo", "Natalia", "Emilio", "Marina", "Sebastián", "Elena", "Hugo", "Adriana", "Felipe", "Isabel"};

        ArrayList<String> nombresCompletos = new ArrayList<>();

        for (int i = 0; i < apellidos.length; i++) {
            nombresCompletos.add(nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)]);
        }

        return nombresCompletos;
    }

    public String generarDocumento() {

        Random random = new Random();
        int numeroDni = random.nextInt(5000000, 60000000);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = numeroDni % 23;
        char letraControl = letras.charAt(indiceLetra);
        String dni = String.format("%07d", numeroDni) + letraControl;

        return dni;
    }

    public HashSet<String> cargarDocumentos() {

        HashSet<String> documentos = new HashSet<>();

        for (int i = 0; i < 50; i++) {

            documentos.add(generarDocumento());
        }

        return documentos;
    }

    public ArrayList<Alumno> crearAlumnos(ArrayList<String> nombres, HashSet<String> documentos) {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Random random = new Random();

        System.out.println("Ingrese la cantidad de alumnos que desea crear");
        int alumnosCant = leer.nextInt();

        Iterator<String> iterator = documentos.iterator();

        for (int i = 0; i < alumnosCant; i++) {
            String nombre = nombres.get(random.nextInt(0, nombres.size()));
            String documento = iterator.next();
            alumnos.add(new Alumno(nombre, documento));
        }

        return alumnos;
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos) {

        System.out.println(" _ _ _ _ _ALUMNOS _ _ _ _ ");
        for (Alumno aux : alumnos) {
            System.out.println(aux);
        }
    }

    public ArrayList<Voto> votacion(ArrayList<Alumno> alumnos) {

        Random random = new Random();

        ArrayList<Voto> votos = new ArrayList<>();


        for (int i = 0; i < alumnos.size(); i++) {

            HashSet<Alumno> votados = new HashSet<>();

            for (int j = 0; j < 3; j++) {

                boolean check = false;
                do {
                    int index = random.nextInt(0, alumnos.size());
                    Alumno voto = alumnos.get(index);

                    String dni1 = voto.getDni();
                    String dni2 = alumnos.get(i).getDni();

                    if (!dni1.equals(dni2)) {
                        alumnos.get(index).setVotosRecibidos(alumnos.get(index).getVotosRecibidos() + 1);
                        votados.add(voto);

                        check = true;
                    }
                } while (!check);
            }

            alumnos.get(i).setVotosEntregados(votados);
            votos.add(new Voto(alumnos.get(i), votados));

        }

        return votos;
    }

    public void mostrarVotos(ArrayList<Voto> votos) {

        System.out.println("_ _ _ _ _ VOTOS _ _ _ _ _ ");

        for (int i = 0; i < votos.size(); i++) {

            System.out.println("Nombre: " + votos.get(i).getAlumno().getNombreCompleto());

            for (Voto aux: votos
                 ) {
                System.out.println("Voto " + j + ": " + votos.get(i).getVotados(j));
            }
            }
        }


    }

}