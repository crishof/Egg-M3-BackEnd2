package entidades;

public class PersonalServicio extends Empleado {

//    • Sobre el personal de servicio, hay que conocer a qué sección están asignados
//            (biblioteca, decanato, secretaría, ...).

    private String seccion;

    public PersonalServicio(String name, String apellido, String estadoCivil, int incorporacion, int despacho, String seccion) {
        super(name, apellido, estadoCivil, incorporacion, despacho);
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
        return "Personal de Servicio: " +
                "id:" + id + "\n" +
                "seccion: " + seccion + "\n" +
                "name='" + name + "\n" +
                "apellido='" + apellido + "\n" +
                "estado Civil='" + estadoCivil + "\n" +
                super.toString();
    }
}
