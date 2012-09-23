/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import cr.ac.una.cgi.pgc.entity.Tarifa;
import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author alfonso
 */
@Remote
public interface TarifaFacadeRemote {

    void create(Tarifa tarifa);

    void edit(Tarifa tarifa);

    void remove(Tarifa tarifa);

    Tarifa find(Object id);

    List<Tarifa> findAll();

    Tarifa findByParameters(Double peso,GrupoEnvio grupo,TipoEnvio tipo);

}
