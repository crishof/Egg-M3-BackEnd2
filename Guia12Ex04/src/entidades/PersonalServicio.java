package entidades;

public class PersonalServicio extends Empleado{

//    • Sobre el personal de servicio, hay que conocer a qué sección están asignados
//            (biblioteca, decanato, secretaría, ...).

    private String seccion;

    public PersonalServicio(int id, String name, String apellido, String estadoCivil, int incorporacion, int despacho, String seccion) {
        super(id, name, apellido, estadoCivil, incorporacion, despacho);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "PersonalServicio{" +
                "seccion='" + seccion + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                "} " + super.toString();
    }
}
