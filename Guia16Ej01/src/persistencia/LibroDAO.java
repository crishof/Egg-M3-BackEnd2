/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Libro;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
public class LibroDAO extends DAO {

    public void persistirLibro(Libro libro) {
        persistirEntidad(libro);
    }

    public void actualizarLibro(Libro libro) {
        actualizarEntidad(libro);
    }

    public void borrarEntidad(Libro libro) {
        borrarEntidad(libro);
    }

    public List consultaGenerica(String entidad, String atributo, String variable) {
        String jpql = "Select e from Libro e where e." + atributo + " like :variable";
        Query query = em.createQuery(jpql);
        query.setParameter("variable", "%" + variable + "%");
        return query.getResultList();
    }

    public List consultarLibros() {
        String jpql = "Select l from Libro l";
        return em.createQuery(jpql).getResultList();
    }

    public Libro buscarPorIsbn(long id) {
        return em.find(Libro.class, id);
    }

}
