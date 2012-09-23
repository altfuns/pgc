/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Unidad;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface UnidadFacadeRemote {

    void create(Unidad unidad);

    void edit(Unidad unidad);

    void remove(Unidad unidad);

    Unidad find(Object id);

    List<Unidad> findAll();

    List<Unidad> findByNombre(String nombre);

    List<Unidad> findByAcron(String acron);

    List<Unidad> findByRuta(cr.ac.una.cgi.pgc.entity.Ruta r);

}
