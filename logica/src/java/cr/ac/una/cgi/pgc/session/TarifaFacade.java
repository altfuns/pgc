/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import cr.ac.una.cgi.pgc.entity.Tarifa;
import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alfonso
 */
@Stateless
public class TarifaFacade implements TarifaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Tarifa tarifa) {
        em.persist(tarifa);
    }

    public void edit(Tarifa tarifa) {
        em.merge(tarifa);
    }

    public void remove(Tarifa tarifa) {
        em.remove(em.merge(tarifa));
    }

    public Tarifa find(Object id) {
        return em.find(Tarifa.class, id);
    }

    public List<Tarifa> findAll() {
        return em.createQuery("select object(o) from Tarifa as o").getResultList();
    }

    public Tarifa findByParameters(Double peso,GrupoEnvio grupo,TipoEnvio tipo){
        String query = "SELECT t FROM Tarifa t WHERE t.codigoGrupoEnvio = :grupo and t.tipo = :tipo AND :peso BETWEEN t.pesoInicio AND t.pesoFinal";
        Query parameterQuery = em.createQuery(query);
        parameterQuery.setParameter("peso", peso);
        parameterQuery.setParameter("grupo", grupo);
        parameterQuery.setParameter("tipo", tipo);
        Tarifa t = null ;
        try{
            t = (Tarifa)parameterQuery.getSingleResult();

        }catch(NonUniqueResultException ex){

        }catch(NoResultException ex){

        }

        return t;

    }

}
