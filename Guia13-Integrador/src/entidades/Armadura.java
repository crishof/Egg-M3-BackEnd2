package entidades;

public class Armadura {

    private String colorPrimario;
    private String colorSecundario;

    private Bota botaL;
    private Bota botaR;
    private Guante guanteR;
    private Guante guanteL;
    private Casco casco;
    private int resistencia;
    private int salud;
    private int bateria;

    public Armadura(String colorPrimario, String colorSecundario, Bota botaL, Bota botaR, Guante guanteR, Guante guanteL, Casco casco, int resistencia, int salud, int bateria) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.botaL = botaL;
        this.botaR = botaR;
        this.guanteR = guanteR;
        this.guanteL = guanteL;
        this.casco = casco;
        this.resistencia = resistencia;
        this.salud = salud;
        this.bateria = bateria;
    }

    public String getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(String colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Bota getBotaL() {
        return botaL;
    }

    public void setBotaL(Bota botaL) {
        this.botaL = botaL;
    }

    public Bota getBotaR() {
        return botaR;
    }

    public void setBotaR(Bota botaR) {
        this.botaR = botaR;
    }

    public Guante getGuanteR() {
        return guanteR;
    }

    public void setGuanteR(Guante guanteR) {
        this.guanteR = guanteR;
    }

    public Guante getGuanteL() {
        return guanteL;
    }

    public void setGuanteL(Guante guanteL) {
        this.guanteL = guanteL;
    }

    public Casco getCasco() {
        return casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public void consumoCaminar(){};
    public void consumoVolar(){};
    public void consumoCorrer(){};
    public void consumoPropulsar(){};
    public void consumoEscribir(){};
    public void consumoLeer(){};

    public void consumirBateria(int consumo){
        bateria-= consumo;
    };

}
