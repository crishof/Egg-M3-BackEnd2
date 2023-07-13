package entidades;

public class Casco {

    private Consola consola;
    private Sintetizador sintetizador;

    public Casco(Consola consola, Sintetizador sintetizador) {
        this.consola = consola;
        this.sintetizador = sintetizador;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }
}
