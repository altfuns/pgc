/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Rol;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface RolFacadeRemote {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

}
