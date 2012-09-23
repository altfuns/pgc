/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class GrupoEnvioFacade implements GrupoEnvioFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(GrupoEnvio grupoEnvio) {
        em.persist(grupoEnvio);
    }

    public void edit(GrupoEnvio grupoEnvio) {
        em.merge(grupoEnvio);
    }

    public void remove(GrupoEnvio grupoEnvio) {
        em.remove(em.merge(grupoEnvio));
    }

    public GrupoEnvio find(Object id) {
        return em.find(GrupoEnvio.class, id);
    }

    public List<GrupoEnvio> findAll() {
        return em.createQuery("select object(o) from GrupoEnvio as o").getResultList();
    }

}
