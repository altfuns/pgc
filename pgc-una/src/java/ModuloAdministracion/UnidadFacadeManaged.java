package ModuloAdministracion;

import Estructuras.UnidadUserObject;
import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Unidad;
import cr.ac.una.cgi.pgc.session.UnidadFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Esta clase se encarga de controlar los procesos que administra la página de
 * "Administración de Unidades".
 * @author Jeremy Guzmán Salazar
 */

public class UnidadFacadeManaged implements Logeable{

    @EJB
    private UnidadFacadeRemote unidadFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public UnidadFacadeManaged() {
        auxUnidad = new AuxUnidad();
    }

    //<editor-fold defaultstate="collapsed" desc="Control del autocompletar de unidades *Acceso Universal*">
    /**
     * Descarta opciones del autocompletar filtrando las unidades por las siglas
     * @param palabra Palabra con que se efectuará el filtrado
     */
    public void generarFiltro(String palabra) {
        if (palabra != null && !palabra.isEmpty()) {
            unidadAutoCompletar = new ArrayList<SelectItem>();
            for (SelectItem u : getUnidadOriginal()) {
                if (((Unidad)u.getValue()).getAcron().toUpperCase().startsWith(palabra.toUpperCase())) {
                    unidadAutoCompletar.add(u);
                }
            }
        } else {
            unidadAutoCompletar = null;
        }
    }

    /**
     *
     * @return Cantidad de unidades que tiene el componente actualmente
     */
    public int getCantidadUnidades() {
        return getUnidadOriginal().size();
    }

    /**
     *
     * @return Unidades que tiene actualmente el componente
     */
    public ArrayList<SelectItem> getUnidadAutoCompletar() {
        if (unidadAutoCompletar == null) 
            unidadAutoCompletar = getUnidadOriginal();        
        return unidadAutoCompletar;
    }

    /**
     * Evento que filtra a las unidades cuando su valor cambia
     * @param event Evento de la acción
     */
    public void valueChange_sit_unidadAutocompletar(ValueChangeEvent event) {
        if (event != null) {
            generarFiltro(event.getNewValue().toString().toUpperCase());
        }
    }

    /**
     *
     * @return Todas las posibles unidades (opciones) que puede tener el componente
     */
    private ArrayList<SelectItem> getUnidadOriginal() {
        if (unidadOriginal == null) {
            try {
                List<Unidad> informacionUnidad = unidadFacade.findAll();
                unidadOriginal = new ArrayList<SelectItem>();

                for (Unidad u : informacionUnidad) {
                    if(u.getNumeroRuta() != null && u.getTipo() != 1)
                        unidadOriginal.add(new SelectItem(u, u.getNombre()));
                }
            } catch (Exception e) {
            }

        }
        return unidadOriginal;
    }
    ArrayList<SelectItem> unidadAutoCompletar;
    ArrayList<SelectItem> unidadOriginal;

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de Unidades">

    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Método que resalta el cuadro del footer
     */
    public void dispararEfecto(){
        efectoFooter.setFired(false);
    }

    /**
     * Valida si existe el nombre de la unidad o sus siglas
     * @param acron Siglas que se van a revisar
     * @param nombre Nombre de la unidad que se va a revisar
     * @return TRUE si ninguno de los dos existe en la base de datos, FALSE de lo contrario
     */
    public boolean validarExistencia(String acron, String nombre){
        Unidad unidad1 = null;
        Unidad unidad2 = null;

        try{unidad1 = unidadFacade.findByNombre(nombre).get(0);}
        catch(Exception e){}

        try{unidad2 = unidadFacade.findByAcron(acron.trim()).get(0);}
        catch(Exception e){}

        if(unidad1 == null && unidad2 == null)
            return true;

        return false;
    }

    /**
     * Evento de un commandButton que cancela la visibilidad del panelPopup encargado
     * de mostrar los errores que el usuario genere en la pantalla
     */
    public void action_cb_cerrarPopup(ActionEvent event) {
        if (event != null) {
            errorVisible = false;
        }
    }

    /**
     * Evento que se encarga de seleccionar una unidad que pertenece al árbol
     * @param event Evento de la acción
     */
    public void action_cl_seleccionarUnidad(ActionEvent event) {
        if (event != null) {
            UIComponent componente = event.getComponent().getChildren().get(0);
            String codigo = componente.getValueBinding("value").getValue(FacesContext.getCurrentInstance()).toString();
            auxUnidad.seleccionarNodo(codigo);
        }
    }

