/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Presupuesto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class PresupuestoFacade implements PresupuestoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Presupuesto presupuesto) {
        em.persist(presupuesto);
    }

    public void edit(Presupuesto presupuesto) {
        em.merge(presupuesto);
    }

    public void remove(Presupuesto presupuesto) {
        em.remove(em.merge(presupuesto));
    }

    public Presupuesto find(Object id) {
        return em.find(Presupuesto.class, id);
    }

    public List<Presupuesto> findAll() {
        return em.createQuery("select object(o) from Presupuesto as o").getResultList();
    }

}
