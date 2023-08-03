package persistencia;

import entidades.Autor;
import java.util.List;

public class AutorDAO extends DAO {

    public void persistirAutor(Autor autor) {
        persistirEntidad(autor);
    }

    public void actualizarAutor(Autor autor) {
        actualizarEntidad(autor);
    }

    public void borrarAutor(Autor autor) {
        borrarEntidad(autor);
    }

    public Object buscarAutor(String nombre) {

        conectarBase();
        String jpql = "Select a from Autor a where a.nombre = :nombre";
        Object autor = em.createQuery(jpql)
                .setParameter("nombre", nombre).getSingleResult();

        desconectarBase();
        return autor;
    }

    public List<Autor> buscarAutoresPorNombre(String nombre) {
        conectarBase();
        String jpql = "Select a from Autor a where a.nombre = :nombre";

        List<Autor> autores = em.createQuery(jpql).setParameter("nombre", nombre).getResultList();

        desconectarBase();

        return autores;
    }
}
