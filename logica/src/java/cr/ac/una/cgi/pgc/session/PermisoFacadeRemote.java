/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.Permiso;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface PermisoFacadeRemote {

    void create(Permiso permiso);

    void edit(Permiso permiso);

    void remove(Permiso permiso);

    Permiso find(Object id);

    List<Permiso> findAll();

    List<Permiso> findByModulo(String modulo);

    public List<Permiso> findByEmpleado(cr.ac.una.cgi.pgc.entity.Empleado empleado);

     public List<Permiso> findByRol(cr.ac.una.cgi.pgc.entity.Rol rol);

    public List<Permiso> findByRolModulo(cr.ac.una.cgi.pgc.entity.Rol rol, String modulo);

    public List<Permiso> findByEmpleadoModulo(cr.ac.una.cgi.pgc.entity.Empleado empleado, String modulo);
 

}
