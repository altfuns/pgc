
package ModuloAdministracion;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.Unidad;
import cr.ac.una.cgi.pgc.session.EmpleadoFacadeRemote;
import cr.ac.una.cgi.pgc.session.RutaFacadeRemote;
import cr.ac.una.cgi.pgc.session.UnidadFacadeRemote;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultTreeModel;

/**
 * Bean request para la administración de la información de la página de "Administración
 * de Rutas"
 * @author red
 */
public class RutaFacadeManaged implements Logeable{
    @EJB
    private EmpleadoFacadeRemote empleadoFacade;
    @EJB
    private UnidadFacadeRemote unidadFacade;
    @EJB
    private RutaFacadeRemote rutaFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public RutaFacadeManaged() {
        auxRuta = new AuxRuta();
    }    
    
    //<editor-fold defaultstate=""collapsed" desc="Página de Administración de Rutas">
    
    //<editor-fold defaultstate="collapsed" desc="Control de itemes de mensajeros">

    /**
     * Selecciona un empleado de la lista de empleados
     *
     * @return Empleado encontrado en la lista.
     */
    public Empleado buscarEmpleadoSel(){
        
        if(auxRuta.getMensajeroSel() != null && auxRuta.getMensajeroSel().compareTo("") != 0 && empleadoOriginal != null){
            String codigo = auxRuta.getMensajeroSel();
            for(Empleado e : empleadoOriginal){
                if(e.getId().compareTo(codigo) == 0)
                    return e;
            }
        }
        
        return null;
    }

    /**
     * Extrae de la base de datos la información de los mensajeros
     * @return Arreglo con la información de los mensajeros.
     */
    public ArrayList<SelectItem> getItemesEmpleado(){
         if(itemes == null){

             if(empleadoOriginal == null){
                 empleadoOriginal = new ArrayList<Empleado>();
                 try{
                     empleadoOriginal.addAll(empleadoFacade.findAll());
                 }
                 catch(Exception e){
                     mensajeError = "No se pudo acceder a la información del sistema. Verifique su conexión y vuelva a intentarlo.";
                     errorVisible = true;
                 }
             }

             itemes = new ArrayList<SelectItem>();

             for(Empleado e : empleadoOriginal){
                 if(e.getTipo().getCodigo() == '3' && e.getActivo())
                     itemes.add(new SelectItem(e.getId(), e.getNombre() + " " + e.getMiddleName() + " " + e.getApellidos()));
             }

         }

         return itemes;
    }
    
    ArrayList<SelectItem> itemes;
    ArrayList<Empleado> empleadoOriginal;

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    public void dispararEfecto(){
       efectoFooter.setFired(false);
    }

    /**
     * Método que se utiliza para remover las unidades de una ruta que se va a eliminar
     */
    private void removerUnidades(){
        
        ArrayList<Unidad> unid = auxRuta.unidadesModeloRuta();

        for(int i = 0; i < unid.size(); i++){
            Unidad u = unid.get(i);
            u.setNumeroRuta(null);
            unid.set(i, u);
        }

        for(Unidad u : unid){
            try{unidadFacade.edit(u);}
            catch(Exception e){}
        }
        
    }

    /**
     * Cerrar el mensaje de error
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        if(event != null){
            errorVisible = false;
            asignacionVisible = false;
        }
    }

    /**
     * Selecciona un nodo del árbol que presenta la información de las rutas internas
     * @param event Evento de la acción
     */
    public void action_cl_seleccionarItemInterna(ActionEvent event){

        if(event != null){
            UIComponent componente = event.getComponent().getChildren().get(0);
            String codigo = componente.getValueBinding("value").getValue(FacesContext.getCurrentInstance()).toString();            
            auxRuta.seleccionarItemInterna(codigo);
        }

    }

    /**
     * Selecciona un nodo del árbol que presenta la información de las rutas externas
     * @param event Evento de la acción
     */
    public void action_cl_seleccionarItemExterna(ActionEvent event){
        if(event != null){
            UIComponent componente = event.getComponent().getChildren().get(0);
            String codigo = componente.getValueBinding("value").getValue(FacesContext.getCurrentInstance()).toString();
            auxRuta.seleccionarItemExterna(codigo);
        }
    }

    /**
     * Asigna el mensajero seleccionado a una ruta
     * @param event Evento de la acción
     */
    public void action_cb_asignarMensajero(ActionEvent event){
        if(event != null){
            if(auxRuta.getRutaSel() != null){
                try{
                    Ruta ruta = auxRuta.getRutaSel();
                    ruta.setEmpleadoId(buscarEmpleadoSel());
                    
                    rutaFacade.edit(ruta);
                    auxiliarTransaction = ruta;
                    getLogFacade().update(this);
                    auxiliarTransaction = null;
                    asignacionVisible = false;
                    infoFooter = "Se actualizó la ruta correctamente.";
                    dispararEfecto();

                    auxRuta.limpiarModelo();
                    
                }
                catch(Exception e){
                    mensajeError = "Ocurrió un problema al intentar actualizar los datos. Verifique su conexión y vuelva a intentarlo.";
                    errorVisible = true;                           
                }
            }
            else{
                mensajeError = "Debe seleccionar una ruta para poder ser asignada.";
                errorVisible = true;
            }
        }        
    }

