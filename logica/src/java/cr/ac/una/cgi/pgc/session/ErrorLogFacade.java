/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.ErrorLog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class ErrorLogFacade implements ErrorLogFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(ErrorLog errorLog) {
        em.persist(errorLog);
    }

    public void edit(ErrorLog errorLog) {
        em.merge(errorLog);
    }

    public void remove(ErrorLog errorLog) {
        em.remove(em.merge(errorLog));
    }

    public ErrorLog find(Object id) {
        return em.find(ErrorLog.class, id);
    }

    public List<ErrorLog> findAll() {
        return em.createQuery("select object(o) from ErrorLog as o").getResultList();
    }

    public int findMax(){
        String query = "Select max(c.codigo) from ErrorLog as c";
        return (Integer)em.createQuery(query).getSingleResult();
    }

}
