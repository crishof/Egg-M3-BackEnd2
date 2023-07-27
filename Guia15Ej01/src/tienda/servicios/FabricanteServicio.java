/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

import java.util.Scanner;

public class FabricanteServicio {

    private final FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    public void crearFabricante() throws Exception {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre del fabricante");
        String nombre = scanner.next();
        System.out.println("Ingrese la nacionalidad");
        String nacionalidad = scanner.next();

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
                throw new Exception("Debe indicar la nacionalidad");
            }
            if (buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe un fabricante con ese nombre");
            }

            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricante.setNacionalidad(nacionalidad);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            return dao.buscarFabricantePorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    public int buscarCodigoFabricante(String nombre) throws Exception {
        try {

            //Validamos
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del fabricante a buscar");
            }

            Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);

            System.out.println("fabricante = " + fabricante);

            return fabricante.getCodigo();
        } catch (Exception e) {
            throw e;
        }
    }

    }
