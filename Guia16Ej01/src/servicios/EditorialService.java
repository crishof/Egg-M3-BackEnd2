package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialService {

    EditorialDAO dao = new EditorialDAO();

    public void guardarEditorial() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean loop;
        do {
            loop = false;
            Editorial editorial = new Editorial();
            System.out.println("Ingrese nombre de la editorial");
            String nombre = leer.next();
            editorial.setNombre(nombre);
            editorial.setAlta(true);

//                        Valida si hay otra editorial con el mismo nombre
            List<Editorial> editoriales = dao.buscarEditorialPorNombre(nombre);
            if (!editoriales.isEmpty()) {
                System.out.println("Ya existe una editorial con el mismo nombre");
                loop = true;
                continue;
            }

            dao.persistirEditorial(editorial);
            System.out.println("Editorial guardada exitosamente");

            System.out.println("Desea ingresar otra Editorial? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                loop = true;
            }
        } while (loop);
    }

    public Editorial guardarEditorial(String nombre) {

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);

        dao.persistirEditorial(editorial);
        System.out.println("Editorial guardada exitosamente");

        return editorial;
    }

    public void BajaEditorial() {
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
