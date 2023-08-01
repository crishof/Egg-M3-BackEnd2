/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Editorial;
import java.util.List;

/**
 *
 * @author cristian
 */
public class EditorialDAO extends DAO {

    public void persistirEditorial(Editorial editorial) {
        persistirEntidad(editorial);
    }

    public void actualizarEditorial(Editorial editorial) {
        actualizarEntidad(editorial);
    }

    protected void borrarEditorial(Editorial editorial) {
        borrarEntidad(editorial);

    }

    public List consultarEditorial() {
        String jpql = "Select e from Editorial e";
        return em.createQuery(jpql).getResultList();
    }

    public List<Editorial> buscarEditorialPorNombre(String nombre) {
        String jpql = "Select e from Editorial e where e.nombre = :nombre";
        return em.createQuery(jpql, Editorial.class).setParameter("nombre", nombre).getResultList();
    }

}