    /**
     * Selecciona una una unidad de la lista de unidades no asignadas
     * @param event Evento de la acción
     */
    public void valueChange_sol_seleccionarUnidad(ValueChangeEvent event){

        if(event != null){            
            auxRuta.seleccionarUnidad(event.getNewValue().toString());
        }
        else
            auxRuta.seleccionarPorDefecto();

    }

    /**
     * Elimina la ruta seleccionada.
     *
     * @param event Evento de la acción
     */
    public void action_cb_eliminarRuta(ActionEvent event){
        if(auxRuta.getRutaSel() != null){
            try{
                removerUnidades();
                rutaFacade.remove(auxRuta.getRutaSel());
                getLogFacade().delete(this);
                auxRuta.limpiarModelo();
                infoFooter = "Se eliminó la ruta correctamente.";
                dispararEfecto();
            }
            catch(Exception e){
                mensajeError = "Ocurrió un problema al intentar eliminar. Verifique su conexió y vuelva a intentarlo.";
                errorVisible = true;
            }
        }
        else{
            mensajeError = "Debe seleccionar una ruta para poder eliminarla";
            errorVisible = true;
        }
    }

    /**
     * Recolecta los datos del formulario de ingreso, crea una ruta y la agrega.
     * @param event Evento de la acción
     */
    public void action_cb_guardarRuta(ActionEvent event){
        if(auxRuta.getNuevaRuta() != null && auxRuta.getNuevaRuta().compareTo("") != 0){
            Ruta nuevaRuta = new Ruta(auxRuta.getNuevaRuta(), new Date(), auxRuta.isInterna());
            try{
                rutaFacade.create(nuevaRuta);
                auxiliarTransaction = nuevaRuta;
                getLogFacade().create(this);
                auxiliarTransaction = null;
                auxRuta.limpiarModelo();
                infoFooter = "Se ingresó la ruta correctamente.";
                dispararEfecto();
            }
            catch(Exception e){
                mensajeError = "El nombre de las rutas no pueden ser iguales.";
                errorVisible = true;
            }
        }
        else{
            mensajeError = "Debe nombrar la nueva ruta para poder ingresarla al sistema.";
            errorVisible = true;
        }
    }

    /**
     * Asigna la unidad seleccionada a una ruta seleccionada.
     * @param event Evento de la acción
     */
    public void action_cb_asignarRuta(ActionEvent event){

        if(event != null){

            if(auxRuta.getUnidadSel() != null && auxRuta.getRutaSel() != null){
                try{
                    Unidad unidadDes = auxRuta.getUnidadSel();
                    unidadDes.setNumeroRuta(auxRuta.getRutaSel());
                    unidadFacade.edit(unidadDes);
                    auxRuta.limpiarModelo();
                    infoFooter = "Se actualizó la unidad correctamente.";
                    dispararEfecto();
                }
                catch(Exception e){
                    mensajeError = "No se pudo actualizar la unidad. Verifique si los datos y vuelva a intentarlo.";
                    errorVisible = true;
                }
            }
            else{
                mensajeError = "Debe seleccionar una unidad y una ruta, para poder realizar el proceso correctamente.";
                errorVisible = true;
            }

        }

    }

    /**
     * Remueve la unidad seleccionada a una ruta seleccionada.
     * @param event Evento de la acción
     */
    public void action_cb_removerRuta(ActionEvent event){

        if(event != null){

            if(auxRuta.getUnidadSel() != null){
                try{
                    Unidad unidadDes = auxRuta.getUnidadSel();
                    unidadDes.setNumeroRuta(null);
                    unidadFacade.edit(unidadDes);
                    auxRuta.limpiarModelo();
                    infoFooter = "Se actualizó la unidad correctamente.";
                    dispararEfecto();
                }
                catch(Exception e){
                    mensajeError = "No se pudo actualizar la unidad. Verifique si los datos y vuelva a intentarlo.";
                    errorVisible = true;
                }
            }
            else{
                mensajeError = "Debe seleccionar una unidad para poder ser removida de la ruta.";
                errorVisible = true;
            }

        }

    }

    /**
     * Abre el componente de asignación de mensajeros.
     * @param event Evento de la acción
     */
    public void action_cb_abrirAsignacionMensajeros(ActionEvent event){
        if(event != null){            
            asignacionVisible = true;
        }
    }

