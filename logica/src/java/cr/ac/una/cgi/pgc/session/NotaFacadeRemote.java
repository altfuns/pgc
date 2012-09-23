/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Nota;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author alfonso
 */
@Remote
public interface NotaFacadeRemote {

    void create(Nota nota);

    void edit(Nota nota);

    void remove(Nota nota);

    Nota find(Object id);

    List<Nota> findAll();

}
