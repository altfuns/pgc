/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Ruta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface RutaFacadeRemote {

    void create(Ruta ruta);

    void edit(Ruta ruta);

    void remove(Ruta ruta);

    Ruta find(Object id);

    List<Ruta> findAll();

    List<Ruta> findByEmpleado(cr.ac.una.cgi.pgc.entity.Empleado empleado);

}
