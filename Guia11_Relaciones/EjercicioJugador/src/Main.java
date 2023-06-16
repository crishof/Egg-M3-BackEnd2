import entidades.Equipo;
import entidades.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(new Jugador("Lionel","Messi","dorsal",10));
        jugadores.add(new Jugador("Marcos","Rojo","cenrto",6));
        jugadores.add(new Jugador("Cristiano","Ronaldo","extremo",7));

        Equipo equipo = new Equipo(new ArrayList<Jugador> (jugadores) );

        System.out.println("Equipo: " + equipo);




    }
}
