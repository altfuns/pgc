
package ModuloAdministracion;

import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
import cr.ac.una.cgi.pgc.entity.Rol;
import cr.ac.una.cgi.pgc.session.EmpleadoFacadeRemote;
import cr.ac.una.cgi.pgc.session.PermisoFacadeRemote;
import cr.ac.una.cgi.pgc.session.RolFacadeRemote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 * Bean request que se utiliza para administrar la información de la página de
 * "Administración de Permisos"
 * @author Jeremy Guzmán Salazar
 */
public class PermisoFacadeManaged {
    @EJB
    private EmpleadoFacadeRemote empleadoFacade;
    @EJB
    private RolFacadeRemote rolFacade;
    @EJB
    private PermisoFacadeRemote permisoFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public PermisoFacadeManaged() {
        auxPermiso = new AuxPermiso();
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de Permisos">

    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Cierra el mensaje de error
     * @param event Evento de la Acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        if(event != null)
            errorVisible = false;
    }

    /**
     * Cambia el tipo de consulta con que se realizan los permisos (Rol o Empleado)
     * @param event Evento de la Acción
     */
    public void valueChange_sol_cambiarTipoP(ValueChangeEvent event){
        if(event != null){
            itemes = null;
            auxPermiso.limpiarPermisos();
        }
    }

    /**
     * Limpia los permisos para volver a consultarlos.
     *
     * @param event Evento de la acción.
     */
    public void valueChange_som_cambiarPermisos(ValueChangeEvent event){        
        auxPermiso.limpiarPermisos();
    }

