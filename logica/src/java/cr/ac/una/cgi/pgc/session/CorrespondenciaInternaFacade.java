/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;
import cr.ac.una.cgi.pgc.entity.Ruta;
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
 * @author red
 */
@Stateless
public class CorrespondenciaInternaFacade implements CorrespondenciaInternaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(CorrespondenciaInterna correspondenciaInterna) {
        em.persist(correspondenciaInterna);
    }

    public void edit(CorrespondenciaInterna correspondenciaInterna) {
        em.merge(correspondenciaInterna);
    }

    public void remove(CorrespondenciaInterna correspondenciaInterna) {
        em.remove(em.merge(correspondenciaInterna));
    }

    public CorrespondenciaInterna find(Object id) {
        return em.find(CorrespondenciaInterna.class, id);
    }

    public List<CorrespondenciaInterna> findAll() {
        return em.createQuery("select object(o) from CorrespondenciaInterna as o").getResultList();
    }

    /**
     * Método que consulta la correspondencia interna por ruta y fecha recibido
     * @param ruta Ruta con la cuál se consultará
     * @param fechaRecibido Fecha con la cuál se consultará
     * @return Resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findByInternaFechaRecibido(Ruta ruta, Date fechaRecibido){

        String query = "select c from Ruta r join r.correspondenciaInternaCollection c where " +
                "r.numero = :numero and c.fechaRecibido = :fechaRecibido";

        return em.createQuery(query).setParameter("numero", ruta.getNumero()).setParameter("fechaRecibido", fechaRecibido).getResultList();
    }

    /**
     * Método que consulta la correspondencia externa fecha recibido
     * @param fechaRecibido Fecha con la cuál se consultará
     * @return Resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findByExternaFechaRecibido(Date fechaRecibido){
        String query = "select c from TipoInterno t join t.correspondenciaInternaCollection c where t.acron <> 'CCR' and " +
                "c.rutaAsignada is null and c.fechaRecibido = :fechaRecibido";

        return em.createQuery(query).setParameter("fechaRecibido", fechaRecibido).getResultList();

    }

    /**
     * Método que devuelve los registros de correspondencia interna que pertenecen al día de hoy o que no han sido entregados,
     * para esto debe verificar si fueron entregados (fechaRecibido es nulo) y ademas que pertenezcan a un
     * periódo de 4 días anteriores(sin contar fines de semana). Esta consulta se realiza por una ruta.
     *
     * @param ruta Ruta con la cuál se realizará la consulta
     * @param fecha1 Fecha de Hoy
     * @param fecha2 Fecha de Ayer
     * @param fecha3 Fecha de Anteayer
     * @param fecha4 Fecha de hace 3 días
     * @param fecha5 Fceha de hace 4 días
     * @return El resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findRegistrosCorrespondenciaInterna(Ruta ruta, Date fecha1, Date fecha2, Date fecha3, Date fecha4, Date fecha5){
        
        String query = "select c from Ruta r join r.correspondenciaInternaCollection c where " +
                "r.numero = :numero and (c.fechaRecibido = :fecha1 or (c.fechaRecibido is null and (c.fechaEntregaMensajero = :fecha2 " +
                "or c.fechaEntregaMensajero = :fecha3 or c.fechaEntregaMensajero = :fecha4 or c.fechaEntregaMensajero = :fecha5 or c.fechaEntregaMensajero = :fecha6))) ORDER BY c.destinoUnidad, c.codigo ASC";

        Query parameterQuery = em.createQuery(query);

        parameterQuery.setParameter("numero", ruta.getNumero());
        parameterQuery.setParameter("fecha1",fecha1);
        parameterQuery.setParameter("fecha2",fecha1);
        parameterQuery.setParameter("fecha3", fecha2);
        parameterQuery.setParameter("fecha4", fecha3);
        parameterQuery.setParameter("fecha5", fecha4);
        parameterQuery.setParameter("fecha6", fecha5);

        return parameterQuery.getResultList();
    }

    /**
     * Método que devuelve los registros de correspondencia externa que pertenecen al día de hoy o que no han sido entregados,
     * para esto debe verificar si fueron entregados (fechaRecibido es nulo) y ademas que pertenezcan a un
     * periódo de 4 días anteriores(sin contar fines de semana).
     *
     * @param fecha1 Fecha de Hoy
     * @param fecha2 Fecha de Ayer
     * @param fecha3 Fecha de Anteayer
     * @param fecha4 Fecha de hace 3 días
     * @param fecha5 Fceha de hace 4 días
     * @return El resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findRegistrosCorrespondenciaExterna(Date fecha1, Date fecha2, Date fecha3, Date fecha4, Date fecha5){
       
        String query = "select c from TipoInterno t join t.correspondenciaInternaCollection c where t.acron <> 'CCR' and " +
                "c.rutaAsignada is null and (c.fechaRecibido = :fecha1 or (c.fechaRecibido is null and (c.fechaEntregaMensajero = :fecha2 " +
                "or c.fechaEntregaMensajero = :fecha3 or c.fechaEntregaMensajero = :fecha4 or c.fechaEntregaMensajero = :fecha5 or c.fechaEntregaMensajero = :fecha6))) ORDER BY c.destinoUnidad, c.codigo ASC";

        Query parameterQuery = em.createQuery(query);

        parameterQuery.setParameter("fecha1",fecha1);
        parameterQuery.setParameter("fecha2",fecha1);
        parameterQuery.setParameter("fecha3", fecha2);
        parameterQuery.setParameter("fecha4", fecha3);
        parameterQuery.setParameter("fecha5", fecha4);
        parameterQuery.setParameter("fecha6", fecha5);

        return parameterQuery.getResultList();
    }

    /**
     * Método que devuelve los registros de correspondencia interna que no han sido entregados,
     * para esto debe verificar si fueron entregados (fechaRecibido es nulo) y ademas que pertenezcan a un
     * periódo de 4 días anteriores(sin contar fines de semana). Esta consulta se realiza por una ruta.
     *
     * @param ruta Ruta con la cuál se realizará la consulta
     * @param fecha1 Fecha de Hoy
     * @param fecha2 Fecha de Ayer
     * @param fecha3 Fecha de Anteayer
     * @param fecha4 Fecha de hace 3 días
     * @param fecha5 Fceha de hace 4 días
     * @return El resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findNoEntregadosInterna(Ruta ruta, Date fecha1, Date fecha2, Date fecha3, Date fecha4, Date fecha5){
        String query = "select c from Ruta r join r.correspondenciaInternaCollection c where " +
                "r.numero = :numero and (c.fechaRecibido is null and (c.fechaEntregaMensajero = :fecha1 " +
                "or c.fechaEntregaMensajero = :fecha2 or c.fechaEntregaMensajero = :fecha3 or " +
                "c.fechaEntregaMensajero = :fecha4 or c.fechaEntregaMensajero = :fecha5))";

        Query parameterQuery = em.createQuery(query);

        parameterQuery.setParameter("numero", ruta.getNumero());
        parameterQuery.setParameter("fecha1",fecha1);
        parameterQuery.setParameter("fecha2", fecha2);
        parameterQuery.setParameter("fecha3", fecha3);
        parameterQuery.setParameter("fecha4", fecha4);
        parameterQuery.setParameter("fecha5", fecha5);

        return parameterQuery.getResultList();
    }    

    /**
     * Método que devuelve los registros de correspondencia externa que no han sido entregados,
     * para esto debe verificar si fueron entregados (fechaRecibido es nulo) y ademas que pertenezcan a un
     * periódo de 4 días anteriores(sin contar fines de semana).
     * 
     * @param fecha1 Fecha de Hoy
     * @param fecha2 Fecha de Ayer
     * @param fecha3 Fecha de Anteayer
     * @param fecha4 Fecha de hace 3 días
     * @param fecha5 Fceha de hace 4 días
     * @return El resultado de esta consulta
     */
    public List<CorrespondenciaInterna> findNoEntregadosExterna(Date fecha1, Date fecha2, Date fecha3, Date fecha4, Date fecha5){
        String query = "select c from TipoInterno t join t.correspondenciaInternaCollection c where t.acron <> 'CCR' and " +
                "c.rutaAsignada is null and c.fechaRecibido is null and (c.fechaEntregaMensajero = :fecha1 " +
                "or c.fechaEntregaMensajero = :fecha2 or c.fechaEntregaMensajero = :fecha3 " +
                "or c.fechaEntregaMensajero = :fecha4 or c.fechaEntregaMensajero = :fecha5) ";

        Query parameterQuery = em.createQuery(query);

        parameterQuery.setParameter("fecha1", fecha1);
        parameterQuery.setParameter("fecha2", fecha2);
        parameterQuery.setParameter("fecha3", fecha3);
        parameterQuery.setParameter("fecha4", fecha4);
        parameterQuery.setParameter("fecha5", fecha5);

        return parameterQuery.getResultList();
    }

    /**
     * Calcula el mayor identificador
     * @return El mayor identificador
     */
    public int findIdentificadorMax(){
        String query = "Select max(c.identificador) from CorrespondenciaInterna as c";
        return (Integer)em.createQuery(query).getSingleResult();
    }
    
    /**
     * Realiza una consulta de correspondencia por varios parámetros. Para ello crea
     * un Query con una serie de valores.
     * @param names Nombres de los campos
     * @param values Valores de los campos
     * @return Los resultados de la consulta
     */
    public List<CorrespondenciaInterna> findByParameters(String[] names, Object[] values){
        String query = "SELECT o FROM CorrespondenciaInterna o ORDER BY o.destinoUnidad, o.codigo";
        Query parameterQuery = em.createQuery(query);      
        
        if(names != null && values != null && names.length != 0 && values.length == names.length){
            query += " WHERE ";
            for(int i = 0; i < names.length; i++){
                query += "o." + names[i] + " = :" + names[i];
                query += i+1 != names.length ? " and " : "";
            }

            query += " ORDER BY o.destinoUnidad, o.codigo";
            parameterQuery = em.createQuery(query);
            for(int j = 0; j < values.length; j++)
                parameterQuery.setParameter(names[j],values[j]);
                        
        }        
                
        return parameterQuery.getResultList();
        
    }

    
    public List reporteRutas(int mes,int  anyo){
         Date inicio = new Date(anyo-1900,mes-1,1);
         Date fin = new Date(anyo-1900,mes,1);
        
         String query = "SELECT ci.rutaAsignada.numero,COUNT(ci.identificador) " +
                "FROM CorrespondenciaInterna ci " +
                "WHERE ci.destinoUnidad IS NOT NULL AND ci.fechaRecibido BETWEEN :inicio AND :fin " +
                "GROUP BY ci.rutaAsignada.numero";
       
        Query q = em.createQuery(query);
        q.setParameter("inicio", inicio,TemporalType.DATE);
        q.setParameter("fin", fin,TemporalType.DATE);
        List l = q.getResultList();
        l.addAll(reporteExterna(inicio, fin));
        return l;
    }
    private List reporteExterna(Date inicio,Date fin){
         String query = "SELECT COUNT(ci.identificador)  " +
                "FROM TipoInterno t join t.correspondenciaInternaCollection ci " +
                "WHERE t.acron <> 'CCR' AND ci.rutaAsignada IS NULL AND ci.fechaRecibido BETWEEN :inicio AND :fin";

        Query q = em.createQuery(query);
        q.setParameter("inicio", inicio,TemporalType.DATE);
        q.setParameter("fin", fin,TemporalType.DATE);
        Object o = q.getSingleResult();
        Object[] oa = new Object[2];
        oa[0] = "Externa";
        oa[1] = o;
        ArrayList a = new ArrayList();
        a.add(oa);
        return a;
    }

}
