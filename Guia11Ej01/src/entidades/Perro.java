package entidades;

public class Perro {

    String nombre;
    String raza;
    int edad;
    String size;

    public Perro(String nombre, String raza, int edad, String size) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.size = size;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", size='" + size + '\'' +
                '}';
    }
}
