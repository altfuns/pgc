/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.MovimientoPresupuesto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class MovimientoPresupuestoFacade implements MovimientoPresupuestoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(MovimientoPresupuesto movimientoPresupuesto) {
        em.persist(movimientoPresupuesto);
    }

    public void edit(MovimientoPresupuesto movimientoPresupuesto) {
        em.merge(movimientoPresupuesto);
    }

    public void remove(MovimientoPresupuesto movimientoPresupuesto) {
        em.remove(em.merge(movimientoPresupuesto));
    }

    public MovimientoPresupuesto find(Object id) {
        return em.find(MovimientoPresupuesto.class, id);
    }

    public List<MovimientoPresupuesto> findAll() {
        return em.createQuery("select object(o) from MovimientoPresupuesto as o").getResultList();
    }

}
