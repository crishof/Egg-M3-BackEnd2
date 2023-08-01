/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import persistencia.EditorialDAO;

/**
 *
 * @author cristian
 */
public class EditorialService {

    EditorialDAO dao = new EditorialDAO();

    public void guardarEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle;

        do {
            bucle = false;
            Editorial editorial = new Editorial();
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            dao.persistirEditorial(editorial);
            System.out.println("Desea cargar ingresar otra editorial? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle = true;
            }
        } while (bucle);
    }

    public void darBajaEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();
        boolean noEncontrado = true;
        boolean alta = true;
        boolean bucle = true;

        List<Editorial> editoriales = dao.consultarEditorial();
        for (Editorial editorial : editoriales) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                do {
                    System.out.println("1- Dar de baja");
                    System.out.println("2- Dar de alta");
                    int opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            alta = false;
                            bucle = false;
                            break;
                        case 2:
                            alta = true;
                            bucle = false;
                            break;
                        default:
                            System.out.println("Opcion no reconocida");
                            bucle = true;
                    }
                } while (bucle);
                editorial.setAlta(alta);
                noEncontrado = false;
                dao.actualizarEditorial(editorial);
                break;
            }
        }
        if (noEncontrado) {
            System.out.println("Editorial no encontrada");
            leer.next();
        }

    }

}
