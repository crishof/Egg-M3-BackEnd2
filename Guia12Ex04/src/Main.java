import entidades.Persona;
import servicios.PersonaServicio;

import java.util.ArrayList;

/*
Sistema Gestión Facultad. Se pretende realizar una aplicación para una facultad que gestione
la información sobre las personas vinculadas con la misma y que se pueden clasificar en tres
tipos: estudiantes, profesores y personal de servicio.
A continuación, se detalla qué tipo de
información debe gestionar esta aplicación:


 */
public class Main {

    public static void main(String[] args) {
    PersonaServicio ps = new PersonaServicio();
    ArrayList<Persona> personas = ps.crearPersonas();
    ps.menu(personas);
}
}