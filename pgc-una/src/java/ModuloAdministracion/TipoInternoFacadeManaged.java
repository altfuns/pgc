package ModuloAdministracion;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.TipoInterno;
import cr.ac.una.cgi.pgc.session.TipoInternoFacadeRemote;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * Bean request que se utiliza para administra la información de la página de
 * "Administración de Tipos Internos"
 * @author red
 */
public class TipoInternoFacadeManaged implements Logeable{

    @EJB
    private TipoInternoFacadeRemote tipoInternoFacade;

    public TipoInternoFacadeManaged() {
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de Tipos Internos">
    //<editor-fold defaultstate="collapsed" desc="Eventos">
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
     * Limpia la información del formulario de ingreso de los tipos internos
     */
    public void limpiarFormulario(){
        nuevaDesc = "";
        nuevasSiglas = "";
    }

    /**
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    public void dispararEfecto() {
        efectoFooter.setFired(false);
    }

    /**
     * Limpia la consulta de los tipos de envíos
     */
    private void limpiarRegistros(){
        tipos = null;
    }

    /**
     * Recolecta los datos del formulario de ingreso, crea un nuevo tipo internos y
     * lo agrega a la base de datos
     * @param event Evento de la acción
     */
    public void action_cb_guardarTipo(ActionEvent event) {

        if (event != null) {

            if (nuevasSiglas != null && nuevasSiglas.trim().compareTo("") != 0 && nuevaDesc != null && nuevaDesc.trim().compareTo("") != 0) {
                TipoInterno validacionSiglas = null;
                TipoInterno validacionDesc = null;

                try {
                    validacionSiglas = tipoInternoFacade.find(nuevasSiglas);
                } catch (Exception e) {
                }
                try {
                    validacionDesc = tipoInternoFacade.findByDescripcion(nuevaDesc);
                } catch (Exception e) {
                }

                if (validacionSiglas == null && validacionDesc == null) {
                    try {
                        tipoInternoFacade.create(new TipoInterno(nuevasSiglas, nuevaDesc));
                        getLogFacade().create(this);
                        limpiarRegistros();
                        infoFooter = "Se agregó con éxito";
                        dispararEfecto();
                        limpiarFormulario();
                    } catch (Exception e) {
                        mensajeError = "Ocurrió un problema al intentar guardar la información. Verifique la conexión y vuelva a intentarlo.";
                        errorVisible = true;
                    }
                } else {
                    mensajeError = "No pueden existir tipos con las mismas siglas ni descripción.";
                    errorVisible = true;
                }
            } else {
                mensajeError = "Debe de llenar todos los campos para agregar el tipo.";
                errorVisible = true;
            }
        }

    }

    /**
     * Cierra el mensaje de error
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event) {
        if (event != null) {
            errorVisible = false;
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public ArrayList<TipoInterno> getTipos() {
        if (tipos == null) {
            seguridad();
            tipos = new ArrayList<TipoInterno>();

            try {
                tipos.addAll(tipoInternoFacade.findAll());
            } catch (Exception e) {
            }
        }

        return tipos;
    }

    public int getCantidadTipos(){
        return getTipos().size();
    }

    public Highlight getEfecto() {
        return efectoFooter;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public String getInfoFooter() {
        return infoFooter;
    }

    public boolean getErrorVisible() {
        return errorVisible;
    }

    public String getNuevaDesc() {
        return nuevaDesc;
    }

    public void setNuevaDesc(String nuevaDesc) {
        this.nuevaDesc = nuevaDesc;
    }

    public String getNuevasSiglas() {
        return nuevasSiglas;
    }

    public void setNuevasSiglas(String nuevasSiglas) {
        this.nuevasSiglas = nuevasSiglas;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ArrayList<TipoInterno> tipos;
    private String nuevasSiglas = "";
    private String nuevaDesc = "";
    private String mensajeError = "";
    private String infoFooter = "";
    private static String codigoPermiso = "11";
    private Highlight efectoFooter = new Highlight();
    private boolean errorVisible;
    //</editor-fold>
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        TipoInterno m = new TipoInterno(nuevasSiglas, nuevaDesc);
        
        String query = "INSERT INTO tipo_interno(acron, descripcion) VALUES ({0},{1})";
        query = query.replace("{0}", m.getAcron() == null? "" : m.getAcron());
        query = query.replace("{1}", m.getDescripcion() == null? "" : m.getDescripcion());

        return query;

    }

    public String getDeleteString() {
        TipoInterno m = null;
        return "Consulta no soportada";
    }

    public String getUpdateString() {
        TipoInterno m = null;
        return "Consulta no soportada";
    }

    public String getTablaString() {
        return "tipo_interno";
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
}
