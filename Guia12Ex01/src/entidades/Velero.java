package entidades;

public class Velero extends Barco{

    private int mastiles;

    public Velero(String matricula, double eslora, int year, int mastiles) {
        super(matricula, eslora, year);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }
}
