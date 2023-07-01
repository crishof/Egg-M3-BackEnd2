package entidades;

public class BarcoMotor extends Barco{

    private int potencia;

    public BarcoMotor(String matricula, double eslora, int year, int potencia) {
        super(matricula, eslora, year);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
