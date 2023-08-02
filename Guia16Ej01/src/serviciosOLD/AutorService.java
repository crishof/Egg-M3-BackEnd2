package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorService {

    AutorDAO dao = new AutorDAO();

    public void guardarAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean loop;
        do {
            loop = false;
            Autor autor = new Autor();
            System.out.println("Ingrese nombre del Autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            autor.setAlta(true);

//                        Valida si hay otro autor con el mismo nombre
            List<Autor> autores = dao.buscarAutoresPorNombre(nombre);
            if (!autores.isEmpty()) {
                System.out.println("Ya existe un autor con el mismo nombre");
                loop = true;
                continue;
            }

            dao.persistirAutor(autor);
            System.out.println("Autor guardado exitosamente");

            System.out.println("Desea ingresar otro Autor? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                loop = true;
            }
        } while (loop);
    }
//
//    public void BajaAutor() {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//
//        boolean noEncontrado = true;
//        boolean alta = true;
//        boolean loop;
//
//        Autor autor = buscarAutorNombre();
//        if (autor != null) {
//            do {
//                System.out.println("1 - Dar de baja");
//                System.out.println("2 - Dar de Alta");
//                int opcion = leer.nextInt();
//                switch (opcion) {
//                    case 1 -> {
//                        alta = false;
//                        loop = false;
//                    }
//                    case 2 -> {
//                        alta = true;
//                        loop = false;
//                    }
//                    default -> {
//                        System.out.println("Opcion incorrecta");
//                        loop = true;
//                    }
//                }
//
//            } while (loop);
//            autor.setAlta(alta);
//            noEncontrado = false;
//            dao.actualizarAutor(autor);
//
//        }
//        if (noEncontrado) {
//            System.out.println("Autor no encontrado");
//            leer.next();
//        }
//    }

    public Autor buscarAutorNombre() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.next();
        List<Autor> autores = dao.buscarAutoresPorNombre(nombre);

        Autor ret = null;
        for(Autor aux : autores) {
        if (aux.getNombre().equalsIgnoreCase(nombre)) {
            System.out.println("Autor encontrado");
            System.out.println(aux.toString());
            ret =  aux;
            
        } else {

            System.out.println("Autor no encontrado");
            ret = null;
        }
        }
        return ret;
    }
    
    
//    public void buscarAutor(){
//        
//        Object autor = dao.buscarAutor("pepe");
//        
//        System.out.println(autor.toString());
//    }

}
