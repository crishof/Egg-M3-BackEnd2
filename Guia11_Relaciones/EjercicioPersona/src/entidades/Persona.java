package entidades;

public class Persona {

    String Nombre;
    String Apellido;

    DNI dni;

    public Persona() {
    }

    public Persona(String nombre, String apellido, DNI dni) {
        Nombre = nombre;
        Apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
