package entidades;

public class HotelCuatro extends Hotel {

    private char gimnasioTipo;
    private String restoNombre;
    private int restoCapacidad;

    public HotelCuatro() {
    }

    public HotelCuatro(String name, String address, String location, String gerente, int habitacionesCant, int camasCant, int pisosCant, int precioHabitacion, char gimnasioTipo, String restoNombre, int restoCapacidad) {
        super(name, address, location, gerente, habitacionesCant, camasCant, pisosCant, precioHabitacion);
        this.gimnasioTipo = gimnasioTipo;
        this.restoNombre = restoNombre;
        this.restoCapacidad = restoCapacidad;
    }

    public char getGimnasioTipo() {
        return gimnasioTipo;
    }

    public void setGimnasioTipo(char gimnasioTipo) {
        this.gimnasioTipo = gimnasioTipo;
    }

    public String getRestoNombre() {
        return restoNombre;
    }

    public void setRestoNombre(String restoNombre) {
        this.restoNombre = restoNombre;
    }

    public int getRestoCapacidad() {
        return restoCapacidad;
    }

    public void setRestoCapacidad(int restoCapacidad) {
        this.restoCapacidad = restoCapacidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n gimnasio Tipo: " + gimnasioTipo +
                "\n Restaurant: " + restoNombre +
                "\n Capacidad Restaurant: " + restoCapacidad + " personas"
                ;
    }
}
