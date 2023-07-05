package entidades;

public class HotelCinco extends HotelCuatro {

    private int salones;
    private int suites;
    private int limo;

    public HotelCinco() {
    }

    public HotelCinco(String name, String address, String location, String gerente, int habitacionesCant, int camasCant, int pisosCant, int precioHabitacion, char gimnasio, String restoNombre, int restoCapacidad, int salones, int suites, int limo) {
        super(name, address, location, gerente, habitacionesCant, camasCant, pisosCant, precioHabitacion, gimnasio, restoNombre, restoCapacidad);
        this.salones = salones;
        this.suites = suites;
        this.limo = limo;
    }

    public int getSalones() {
        return salones;
    }

    public void setSalones(int salones) {
        this.salones = salones;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getLimo() {
        return limo;
    }

    public void setLimo(int limo) {
        this.limo = limo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n salones: " + salones +
                "\n suites: " + suites +
                "\n limosina: " + limo
                ;
    }
}
