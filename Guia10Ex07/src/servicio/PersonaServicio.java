package servicio;

import entidad.Persona;

import java.util.*;

public class PersonaServicio {

    public ArrayList<Persona> cargarArray(){

        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Cris", 34566578));
        personas.add(new Persona("Tom", 33457856));
        personas.add(new Persona("Pepe", 22345879));
        personas.add(new Persona("Fer", 14654766));
        personas.add(new Persona("Sofia", 39455322));
        personas.add(new Persona("Clara", 55677854));
        return personas;
    }

    public HashSet<Persona> pasaAHash(ArrayList<Persona> personas){

        return new HashSet<>(personas);
    }

    public TreeSet<Persona> pasaATree (HashSet<Persona> personaHashSet){

        return new TreeSet<>(personaHashSet);
    }

    public void print (ArrayList<Persona> personaArrayList, HashSet<Persona> personaHashSet, TreeSet<Persona> personaTreeSet){

        System.out.println("personaArrayList = " + personaArrayList);
        System.out.println("personaHashSet = " + personaHashSet);
        System.out.println("personaTreeSet = " + personaTreeSet);
    }
}
