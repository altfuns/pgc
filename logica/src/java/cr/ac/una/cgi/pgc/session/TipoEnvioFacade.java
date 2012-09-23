/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class TipoEnvioFacade implements TipoEnvioFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(TipoEnvio tipoEnvio) {
        em.persist(tipoEnvio);
    }

    public void edit(TipoEnvio tipoEnvio) {
        em.merge(tipoEnvio);
    }

    public void remove(TipoEnvio tipoEnvio) {
        em.remove(em.merge(tipoEnvio));
    }

    public TipoEnvio find(Object id) {
        return em.find(TipoEnvio.class, id);
    }

    public List<TipoEnvio> findAll() {
        return em.createQuery("select object(o) from TipoEnvio as o").getResultList();
    }

}
