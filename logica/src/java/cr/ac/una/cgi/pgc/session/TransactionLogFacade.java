/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TransactionLog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author red
 */
@Stateless
public class TransactionLogFacade implements TransactionLogFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(TransactionLog transactionLog) {
        em.persist(transactionLog);
    }

    public void edit(TransactionLog transactionLog) {
        em.merge(transactionLog);
    }

    public void remove(TransactionLog transactionLog) {
        em.remove(em.merge(transactionLog));
    }

    public TransactionLog find(Object id) {
        return em.find(TransactionLog.class, id);
    }

    public List<TransactionLog> findAll() {
        return em.createQuery("select object(o) from TransactionLog as o").getResultList();
    }
    public int findMax(){
        String query = "Select max(c.codigo) from TransactionLog as c";
        return (Integer)em.createQuery(query).getSingleResult();
    }

}
