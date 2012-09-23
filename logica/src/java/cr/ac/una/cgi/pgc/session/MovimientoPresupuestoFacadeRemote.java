/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.MovimientoPresupuesto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface MovimientoPresupuestoFacadeRemote {

    void create(MovimientoPresupuesto movimientoPresupuesto);

    void edit(MovimientoPresupuesto movimientoPresupuesto);

    void remove(MovimientoPresupuesto movimientoPresupuesto);

    MovimientoPresupuesto find(Object id);

    List<MovimientoPresupuesto> findAll();

}
