import entidad.CantanteFamoso;
import servicio.CantanteServicio;

import java.util.ArrayList;

/*
2. Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.

Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5
objetos de tipo CantanteFamoso a la lista.

Luego, se debe mostrar los nombres de cada cantante y su disco con más ventas por pantalla.

Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el
usuario elija o de salir del programa. Al final se deberá mostrar la lista con todos los
cambios.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<CantanteFamoso> cantantes = new ArrayList<>();
        CantanteServicio cs = new CantanteServicio();

        cantantes.add(new CantanteFamoso("Charly Garcia","Unplugged"));
        cantantes.add(new CantanteFamoso("Fito Paez","El amor despues del amor"));
        cantantes.add(new CantanteFamoso("Los redondos","Oktubre"));
        cantantes.add(new CantanteFamoso("U2","The Joshua tree"));
        cantantes.add(new CantanteFamoso("Red hot","Californication"));

        cs.mostrarLista(cantantes);
        cs.menu(cantantes);

    }
}
