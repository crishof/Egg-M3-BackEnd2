import entidad.Alumno;
import entidad.Voto;
import servicio.Simulador;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Simulador ss = new Simulador();

        ArrayList<String> nombres = ss.crearNombres();
        HashSet<String> documentos = ss.cargarDocumentos();
        ArrayList<Alumno> alumnos = ss.crearAlumnos(nombres, documentos);
        ss.mostrarAlumnos(alumnos);

        ArrayList<Voto> votos = ss.votacion(alumnos);
        ss.mostrarVotos(votos);


    }
}
