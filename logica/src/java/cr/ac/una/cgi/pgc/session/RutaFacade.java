/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Ruta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class RutaFacade implements RutaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Ruta ruta) {
        em.persist(ruta);
    }

    public void edit(Ruta ruta) {
        em.merge(ruta);
    }

    public void remove(Ruta ruta) {
        em.remove(em.merge(ruta));
    }

    public Ruta find(Object id) {
        return em.find(Ruta.class, id);
    }

    public List<Ruta> findAll() {
        return em.createQuery("select object(o) from Ruta as o order by o.numero").getResultList();
    }

    /**
     * Extrae la lista de las unidades por empleado, y directamente extrae las unidades por
     * ruta.
     * @param empleado Empleado para realizar la consulta
     * @return El resultado de la consulta.
     */
    public List<Ruta> findByEmpleado(Empleado empleado){
        
        String query = "select r from Empleado e join e.rutaCollection r where e.id = :id";

        List<Ruta> rutas = em.createQuery(query).setParameter("id", empleado.getId()).getResultList();

        for(Ruta r : rutas){
            r.getUnidadCollection().size();
        }

        return rutas;
        
    }

}
