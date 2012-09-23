
package ModuloAdministracion;
import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.session.EmpleadoFacadeRemote;
import cr.ac.una.cgi.pgc.session.PermisoFacadeRemote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 * Bean request que se encarga de administrar la información de la página
 * "Administración de Empleados"
 * @author Jeremy Guzmán Salazar
 */

public class EmpleadoFacadeManaged implements Logeable{
    @EJB
    private PermisoFacadeRemote permisoFacade;
    @EJB
    private EmpleadoFacadeRemote empleadoFacade;

    /**
     * Creación de la Instancia, se inicia la instancia auxiliar
     */
    public EmpleadoFacadeManaged() {
        auxEmpleado = new AuxEmpleado();
    }        

    //<editor-fold defaultstate="collapsed" desc="Control de Página de Administración de Empleados">
   
    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    private void dispararEfecto(){
        efectoFooter.setFired(false);
    }

    /**
     * Guarda los cambios que se le hayan hecho al grid de los empleados.
     *
     * @param event Evento de la acción
     */
    public void action_cb_guardarCambios(ActionEvent event){
        if(event != null){
            try{
                ArrayList<Empleado> empleados = auxEmpleado.getEmpleados();

                for(Empleado e : empleados){
                    try{
                        if(e.getTipo().getCodigo() == '1' && !e.getActivo()){
                            errorMensaje = "No se puede inhabilitar al jefe.";
                            erroresVisible = true;
                        }
                        else{
                            empleadoFacade.edit(e);                        
                            auxiliarCambios = e;
                            getLogFacade().update(this);
                            auxiliarCambios = null;
                        }
                    }
                    catch(Exception x){
                        errorMensaje = "No se pudo actualizar a la informacion. Verifique si no ha ingresado algún dato erróneo y vuelva a intentarlo.";
                        erroresVisible = true;
                    }
                }

                infoFooter = "Se actualizaron los registros correctamente.";
                dispararEfecto();

            }
            catch(Exception e){
                errorMensaje = "No se pudo acceder a la informacion. Verifique si no ha ingresado algún dato erróneo y vuelva a intentarlo.";
                erroresVisible = true;
            }

            auxEmpleado.limpiarConsulta();
        }
    }

    /**
     * Crea y guarda el empleado con los datos obtenidos del formulario.
     *
     * @param event Evento de la acción.
     */
    public void action_cb_guardarEmpleado(ActionEvent event){
        if(event != null){

            try{

                if(auxEmpleado.validarEmpleadoIngreso()){

                    auxEmpleado.llenarCargoEmpleado();
                    auxEmpleado.asignarPermisos(permisoFacade.findByRol(auxEmpleado.getEmpleadoIngreso().getTipo()));
                    
                    Empleado jefe = auxEmpleado.buscarJefe();

                    if(auxEmpleado.getEmpleadoIngreso().getTipo().getCodigo() == '1' && jefe != null)
                        empleadoFacade.remove(jefe);

                    empleadoFacade.create(auxEmpleado.getEmpleadoIngreso());
                    getLogFacade().create(this);
                    auxEmpleado.vaciarFormulario();
                    auxEmpleado.limpiarConsulta();
                    infoFooter = "Se pudo almacenar la información del nuevo empleado correctamente.";
                    dispararEfecto();
                }else{
                    throw new Exception();
                }
            }
            catch(Exception e){
                errorMensaje = "No se pudo guardar la información del nuevo empleado dentro del sistema. Verifique que toda la información esté correcta y vuelva a intentarlo.";
                erroresVisible = true;
            }
            
        }
    }

