/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Nota;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alfonso
 */
@Stateless
public class NotaFacade implements NotaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Nota nota) {
        em.persist(nota);
    }

    public void edit(Nota nota) {
        em.merge(nota);
    }

    public void remove(Nota nota) {
        em.remove(em.merge(nota));
    }

    public Nota find(Object id) {
        return em.find(Nota.class, id);
    }

    public List<Nota> findAll() {
        return em.createQuery("select object(o) from Nota as o").getResultList();
    }

}
