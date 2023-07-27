package entidades;

public class Sintetizador {

    private int consumo;

    public Sintetizador(){
        consumo = 1;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Sintetizador{" +
                "consumo=" + consumo +
                '}';
    }
}
