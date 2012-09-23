/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
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
public class PermisoFacade implements PermisoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Permiso permiso) {
        em.persist(permiso);
    }

    public void edit(Permiso permiso) {
        em.merge(permiso);
    }

    public void remove(Permiso permiso) {
        em.remove(em.merge(permiso));
    }

    public Permiso find(Object id) {
        return em.find(Permiso.class, id);
    }

    public List<Permiso> findAll() {
        List<Permiso> result = em.createQuery("select object(o) from Permiso as o").getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

    /**
     * Realiza una consulta por el módulo de un permiso
     * @param modulo Nombre del módulo
     * @return El resultado de la consulta
     */
    public List<Permiso> findByModulo(String modulo){
         List<Permiso> result = em.createNamedQuery("Permiso.findByModulo").setParameter("modulo",modulo).getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

    /**
     * Realiza una consulta por rol y por módulo
     * @param rol Rol para realizar la consulta
     * @param modulo Módulo para realizar la consulta
     * @return El resultado de la consulta
     */
    public List<Permiso> findByRolModulo(Rol rol, String modulo){
        String query = "select p from Rol r join r.permisoCollection p where r.codigo = :codigo and p.modulo = :modulo";
        List<Permiso> result = em.createQuery(query).setParameter("codigo", rol.getCodigo()).setParameter("modulo", modulo).getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

    /**
     * Realiza una consulta de permisos por rol
     * @param rol Rol para realizar la consulta
     * @return El resultado de la consulta.
     */
    public List<Permiso> findByRol(Rol rol){
        String query = "select p from Rol r join r.permisoCollection p where r.codigo = :codigo";

        List<Permiso> result = em.createQuery(query).setParameter("codigo", rol.getCodigo()).getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

    /**
     * Realiza una consulta por empleado y por módulo
     * @param empleado Empleado para realizar la consulta
     * @param modulo Módulo para realizar la consulta
     * @return El resultado de la consulta
     */
    public List<Permiso> findByEmpleadoModulo(Empleado empleado, String modulo){
        String query = "select p from Empleado e join e.permisoCollection p where e.id = :id and p.modulo = :modulo";
        List<Permiso> result = em.createQuery(query).setParameter("id", empleado.getId()).setParameter("modulo", modulo).getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

    /**
     * Realiza una consulta de permisos por empleado
     * @param empleado Empleado para realizar la consulta
     * @return El resultado de la consulta
     */
    public List<Permiso> findByEmpleado(Empleado empleado){
        String query = "select p from Empleado e join e.permisoCollection p where e.id = :id";
        List<Permiso> result = em.createQuery(query).setParameter("id", empleado.getId()).getResultList();
        if(result.size() > 0){
            for(Permiso p : result){
                p.getEmpleadoCollection().size();
            }
        }
        return result;
    }

}
