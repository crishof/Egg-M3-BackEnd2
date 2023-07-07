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
