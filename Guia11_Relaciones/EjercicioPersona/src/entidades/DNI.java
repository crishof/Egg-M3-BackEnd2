package entidades;

public class DNI {


    private long numero;
    private char serie;

    public DNI() {
    }

    public DNI(long numero, char serie) {
        this.numero = numero;
        this.serie = serie;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public char getSerie() {
        return serie;
    }

    public void setSerie(char serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "DNI{" +
                "numero=" + numero +
                ", serie=" + serie +
                '}';
    }
}
