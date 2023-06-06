//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.
//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
package servicios;

import entidades.Alumno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AlumnoServicio {

    public ArrayList<Alumno> crearListaAlumnos() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");


        ArrayList<Alumno> alumnos = new ArrayList<>();
        String check = "S";
        do {
            Alumno alumno = new Alumno();
            System.out.println("Ingrese nombre del alumno");
            alumno.setNombre(leer.next());
            ArrayList<Integer> notas = new ArrayList<>();
            System.out.println("Ingrese las 3 notas del alumno");

            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese la nota " + (i + 1));
                notas.add(leer.nextInt());
            }
            alumno.setNotas(notas);
            alumnos.add(alumno);

            System.out.println("Desea ingresar otro alumno? S/N");
            check = leer.next();
            while (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")) {
                System.out.println("Opción incorrecta, reingrese S/N");
                check = leer.next();
            }
        } while (check.equalsIgnoreCase("S"));
        return alumnos;
    }

    //Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.

    public double buscarAlumno(ArrayList<Alumno> alumnos) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el alumno del que desea ver la nota final");
        String alumnoBuscar = leer.next();
        Iterator<Alumno> iterator = alumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumnoAuxiliar = iterator.next();
            if ((alumnoAuxiliar.getNombre().equalsIgnoreCase(alumnoBuscar))) {
                return notaFinal(alumnoAuxiliar);
            }
        }
        System.out.println("No se encontró el alumno");
        return 0;
    }

    public double notaFinal(Alumno alumno) {
        double sumaNotas = 0;
        for (Integer nota : alumno.getNotas()) {
            sumaNotas += nota;
        }
        return sumaNotas / alumno.getNotas().size();
    }

}

