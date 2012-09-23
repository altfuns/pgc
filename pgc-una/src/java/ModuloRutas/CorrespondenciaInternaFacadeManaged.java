package ModuloRutas;

import Logs.Log;
import Reportes.Reporte;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.FileResource;
import com.icesoft.faces.context.Resource;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.TipoInterno;
import cr.ac.una.cgi.pgc.entity.Unidad;
import cr.ac.una.cgi.pgc.session.CorrespondenciaInternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.EmpleadoFacadeRemote;
import cr.ac.una.cgi.pgc.session.RutaFacadeRemote;
import cr.ac.una.cgi.pgc.session.TipoInternoFacadeRemote;
import cr.ac.una.cgi.pgc.session.UnidadFacadeRemote;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 * Bean Request que se encarga de administrar la información de las páginas de
 * "Control de Correspondencia" y de "Consulta de Correspondencia generada en las Rutas"
 * @author Jeremy Guzmán Salazar
 */
public class CorrespondenciaInternaFacadeManaged {
    @EJB
    private TipoInternoFacadeRemote tipoInternoFacade;
    @EJB
    private RutaFacadeRemote rutaFacade;
    @EJB
    private EmpleadoFacadeRemote empleadoFacade;
    @EJB
    private UnidadFacadeRemote unidadFacade;
    @EJB
    private CorrespondenciaInternaFacadeRemote correspondenciaInternaFacade;

    /**
     * Constructor de la clase, se crea la instancia auxiliar y la clase para construir los reportes
     */
    public CorrespondenciaInternaFacadeManaged() {
        auxCorrespondenciaInterna = new AuxCorrespondenciaInterna();
        controlR = new Reporte();

    }    

    //<editor-fold defaultstate="collapsed" desc="Página de Control de Correspondencia">

    //<editor-fold defaultstate="collapsed" desc="Control de Autocompletar de mensajeros">

    /**
     * Selecciona un empleado de las opciones el autocompletar
     * @param nombre Nombre del empleado (etiqueta de la opción)
     * @return Empleado que se ajuste al nombre
     */
    private Empleado getFindEmpleadoMatch(String nombre){

        if(empleadoAutoCompletar != null){

            for(SelectItem e : empleadoAutoCompletar){
                if(e.getLabel().compareToIgnoreCase(nombre)==0){
                    return (Empleado)e.getValue();
                }
            }

        }

        return null;
    }

    /**
     * Genera el filtro de las opciones que se muestran en el componente de autocompletar
     * de los empleados
     * @param palabra Nuevo valor en el componente
     */
    private void generarFiltro(String palabra) {
        if (palabra != null && !palabra.isEmpty()) {
            empleadoAutoCompletar = new ArrayList<SelectItem>();

            for (SelectItem e : getEmpleadoOriginal()) {
                String label = e.getLabel().toUpperCase();
                if (label.startsWith(palabra.toUpperCase())){
                    empleadoAutoCompletar.add(e);
                }
            }

        } 
    }

    /**
     *
     * @return Cantidad de opciones que tiene el componente actualmente
     */
    public int getCantidadEmpleados(){
        return getEmpleadoOriginal().size();
    }

    /**
     * @return Opciones que tiene el componente
     */
    public ArrayList<SelectItem> getEmpleadoAutoCompletar() {
        if (empleadoAutoCompletar == null){
            empleadoAutoCompletar = new ArrayList<SelectItem>();
            for(SelectItem auxOriginal : getEmpleadoOriginal())
                empleadoAutoCompletar.add(auxOriginal);
        }
        return empleadoAutoCompletar;
    }

    /**
     * @return Opciones de todos los empleados que puede tener el componente
     */
    public ArrayList<SelectItem> getEmpleadoOriginal() {
        if (empleadoOriginal == null) {
            empleadoOriginal = new ArrayList<SelectItem>();
            try{
                ArrayList<Empleado> informacionUnidad = auxCorrespondenciaInterna.getMensajeros(empleadoFacade.findAll());
                for (Empleado e : informacionUnidad) {
                    empleadoOriginal.add(new SelectItem(e,
                            e.getNombre() + " " + e.getApellidos()));
                }
            }
            catch(Exception e){                
            }
        }
        return empleadoOriginal;
    }

