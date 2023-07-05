import entidades.Alojamiento;
import servicios.AlojamientoServicio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        AlojamientoServicio as = new AlojamientoServicio();

        ArrayList<Alojamiento> alojamientos = as.crearAlojamientos();

        as.calcularPrecioHabitacion(alojamientos);
        as.menu(alojamientos);


    }
}