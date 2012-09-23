/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
@Remote
public interface FacturaFacadeRemote {

    void create(Factura factura);

    void edit(Factura factura);

    void remove(Factura factura);

    Factura find(Object id);

    List<Factura> findAll();

    /**
     * Busca los registros que cumplan con los parámetros dados
     * @param names
     * Nombres de los parámetros
     * @param values
     * Valores de los parámetros
     * @return
     * Registros que cumplan con los filtros
     */
    List<Factura> findByParameters(ArrayList<String> names, ArrayList values);

}
