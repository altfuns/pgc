
package ModuloAdministracion;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Tarifa;
import cr.ac.una.cgi.pgc.session.TarifaFacadeRemote;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * Bean request que se utiliza para administrar la información de la página de
 * "Administración del Tarifario"
 * @author Jeremy Guzmán Salazar
 */
public class TarifaFacadeManaged implements Logeable{
    @EJB
    private TarifaFacadeRemote tarifaFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public TarifaFacadeManaged() {
        auxTarifa = new AuxTarifa();
    }

    //<editor-fold defaultstate="collapsed" desc="Control de Página de Administración del Tarifario">
    
    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Guarda los cambios que se le han hecho a la información del tarifario.
     *
     * @param event Evento de acción.
     */
    public void action_cb_guardarCambios(ActionEvent event){
        if(event != null){
            try{
                ArrayList<Tarifa> consultados = auxTarifa.getConsultados();

                for(Tarifa t : consultados){
                    if(t.getPrecio() > 0){
                        tarifaFacade.edit(t);
                        tarifaTransaction = t;
                        getLogFacade().update(this);
                        tarifaTransaction = null;
                    }
                    else{
                        mensajeError = "No se pemiten tarifas menores o iguales a 0. Esos precios no se almacenarán en el sistema.";
                        errorVisible = true;
                    }
                }


            }
            catch(Exception e){
                mensajeError = "No se pudieron actualizar los datos correctamente. Revise la conexión con el servidor y vuelva a intentarlo." 
                        + e.getMessage() + e.toString()+e.getStackTrace().toString();
                e.printStackTrace();

                errorVisible = true;
            }
        }
    }

    /**
     * Limpia la consulta, para cancelar cualquier cambio en la información que no haya
     * sido guardado.
     *
     * @param event Evento de la acción.
     */
    public void action_cb_cancelarCambios(ActionEvent event){
        auxTarifa.limpiarConsulta();
    }

    /**
     * Cierra el mensaje de error
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        errorVisible = false;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos y Propiedades">

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
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    private void dispararEfecto(){
        efectoFooter.setFired(false);
    }

    /**
     * Consulta la información del tarifario según los parámetros de consulta (Grupo de Envío y Tipo de Envío)
     * @return Arreglo con la información del tarifario
     */
    public ArrayList<Tarifa> getConsultados(){

        seguridad();

        try{
            return auxTarifa.getConsultados();
        }
        catch(Exception e){
            try{
                auxTarifa.setTarifario(tarifaFacade.findAll());
                infoFooter = "Datos cargados exitosamente.";
                dispararEfecto();
                return auxTarifa.getConsultados();
            }
            catch(Exception x){
                mensajeError = "No se pudo acceder a la información del sistema. Revise la conexión con el servidor y vuelva a intentarlo.";
                errorVisible = true;
            }
        }
        
        return new ArrayList<Tarifa>();
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

    private String infoFooter = "No hay información relevante.";
    private Highlight efectoFooter = new Highlight();
    private String mensajeError = "";
    private boolean errorVisible = false;
    private String codigoPermiso = "5";
    private Tarifa tarifaTransaction;

    //</editor-fold>
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        Tarifa m = null;
        return "Consulta no soportada";
    }

    public String getDeleteString() {
        Tarifa m = null;
        return "Consulta no soportada";
    }

    public String getUpdateString() {
        Tarifa m = tarifaTransaction;

        String query = "UPDATE tarifa SET peso_inicio = {0}, peso_final = {1}, codigo_grupo_envio = {2}, tipo = {3}, precio = {4} " +
                "WHERE codigo = {5}";
        
        query = query.replace("{0}", String.valueOf(m.getPesoInicio()));
        query = query.replace("{1}", String.valueOf(m.getPesoFinal()));
        query = query.replace("{2}", m.getCodigoGrupoEnvio() == null? "" : m.getCodigoGrupoEnvio().getCodigo());
        query = query.replace("{3}", m.getTipo() == null? "" : m.getTipo().getCodigo());
        query = query.replace("{4}", String.valueOf(m.getPrecio()));
        query = query.replace("{5}", m.getCodigo() == null? "" : String.valueOf(m.getCodigo()));

        return query;

    }

    public String getTablaString() {
        return "tarifa";
    }

    public  Empleado getEmpleado() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        return seguridad.getEmpleadoIngreso();
    }

    private Log getLogFacade(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (Log)session.getAttribute("Log");
    }

     //</editor-fold>

    public AuxTarifa getAuxTarifa(){
        return auxTarifa;
    }

    private AuxTarifa auxTarifa;    

}
