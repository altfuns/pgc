package ModuloRutas;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.TipoInterno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

//Request
/**
 * Clase auxiliar a CorrespondenciaInternaFacadeManaged.
 * @author Jeremy Guzmán Salazar
 */
public class AuxCorrespondenciaInterna {
   
    public AuxCorrespondenciaInterna() {
    }

    //<editor-fold defaultstate="collapsed" desc="Control de Correspondencia">

    //<editor-fold defaultstate="collapsed" desc="Métodos de Control de Interfaz" >

    /**
     * Agregar 3 registros vacíos para que el usuario los ingrese
     */
    public void agregarVacíos() {

        Date hoy = new Date();
        registros = registros == null ? new ArrayList<CorrespondenciaInternaLocal>() : registros;

        if (hoy.getDate() == fechaComparacion.getDate() && hoy.getMonth() == fechaComparacion.getMonth() && hoy.getYear() == fechaComparacion.getYear()) {

            CorrespondenciaInterna nuevoRegistro1 = new CorrespondenciaInterna();
            nuevoRegistro1.setFechaEntregaMensajero(new Date());
            
            CorrespondenciaInterna nuevoRegistro2 = new CorrespondenciaInterna();
            nuevoRegistro2.setFechaEntregaMensajero(new Date());

            CorrespondenciaInterna nuevoRegistro3 = new CorrespondenciaInterna();
            nuevoRegistro3.setFechaEntregaMensajero(new Date());

            registros.add(new CorrespondenciaInternaLocal(new CorrespondenciaInterna()));
            registros.add(new CorrespondenciaInternaLocal(new CorrespondenciaInterna()));
            registros.add(new CorrespondenciaInternaLocal(new CorrespondenciaInterna()));

        }
    }

    /**
     * Limpia los registros de la pantalla para que pueda reiniciar la consulta
     */
    public void cancelarCambios() {
        registros = null;
    }

    /**
     * Cambia la ruta y limpia la pantalla para que pueda reiniciar la consulta
     * @param nuevaRuta Nombre de la ruta por la que serán consultados los registros.
     */
    public void cambiarRuta(String nuevaRuta) {
        rutaSeleccionada = nuevaRuta;
        registros = null;
    }

    /**
     * Cambia la fecha de comparación de acuerdo al botón (si es un botón de avanzar avanza,
     * si no retrocede) y limpia la pantalla para volver a generar la consulta. Se elige una
     * de las fechas válidas. (Véase la documentación del métodos fechasEntrega())     * 
     * @param id Nombre del botón para saber si avanza o retrocede.
     */
    public void cambiarFecha(String id) {
        estadosPaginador[0] = false;
        estadosPaginador[1] = false;

        Date fechas[] = fechasEntrega();
        int indice = obtenerIndice(fechas);

        if (indice != -1) {
            if (id.contains("avanzar")) {
                indice--;
                fechaComparacion = fechas[indice];
                if (indice == 0) {
                    estadosPaginador[0] = false;
                    estadosPaginador[1] = true;
                }
            } else {
                indice++;
                fechaComparacion = fechas[indice];
                if (indice == fechas.length-1) {
                    estadosPaginador[0] = true;
                    estadosPaginador[1] = false;
                }
            }
        } else {
            fechaComparacion = new Date();
        }

        registros = null;
    }

