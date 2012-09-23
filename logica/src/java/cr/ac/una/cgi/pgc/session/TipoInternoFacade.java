/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TipoInterno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class TipoInternoFacade implements TipoInternoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(TipoInterno tipoInterno) {
        em.persist(tipoInterno);
    }

    public void edit(TipoInterno tipoInterno) {
        em.merge(tipoInterno);
    }

    public void remove(TipoInterno tipoInterno) {
        em.remove(em.merge(tipoInterno));
    }

    public TipoInterno find(Object id) {
        return em.find(TipoInterno.class, id);
    }

    public TipoInterno findByDescripcion(String desc){
        return (TipoInterno)em.createNamedQuery("TipoInterno.findByDescripcion").setParameter("descripcion", desc).getSingleResult();
    }

    public List<TipoInterno> findAll() {
        return em.createQuery("select object(o) from TipoInterno as o").getResultList();
    }

}
