
package ModuloAdministracion;

import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
import cr.ac.una.cgi.pgc.entity.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 * Es una clase que sirve de apoyo a la clase PermisoFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxPermiso {

    public AuxPermiso(){
        
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de permisos">

    //<editor-fold defaultstate="collapsed" desc="Métodos">

    /**
     * Limpia la consulta de permisos
     */
    public void limpiarPermisos(){
        permisosAsignados = null;
        permisosSinAsignar = null;
    }

    /**
     * Limpia la selección de los componentes de los permisos y selecciona valores predeterminadosç
     * del rol y el empleado.
     *
     * @param itemes Arreglo que contiene las opciones por las cuales se pueden buscar permisos (Roles o Empleados)
     *
     */
    public void limpiarSeleccion(ArrayList<SelectItem> itemes){
        if(tipoP.compareTo("Cargo") == 0 && itemes != null && itemes.size() > 0){
            empleadoSel = null;
            if(rolSel == null)
                rolSel = (Rol)itemes.get(0).getValue();
        }
        else{
            rolSel = null;
            if(empleadoSel == null)
                empleadoSel = (Empleado)itemes.get(0).getValue();
        }

    }

    /**
     * Selecciona uno de los itemes de consulta (Empleado o Rol), para realizar la
     * consulta de los permisos.
     *
     * @param itemes Opciones que se pueden elegir
     * @param codigo Nuevo valor por el cual se consultarán los permisos.
     */
    public void seleccionarItem(ArrayList<SelectItem> itemes, String codigo){

        for(SelectItem s : itemes){
            if(s.getValue().toString().compareTo(codigo) == 0){
                if(tipoP.compareTo("Cargo") == 0)
                    rolSel = (Rol)s.getValue();
                else
                    empleadoSel = (Empleado)s.getValue();
            }
        }

    }

    /**
     * Selecciona un permiso de la lista de permisos no asignados
     *
     * @param codigo Código del permiso que va a ser seleccionado
     */
    public void seleccionarPermisoNoAsignado(String codigo){
        if(permisosSinAsignar != null){
            for(Permiso p : permisosSinAsignar){
                if(p.toString().compareTo(codigo) == 0){
                    permNoAsigSel = p;
                    break;
                }
            }
        }
    }

    /**
     * Selecciona un permiso de la lista de permisos asignados
     *
     * @param codigo Código del permiso que va a ser seleccionado
     */
    public void seleccionarPermisoAsignado(String codigo){
        if(permisosAsignados != null){
            for(Permiso p : permisosAsignados){
                if(p.toString().compareTo(codigo) == 0){
                    permAsigSel = p;
                    break;
                }
            }
        }
    }    

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public void setTipoP(String tipoP){
        this.tipoP = tipoP;
    }

    public String getTipoP(){
        return tipoP;
    }

    public Empleado getEmpleadoSel() {
        return empleadoSel;
    }

    public void setEmpleadoSel(Empleado empleadoSel) {
        this.empleadoSel = empleadoSel;
    }

    public String getModuloSel() {
        return moduloSel;
    }

    public void setModuloSel(String moduloSel) {
        this.moduloSel = moduloSel;
    }

    public Rol getRolSel() {
        return rolSel;
    }

    public void setRolSel(Rol rolSel) {
        this.rolSel = rolSel;
    }

    public Permiso getPermNoAsigSel(){
        if(permisosSinAsignar != null && permisosSinAsignar.size() == 1)
            return permisosSinAsignar.get(0);
        return permNoAsigSel;
    }
    
    public Permiso getPermAsigSel(){
        if(permisosAsignados != null && permisosAsignados.size() == 1)
            return permisosAsignados.get(0);
        return permAsigSel;
    }

    public ArrayList<Permiso> getPermisosAsignados() throws Exception{
        if(permisosAsignados == null)
            throw new Exception();
        return permisosAsignados;
    }

    public void setPermisosAsignados(List<Permiso> permisosAsignados) {
        this.permisosAsignados = new ArrayList<Permiso>();
        this.permisosAsignados.addAll(permisosAsignados);
        this.permisosSinAsignar.removeAll(permisosAsignados);
    }

    public ArrayList<Permiso> getPermisosSinAsignar() throws Exception{
        if(permisosSinAsignar == null)
            throw new Exception();
        return permisosSinAsignar;
    }

    public void setPermisosSinAsignar(List<Permiso> permisosSinAsignar) {
        this.permisosSinAsignar = new ArrayList<Permiso>();
        this.permisosSinAsignar.addAll(permisosSinAsignar);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String tipoP = "Cargo";
    private String moduloSel = "rutas";
    private Rol rolSel;
    private Empleado empleadoSel;
    private Permiso permNoAsigSel;
    private Permiso permAsigSel;
    private ArrayList<Permiso> permisosAsignados;
    private ArrayList<Permiso> permisosSinAsignar;

    //</editor-fold>

    //</editor-fold>

}
