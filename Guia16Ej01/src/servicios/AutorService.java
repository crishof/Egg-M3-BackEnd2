/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;

public class AutorService {

    AutorDAO dao = new AutorDAO();

    public void guardarAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean bucle;
        do {
            bucle = false;
            Autor autor = new Autor();
            System.out.println("Ingrese nombre del Autor");
            String nombre = leer.next();
            autor.setNombre(nombre);
            autor.setAlta(true);

//                        Valida si hay otro autor con el mismo nombre
            List<Autor> autores = dao.buscarAutoresPorNombre(nombre);
            if (autores.isEmpty()) {
                System.out.println("Ya existe un autor con el mismo nombre");
                continue;
            }

            dao.persistirAutor(autor);
            System.out.println("Autor guardado exitosamente");

            System.out.println("Desea ingresar otro Autor? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                bucle = true;
            }
        } while (bucle);
    }

    public void BajaAutor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        boolean noEncontrado = true;
        boolean alta = true;
        boolean bucle;

        Autor autor = buscarAutorNombre();
        if (autor != null) {
            do {
                System.out.println("1 - Dar de baja");
                System.out.println("2 - Dar de Alta");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1 -> {
                        alta = false;
                        bucle = false;
                    }
                    case 2 -> {
                        alta = true;
                        bucle = false;
                    }
                    default -> {
                        System.out.println("Opcion incorrecta");
                        bucle = true;
                    }
                }

            } while (bucle);
            autor.setAlta(alta);
            noEncontrado = false;
            dao.actualizarAutor(autor);

        }
        if (noEncontrado) {
            System.out.println("Autor no encontrado");
            leer.next();
        }
    }

    public Autor buscarAutorNombre() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.next();
        List<Autor> autores = dao.buscarAutor();
        for (Autor aux : autores) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Autor encontrado");
                System.out.println(aux);
                return aux;
            }

        }

        System.out.println("Autor no encontrado");
        return null;

    }

}
