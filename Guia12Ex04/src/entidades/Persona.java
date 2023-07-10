package entidades;

public class Persona {
    private static int contador = 1;
    //    Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de
//    identificación y su estado civil.
    int id;
    String name;
    String apellido;
    String estadoCivil;

    public Persona() {
    }

    public Persona(String name, String apellido, String estadoCivil) {
        id = contador++;
        this.name = name;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estado Civil='" + estadoCivil + '\'' +
                '}';
    }
}

