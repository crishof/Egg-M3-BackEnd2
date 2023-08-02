package persistencia;

import entidades.Libro;
import java.util.List;
import javax.persistence.Query;

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
        conectarBase();
        String jpql = "SELECT e FROM " + entidad + " e WHERE e." + atributo + " LIKE :variable";
        Query query = em.createQuery(jpql);
        query.setParameter("variable", "%" + variable + "%");
//        desconectarBase();
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
