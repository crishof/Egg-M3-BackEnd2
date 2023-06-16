package entidad;

import java.util.Arrays;

public class Sala {

    private Asiento[][] asientos;

    public Sala() {
        this.asientos = new Asiento[8][6];
    }

    public Sala(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "asientos=" + Arrays.toString(asientos) +
                '}';
    }
}
