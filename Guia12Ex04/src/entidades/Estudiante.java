package entidades;

public class Estudiante extends Persona{

//    • En cuanto a los estudiantes, se requiere almacenar el curso en el que están
//    matriculados.

    private String curso;

    public Estudiante(int id, String name, String apellido, String estadoCivil, String curso) {
        super(id, name, apellido, estadoCivil);
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
        return "Estudiante{" +
                "curso='" + curso + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                "} " + super.toString();
    }
}
