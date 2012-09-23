/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface GrupoEnvioFacadeRemote {

    void create(GrupoEnvio grupoEnvio);

    void edit(GrupoEnvio grupoEnvio);

    void remove(GrupoEnvio grupoEnvio);

    GrupoEnvio find(Object id);

    List<GrupoEnvio> findAll();

}
