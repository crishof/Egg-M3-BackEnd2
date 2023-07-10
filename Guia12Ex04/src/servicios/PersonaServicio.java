package servicios;

import entidades.*;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonaServicio {

    //    El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A
//    continuación, debe programar las clases definidas en las que, además de los constructores,
//    hay que desarrollar los métodos correspondientes a las siguientes operaciones:
//
//            • Cambio del estado civil de una persona.
//• Reasignación de despacho a un empleado.
//            • Matriculación de un estudiante en un nuevo curso.
//            • Cambio de departamento de un profesor.
//            • Traslado de sección de un empleado del personal de servicio.
//            • Imprimir toda la información de cada tipo de individuo. Incluya un programa de prueba
//    que instancie objetos de los distintos tipos y pruebe los métodos desarrollados.

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Persona> crearPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Estudiante("Cris", "Fuentes", "Casado", "1-A"));
        personas.add(new Estudiante("Hector", "Sosa", "Soltero", "3-B"));
        personas.add(new Profesor("Jose", "Marmol", "Soltero", 2020, 14, "Ciencias"));
        personas.add(new Profesor("Sara", "Tejada", "Casado", 2019, 13, "Arquitectura"));
        personas.add(new PersonalServicio("Maria", "Rosas", "Soltero", 2015, 3, "Decanato"));
        personas.add(new PersonalServicio("Esteban", "Juarez", "Casado", 2010, 4, "Secretaría"));
        return personas;
    }

    public void cambiarEstadoCivil(ArrayList<Persona> personas) {
        System.out.println("Ingrese el id de la persona que desea modificar");
        int id = leer.nextInt();

        for (Persona aux : personas) {
            if (aux.getId() == id) {
                System.out.println("La persona está definida como " + aux.getEstadoCivil().toUpperCase());
                System.out.println("Ingrese el nuevo estado civil");
                System.out.println("Digite C para casado, S para soltero, V para viudo, D para divorciado");
                String estadoCivil = leer.next();
                switch (estadoCivil.toUpperCase()) {
                    case "C" -> aux.setEstadoCivil("Casado");
                    case "S" -> aux.setEstadoCivil("Soltero");
                    case "D" -> aux.setEstadoCivil("Divorciado");
                    case "V" -> aux.setEstadoCivil("Viudo");
                }
            }
        }
    }

    public void reasignarDespacho(ArrayList<Persona> personas) {
        System.out.println("Ingrese el id del empleado que desea reasignar");
        int id = leer.nextInt();

        for (Persona aux : personas) {
            if (aux.getId() == id) {
                if (aux instanceof Empleado) {
                    System.out.println("El empleado tiene asignado el  despacho n° " + ((Empleado) aux).getDespacho());
                    System.out.println("Ingrese el despacho que desea asignar");
                    int despacho = leer.nextInt();
                    ((Empleado) aux).setDespacho(despacho);
                } else {
                    System.out.println("El Id ingresado no corresponde a un empleado");
                    break;
                }
            }
        }
    }

    public void reasignarDepartamento(ArrayList<Persona> personas) {
        System.out.println("Ingrese el id del profesor que desea reasignar");
        int id = leer.nextInt();

        for (Persona aux : personas) {
            if (aux.getId() == id && aux instanceof Profesor) {
                System.out.println("El profesor tiene asignado el  departamento n° " + ((Profesor) aux).getDepartamento());
                System.out.println("Ingrese el departamento que desea asignar");
                String departamento = leer.next();
                ((Profesor) aux).setDepartamento(departamento);
            }
        }
    }
    public void trasladarEmpleadoServicio(ArrayList<Persona> personas) {
        System.out.println("Ingrese el id del empleado que desea trasladar");
        int id = leer.nextInt();

        for (Persona aux : personas) {
            if (aux.getId() == id && aux instanceof PersonalServicio) {
                System.out.println("El empleado trabaja en la seccion " + ((PersonalServicio) aux).getSeccion());
                System.out.println("Ingrese la seccion a la que desea trasladar");
                String seccion = leer.next();
                 ((PersonalServicio) aux).setSeccion(seccion);
            }
        }
    }

    public void mostrarEstudiantes(ArrayList<Persona> personas){

        for ( Persona aux : personas){

            if (aux instanceof Estudiante){
                System.out.println(aux);
            }
        }
    }
    public void mostrarProfesores(ArrayList<Persona> personas){

        for ( Persona aux : personas){

            if (aux instanceof Profesor){
                System.out.println(aux);
            }
        }
    }
    public void mostrarPersonalServicio(ArrayList<Persona> personas){

        for ( Persona aux : personas){

            if (aux instanceof PersonalServicio){
                System.out.println(aux);
            }
        }
    }
    public void mostrarTodos(ArrayList<Persona> personas){

        for ( Persona aux : personas){
             System.out.println(aux);
            }
    }

    public Estudiante matricularEstudiante() {
        System.out.println("Ingrese nombre");
        String name = leer.next();
        System.out.println("Ingrese Apellido");
        String apellido = leer.next();
        System.out.println("Ingrese estado Civil");
        String estadoCivil = leer.next();
        System.out.println("Ingrese curso");
        String curso = leer.next();

        return new Estudiante(name, apellido, estadoCivil, curso);
    }

    public void menu(ArrayList<Persona> personas) {

        int opcion = 0;

        do {
            System.out.println("= = = = MENU = = = = =" +
                    "\n Ingrese la opcion deseada" +
                    "\n  " +
                    "\n 1 - Matricular Alumno" +
                    "\n 2 - Cambiar estado civil" +
                    "\n 3 - Reasignar despacho" +
                    "\n 4 - Cambiar departamento Profesor" +
                    "\n 5 - Trasladar seccion Empleado de Servicio" +
                    "\n 6 - Mostrar Estudiantes" +
                    "\n 7 - Mostrar Profesores" +
                    "\n 8 - Mostrar Personal de servicio" +
                    "\n 9 - Mostrar todas las personas" +
                    "\n 0 - SALIR");

            opcion = leer.nextInt();

            switch (opcion) {

                case 1 -> personas.add(matricularEstudiante());
                case 2 -> cambiarEstadoCivil(personas);
                case 3 -> reasignarDespacho(personas);
                case 4 -> reasignarDepartamento(personas);
                case 5 -> trasladarEmpleadoServicio(personas);
                case 6 -> mostrarEstudiantes(personas);
                case 7 -> mostrarProfesores(personas);
                case 8 -> mostrarPersonalServicio(personas);
                case 9 -> mostrarTodos(personas);
                case 0 -> System.out.println("Hasta luego!");

            }

        } while (opcion != 0);


    }
}
