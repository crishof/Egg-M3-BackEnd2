package uttilidades;

import entidades.Alojamiento;
import entidades.Hotel;

import java.util.Comparator;

public class Comparadores {

    public static Comparator<Alojamiento> ordenarPorNombre = new Comparator<Alojamiento>() {
        @Override
        public int compare(Alojamiento p1, Alojamiento p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };
    public static Comparator<Hotel> ordenarPorPrecio = new Comparator<Hotel>() {
        @Override
        public int compare(Hotel p1, Hotel p2) {
            return Integer.compare(p2.getPrecioHabitacion(), p1.getPrecioHabitacion());
        }
    };
}
