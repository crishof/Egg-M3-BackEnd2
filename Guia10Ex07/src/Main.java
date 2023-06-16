import entidad.Persona;
import servicio.PersonaServicio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/*
Desarrolla una función que reciba como parámetro un ArrayList de objetos "entidad.Persona" y devuelva
un HashSet con los nombres de las personas.
A continuación, implementa otra función que tome este HashSet como entrada y retorne un TreeSet ordenado de los nombres.
Además, crea las entidades y servicios necesarios.
 */
public class Main {
    public static void main(String[] args) {

        PersonaServicio ps = new PersonaServicio();
        ArrayList<Persona> personas =ps.cargarArray();
        HashSet<Persona> personaHashSet = ps.pasaAHash(personas);
        TreeSet <Persona> personaTreeSet = ps.pasaATree(personaHashSet);
        ps.print(personas,personaHashSet,personaTreeSet);

    }
}