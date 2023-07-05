package entidades;

public class Camping extends AlojamientoExtra {

    private int carpasCant;
    private int bath;
    private boolean resto;

    public Camping() {
    }

    public Camping(String name, String address, String location, String gerente, boolean privado, int superficie, int carpasCant, int bath, boolean resto) {
        super(name, address, location, gerente, privado, superficie);
        this.carpasCant = carpasCant;
        this.bath = bath;
        this.resto = resto;
    }

    public int getCarpasCant() {
        return carpasCant;
    }

    public void setCarpasCant(int carpasCant) {
        this.carpasCant = carpasCant;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public boolean isResto() {
        return resto;
    }

    public void setResto(boolean resto) {
        this.resto = resto;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Cantidad de carpas: " + carpasCant +
                "\n Baños: " + bath +
                "\n Restaurant: " + resto;
    }
}