package entidades;

public class Empleado extends Persona{

//    Con respecto a los empleados, sean del tipo que sean, hay que saber su año de
//    incorporación a la facultad y qué número de despacho tienen asignado.

    private int incorporacion;
    private int despacho;

    public Empleado() {
    }

    public Empleado(int id, String name, String apellido, String estadoCivil, int incorporacion, int despacho) {
        super(id, name, apellido, estadoCivil);
        this.incorporacion = incorporacion;
        this.despacho = despacho;
    }

    public int getIncorporacion() {
        return incorporacion;
    }

    public void setIncorporacion(int incorporacion) {
        this.incorporacion = incorporacion;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "incorporacion=" + incorporacion +
                ", despacho=" + despacho +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                "} " + super.toString();
    }
}
