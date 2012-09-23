/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Presupuesto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface PresupuestoFacadeRemote {

    void create(Presupuesto presupuesto);

    void edit(Presupuesto presupuesto);

    void remove(Presupuesto presupuesto);

    Presupuesto find(Object id);

    List<Presupuesto> findAll();

}
