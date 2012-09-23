/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.Unidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class UnidadFacade implements UnidadFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Unidad unidad) {
        em.persist(unidad);
    }

    public void edit(Unidad unidad) {
        em.merge(unidad);
    }

    public void remove(Unidad unidad) {
        em.remove(em.merge(unidad));
    }

    public Unidad find(Object id) {
        return em.find(Unidad.class, id);
    }

    public List<Unidad> findAll() {
        return em.createQuery("select object(o) from Unidad as o order by o.codigo asc").getResultList();
    }

    /**
     * Realiza una consulta de unidades por el nombre
     * @param nombre Nombre de las unidades
     * @return El resultado de la consulta realizada
     */
    public List<Unidad> findByNombre(String nombre){
        return em.createNamedQuery("Unidad.findByNombre").setParameter("nombre", nombre).getResultList();
    }

    /**
     * Realiza una consulta por las siglas de la unidad
     * @param acron Siglas de la unidad para realizar la búsqueda
     * @return El resultado de la consulta realizada
     */
    public List<Unidad> findByAcron(String acron){
        return em.createNamedQuery("Unidad.findByAcron").setParameter("acron", acron).getResultList();
    }

    /**
     * Realiza la búsqueda de las unidades por una ruta en específico
     * @param r Ruta para realizar la consulta
     * @return El resultado de la búsqueda
     */
    public List<Unidad> findByRuta(Ruta r){
        String query = "select u from Ruta r join r.unidadCollection u where r.numero = :numero";
        return em.createQuery(query).setParameter("numero", r.getNumero()).getResultList();      
    }

}
