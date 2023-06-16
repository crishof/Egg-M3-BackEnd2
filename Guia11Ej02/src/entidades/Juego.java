package entidades;

import java.util.ArrayList;

/*
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
public class Juego {

    private ArrayList<Jugador> jugadores;
    private Revolver revolver;

    public void llenarJuego(ArrayList<Jugador> jugadores, Revolver revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    public boolean ronda() {

        Jugador actual = jugadores.get(0);
        boolean disparo = actual.disparo(revolver);
        if (disparo) {
            actual.setMojado(true);
        }
        return disparo;
    }
}
