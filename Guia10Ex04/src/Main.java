import servicio.CiudadServicio;

import java.util.HashMap;

/*
4. Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta
página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el
numero.
• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
• Muestra por pantalla los datos introducidos
• Pide un código postal y muestra la ciudad asociada si existe sino avisa al
usuario.
• Muestra por pantalla los datos
• Agregar una ciudad con su código postal correspondiente más al HashMap.
• Elimina 3 ciudades existentes dentro del HashMap.
 */
public class Main {

    public static void main(String[] args) {

        CiudadServicio cs = new CiudadServicio();


        HashMap<Integer, String> codigos = cs.cargarCodigosAutom();

        cs.mostrarDatos(codigos);
        cs.buscarCodigo(codigos);
        cs.agregarCiudad(codigos);
        cs.mostrarDatos(codigos);
        cs.eliminarCiudades(codigos);
        cs.mostrarDatos(codigos);





    }

}
