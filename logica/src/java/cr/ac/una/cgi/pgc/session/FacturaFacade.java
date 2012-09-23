/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alfonso
 */
@Stateless
public class FacturaFacade implements FacturaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Factura factura) {
        em.persist(factura);
    }

    public void edit(Factura factura) {
        em.merge(factura);
    }

    public void remove(Factura factura) {
        em.remove(em.merge(factura));
    }

    public Factura find(Object id) {
        return em.find(Factura.class, id);
    }

    public List<Factura> findAll() {
        return em.createQuery("select object(o) from Factura as o").getResultList();
    }
    
    public List<Factura> findByParameters(ArrayList<String> names, ArrayList values){
        String query = "SELECT f FROM Factura f";
        Query parameterQuery = em.createNamedQuery(query);

        if(names != null && values != null && !names.isEmpty() && values.size() == names.size()){
            query += " WHERE ";

            for(int i=0;i<names.size();i++){
                query += "f." + names.get(i) + " = :" + names.get(i);
                query += i+1 != names.size() ? " and " : "";
            }

            parameterQuery = em.createQuery(query);

            for(int j = 0; j < values.size(); j++)
                parameterQuery.setParameter(names.get(j),values.get(j));

        }

        return parameterQuery.getResultList();

    }
}
