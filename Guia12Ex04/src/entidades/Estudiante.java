package entidades;

import java.util.Objects;

public class Estudiante extends Persona {

//    • En cuanto a los estudiantes, se requiere almacenar el curso en el que están
//    matriculados.

    private String curso;

    public Estudiante(String name, String apellido, String estadoCivil, String curso) {
        super(name, apellido, estadoCivil);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante: " +
                "id: " + id + '\n' +
                "curso: " + curso + '\n' +
                "name: " + name + '\n' +
                "apellido: " + apellido + '\n' +
                "estado Civil: " + estadoCivil + '\n';
//                + super.toString();
    }
}
