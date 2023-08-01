/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Autor;
import java.util.List;

/**
 *
 * @author cristian
 */
public class AutorDAO extends DAO {

    public void persistirAutor(Autor autor) {
        persistirEntidad(autor);
    }

    public void actualizarAutor(Autor autor) {
        actualizarEntidad(autor);
    }

    public void borrarEntidad(Autor autor) {
        borrarEntidad(autor);
    }

    public List buscarAutor() {

        return em.createQuery("Select a from Autor a").getResultList();
    }

    public List<Autor> buscarAutoresPorNombre(String nombre) {
        String jpql = "Select a from Autor a where a.nombre = :nombre";
        return em.createQuery(jpql, Autor.class).setParameter("nombre", nombre).getResultList();
    }

}
