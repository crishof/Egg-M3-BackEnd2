package entidades;

public class YateLujo extends BarcoMotor{

    private int camarotes;

    public YateLujo(String matricula, double eslora, int year, int potencia, int camarotes) {
        super(matricula, eslora, year,potencia);
        this.camarotes = camarotes;
    }

    public int getCamarotes() {
        return camarotes;
    }

    public void setCamarotes(int camarotes) {
        this.camarotes = camarotes;
    }
}