    /**
     * Evento que reune todos los datos del formulario de ingreso, crea una nueva unidad
     * y la agrega a la base de datos
     * @param event Evento de la acción
     */
    public void action_cb_agregarUnidad(ActionEvent event) {
        if (auxUnidad.getUnidadSeleccionada() != null) {
            if (auxUnidad.getNuevaUnidad() != null && auxUnidad.getNuevaUnidad().compareTo("") != 0
                    && auxUnidad.getNuevoAcron() != null && auxUnidad.getNuevoAcron().compareTo("") != 0 &&
                    validarExistencia(auxUnidad.getNuevoAcron(), auxUnidad.getNuevaUnidad())) {
                try {
                    unidadFacade.create(auxUnidad.crearUnidad());
                    infoFooter = "Se agregó la unidad correctamente.";
                    getLogFacade().create(this);
                    dispararEfecto();
                } catch (Exception e) {
                    mensajeError = "Ocurrió un problema mientras se almacenaba la unidad en el sistema. Verifique la conexión y vuelva a intentarlo."+e.getMessage();
                    errorVisible = true;
                }
            } else {
                mensajeError = "Los campos de la nueva unidad y las siglas, deben estar llenos y no deben ser iguales a los de otra unidad.";
                errorVisible = true;
            }
        } else {
            mensajeError = "Debe seleccionar una unidad para poder agregar otra como hija.";
            errorVisible = true;
        }

        auxUnidad.limpiarModelo();
    }

    /**
     * Evento que elimina la unidad seleccionada
     * @param event Evento de la acción
     */
    public void action_cb_eliminarUnidad(ActionEvent event) {
        if (auxUnidad.getUnidadSeleccionada() != null) {
            if (((UnidadUserObject) auxUnidad.getUnidadSeleccionada().getUserObject()).getUnidad().getTipo() != 0) {
                try {
                    ArrayList<Unidad> unidades = auxUnidad.getAEliminar();
                    
                    for (Unidad u : unidades){
                        unidadFacade.remove(u);

                        auxiliarTransaction = u;
                        getLogFacade().delete(this);
                        auxiliarTransaction = null;

                    }

                    infoFooter = "Se eliminaron las unidades correctamente.";
                    dispararEfecto();
                    
                } catch (Exception e) {
                    mensajeError = "No se pudo eliminar la unidad correctamente, verifique la conexión y vuelva a intentarlo.";
                    errorVisible = true;
                }
            } else {
                mensajeError = "No se puede eliminar esta unidad.";
                errorVisible = true;
            }
        } else {
            mensajeError = "Debe seleccionar una unidad para poder eliminarla.";
            errorVisible = true;
        }

        auxUnidad.limpiarModelo();
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
     * Método que se encarga de suministrar la información del árbol, que representa el
     * organigrama de la Universidad Nacional
     * @return Modelo del árbol con todas las unidades
     */
    public DefaultTreeModel getModel() {

        seguridad();

        try {
            return auxUnidad.getModel();
        } catch (Exception e) {
            try {
                auxUnidad.armarModelo(unidadFacade.findAll());
                return auxUnidad.getModel();
            } catch (Exception x) {
                mensajeError = x.toString();
                errorVisible = true;
            }
        }

        DefaultMutableTreeNode raiz = auxUnidad.agregarNodo(null, new Unidad("0", "Universidad Nacional","UNA"));
        DefaultTreeModel model = new DefaultTreeModel(raiz);

        return model;
    }

    public String getUnidadSel(){
        if(auxUnidad.getUnidadSeleccionada() != null){
            return auxUnidad.getUnidadSeleccionada().toString();
        }
        return "No hay unidad seleccionada";
    }

    public boolean getErrorVisible() {
        return errorVisible;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public String getInfoFooter(){
        return infoFooter;
    }

    public Highlight getEfecto(){
        return efectoFooter;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private boolean errorVisible = false;
    private String mensajeError;
    private String infoFooter = "No hay información relevante";
    private Highlight efectoFooter = new Highlight();
    private String codigoPermiso = "7";

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        Unidad m = auxUnidad.crearUnidad();
        
        String query = "INSERT INTO unidad(codigo, nombre,acron,numero_ruta,tipo) VALUES ({0},{1},{2},{3},{4})";

        query = query.replace("{0}", m.getCodigo() == null? "" : m.getCodigo());
        query = query.replace("{1}", m.getNombre() == null? "" : m.getNombre());
        query = query.replace("{2}", m.getAcron() == null? "" : m.getAcron());
        query = query.replace("{3}", m.getNumeroRuta() == null? "" : m.getNumeroRuta().getNumero());
        query = query.replace("{4}", m.getTipo() == null? "" : m.getTipo().toString());

        return query;
    }

    public String getDeleteString() {
        Unidad m = auxiliarTransaction;
        
        String query = "DELETE FROM unidad WHERE codigo = {0}";
        query = query.replace("{0}", m.getCodigo());

        return query;
    }

    public String getUpdateString() {
        Unidad m = null;
        
        /*String query = "UPDATE unidad SET nombre = {0}, acron = {1}, numero_ruta = {2}, tipo = {3} WHERE codigo = {4}";

        query = query.replace("{0}", m.getNombre() == null? "" : m.getNombre());
        query = query.replace("{1}", m.getAcron() == null? "" : m.getAcron());
        query = query.replace("{2}", m.getNumeroRuta() == null? "" : m.getNumeroRuta().getNumero());
        query = query.replace("{3}", m.getTipo() == null? "" : m.getTipo().toString());
        query = query.replace("{4}", m.getCodigo() == null? "" : m.getCodigo());*/

        return "Instrucción no soportada";
    }

    public String getTablaString() {
        return "unidad";
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

    public AuxUnidad getAuxUnidad() {
        return auxUnidad;
    }
    private AuxUnidad auxUnidad;

    private Unidad auxiliarTransaction;
}