    /**
     * Calcula el indice de la fecha de comparación, para averiguar cual es la fecha
     * anterior y posterior. (Véase la documentación del método fechasEntrega())
     * @param fechas fechas válidas para buscar la fecha.
     */
    private int obtenerIndice(Date[] fechas) {

        for (int i = 0; i < fechas.length; i++) {
            if (fechaComparacion.getDate() == fechas[i].getDate() &&
                    fechaComparacion.getMonth() == fechas[i].getMonth() &&
                    fechaComparacion.getYear() == fechas[i].getYear()) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Retorna una consulta vacía, pasa cuando la consulta a bd no tiene resultados
     * @return Consulta Vacía
     */
    public ArrayList<CorrespondenciaInternaLocal> getRegistrosVacíos() {
        registros = new ArrayList<CorrespondenciaInternaLocal>();
        agregarVacíos();
        return registros;
    }

    /**
     * Elige el mensajero inicial con que la página consultará sus registros. Se determina con
     * el usuario que lo ingresó y su rol dentro del sistema.
     * @param login Empleado ingresó al sistema.
     * @param mensajeros Lista de opciones con nombres de mensajeros para elegir la opción correcta.
     */
    public void elegirMensajeroInicial(Empleado login, ArrayList<SelectItem> mensajeros) {

        if (login != null) {
            if (login.getTipo().getCodigo() == '3') {
                empleadoIngreso = login;
            } else {
                if (mensajeros != null && mensajeros.size() > 0) {
                    empleadoIngreso = (Empleado) mensajeros.get(0).getValue();
                } else {
                    empleadoIngreso = null;
                }
            }
        }

    }

    /**
     * Elige la ruta inicial con que la página comenzará consultando. Esta se elige con respecto al empleado que ingresa al sistema     
     * @param empleado Empleado de ingreso al sistema.
     * @param externo Tipo que indica si el empleado ingresado tiene asignadas rutas externas
     * @param rutasAsignadas Cantidad de rutas asignadas al empleado
     */
    public void elegirRutaInicial(Empleado empleado, boolean externo, int rutasAsignadas) {

        if (rutas != null) {
            if (empleado != null && rutasAsignadas != 0) {
                for (SelectItem si : rutas) {
                    Ruta ruta = null;
                    try {
                        ruta = (Ruta) si.getValue();
                    } catch (Exception e) {
                    }
                    if ((externo && ruta == null) ||
                            (ruta.getEmpleadoId() != null && ruta.getEmpleadoId().getId().compareTo(empleado.getId()) == 0)) {
                        try{
                            rutaSeleccionada = ((Ruta) si.getValue()).getNumero();
                        }
                        catch(Exception e){
                            rutaSeleccionada = "Externa";
                        }
                        break;
                    }
                }
            } else {
                for (SelectItem si : rutas) {
                    if (!si.isDisabled()) {
                        try{
                            rutaSeleccionada = ((Ruta) si.getValue()).getNumero();
                        }
                        catch(Exception e){
                            rutaSeleccionada = "Externa";
                        }
                        break;
                    }
                }
            }
        }

    }

    /**
     * Se encarga de activar las opciones para la elección de la ruta de consulta.
     * Este método se encarga en particular de activar los SelectItem de las rutas asignadas
     * a un empleado.
     * @param empleado Empleado que ingresa al sistema.
     * @param externo Si este empleado tiene asignadas rutas externas.
     */
    public void habilitarRutasPropias(Empleado empleado, boolean externo) {

        if (rutas != null && empleado != null) {

            for (int i = 0; i < rutas.size(); i++) {
                Ruta auxR = null;
                try {
                    auxR = (Ruta) rutas.get(i).getValue();
                } catch (Exception e) {
                }
                if ((externo && auxR == null) || (auxR != null && auxR.getEmpleadoId() != null && auxR.getEmpleadoId().getId().compareTo(empleado.getId()) == 0)) {
                    SelectItem aux = rutas.get(i);
                    aux.setDisabled(false);
                    rutas.set(i, aux);
                }
            }

        }

    }

    /**
     * Se encarga de activar las opciones para la elección de la ruta de consulta.
     * Este método se encarga en particular de activar los SelectItem de las rutas asignadas
     * a otros empleados.
     * @param empleado Empleado que ingresa al sistema.
     * @param externo Si este empleado tiene asignadas rutas externas.
     */
    public void habilitarRutasAjenas(Empleado empleado, boolean externo) {

        if (rutas != null && empleado != null) {

            for (int i = 0; i < rutas.size(); i++) {
                Ruta auxR = null;
                try {
                    auxR = (Ruta) rutas.get(i).getValue();
                } catch (Exception e) {
                }
                if ((externo && auxR != null) || (!externo && auxR == null) || (auxR != null && auxR.getEmpleadoId() == null) ||
                        (auxR != null && auxR.getEmpleadoId() != null && auxR.getEmpleadoId().getId().compareTo(empleado.getId()) != 0)) {
                    SelectItem aux = rutas.get(i);
                    aux.setDisabled(false);
                    rutas.set(i, aux);
                }
            }

        }

    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos de lógica">

    /**
     * Verifica si en las rutas asignadas a un mensajero existe alguna ruta externa
     * @param rutas Rutas en las que se busca una de tipo externa
     * @return TRUE si se encuentra una ruta externa, FALSE si no.
     */
    public boolean isEmpleadoExterno(List<Ruta> rutas) {

        if (rutas != null && rutas.size() != 0) {
            for (Ruta r : rutas) {
                if (!r.getInterna()) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Selecciona de toda la lista de empleados, los que están activos y los que son
     * mensajeros, para poder asignarlos a la correspondencia interna - externa por mensajero propio.
     * @param empleados Lista de empleados que se han ingresado al sistema
     * @return Lista con los empleados activos y que son mensajeros
     */
    public ArrayList<Empleado> getMensajeros(List<Empleado> empleados) {

        ArrayList<Empleado> mensajeros = new ArrayList<Empleado>();
        if (empleados != null) {
            for (Empleado e : empleados) {
                if (e.getActivo() && e.getTipo().getCodigo() == '3') {
                    mensajeros.add(e);
                }
            }

        }

        return mensajeros;
    }

    /**
     * Selecciona al empleado que esta ingresando la correspondencia. 
     * @param codigo
     * @param itemes
     */
    public void seleccionarEmpleadoIngreso(String codigo, ArrayList<SelectItem> itemes) {
        for (SelectItem si : itemes) {
            if (((Empleado) si.getValue()).toString().compareTo(codigo) == 0) {
                empleadoIngreso = (Empleado) si.getValue();
                break;
            }
        }
    }

    /**
     * Este método se encarga de presentar al usuario los registros de correspondencia
     * que no se han entregado, y de añadirle los registros que resultaron erróneos de la
     * de la última actualización.
     * @param originales Consulta de Correspondencia Interna
     */
    public void actualizarRegistros(List<CorrespondenciaInterna> originales) {
        registros = new ArrayList<CorrespondenciaInternaLocal>();

        for (CorrespondenciaInterna c : originales) {
            registros.add(new CorrespondenciaInternaLocal(c));
        }

        if (registrosErroneos != null) {
            for(CorrespondenciaInternaLocal cil : registrosErroneos){
                if(cil.getIdentificador() == null)
                    registros.add(cil);
            }
            registrosErroneos = null;
        }

        agregarVacíos();
    }

    /**
     * Este método se encarga de verificar si un registro está totalmente vacío
     * @param auxRegistro Registro que se va a analizar
     * @return TRUE si el registro está vacío, FALSE si no
     */
    public boolean estaVacío(CorrespondenciaInterna auxRegistro) {

        boolean vacio = true;

        vacio = vacio && (auxRegistro.getCodigo() == null || auxRegistro.getCodigo().compareTo("") == 0);
        vacio = vacio && (auxRegistro.getProcedenciaUnidad() == null || auxRegistro.getProcedenciaUnidad().compareTo("") == 0);
        vacio = vacio && (auxRegistro.getDestinoUnidad() == null || auxRegistro.getDestinoUnidad().compareTo("") == 0);
        vacio = vacio && (auxRegistro.getNombreRecibido() == null || auxRegistro.getNombreRecibido().compareTo("") == 0);
        vacio = vacio && auxRegistro.getFechaRecibido() == null && auxRegistro.getIdEntregaEmpleado() == null;

        return vacio;
    }

    /**
     * Este método se encarga de añadir a un nuevo registro, la información necesaria para
     * completarlo y añadirlo a la base de datos.
     * @param registro Registro que se va a modificar
     * @param max Actual identificador máximo, calcular el identificador del nuevo registro
     * @param rutaAsig Ruta a la cuál el nuevo registro se va a asignar
     * @return Registro de correspondencia interna con los nuevos datos.
     */
    public CorrespondenciaInternaLocal llenarNuevoRegistro(CorrespondenciaInternaLocal registro, int max, Ruta rutaAsig) {
        registro.setIdentificador(max + 1);
        registro.setFechaEntregaMensajero(fechaIngreso);
        registro.setIdRecibeEmpleado(empleadoIngreso);
        registro.setRutaAsignada(rutaAsig);
        return registro;
    }

    /**
     * Agrega a la lista de registros erróneos uno nuevo
     * @param nuevoErroneo Nuevo registro erróneo que se va a asignar al arreglo
     */
    public void agregarErroneo(CorrespondenciaInterna nuevoErroneo) {
        if (registrosErroneos == null) {
            registrosErroneos = new ArrayList<CorrespondenciaInternaLocal>();
        }
        if (nuevoErroneo != null) {           
            registrosErroneos.add(new CorrespondenciaInternaLocal(nuevoErroneo));
        }
    }

    /**
     * Metodo que asigna un mensajero a un registro
     * @param nuevoEmpleado Empleado responsable de la carta
     * @param indice Identificador del registro dentro del arreglo.
     */
    public void setEmpleado(Empleado nuevoEmpleado, int indice) {
        if (nuevoEmpleado != null && indice >= 0 && indice < getCantidadRegistros()) {
            CorrespondenciaInternaLocal auxRegistro = registros.get(indice);
            auxRegistro.setIdEntregaEmpleado(nuevoEmpleado);
            registros.set(indice, auxRegistro);
        }
    }

    /**
     * Metodo que asigna un tipo a un registro
     * @param tipo tipo del envío
     * @param indice Identificador del registro dentro del arreglo.
     */
    public void setTipo(TipoInterno tipo, int indice){
        if(tipo != null){
            CorrespondenciaInternaLocal auxRegistro = registros.get(indice);
            auxRegistro.setTipo(tipo);
            registros.set(indice, auxRegistro);
        }
    }

    /**
     * Valida que el registro se correcto antes de enviarlo a guardar a la base de datos
     * @param registro Registro que va a analizar
     * @return TRUE si el registro es correcto, FALSE de lo contrario.
     */
    public boolean validarRegistro(CorrespondenciaInterna registro) {

        boolean valid = true;

        valid = valid && registro.getDestinoUnidad().compareTo(registro.getProcedenciaUnidad()) != 0;
        if (registro.getFechaRecibido() != null) {
            Date fechaC = registro.getFechaEntregaMensajero() == null ? fechaComparacion : registro.getFechaEntregaMensajero();
            valid = valid && (registro.getFechaRecibido().after(fechaC) || 
                    (registro.getFechaRecibido().getDate() == fechaC.getDate() &&
                    registro.getFechaRecibido().getMonth() == fechaC.getMonth() &&
                    registro.getFechaRecibido().getYear() == fechaC.getYear()));
            valid = valid && registro.getIdEntregaEmpleado() != null;
        }

        valid = valid && registro.getDestinoUnidad().trim().compareTo("") != 0;
        valid = valid && registro.getProcedenciaUnidad().trim().compareTo("") != 0;

        return valid;
    }

    /**
     * Método que calcula 5 fechas distintas. La fecha actual, y de cuatro dias anteriores, sin contar fines de semana.
     * @return Arreglo con las cinco fechas
     */
    public Date[] fechasEntrega() {
        Date[] fechas = new Date[5];

        fechas[0] = new Date();

        for(int i = 1; i < 5; i++){
            Date aux = new Date(fechas[i-1].getTime());

            if(aux.getDay() == 1)
                aux.setDate(aux.getDate()-3);
            else
                aux.setDate(aux.getDate()-1);

            fechas[i] = aux;
        }

        return fechas;
    }

    /**
     * Compara la fecha de comparación de la página con la fecha de hoy, para ver si coindice
     * @return TRUE si se cumple, FALSE de lo contrario
     */
    public boolean comparacionHoy() {

        Date hoy = new Date();
        return fechaComparacion.getDate() == hoy.getDate() && fechaComparacion.getMonth() == hoy.getMonth() && fechaComparacion.getYear() == hoy.getYear();

    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public void setRegistros(List<CorrespondenciaInterna> auxRegistros) {
        registros = new ArrayList<CorrespondenciaInternaLocal>();

        for (CorrespondenciaInterna c : auxRegistros) {
            registros.add(new CorrespondenciaInternaLocal(c));
        }

        agregarVacíos();
    }

    public int getCantidadRegistros() {
        try {
            return getRegistros().size();
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<CorrespondenciaInternaLocal> getRegistros() throws Exception {
        if (registros == null) {
            throw new Exception();
        }

        return registros;
    }

    public ArrayList<CorrespondenciaInternaLocal> getErroneos() {
        if (registrosErroneos == null) {
            registrosErroneos = new ArrayList();
        }
        return registrosErroneos;
    }

    public ArrayList<SelectItem> getRutas() throws Exception {
        if (rutas == null) {
            throw new Exception();
        }
        return rutas;
    }

    /**
     * Crea las opciones de las rutas con los datos extraidos de la base de datos
     * @param originales Información de las rutas
     */
    public void setRutas(List<Ruta> originales) {
        rutas = new ArrayList<SelectItem>();

        for (Ruta r : originales) {
            if (r.getInterna()) {
                SelectItem si = new SelectItem(r, r.getNumero());
                si.setDisabled(true);
                rutas.add(si);
            }
        }

        SelectItem si = new SelectItem("Externa", "Externa");
        si.setDisabled(true);

        rutas.add(si);
    }

    public Ruta getRutaSel() {

        if (rutas != null) {
            for (SelectItem r : rutas) {
                if (r.getValue() instanceof Ruta &&
                        (((Ruta) r.getValue()).getNumero().compareTo(rutaSeleccionada) == 0 ||
                        ((Ruta) r.getValue()).toString().compareTo(rutaSeleccionada) == 0)) {
                    return (Ruta) r.getValue();
                }
            }
        }

        return null;
    }

    public Empleado getEmpleadoIngreso() {
        return empleadoIngreso;
    }

    public void setEmpleadoIngreso(String empleadoIngreso){
    }

    public boolean[] getEstadoPaginador() {
        return estadosPaginador;
    }

    public Date getFechaComparacion() {
        return fechaComparacion;
    }

    public String getEtqFechaComparacion() {
        return Integer.toString(fechaComparacion.getDate()) + "/" + Integer.toString(fechaComparacion.getMonth() + 1) + "/" + Integer.toString(fechaComparacion.getYear() + 1900);
    }

    public Date getFechaIngreso() {
        if (fechaIngreso == null) {
            fechaIngreso = new Date();
        }
        return fechaIngreso;
    }

    public void setFechaIngreso(Date nuevaFecha){
    }

    public String getRutaSeleccionada() {
  
        return rutaSeleccionada;
    }

    public void setRutaSeleccionada(String rutaSel) {
        cancelarCambios();
        rutaSeleccionada = rutaSel;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos de la página">
    ArrayList<CorrespondenciaInternaLocal> registros;
    ArrayList<CorrespondenciaInternaLocal> registrosErroneos;
    ArrayList<SelectItem> rutas;
    //Atributos de control de componentes
    private boolean[] estadosPaginador = {false, true};
    //Atributos para el control de información de la página    
    private Date fechaIngreso;
    private Date fechaComparacion = new Date();
    private Empleado empleadoIngreso;
    //Seleccionada por tipo de usuario
    private String rutaSeleccionada = "1";

    //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Consulta de Rutas">

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Limpia el formulario de consulta
     */
    public void limpiarFormulario() {
        registroConsulta = new CorrespondenciaInterna();
        empleadoResponsable = null;
        empleadoEntrega = null;
        tipoSel = null;
    }

    /**
     * Limpia los reh¡gistros que han sido consultados
     */
    public void limpiarConsulta() {
        consulta = null;
    }

    /**
     * Genera los nombres de los campos y sus valores, para poder realizar la consulta
     */
    public void generarParametros() {

        ArrayList<String> aNames = new ArrayList<String>();
        ArrayList<Object> aValues = new ArrayList<Object>();

        if (registroConsulta != null) {

            if (registroConsulta.getCodigo() != null && registroConsulta.getCodigo().compareTo("") != 0) {
                aNames.add("codigo");
                aValues.add(registroConsulta.getCodigo());
            }

            if (registroConsulta.getDestinatario() != null && registroConsulta.getDestinatario().compareTo("") != 0) {
                aNames.add("destinatario");
                aValues.add(registroConsulta.getDestinatario());
            }

            if (registroConsulta.getDestinoUnidad() != null && registroConsulta.getDestinoUnidad().compareTo("") != 0) {
                aNames.add("destinoUnidad");
                aValues.add(registroConsulta.getDestinoUnidad());
            }

            if (registroConsulta.getFechaEntregaMensajero() != null) {
                aNames.add("fechaEntregaMensajero");
                aValues.add(registroConsulta.getFechaEntregaMensajero());
            }

            if (registroConsulta.getFechaRecibido() != null) {
                aNames.add("fechaRecibido");
                aValues.add(registroConsulta.getFechaRecibido());
            }

            if (registroConsulta.getNombreRecibido() != null && registroConsulta.getNombreRecibido().compareTo("") != 0) {
                aNames.add("nombreRecibido");
                aValues.add(registroConsulta.getNombreRecibido());
            }

            if (registroConsulta.getProcedenciaUnidad() != null && registroConsulta.getProcedenciaUnidad().compareTo("") != 0) {
                aNames.add("procedenciaUnidad");
                aValues.add(registroConsulta.getProcedenciaUnidad());
            }            

        }

        names = new String[aNames.size()];
        for (int i = 0; i < aNames.size(); i++) {
            names[i] = aNames.get(i);
        }
        values = aValues.toArray();

    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public ArrayList<CorrespondenciaInterna> getConsulta() throws Exception {
        if (consulta == null) {
            throw new Exception();
        }
        return consulta;
    }

    public void setConsulta(List<CorrespondenciaInterna> auxConsulta) {
        consulta = new ArrayList<CorrespondenciaInterna>();
        for (CorrespondenciaInterna c : auxConsulta) {            
            if ((empleadoResponsable == null || (c.getIdEntregaEmpleado() != null && c.getIdEntregaEmpleado().getId().compareTo(empleadoResponsable.getId())== 0))
                    && (empleadoEntrega == null || (c.getIdRecibeEmpleado() != null && c.getIdRecibeEmpleado().getId().compareTo(empleadoEntrega.getId()) == 0))
                    && (tipoSel == null || (tipoSel != null && c.getTipo().getAcron().compareTo(tipoSel.getAcron()) == 0))) {
                 consulta.add(c);
            }
        }
    }

    public void setRegistroConsulta(CorrespondenciaInterna auxRegistro) {
        if (auxRegistro != null) {
            registroConsulta = auxRegistro;
        }
    }

    public CorrespondenciaInterna getRegistroConsulta() {
        if (registroConsulta == null) {
            registroConsulta = new CorrespondenciaInterna();
        }
        return registroConsulta;
    }

    public String getEmpleadoRespToString(){
        if(empleadoResponsable != null)
            return empleadoResponsable.getNombre() + " " + empleadoResponsable.getMiddleName() + " " + empleadoResponsable.getApellidos();
        return "";
    }
    
    public void setEmpleadoRespToString(String empleadoResp){        
    }

    public Empleado getEmpleadoResponsable() {
        return empleadoResponsable;
    }

    public void setEmpleadoResponsable(Empleado empleadoSel) {
        this.empleadoResponsable = empleadoSel;
    }

    public String getEmpleadoEntrToString(){
        if(empleadoEntrega != null)
            return empleadoEntrega.getNombre() + " " + empleadoEntrega.getMiddleName() + " " + empleadoEntrega.getApellidos();
        return "";
    }

    public void setEmpleadoEntrToString(String empleadoEntr){
    }

    public Empleado getEmpleadoEntrega() {
        return empleadoEntrega;
    }

    public void setEmpleadoEntrega(Empleado empleadoSel) {
        this.empleadoEntrega = empleadoSel;
    }

    public String getTipoSelToString(){
        if(tipoSel != null)
            return tipoSel.getDescripcion();
        return "";
    }

    public void setTipoSel(TipoInterno tipo){
        tipoSel = tipo;
    }

    public TipoInterno getTipoSel(){
        return tipoSel;
    }

    public String[] getNames() {
        return names;
    }

    public Object[] getValues() {
        return values;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String[] names;
    private Object[] values;
    private ArrayList<CorrespondenciaInterna> consulta;
    private CorrespondenciaInterna registroConsulta;
    private Empleado empleadoResponsable;
    private Empleado empleadoEntrega;
    private TipoInterno tipoSel;

    //</editor-fold>
    
    //</editor-fold>

    
}
