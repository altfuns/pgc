
package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;
import cr.ac.una.cgi.pgc.entity.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
@Remote
public interface CorrespondenciaExternaFacadeRemote {

    void create(CorrespondenciaExterna correspondenciaExterna);

    void edit(CorrespondenciaExterna correspondenciaExterna);

    void remove(CorrespondenciaExterna correspondenciaExterna);

    CorrespondenciaExterna find(Object id);

    List<CorrespondenciaExterna> findAll();

    /**
     * Obtiene el valor máximo del Identificador
     * @return
     * El valor máximo del identificador
     */
    Integer findIdentificadorMax();

    /**
     * Busca un registro por una determinada factura
     * @param factura
     * Factura por la cual se quiere bucar
     * @return
     * Registros que tengan asociada dicha factura
     */
    List<CorrespondenciaExterna> findByFactura(Factura factura);

    /**
     * Busca uno o varios por lo parámetros dados en las listas
     * @param names
     * Nombres de los parámetros
     * @param values
     * Valores de los parámetros
     * @return
     * Registros que cumplan con los parámetros dados
     */
    List<CorrespondenciaExterna> findByParameters(String numeroFactura, ArrayList<String> names, ArrayList values);

    /**
     * Busca los registros que cumplan con los carácteristicas del reporte en un mes específico
     * @param mes
     * @param anyo
     * @return
     */
    List reporteExpidida(int mes,int  anyo);

    /**
     * Busca los registros que cumplan con los carácteristicas del reporte en un mes específico
     * @param mes
     * @param anyo
     * @return
     */
    List reporteAnualGatos(int mes,int  anyo);

    /**
     * Busca los registros que cumplan con los carácteristicas del reporte en un mes específico
     * @param mes
     * @param anyo
     * @return
     */
    List reporteGrupoEnvio(int mes,int  anyo);

    /**
     * Devuelve la cantidad de registros que no tiene factura
     * @return
     */
    int cantidadSinFactura();

}
