
package ModuloAdministracion;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Pais;
import cr.ac.una.cgi.pgc.session.GrupoEnvioFacadeRemote;
import cr.ac.una.cgi.pgc.session.PaisFacadeRemote;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 * Bean request que se encarga de manipular los datos de la página de "Administración
 * de Grupo de Envío"
 * @author Jeremy Guzmán Salazar
 */
public class PaisFacadeManaged implements Logeable{
    @EJB
    private GrupoEnvioFacadeRemote grupoEnvioFacade;
    @EJB
    private PaisFacadeRemote paisFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public PaisFacadeManaged() {
        auxPais = new AuxPais();
    }    
    
    //<editor-fold defaultstate="collapsed" desc="Página de Control de Grupos">

    //<editor-fold defaultstate="collapsed" desc="Eventos Pagina Control de Grupos">

    /**
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    private void dispararEfecto(){
        efectoFooter.setFired(false);
    }

    /**
     * Método que reúne todos los datos del formulario, crea un nuevo país y lo almacena
     * en la base de datos.
     * @param event Evento de la acción
     */
    public void action_cb_guardarPais(ActionEvent event){
        if(event != null){
            if(auxPais.getNuevoPais() != null && auxPais.getNuevoPais().trim().compareTo("") != 0 && auxPais.getNuevoPais().trim().toLowerCase().compareTo("costarica") != 0){
                try{
                    Pais aux = null;
                    try{aux = paisFacade.findByNombre(auxPais.getNuevoPais()).get(0);}
                    catch(Exception e){ }
                    if(aux == null){
                        auxiliarTransaccion = auxPais.crearNuevoPais(grupoEnvioFacade.find(auxPais.getGrupoSeleccionado()));
                        paisFacade.create(auxiliarTransaccion);
                        getLogFacade().create(this);
                        auxiliarTransaccion = null;
                        auxPais.limpiarConsulta();
                        auxPais.setNuevoPais("");
                        infoFooter = "Se agregó el país con éxito.";
                        dispararEfecto();
                    }
                    else{
                        mensajeError = "Dos paises no pueden llamarse igual.";
                        errorVisible = true;
                    }
                }
                catch(Exception e){
                    mensajeError = "Se produjo un error al intentar guardar el registro. Verifique su conexión y vuelva a intentarlo.";
                    errorVisible = true;
                }
            }
            else{
                mensajeError = "El campo no puede estar vacío, ni puede ser Costa Rica. Ingrese el nombre del nuevo pais para agragarlo.";
                errorVisible = true;
            }

        }
    }

    /**
     * Elimina de la base de datos el país seleccionado.
     * @param event Evento de la acción.
     */
    public void action_cb_eliminarPais(ActionEvent event){
        if(auxPais.getPaisSeleccionado() != null){
            try{
                paisFacade.remove(auxPais.getPaisSeleccionado());
                getLogFacade().delete(this);
                auxPais.setPaisSeleccionado(null);
                auxPais.limpiarConsulta();
                infoFooter = "El pais se eliminó con éxito";
                dispararEfecto();
            }
            catch(Exception e){
                mensajeError = "Se produjo un error al intentar guardar el registro. Verifique su conexión y vuelva a intentarlo.";
                errorVisible = true;
            }
        }
    }

    /**
     * Cierra el mensaje de error
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        errorVisible = false;
    }

    /**
     * Selecciona un país de la lista de consultados
     * @param event Evento de la acción
     */
    public void valueChange_sol_seleccionarPais(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null && event.getNewValue().toString().compareTo("") != 0){
            String palabra = event.getNewValue().toString();
            palabra = palabra.substring(palabra.indexOf("[")+1, palabra.indexOf("]")).replace("codigo=", "");
            try{
                auxPais.seleccionarPaisAEliminar(auxPais.getPaisesConsultados(), palabra);
            }
            catch(Exception e){
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
     * Regresa una lista con los países consultados. Si no tiene información la extrae
     * de la base de datos.
     * @return Arreglo con la información de los paises consultados
     */
    public ArrayList<SelectItem> getPaisesConsultados(){
        seguridad();
        try{
            return auxPais.getPaisesConsultados();
        }
        catch(Exception e){
            try{
                auxPais.setPaisesConsultados(paisFacade.findAll());
                return auxPais.getPaisesConsultados();
            }
            catch(Exception x){
                mensajeError = x.toString();
                errorVisible = true;
            }
        }
        return new ArrayList<SelectItem>();
    }

    public String getInfoFooter(){
        return infoFooter;
    }
    
    public Highlight getEfecto(){
        return efectoFooter;
    }

    public boolean getErrorVisible() {
        return errorVisible;
    }

    public String getMensajeError() {
        return mensajeError;
    }
    
    public String getPaisSeleccionado(){
        if(auxPais.getPaisSeleccionado() != null)
            return auxPais.getPaisSeleccionado().getNombre();
        return "No se seleccionó país";
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String infoFooter = "No hay información relevante.";
    private Highlight efectoFooter = new Highlight();
    boolean errorVisible = false;
    String mensajeError;
    private String codigoPermiso = "6";
    private Pais auxiliarTransaccion;

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        Pais m = auxiliarTransaccion;

        String query = "INSERT INTO pais(codigo, nombre, codigo_grupo_envio) VALUES ({0},{1},{2})";

        query = query.replace("{0}", m.getCodigo() == null? "" : m.getCodigo());
        query = query.replace("{1}", m.getNombre() == null? "" : m.getNombre());
        query = query.replace("{2}", m.getCodigoGrupoEnvio() == null? "" : m.getCodigoGrupoEnvio().getCodigo());

        return query;
    }

    public String getDeleteString() {
        Pais m = auxPais.getPaisSeleccionado();
        
        String query = "DELETE FROM pais WHERE codigo = {0}";
        query = query.replace("{0}", m.getCodigo() == null? "" : m.getCodigo());

        return query;
    }

    public String getUpdateString() {
        Pais m = null;
        return "Instrucción no soportada";
    }

    public String getTablaString() {
        return "pais";
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

    public AuxPais getAuxPais(){
        return auxPais;
    }

    private AuxPais auxPais;

}
