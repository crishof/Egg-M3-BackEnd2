package entidades;

public class Casco {
    Sintetizador sintetizador;
    Consola consola;

    public Casco(){
        sintetizador = new Sintetizador();
        consola = new Consola();
    }

    public Sintetizador getSintetizador() {
        return sintetizador;
    }

    public void setSintetizador(Sintetizador sintetizador) {
        this.sintetizador = sintetizador;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "sintetizador=" + sintetizador +
                ", consola=" + consola +
                '}';
    }

    public void usarConsola(Armadura armadura) {
        armadura.setBateria((armadura.getBateria() - (armadura.getCasco().getConsola().getConsumo())));
    }

    public void usarSintetizador(Armadura armadura) {
        armadura.setBateria((armadura.getBateria() - (armadura.getCasco().getSintetizador().getConsumo())));
    }
}
