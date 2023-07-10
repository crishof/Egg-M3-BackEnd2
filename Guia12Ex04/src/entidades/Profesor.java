package entidades;

public class Profesor extends Empleado {

//    • Por lo que se refiere a los profesores, es necesario gestionar a qué departamento
//    pertenecen (lenguajes, matemáticas, arquitectura, ...).

    private String departamento;

    public Profesor(String name, String apellido, String estadoCivil, int incorporacion, int despacho, String departamento) {
        super(name, apellido, estadoCivil, incorporacion, despacho);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor: " +
                "id: " + id + '\n' +
                "departamento: " + departamento + '\n' +
                "name: " + name + '\n' +
                "apellido: " + apellido + '\n' +
                "estadoCivil: " + estadoCivil + '\n'
                + super.toString();
    }
}
