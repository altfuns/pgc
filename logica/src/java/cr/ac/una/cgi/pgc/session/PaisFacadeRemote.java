/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Pais;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface PaisFacadeRemote {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findByGrupoEnvio(String grupoEnvio);

    List<Pais> findByNombre(java.lang.String nombre);

}
