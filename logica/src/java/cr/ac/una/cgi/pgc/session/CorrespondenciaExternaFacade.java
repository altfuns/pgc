/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;
import cr.ac.una.cgi.pgc.entity.Factura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author alfonso
 */
@Stateless
public class CorrespondenciaExternaFacade implements CorrespondenciaExternaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(CorrespondenciaExterna correspondenciaExterna) {
        em.persist(correspondenciaExterna);
    }

    public void edit(CorrespondenciaExterna correspondenciaExterna) {
        em.merge(correspondenciaExterna);
    }

    public void remove(CorrespondenciaExterna correspondenciaExterna) {
        em.remove(em.merge(correspondenciaExterna));
    }

    public CorrespondenciaExterna find(Object id) {
        return em.find(CorrespondenciaExterna.class, id);
    }

    public List<CorrespondenciaExterna> findAll() {
        return em.createQuery("select object(o) from CorrespondenciaExterna as o").getResultList();
    }
    public Integer findIdentificadorMax(){
        String query = "Select max(c.identificador) from CorrespondenciaExterna as c";
        return (Integer)em.createQuery(query).getResultList().get(0);
    }

    public List<CorrespondenciaExterna> findByFactura(Factura factura){
        String query = "SELECT c FROM CorrespondenciaExterna c WHERE c.factura = :factura";
        Query parameterQuery = em.createQuery(query);
        parameterQuery.setParameter("factura", factura);
        return parameterQuery.getResultList();

    }

    public int cantidadSinFactura(){
        String query = "SELECT SUM(ce.cantidad) FROM CorrespondenciaExterna ce WHERE ce.factura is null";
        return Integer.parseInt(em.createQuery(query).getSingleResult().toString());
    }

    public List<CorrespondenciaExterna> findByParameters(String numeroFactura, ArrayList<String> names, ArrayList values){
        String query = numeroFactura != null && numeroFactura.trim().compareTo("") != 0 ?
                "SELECT c FROM Factura f join f.correspondenciaExternaCollection c WHERE f.numero = :numero" :
                "SELECT c FROM CorrespondenciaExterna c";


        if(names != null && values != null && !names.isEmpty() && values.size() == names.size()){
            query += numeroFactura != null && numeroFactura.trim().compareTo("") != 0 ? " AND " : " WHERE ";

            for(int i=0;i<names.size();i++){
                query += "c." + names.get(i) + " = :" + names.get(i);
                query += i+1 != names.size() ? " and " : "";
            }          

        }

        Query parameterQuery = em.createQuery(query);

        if(numeroFactura != null && numeroFactura.trim().compareTo("") != 0){
            parameterQuery.setParameter("numero", numeroFactura);
        }            
            
        if(names != null && values != null && !names.isEmpty() && values.size() == names.size()){
            for(int j = 0; j < values.size(); j++)         
                parameterQuery.setParameter(names.get(j),values.get(j));
        }

        return parameterQuery.getResultList();

    }

    public List reporteExpidida(int mes,int anyo){
        System.out.println("Fechas :" + mes + anyo);
        Date inicio = new Date(anyo-1900,mes-1,1);
        Date fin = new Date(anyo-1900,mes,1);

        String query = "SELECT	u1.acron, SUM(ce.cantidad), SUM(ce.precio),u2.acron FROM CorrespondenciaExterna ce,Unidad u1, Unidad u2 " +
                "WHERE ce.fecha BETWEEN :inicio AND :fin AND ce.unidad = u1 AND u2.codigo = SUBSTRING(u1.codigo,1,1) GROUP BY " +
                "u2.acron, u1.acron, u1.codigo ORDER BY u2.acron, u1.codigo";

        Query q = em.createQuery(query);
        q.setParameter("inicio", inicio,TemporalType.DATE);
        q.setParameter("fin", fin,TemporalType.DATE);
        return q.getResultList();
    }

    public List reporteAnualGatos(int mes,int  anyo){
        Date inicio = new Date(anyo-1900,mes-1,1);
        Date fin = new Date(anyo-1900,mes,1);

        String query = "SELECT u2.acron, SUM(ce.precio) FROM CorrespondenciaExterna ce,Unidad u1, Unidad u2 " +
                "WHERE ce.fecha BETWEEN :inicio AND :fin AND ce.unidad = u1 AND u2.codigo = SUBSTRING(u1.codigo,1,1) AND u2.tipo = 1  " +
                "GROUP BY u2.acron ";
        Query q = em.createQuery(query);
        q.setParameter("inicio", inicio,TemporalType.DATE);
        q.setParameter("fin", fin,TemporalType.DATE);
        return q.getResultList();
    }

    public List reporteGrupoEnvio(int mes,int  anyo){
        Date inicio = new Date(anyo-1900,mes-1,1);
        Date fin = new Date(anyo-1900,mes,1);       
        String query = "SELECT g.nombre,sum(ce.cantidad),SUM(ce.precio) " +
                "FROM CorrespondenciaExterna ce, GrupoEnvio g, Pais p " +
                "WHERE ce.pais.codigo = p.codigo AND p.codigoGrupoEnvio.codigo = g.codigo AND ce.fecha BETWEEN :inicio AND :fin " +
                "GROUP BY g.nombre";
        Query q = em.createQuery(query);
        q.setParameter("inicio", inicio,TemporalType.DATE);
        q.setParameter("fin", fin,TemporalType.DATE);
        return q.getResultList();
    }

}
