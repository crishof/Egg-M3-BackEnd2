package entidades;

public class Hotel extends Alojamiento implements Comparable<Hotel>{

    private int habitacionesCant;
    private int camasCant;
    private int pisosCant;
    private int precioHabitacion;

    public Hotel() {
    }
    public Hotel(String name, String address, String location, String gerente, int habitacionesCant, int camasCant, int pisosCant,int precioHabitacion) {
        super(name, address, location, gerente);
        this.habitacionesCant = habitacionesCant;
        this.camasCant = camasCant;
        this.pisosCant = pisosCant;
        this.precioHabitacion = precioHabitacion;
    }

    public int getHabitacionesCant() {
        return habitacionesCant;
    }

    public void setHabitacionesCant(int habitacionesCant) {
        this.habitacionesCant = habitacionesCant;
    }

    public int getCamasCant() {
        return camasCant;
    }

    public void setCamasCant(int camasCant) {
        this.camasCant = camasCant;
    }

    public int getPisosCant() {
        return pisosCant;
    }

    public void setPisosCant(int pisosCant) {
        this.pisosCant = pisosCant;
    }

    public int getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(int precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public void precioHabitacion() {
        precioHabitacion = 50 + (pisosCant * habitacionesCant * camasCant);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n habitaciones: " + habitacionesCant +
                "\n camas: " + camasCant +
                "\n pisos: " + pisosCant +
                "\n precio: USD " + precioHabitacion
                ;
    }

    @Override
    public int compareTo(Hotel o) {
        return 0;
    }
}
