package entidades;

public class Residencia extends AlojamientoExtra {
    private int habitacionesCant;
    private boolean descuentoGremio;
    private boolean campoDeportivo;

    public Residencia() {
    }

    public Residencia(String name, String address, String location, String gerente, boolean privado, int superficie, int habitacionesCant, boolean descuentoGremio, boolean campoDeportivo) {
        super(name, address, location, gerente, privado, superficie);
        this.habitacionesCant = habitacionesCant;
        this.descuentoGremio = descuentoGremio;
        this.campoDeportivo = campoDeportivo;
    }

    public int getHabitacionesCant() {
        return habitacionesCant;
    }

    public void setHabitacionesCant(int habitacionesCant) {
        this.habitacionesCant = habitacionesCant;
    }

    public boolean isDescuentoGremio() {
        return descuentoGremio;
    }

    public void setDescuentoGremio(boolean descuentoGremio) {
        this.descuentoGremio = descuentoGremio;
    }

    public boolean isCampoDeportivo() {
        return campoDeportivo;
    }

    public void setCampoDeportivo(boolean campoDeportivo) {
        this.campoDeportivo = campoDeportivo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Cantidad de habitaciones: " + habitacionesCant +
                "\n Descuento Gremio: " + descuentoGremio +
                "\n Campo Deportivo: " + campoDeportivo
                ;
    }
}
