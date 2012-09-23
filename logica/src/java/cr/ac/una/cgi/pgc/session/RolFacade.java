/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class RolFacade implements RolFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Rol rol) {
        em.persist(rol);
    }

    public void edit(Rol rol) {
        em.merge(rol);
    }

    public void remove(Rol rol) {
        em.remove(em.merge(rol));
    }

    public Rol find(Object id) {
        return em.find(Rol.class, id);
    }

    public List<Rol> findAll() {
        List<Rol> result = em.createQuery("select object(o) from Rol as o").getResultList();
        if(result.size() > 0){
            for(Rol r: result){
                r.getPermisoCollection().size();
            }
        }
        return result;
    }

}