    /**
     * Evento que controla los cambios en el componente, y las opciones que presenta
     * @param event Evento de la acción
     */
    public void valueChange_sit_empleadoAutocompletar(ValueChangeEvent event){
        if(event.getComponent() instanceof SelectInputText){
            generarFiltro(event.getNewValue().toString());

            int i = Integer.parseInt(event.getComponent().getClientId(FacesContext.getCurrentInstance()).toString().split(":")[2]);
            
            SelectInputText autoComplete = (SelectInputText) event.getComponent();
            if (autoComplete.getSelectedItem() != null) {
                auxCorrespondenciaInterna.setEmpleado((Empleado)autoComplete.getSelectedItem().getValue(), i);
            }else{
                Empleado tmp = getFindEmpleadoMatch(event.getNewValue().toString());
                if (tmp != null){
                    autoComplete.setSelectedItem(tmp.getId());
                    auxCorrespondenciaInterna.setEmpleado(tmp, i);
                }
            }

        }
    }

    ArrayList<SelectItem> empleadoAutoCompletar;
    ArrayList<SelectItem> empleadoOriginal;

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Evento que almacena todos los cambios que han ocurrido en la página. Se toma en cuenta
     * la creación, la modificación y la actualización de los registros.
     * @param event Evento de la acción
     */
    public void action_cb_guardarPagina(ActionEvent event) {

        int agregados = 0;
        int eliminados = 0;
        int actualizados = 0;
        archivoPDF = null;

        if(event != null){

            try{               
                ArrayList<CorrespondenciaInternaLocal> registros = auxCorrespondenciaInterna.getRegistros();

                for(int i = 0; i < registros.size(); i++){
                    try{
                        if(!auxCorrespondenciaInterna.estaVacío(registros.get(i)) || (registros.get(i).isaEliminar() && registros.get(i).getIdentificador() != null)){
                            if(registros.get(i).isaEliminar()){
                                correspondenciaInternaFacade.remove(registros.get(i).getCorrespondenciaInterna());
                                getLogFacade().delete(registros.get(i));
                                eliminados++;
                            }
                            else{
                                Unidad procedencia = null;
                                Unidad destino = null;

                                try{procedencia = unidadFacade.findByNombre(registros.get(i).getProcedenciaUnidad()).get(0);}
                                catch(Exception e){}
                                try{destino = unidadFacade.findByNombre(registros.get(i).getDestinoUnidad()).get(0);}
                                catch(Exception e){}

                                if(verificarRegistro(registros.get(i), procedencia, destino)){

                                    Ruta rutaAsig = destino != null ? destino.getNumeroRuta() : null;

                                    if(registros.get(i).getIdentificador() != null){
                                        CorrespondenciaInterna registroEditar = registros.get(i).getCorrespondenciaInterna();
                                        registroEditar.setRutaAsignada(rutaAsig);
                                        correspondenciaInternaFacade.edit(registroEditar);
                                        getLogFacade().update(new CorrespondenciaInternaLocal(registroEditar));
                                        actualizados++;
                                    }
                                    else{
                                        int max = 0;
                                        try{max = correspondenciaInternaFacade.findIdentificadorMax();}catch(Exception e){}

                                        CorrespondenciaInternaLocal nuevoRegistro = auxCorrespondenciaInterna.llenarNuevoRegistro(registros.get(i),max, rutaAsig);
                                        correspondenciaInternaFacade.create(nuevoRegistro.getCorrespondenciaInterna());
                                        getLogFacade().create(nuevoRegistro);
                                        agregados++;
                                    }
                                }
                                else{                                    
                                    throw new Exception();
                                }

                            }                           
                        }                        
                    }
                    catch(Exception e){
                        auxCorrespondenciaInterna.agregarErroneo(registros.get(i));
                    }
                }

                if(auxCorrespondenciaInterna.getErroneos() != null && auxCorrespondenciaInterna.getErroneos().size() != 0){
                    errorConexion = "Hay registros erróneos. Verifique la información de los registros (que no se han guardado o actualizado) " +
                            "si las unidades existen, si no son iguales, si el mensajero responsable ingresado existe, o si la fecha de entrega es inferior o igual a la fecha de recibido.";
                    popupVisible = true;
                }
                
                auxCorrespondenciaInterna.cancelarCambios();
                infoFooter = "Registros agregados: " + Integer.toString(agregados) + ". " +
                        "Registros eliminados: " + Integer.toString(eliminados) + ". " +
                        "Registros actualizados: " + Integer.toString(actualizados) + ". " +
                        "Registros erróneos: " + Integer.toString(auxCorrespondenciaInterna.getErroneos().size()) + ".";

                dispararEfecto();
            
            }
            catch(Exception e){
                errorConexion = e.toString();
                popupVisible = true;
            }

        }

    }

