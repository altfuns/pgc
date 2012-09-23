/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.ErrorLog;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface ErrorLogFacadeRemote {

    void create(ErrorLog errorLog);

    void edit(ErrorLog errorLog);

    void remove(ErrorLog errorLog);

    ErrorLog find(Object id);

    List<ErrorLog> findAll();

    int findMax();

}