    /**
     * Cierra el mensaje de error.
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        erroresVisible = false;
    }

    /**
     * Limpia los campos del formulario de ingreso al sistema.
     *
     * @param event Evento de la acción.
     */
    public void action_cb_limpiarFormulario(ActionEvent event){
        auxEmpleado.vaciarFormulario();
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
     * @return Cantidad de empleados que tiene la consulta.
     */
    public int getCantidadEmpleados(){
        return getEmpleados().size();
    }

    /**
     * Regresa la información de todos los empleados. Si no existen en memoria, lo
     * extrae de la base de datos.
     *
     * @return Arreglo con la información de todos los empleados.
     */
    public ArrayList<Empleado> getEmpleados(){
        seguridad();
        ArrayList<Empleado> result = new ArrayList<Empleado>();
        try{
            result = auxEmpleado.getEmpleados();

        }
        catch(Exception e){
            try{
                auxEmpleado.setEmpleados(empleadoFacade.findAll());
                result = auxEmpleado.getEmpleados();
            }
            catch(Exception x){
                errorMensaje = "No se pudo acceder a la información, verifique su conexión y vuelva a intentar.";                
                erroresVisible = true;
                result = auxEmpleado.getEmpleadosVacios();
            }
            
        }
        Collections.sort(result, empleadosComparator);
        return result;
    }

    public String getMensajeError(){
        return errorMensaje;
    }

    public boolean getErrorVisible(){
        return erroresVisible;
    }

    public Highlight getEfecto(){
        return efectoFooter;        
    }
    
    public String getInfoFooter(){
        return infoFooter;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private Highlight efectoFooter = new Highlight();
    private String infoFooter = "No hay información relevante.";
    private boolean erroresVisible = false;
    private String errorMensaje = "";
    private String codigoPermiso = "9";

    //</editor-fold>
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        Empleado m = auxEmpleado.getEmpleadoIngreso();

        String query = "INSERT INTO empleado(id, nombre, middle_name, apellidos, tipo, activo) VALUES ({0},{1},{2},{3},{4},{5})";
        
        query = query.replace("{0}",m.getId() == null? "" : m.getId());
        query = query.replace("{1}",m.getNombre() == null? "" : m.getNombre());
        query = query.replace("{2}",m.getMiddleName() == null? "" : m.getMiddleName());
        query = query.replace("{3}",m.getApellidos() == null? "" : m.getApellidos());
        query = query.replace("{4}",m.getTipo() == null? "" : m.getTipo().getDescripcion());
        query = query.replace("{5}",String.valueOf(m.getActivo()));

        return query;

    }

    public String getDeleteString() {        
        return "Instrucción no soportada";
    }

    public String getUpdateString() {
        Empleado m = auxiliarCambios;
        
        String query = "UPDATE empleado SET nombre = {0}, middle_name = {1}, apellidos = {2}, tipo = {3}, activo = {4} WHERE id = {5}";

        query = query.replace("{0}",m.getNombre() == null? "" : m.getNombre());
        query = query.replace("{1}",m.getMiddleName() == null? "" : m.getMiddleName());
        query = query.replace("{2}",m.getApellidos() == null? "" : m.getApellidos());
        query = query.replace("{3}",m.getTipo() == null? "" : m.getTipo().getDescripcion());
        query = query.replace("{4}",String.valueOf(m.getActivo()));
        query = query.replace("{5}",m.getId() == null? "" : m.getId());

        return query;
    }

    public String getTablaString() {
        return "empleado";
    }

    private Log getLogFacade(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (Log)session.getAttribute("Log");
    }

     //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos y Propiedades">

    public AuxEmpleado getAuxEmpleado(){
        return auxEmpleado;
    }

    AuxEmpleado auxEmpleado;
    Empleado auxiliarCambios;

    Comparator<Empleado> empleadosComparator = new Comparator<Empleado>(){

        @Override
        public int compare(Empleado e1, Empleado e2) {
            int result = 1;
            if(e1.getActivo() == e2.getActivo()){
                result = e1.getNombre().compareToIgnoreCase(e2.getNombre());
            }else{
                result = e1.getActivo() && !e2.getActivo()? -1 : 1;
            }
            return result;
        }

    };

    //</editor-fold>


}