    /**
     * Evento que se utiliza para añadir un tipo de envío a un registro
     * @param event Evento de la acción
     */
    public void valueChange_som_seleccionarTipo(ValueChangeEvent event){
        
        if(event != null){            
            int indice = Integer.parseInt(event.getComponent().getClientId(FacesContext.getCurrentInstance()).split(":")[2]);
            auxCorrespondenciaInterna.setTipo(getFindTipoMatch(event.getNewValue().toString()), indice);
        }
        
    }

    /**
     * Evento que se utiliza para cerrar el mensaje de error
     * @param event Evento de la acción
     */
    public void action_cb_cerrarPopup(ActionEvent event){
        popupVisible = false;
    }

    /**
     * Evento que se utiliza para borrar todos los cambios que se hayan hecho en la página
     * y que no hayan sido borrados
     * @param event Evento de la acción
     */
    public void action_cb_cancelarCambios(ActionEvent event) {
        archivoPDF = null;
        auxCorrespondenciaInterna.cancelarCambios();
    }

    /**
     * Evento que manipula los días de consulta, que permiten modificar los datos registros de
     * dias anteriores
     * @param event Evento de la acción
     */
    public void action_cb_elegirDia(ActionEvent event) {
        auxCorrespondenciaInterna.cambiarFecha(event.getComponent().getId());
    }    

    /**
     * Evento que agrega tres registros vacíos para almacenar la información.
     * @param event Evento de la acción
     */
    public void action_cb_agregarRegistrosVacios(ActionEvent event){
        auxCorrespondenciaInterna.agregarVacíos();
    }    

