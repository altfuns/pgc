/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Pais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author red
 */
@Stateless
public class PaisFacade implements PaisFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Pais pais) {
        em.persist(pais);
    }

    public void edit(Pais pais) {
        em.merge(pais);
    }

    public void remove(Pais pais) {
        em.remove(em.merge(pais));
    }

    public Pais find(Object id) {
        return em.find(Pais.class, id);
    }

    public List<Pais> findAll() {
        return em.createQuery("select object(o) from Pais as o").getResultList();
    }

    /**
     * Realiza una consulta de los paises por nombre.
     * @param nombre Nombre a buscar
     * @return El resultado de la consulta
     */
    public List<Pais> findByNombre(String nombre){
        return em.createNamedQuery("Pais.findByNombre").setParameter("nombre", nombre).getResultList();
    }

    /**
     * Realiza una consulta de paises por grupo de envío
     * @param grupoEnvio Nombre del grupo de envío
     * @return El resultado de la consulta
     */
    public List<Pais> findByGrupoEnvio(String grupoEnvio){
        String query = "SELECT p FROM Pais p WHERE p.grupo_envio = :grupo";
        Query parameterQuery = em.createQuery(query);
        parameterQuery.setParameter("grupo", grupoEnvio);
        return parameterQuery.getResultList();
    }

}
