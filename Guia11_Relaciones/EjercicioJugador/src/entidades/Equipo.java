package entidades;

import java.util.List;

public class Equipo {

    List<Jugador> jugadores;

    public Equipo(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "jugadores=" + jugadores +
                '}';
    }
}