    /**
     * Evento que selecciona el empleado que recibe la correspondencia.
     * @param event Evento de la acción
     */
    public void valueChange_som_seleccionarEmpleado(ValueChangeEvent event){
        if(event != null && event.getNewValue() != null){
            auxCorrespondenciaInterna.seleccionarEmpleadoIngreso(event.getNewValue().toString(), empleadoOriginal);            
        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">

    /**
     * Método que verifica si el usuario tiene los permisos adecuado para ver la información
     * de esta página.
     */
    private void seguridad(){
       
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        if(seguridad != null){
            ArrayList<Permiso> permisos = seguridad.getPermisosRegistroInterna();

            if(permisos.size() == 0){
                try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
                }
                catch(Exception e){ }
            }
            else{
                List<Ruta> rutasAsignadas = new ArrayList<Ruta>();
                try{rutasAsignadas = rutaFacade.findByEmpleado(seguridad.getEmpleadoIngreso());}
                catch(Exception e){ }
                boolean externo = auxCorrespondenciaInterna.isEmpleadoExterno(rutasAsignadas);

                if(rutasAsignadas != null && rutasAsignadas.size() != 0)
                    auxCorrespondenciaInterna.habilitarRutasPropias(seguridad.getEmpleadoIngreso(), externo);

                if(permisos.size() == 2)
                    auxCorrespondenciaInterna.habilitarRutasAjenas(seguridad.getEmpleadoIngreso(), externo);

                getEmpleadoOriginal();
                
                auxCorrespondenciaInterna.elegirMensajeroInicial(seguridad.getEmpleadoIngreso(), empleadoOriginal);
                auxCorrespondenciaInterna.elegirRutaInicial(seguridad.getEmpleadoIngreso(), externo, rutasAsignadas == null ? 0 : rutasAsignadas.size());
                
            }
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
     * Selecciona un empleado de las opciones del autocompletar
     * @param empleadoAutoCompletar Opciones del componente
     * @param nombre Nombre de búsqueda del empleado
     * @return Empleado encontrado, null de lo contrario
     */
    public Empleado getFindEmpleadoMatch(List<Object> empleadoAutoCompletar, String nombre){

        if(empleadoAutoCompletar != null){
            
            for(Object e : empleadoAutoCompletar){
                if(e instanceof SelectItem && ((SelectItem)e).getLabel().compareToIgnoreCase(nombre)==0)
                    return (Empleado)((SelectItem)e).getValue();
            }

        }

        return null;
    }

    /**
     * Selecciona un tipo de las opciones del autocompletar
     * @param nombre Nombre del tipo
     * @return Tipo que se encontró, null de lo contrario
     */
    public TipoInterno getFindTipoMatch(String nombre){
        if(tipos != null){
            
            for(Object e : tipos){
                if(((SelectItem)e).getValue().toString().compareToIgnoreCase(nombre)==0)
                    return (TipoInterno)((SelectItem)e).getValue();
            }

        }

        return null;
    }

    /**
     * Verifica si el registro está correcto
     * @param registro Registro a analizar
     * @param procedencia Unidad de procedencia del registro
     * @param destino Unidad de destino del registro
     * @return TRUE si el registro es correcto, FALSE de lo contrario
     */
    private boolean verificarRegistro(CorrespondenciaInterna registro, Unidad procedencia, Unidad destino){

        if(procedencia == null && destino == null)
            return false;
        
        return auxCorrespondenciaInterna.validarRegistro(registro);
    }   

    /**
     * Activa el efecto para hacer notar el mensaje del pie de página.
     */
    private void dispararEfecto(){
        efectoFooter.setFired(false);
    }

    /**
     * Crea el reporte para llenar la hoja de control de correspondencia
     */
    private void crearResource(){
                               
        Ruta rutaSel = auxCorrespondenciaInterna.getRutaSel();
        
        String nombreArchivo = rutaSel != null ? "Ruta" + rutaSel.getNumero() : "RutaExterna";
        FacesContext facesContext = FacesContext.getCurrentInstance();

        Date hoy = new Date();
        
        Date comparacionTarea = new Date(hoy.getYear(), hoy.getMonth(), hoy.getDate(), 12, 0);
        nombreArchivo += "_" + Integer.toString(hoy.getYear() + 1900) + Integer.toString(hoy.getMonth()) + Integer.toString(hoy.getDate()) + "_";
        nombreArchivo += hoy.before(comparacionTarea) ? "mañana" : "tarde";


        try{
            try{
                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }

            String sel = auxCorrespondenciaInterna.getEmpleadoIngreso() == null ? "" :
                auxCorrespondenciaInterna.getEmpleadoIngreso().getNombre() + " " +
                auxCorrespondenciaInterna.getEmpleadoIngreso().getApellidos();

            controlR.registrosCorrespondenciaInterna(auxCorrespondenciaInterna.getRutaSel(),
                    sel, auxCorrespondenciaInterna.fechasEntrega(), nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            archivoPDF = new FileResource(archivo);
        }
        catch(Exception e){
            errorConexion = "Ocurrió un problema al crear el archivo.";
            popupVisible = true;
        }        
    }    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public Highlight getEfecto(){
        return efectoFooter;
    }

    /**
     * Extrae de la base de datos los registros consultados según la ruta, la fecha y los envíos no entregados     *
     * @return Registros de correspondencia interna de hoy
     */
    public ArrayList<CorrespondenciaInternaLocal> getRegistrosCorrespondenciaInterna(){
       
        try{
            return auxCorrespondenciaInterna.getRegistros();
        }
        catch(Exception e){
            try{

                List<CorrespondenciaInterna> bd = new ArrayList<CorrespondenciaInterna>();

                Ruta rutaSel = auxCorrespondenciaInterna.getRutaSel();

                if(auxCorrespondenciaInterna.comparacionHoy()){
                    Date[] fechas = auxCorrespondenciaInterna.fechasEntrega();
                    try{
                        if(rutaSel != null)
                            bd.addAll(correspondenciaInternaFacade.findRegistrosCorrespondenciaInterna(rutaSel, fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]));
                        else
                            bd.addAll(correspondenciaInternaFacade.findRegistrosCorrespondenciaExterna(fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]));
                    }
                    catch(Exception x){ }

                }
                else{
                    try{
                        if(rutaSel != null)
                            bd.addAll(correspondenciaInternaFacade.findByInternaFechaRecibido(rutaSel, auxCorrespondenciaInterna.getFechaComparacion()));
                        else
                            bd.addAll(correspondenciaInternaFacade.findByExternaFechaRecibido(auxCorrespondenciaInterna.getFechaComparacion()));
                    }
                    catch(Exception x){ }
                }
                auxCorrespondenciaInterna.actualizarRegistros(bd);
                
                return auxCorrespondenciaInterna.getRegistros();

            }
            catch(Exception x){
                
            }
        }

        return auxCorrespondenciaInterna.getRegistrosVacíos();
    }

    /**
     * Extrae de la base de datos la información de las rutas y crea las opciones para presentarlas en el menu
     * @return Arreglo con todas las rutas
     */
    public ArrayList<SelectItem> getRutas(){

        try{
            return auxCorrespondenciaInterna.getRutas();
        }
        catch(Exception e){
            try{
                auxCorrespondenciaInterna.setRutas(rutaFacade.findAll());
                try{
                    seguridad();
                }
                catch(Exception x){
                    try{ FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface"); }
                    catch(Exception c){ }
                }
                return auxCorrespondenciaInterna.getRutas();
            }
            catch(Exception x){
                errorConexion = "No se pudo acceder a la información del sistema. Verifique su conexión y vuelva a intentarlo.";
                popupVisible = true;
            }
        }      

        ArrayList<SelectItem> itemes = new ArrayList<SelectItem>();
        return itemes;        
    }

    public String getErrorConexion(){
        return errorConexion;
    }

    public boolean getPDFVisible(){
        return PDFVisible;
    }

    public boolean getPopupVisible(){
        return popupVisible;
    }
    
    public String getInfoFooter(){
        return infoFooter;
    }
    
    public Resource getArchivoPDF(){
        if(archivoPDF == null){
            crearResource();
        }
        return archivoPDF;
    }   
    
    public String getEmpleadoSel(){
       if(auxCorrespondenciaInterna.getEmpleadoIngreso() == null){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");

            auxCorrespondenciaInterna.elegirMensajeroInicial(seguridad.getEmpleadoIngreso(), empleadoOriginal);
            
            if(auxCorrespondenciaInterna.getEmpleadoIngreso() == null)
                return "";
            
        }

        String algo = auxCorrespondenciaInterna.getEmpleadoIngreso().toString();
        return algo;
    }

    public void setRutaSeleccionada(String ruta){
        archivoPDF = null;
        auxCorrespondenciaInterna.setRutaSeleccionada(ruta);
    }

    public String getRutaSeleccionada(){
        return auxCorrespondenciaInterna.getRutaSeleccionada();
    }

    public void setEmpleadoSel(String empleadoSel){
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private boolean PDFVisible = false;
    private Highlight efectoFooter = new Highlight();
    private boolean popupVisible = false;
    private String errorConexion;
    private String infoFooter = "No hay información relevante.";
    private Resource archivoPDF;

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Página de Consulta de Correspondencia Interna">
    
    //<editor-fold defaultstate="collapsed" desc="Eventos">

    /**
     * Evento para controlar el autocompletar del mensajero que recibe la correspondencia
     * @param event Evento de la accioón
     */
    public void valueChange_sit_empleadoAutoCompletarC1(ValueChangeEvent event){
        if(event.getComponent() instanceof SelectInputText){
            generarFiltro(event.getNewValue().toString());

            auxCorrespondenciaInterna.setEmpleadoEntrega(null);
            if(empleadoOriginal != null){
                for(SelectItem si : empleadoOriginal){                    
                    if(si.getLabel().compareTo(event.getNewValue().toString()) == 0)
                        auxCorrespondenciaInterna.setEmpleadoEntrega((Empleado)si.getValue());
                }
            }

        }
    }

    /**
     * Evento para controlar el autocompletar del mensajero que entrega la correspondencia
     * @param event Evento de la accioón
     */
    public void valueChange_sit_empleadoAutoCompletarC2(ValueChangeEvent event){
        if(event.getComponent() instanceof SelectInputText){
            generarFiltro(event.getNewValue().toString());

            auxCorrespondenciaInterna.setEmpleadoResponsable(null);
            if(empleadoOriginal != null){
                for(SelectItem si : empleadoOriginal){                   
                    if(si.getLabel().compareTo(event.getNewValue().toString()) == 0)
                        auxCorrespondenciaInterna.setEmpleadoResponsable((Empleado)si.getValue());
                }
            }

        }
    }

    /**
     * Evento que limpia el formulario de la página de consulta
     * @param event Evento de la acción
     */
    public void action_cb_limpiarFormulario(ActionEvent event){
        auxCorrespondenciaInterna.limpiarFormulario();
    }

    /**
     * Evento de que limpia los registros consultados
     * @param event Evento de la acción
     */
    public void action_cb_limpiarConsulta(ActionEvent event){
        auxCorrespondenciaInterna.limpiarConsulta();
    }

    /**
     * Evento que genera los parámetros y realiza la consulta de la base de datos.
     * @param event Evento de la acción.
     */
    public void action_cb_generarConsulta(ActionEvent event){
        try{
            auxCorrespondenciaInterna.generarParametros();
            String[] names = auxCorrespondenciaInterna.getNames();
            Object[] values = auxCorrespondenciaInterna.getValues();
            auxCorrespondenciaInterna.setConsulta(correspondenciaInternaFacade.findByParameters(names, values));
            infoFooter = "Consulta fué exitosa. Se consultaron " + Integer.toString(auxCorrespondenciaInterna.getConsulta().size()) + " registros.";
            dispararEfecto();
        }catch(Exception x){
            errorConexion = "No se pudo acceder a la información. Verifique su conexión y vuelva a intentarlo.";
            popupVisible = true;
        }
    }

    /**
     * Método que verifica si los permisos del empleado que ingresó al sistema son los adecuados
     * para consultar esta información.
     */
    public void seguridadC(){      
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        if(seguridad != null){
            ArrayList<Permiso> permisos = seguridad.getPermisosConsultaInterna();

            if(permisos.size() == 0){
                try{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
                }
                catch(Exception e){ }
            }
            else{
                if(permisos.size() == 1){
                    mensajeroInactivo = true;
                    auxCorrespondenciaInterna.setEmpleadoResponsable(seguridad.getEmpleadoIngreso());
                }
            }
        }
        else{
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
            }
            catch(Exception e){
            }
        }              
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos y Propiedades">

    public ArrayList<CorrespondenciaInterna> getConsulta() {        
        try{
            return auxCorrespondenciaInterna.getConsulta();
        }catch(Exception e){            
        }

        return new ArrayList<CorrespondenciaInterna>();

    }

    public boolean getMensajeroInactivo(){
        seguridadC();
        return mensajeroInactivo;
    }

    private boolean mensajeroInactivo = false;

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Autocompletar de tipos">

    /**
     * Evento que filtra las opciones del componente de autocompletar de tipos.
     *
     * @param event
     */
    public void valueChange_sit_tiposAutocompletar(ValueChangeEvent event) {
        if (event != null && event.getComponent() instanceof SelectInputText) {
            generarFiltroT(event.getNewValue().toString());

            auxCorrespondenciaInterna.setTipoSel(null);
            if(tipos != null){
                for(SelectItem si : tipos){
                    if(si.getLabel().compareTo(event.getNewValue().toString()) == 0)
                        auxCorrespondenciaInterna.setTipoSel((TipoInterno)si.getValue());
                }
            }
        }
    }

    /**
     * Evento que descarta opciones del autocompletar, segun la palabra que ingresó el usuario
     * @param palabra Palabra ingresada para generar el filtro.
     */
    public void generarFiltroT(String palabra) {
        tiposAutocompletar = new ArrayList<SelectItem>();

        if (palabra != null && !palabra.isEmpty()) {
            for (SelectItem auxTipo : getTipos()) {
                if (auxTipo.getLabel().toUpperCase().startsWith(palabra.toUpperCase())) {
                    tiposAutocompletar.add(auxTipo);
                }
            }
        } else {
            tiposAutocompletar = getTipos();
        }

    }

    /**
     *
     * @return Cantidad de opciones que tiene el componente
     */
    public int getCantidadTipos() {
        return getTipos().size();
    }

    /**
     *
     * @return Opciones del componente de autocompletar actuales
     */
    public ArrayList<SelectItem> getTipoAutocompletar() {
        if (tiposAutocompletar == null) {
            return tipos;
        }
        return tiposAutocompletar;
    }

    /**
     *
     * @return Todas las posibles opciones del componente de autocompletar
     */
    public ArrayList<SelectItem> getTipos() {
        if (tipos == null) {
            tipos = new ArrayList<SelectItem>();

            ArrayList<TipoInterno> tiposI = new ArrayList<TipoInterno>();
            try{tiposI.addAll(tipoInternoFacade.findAll());}
            catch(Exception e){ }

            for(TipoInterno ti : tiposI)
                tipos.add(new SelectItem(ti, ti.getDescripcion()));

        }
        return tipos;
    }

    private ArrayList<SelectItem> tipos;
    private ArrayList<SelectItem> tiposAutocompletar;

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">
    
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

    public AuxCorrespondenciaInterna getAuxCorrespondenciaInterna() {
        return auxCorrespondenciaInterna;
    } 

    private AuxCorrespondenciaInterna auxCorrespondenciaInterna;
    private Reporte controlR;
}
