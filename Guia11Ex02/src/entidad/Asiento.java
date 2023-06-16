package entidad;

public class Asiento {

    private String nombre;
    private boolean ocupado;
    private Espectador espectador;

    public Asiento() {
    }

    public Asiento(String nombre, boolean ocupado, Espectador espectador) {
        this.nombre = nombre;
        this.ocupado = ocupado;
        this.espectador = espectador;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        String check = " . ";
        if (ocupado){
            check = " x ";
        }
        return nombre + " " + check + " ";
    }
}
