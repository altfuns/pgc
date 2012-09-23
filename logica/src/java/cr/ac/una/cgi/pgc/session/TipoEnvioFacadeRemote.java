/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface TipoEnvioFacadeRemote {

    void create(TipoEnvio tipoEnvio);

    void edit(TipoEnvio tipoEnvio);

    void remove(TipoEnvio tipoEnvio);

    TipoEnvio find(Object id);

    List<TipoEnvio> findAll();

}
