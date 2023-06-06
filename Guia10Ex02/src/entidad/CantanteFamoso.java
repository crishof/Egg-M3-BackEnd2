package entidad;

import servicio.CantanteServicio;

public class CantanteFamoso {

    private String nombre;
    private String discoVentas;

    public CantanteFamoso() {
    }

    public CantanteFamoso(String nombre, String discoVentas) {
        this.nombre = nombre;
        this.discoVentas = discoVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscoVentas() {
        return discoVentas;
    }

    public void setDiscoVentas(String discoVentas) {
        this.discoVentas = discoVentas;
    }

    @Override
    public String toString() {
        return "CantanteFamoso{" +
                "nombre='" + nombre + '\'' +
                ", discoVentas='" + discoVentas + '\'' +
                '}';
    }
}
