import entidades.Alumno;
import servicios.AlumnoServicio;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        AlumnoServicio as = new AlumnoServicio();
        ArrayList<Alumno> alumnos = as.crearListaAlumnos();

//        System.out.println("La nota final del alumno es; " + AlumnoServicio.notaFinal(alumnos));
//        System.out.println("= = = = = = ");

        for (Alumno alumno : alumnos){
            System.out.println("alumno = " + alumno);
        }

        for (Alumno alumno : alumnos){
            System.out.println(alumno.toString());
        }
//        as.mostrarDatos(alumnos);

        System.out.println("La nota final del alumno es : " + as.buscarAlumno(alumnos));
    }
}