    /**
     * Selecciona un item (Rol o Empleado) para consultar los empleados.
     * @param event
     */
    public void valueChange_som_seleccionarItem(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null){
            String codigo = event.getNewValue().toString();
            auxPermiso.seleccionarItem(itemes, codigo);
            itemes = null;
            auxPermiso.limpiarPermisos();
        }
    }

    /**
     * Selecciona un permiso de la lista de los "Permisos no Asignados"
     *
     * @param event Evento de la acción
     */
    public void valueChange_sol_seleccionarPermisoNoAsignado(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null )
            auxPermiso.seleccionarPermisoNoAsignado(event.getNewValue().toString());            
    }

    /**
     * Selecciona un permiso de la lista de los "Permisos Asignados"
     *
     * @param event Evento de la acción
     */
    public void valueChange_sol_seleccionarPermisoAsignado(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null ){
            try{
                auxPermiso.getPermisosAsignados();
            }
            catch(Exception e){
                try{
                    auxPermiso.setPermisosSinAsignar(permisoFacade.findByModulo(auxPermiso.getModuloSel()));

                    if(auxPermiso.getRolSel() == null)
                        auxPermiso.setPermisosAsignados(permisoFacade.findByEmpleadoModulo(auxPermiso.getEmpleadoSel(), auxPermiso.getModuloSel()));
                    else
                        auxPermiso.setPermisosAsignados(permisoFacade.findByRolModulo(auxPermiso.getRolSel(), auxPermiso.getModuloSel()));
                }
                catch(Exception x){
                    mensajeError = "No se puede acceder a la información del sistema. Verifique la conexión y vuelva a intentarlo.";
                    errorVisible = true;
                }
            }
            
            auxPermiso.seleccionarPermisoAsignado(event.getNewValue().toString());
        }
    }

    /**
     * Asigna el permiso seleccionado, a un rol o a un empleado. Si es a un rol, debe
     * asignar el permiso a todos los empleados con este.
     *
     * @param event Evento de la acción.
     */
    public void action_cb_asignarPermiso(ActionEvent event){
        if(event != null){
            if(auxPermiso.getPermNoAsigSel() != null){
                try{                    
                    if(auxPermiso.getRolSel() == null){
                        Empleado e = auxPermiso.getEmpleadoSel();
                        Collection<Permiso> p = e.getPermisoCollection();
                        p.add(auxPermiso.getPermNoAsigSel());
                        e.setPermisoCollection(p);
                        empleadoFacade.edit(e);                       
                    }
                    else{
                        Rol r = auxPermiso.getRolSel();
                        Collection<Permiso> pr = r.getPermisoCollection();
                        pr.add(auxPermiso.getPermNoAsigSel());
                        r.setPermisoCollection(pr);
                        rolFacade.edit(r);

                        List<Empleado> empleados = empleadoFacade.findAll();
                        if(empleados != null){
                            for(Empleado e : empleados){
                                if(e.getActivo() && e.getTipo().getCodigo().compareTo(auxPermiso.getRolSel().getCodigo()) == 0) {
                                    try{                                                                                        
                                        e.setPermisoCollection(pr);
                                        empleadoFacade.edit(e);
                                    }
                                    catch(Exception x){
                                        throw x;
                                    }
                                }
                            }    
                        }
                    }
                    
                    auxPermiso.limpiarPermisos();
                    infoFooter = "Se agregó el permiso correctamente.";
                }
                catch(Exception e){
                    mensajeError = "Ocurrió un problema al intentar guardar la informacion. Verifique la conexión y vuelva a intentarlo."
                            + e.getMessage() + e.getStackTrace().toString();
                    errorVisible = true;
                }
            }
            else{
                mensajeError = "Debe seleccionar un permiso no asignado, para poder asignarlo.";
                errorVisible = true;
            }
        }
    }

    /**
     * Remueve el permiso seleccionado, a un rol o a un empleado. Si es a un rol, debe
     * remover el permiso a todos los empleados con este.
     *
     * @param event Evento de la acción.
     */
    public void action_cb_removerPermiso(ActionEvent event){
        if(event != null){
            if(auxPermiso.getPermAsigSel() != null){
                try{
                    if(auxPermiso.getRolSel() == null){
                       
                        Empleado e = auxPermiso.getEmpleadoSel();
                        Collection<Permiso> p = e.getPermisoCollection();
                        p.remove(auxPermiso.getPermAsigSel());
                        e.setPermisoCollection(p);
                        empleadoFacade.edit(e);

                    }
                    else{
                        
                        Rol r = auxPermiso.getRolSel();
                        Collection<Permiso> pr = r.getPermisoCollection();
                        pr.remove(auxPermiso.getPermAsigSel());
                        r.setPermisoCollection(pr);
                        rolFacade.edit(r);

                        List<Empleado> empleados = empleadoFacade.findAll();
                        if(empleados != null){
                            for(Empleado e : empleados){
                                if(e.getActivo() && e.getTipo().getCodigo().compareTo(auxPermiso.getRolSel().getCodigo()) == 0){
                                    try{
                                        
                                        e.setPermisoCollection(pr);
                                        empleadoFacade.edit(e);

                                    }
                                    catch(Exception x){}
                                }
                            }
                        }
                    }
                    auxPermiso.limpiarPermisos();
                    infoFooter = "Se removió el permiso correctamente.";
                }
                catch(Exception e){
                    mensajeError = "Ocurrió un problema al intentar guardar la informacion. Verifique la conexión y vuelva a intentarlo.";
                    errorVisible = true;
                }
            }
            else{
                mensajeError = "Debe seleccionar un permiso asignado, para poder removerlo.";
                errorVisible = true;
            }
        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    /**
     * Método que verifica si el usuario tiene los permisos adecuado para ver la información
     * de esta página.
     */
    private void seguridad(){
       
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        if(seguridad != null){
            seguridad.validarPermiso(codigoPermiso);
        }
        else{
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
            }
            catch(Exception e){
            }
        }        
    }

    /**
     * Consulta los permisos que el Rol o el Empleado seleccionado no tiene asignados.
     * @return Arreglo con los permisos que el Rol o el Empleado seleccionado no tiene asignados.
     */
    public ArrayList<SelectItem> getItemesNoAsignados(){

        seguridad();

        ArrayList<Permiso> permisos = new ArrayList<Permiso>();

        try{
            permisos = auxPermiso.getPermisosSinAsignar();
        }
        catch(Exception e){
                                            
                try{
                    auxPermiso.setPermisosSinAsignar(permisoFacade.findByModulo(auxPermiso.getModuloSel()));

                    List<Permiso> asignados = new ArrayList<Permiso>();

                    getItemes();

                    asignados = auxPermiso.getEmpleadoSel() == null ?
                        permisoFacade.findByRolModulo(auxPermiso.getRolSel(), auxPermiso.getModuloSel()) :
                        permisoFacade.findByEmpleadoModulo(auxPermiso.getEmpleadoSel(), auxPermiso.getModuloSel());
                    
                    auxPermiso.setPermisosAsignados(asignados);

                    permisos = auxPermiso.getPermisosSinAsignar();
                }
                catch(Exception x){}                
            
        }

        ArrayList<SelectItem> itemesNoAsignados = new ArrayList<SelectItem>();

        for(Permiso p : permisos)
            itemesNoAsignados.add(new SelectItem(p, p.getDescripcion()));

        return itemesNoAsignados;

    }

    /**
     * Consulta los permisos que el Rol o el Empleado seleccionado tiene asignados.
     * @return Arreglo con los permisos que el Rol o el Empleado seleccionado tiene asignados.
     */
    public ArrayList<SelectItem> getItemesAsignados(){
        ArrayList<Permiso> permisos = new ArrayList<Permiso>();

        try{
            permisos = auxPermiso.getPermisosAsignados();
        }
        catch(Exception e){
            try{
                auxPermiso.setPermisosSinAsignar(permisoFacade.findByModulo(auxPermiso.getModuloSel()));

                List<Permiso> asignados = new ArrayList<Permiso>();

                try{
                    asignados = auxPermiso.getEmpleadoSel() == null ?
                        permisoFacade.findByRolModulo(auxPermiso.getRolSel(), auxPermiso.getModuloSel()) :
                        permisoFacade.findByEmpleadoModulo(auxPermiso.getEmpleadoSel(), auxPermiso.getModuloSel());
                }
                catch(Exception x){}

                auxPermiso.setPermisosAsignados(asignados);

                permisos = auxPermiso.getPermisosAsignados();
            }
            catch(Exception x){
                mensajeError = "No se pudo acceder a la información del sistema. Verifique su conexión y vuelva a intentarlo.";
                errorVisible = true;
            }
        }

        ArrayList<SelectItem> itemesAsignados = new ArrayList<SelectItem>();

        for(Permiso p : permisos)
            itemesAsignados.add(new SelectItem(p, p.getDescripcion()));

        return itemesAsignados;
    }

    /**
     * Obtienen las opciones de consulta (Rol o Empleado), deacuerdo a la selección del usuario.
     *
     * @return Itemes con Roles o con Empleados.
     */
    public ArrayList<SelectItem> getItemes(){
        
        if(itemes == null){
            itemes = new ArrayList<SelectItem>();
            
            try{

                if(auxPermiso.getTipoP().compareTo("Cargo") == 0){
                    List<Rol> roles = rolFacade.findAll();
                
                    for(Rol r : roles)
                        itemes.add(new SelectItem(r, r.getDescripcion()));
                
                }
                else{
                    List<Empleado> empleados = empleadoFacade.findAll();
                    
                    for(Empleado e : empleados)
                        itemes.add(new SelectItem(e, e.getNombre() + " " + e.getMiddleName() + " " +e.getApellidos()));

                }

                auxPermiso.limpiarSeleccion(itemes);               

                
            }
            catch(Exception e){
                mensajeError = "No se pudo acceder a la información del sistema. Verifique la conexión y vuelva a intentarlo.";
                errorVisible = true;
            }
            
        }
        
        return itemes;
    }

    public Highlight getEfecto(){
        return efectoFooter;
    }

    public String getEtqAsignando(){
        return auxPermiso.getTipoP() + ":";
    }

    public String getInfoFooter(){
        return infoFooter;
    }

    public String getMensajeError(){
        return mensajeError;
    }

    public boolean getErrorVisible(){
        return errorVisible;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private ArrayList<SelectItem> itemes;
    private Highlight efectoFooter = new Highlight();
    private String infoFooter = "No hay información relevante.";
    private String mensajeError = "";
    private boolean errorVisible = false;   
    private String codigoPermiso = "10";

    //</editor-fold>

    //</editor-fold>

    public AuxPermiso getAuxPermiso(){
        return auxPermiso;
    }

    private AuxPermiso auxPermiso;

}
