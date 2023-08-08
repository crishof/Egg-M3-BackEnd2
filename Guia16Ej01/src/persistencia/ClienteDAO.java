package persistencia;

import entidades.Cliente;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ClienteDAO extends DAO {

    public void persistirCliente(Cliente cliente) {
        persistirEntidad(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        actualizarEntidad(cliente);
    }

    public void borrarCliente(Cliente cliente) {
        borrarEntidad(cliente);
    }

    public List consultaGenerica(String entidad, String atributo, String variable) {
        conectarBase();
        String jpql = "SELECT e FROM " + entidad + " e WHERE e." + atributo + " LIKE :variable";
        Query query = em.createQuery(jpql);
        query.setParameter("variable", "%" + variable + "%");
//        desconectarBase();
        return query.getResultList();
    }

    public List<Cliente> buscarClienteDni(long dni) {
        conectarBase();
        String jpql = "Select c from Cliente c where c.dni = :dni";
        return em.createQuery(jpql, Cliente.class).setParameter("dni", dni).getResultList();
    }

    public Cliente buscarClienteDniSingle(long dni) {
        conectarBase();
        String jpql = "Select c from Cliente c where c.dni = :dni";
        return em.createQuery(jpql, Cliente.class).setParameter("dni", dni).getSingleResult();
    }
}