    /**
     * Cierra el componente de asignación de mensajeros
     * @param event Evento de la acción
     */
    public void action_cb_cerrarAsignacionMensajeros(ActionEvent event){
        if(event != null){
            asignacionVisible = false;

        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        Ruta m = auxiliarTransaction;
        
        String query = "INSERT INTO ruta(numero, fecha, empleado_id, interna) VALUES ({0},{1},{2},{3})";

        query = query.replace("{0}", m.getNumero() == null? "" : m.getNumero());
        query = query.replace("{1}", m.getFecha() == null? "" : m.getFecha().toString());
        query = query.replace("{2}", m.getEmpleadoId() == null? "" : m.getEmpleadoId().getId());
        query = query.replace("{3}", String.valueOf(m.getInterna()));

        return query;

    }

    public String getDeleteString() {
        Ruta m = auxRuta.getRutaSel();

        String query = "DELETE FROM ruta WHERE numero = {0}";

        query = query.replace("{0}", m.getNumero() == null? "" : m.getNumero());
        
        return query;
    }

    public String getUpdateString() {
        Ruta m = auxiliarTransaction;
        String query = "UPDATE ruta SET fecha = {0}, empleado_id = {1}, interna = {2} WHERE numero = {3}";

        query = query.replace("{0}", m.getFecha() == null? "" : m.getFecha().toString());
        query = query.replace("{1}", m.getEmpleadoId() == null? "" : m.getEmpleadoId().getId());
        query = query.replace("{2}", String.valueOf(m.getInterna()));
        query = query.replace("{3}", m.getNumero() == null? "" : m.getNumero());

        return query;

    }

    public String getTablaString() {
        return "ruta";
    }

    public  Empleado getEmpleado() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        return seguridad.getEmpleadoIngreso();
    }

    private Log getLogFacade(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (Log)session.getAttribute("Log");
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
     * Crea el árbol de la asignación de las unidades a la ruta interna.
     * @return Modelo del árbol
     */
    public DefaultTreeModel getModel(){

        seguridad();

        try{
            return auxRuta.getModel();
        }
        catch(Exception e){
            try{
                List<Unidad> unidades = new ArrayList<Unidad>();
                try{unidades = unidadFacade.findAll();}
                catch(Exception x){ }

                auxRuta.armarModelos(rutaFacade.findAll(), unidades);
                return auxRuta.getModel();
            }
            catch(Exception x){
               mensajeError = "No se pudo acceder a la información del sistema. Verifique la conexión y vuelva a intentarlo.";
               errorVisible = true;                       
            }
        }       
        
        return new DefaultTreeModel(auxRuta.agregarNodoUnidad(null, new Unidad("0","Rutas Internas","RI")));
    }

    /**
     * Crea el árbol de las rutas externas.
     * @return Modelo del árbol
     */
    public DefaultTreeModel getModelExternas(){
        try{
            return auxRuta.getModelExterna();
        }
        catch(Exception e){
            try{
                List<Unidad> unidades = new ArrayList<Unidad>();
                try{unidades = unidadFacade.findAll();}
                catch(Exception x){ }

                auxRuta.armarModelos(rutaFacade.findAll(), unidades);
                return auxRuta.getModelExterna();
            }
            catch(Exception x){
               mensajeError = x.toString();// "No se pudo acceder a la información del sistema. Verifique la conexión y vuelva a intentarlo.";
               errorVisible = true;
            }
        }

        return new DefaultTreeModel(auxRuta.agregarNodoUnidad(null, new Unidad("0","Rutas Externas","RI")));
    }

    public Highlight getEfecto(){
        return efectoFooter;
    }

    public String getInfoFooter(){
        return infoFooter;
    }

    public boolean getErrorVisible() {
        return errorVisible;
    }

    public String getMensajeError() {
        return mensajeError;
    }    
    
    public boolean getAsignacionVisible(){
        return asignacionVisible;
    }

    public String getRutaSel(){
        if(auxRuta.getRutaSel() != null)
            return auxRuta.getRutaSel().getNumero();
        return "No se seleccionó una ruta";
    }
    
    public String getUnidadSel(){
        if(auxRuta.getUnidadSel() != null)
            return auxRuta.getUnidadSel().getNombre();
        return "No se seleccionó una unidad"; 
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private boolean asignacionVisible = false;
    private Highlight efectoFooter = new Highlight();
    private String infoFooter = "No hay información relevante.";
    private String mensajeError;
    private boolean errorVisible = false;
    private String codigoPermiso = "8";
    private Ruta auxiliarTransaction;

    //</editor-fold>
    
    //</editor-fold>

    public AuxRuta getAuxRuta(){
        return auxRuta;
    }

    private AuxRuta auxRuta;

}
