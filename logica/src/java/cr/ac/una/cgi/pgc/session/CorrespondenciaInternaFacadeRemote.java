/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface CorrespondenciaInternaFacadeRemote {

    void create(CorrespondenciaInterna correspondenciaInterna);

    void edit(CorrespondenciaInterna correspondenciaInterna);

    void remove(CorrespondenciaInterna correspondenciaInterna);

    CorrespondenciaInterna find(Object id);

    List<CorrespondenciaInterna> findAll();

    int findIdentificadorMax();

    List<CorrespondenciaInterna> findByParameters(String[] names, Object[] values);    

    List<CorrespondenciaInterna> findRegistrosCorrespondenciaExterna(java.util.Date fecha1, java.util.Date fecha2, java.util.Date fecha3, java.util.Date fecha4, java.util.Date fecha5);

    List<CorrespondenciaInterna> findRegistrosCorrespondenciaInterna(cr.ac.una.cgi.pgc.entity.Ruta ruta, java.util.Date fecha1, java.util.Date fecha2, java.util.Date fecha3, java.util.Date fecha4, java.util.Date fecha5);
    
    List<CorrespondenciaInterna> findNoEntregadosInterna(cr.ac.una.cgi.pgc.entity.Ruta ruta, java.util.Date fecha1, java.util.Date fecha2, java.util.Date fecha3, java.util.Date fecha4, java.util.Date fecha5);
    
    List<CorrespondenciaInterna> findNoEntregadosExterna(java.util.Date fecha1, java.util.Date fecha2, java.util.Date fecha3, java.util.Date fecha4, java.util.Date fecha5);
    
    List<CorrespondenciaInterna> findByInternaFechaRecibido(cr.ac.una.cgi.pgc.entity.Ruta ruta, java.util.Date fechaRecibido);

    List<CorrespondenciaInterna> findByExternaFechaRecibido(java.util.Date fechaRecibido);

    /**
     * Obtiene la información del reporte de rutas en un mes específico
     * @param mes
     * @param anyo
     * @return
     * Registro que cumplan con las caraterísticas del reporte de rutas
     */
    List reporteRutas(int mes, int anyo);

}