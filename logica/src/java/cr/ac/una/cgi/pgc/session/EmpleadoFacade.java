/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class EmpleadoFacade implements EmpleadoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Empleado empleado) {
        em.persist(empleado);
    }

    public void edit(Empleado empleado) {
        em.merge(empleado);
    }

    public void remove(Empleado empleado) {
        em.remove(em.merge(empleado));
    }

    public Empleado find(Object id) {
        return em.find(Empleado.class, id);
    }

    public List<Empleado> findAll() {
        List<Empleado> result = em.createQuery("select object(o) from Empleado as o").getResultList();
        if(result.size() > 0){
            for(Empleado e: result){
                e.getPermisoCollection().size();
                e.getCorrespondenciaInternaCollection().size();
                e.getCorrespondenciaInternaCollection1().size();
                e.getErrorLogCollection().size();
                e.getRutaCollection();
                e.getTransactionLogCollection().size();

            }
        }
        return result;
    }    

}
