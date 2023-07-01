package entidades;

public class Barco {

    private String matricula;
    private double eslora;
    private int year;

    public Barco() {
    }

    public Barco(String matricula, double eslora, int year) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.year = year;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
