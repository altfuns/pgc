/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TransactionLog;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface TransactionLogFacadeRemote {

    void create(TransactionLog transactionLog);

    void edit(TransactionLog transactionLog);

    void remove(TransactionLog transactionLog);

    TransactionLog find(Object id);

    List<TransactionLog> findAll();

    int findMax();

}
