package entidades;


/*
Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.

Disparo (Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.

 */
public class Jugador {

    Revolver revolver;
    private final String nombre;
    private boolean mojado;

    public Jugador(int idJugador) {
        nombre = "Jugador " + idJugador;
        mojado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }

    @Override
    public String toString() {
        return "Jugador{" + '\'' + ", nombre='" + nombre + '\'' + ", mojado=" + mojado + ", revolver=" + revolver + '}';
    }

    public boolean disparo(Revolver revolver) {

        if (revolver.mojar()) {
            mojado = true;
        } else {
            mojado = false;
            revolver.siguienteChorro();
        }
        return mojado;
    }
}
