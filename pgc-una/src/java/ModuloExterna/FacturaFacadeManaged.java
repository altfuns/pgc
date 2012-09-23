
package ModuloExterna;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Factura;
import cr.ac.una.cgi.pgc.entity.Presupuesto;
import cr.ac.una.cgi.pgc.session.CorrespondenciaExternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.FacturaFacadeRemote;
import cr.ac.una.cgi.pgc.session.PresupuestoFacadeRemote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */

public class FacturaFacadeManaged implements Logeable {
    @EJB
    private CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade;
    @EJB
    private PresupuestoFacadeRemote presupuestoFacade;
    @EJB
    private FacturaFacadeRemote facturaFacade;
    
    public FacturaFacadeManaged() {
    }

    //<editor-fold defaultstate="collapsed" desc="Manejo del ListBox de Envios Agregados">
    /**
     * Propiedad set de los Envios seleccionados
     * @param envios
     * Lista de envíos nueva que quiere cambiar
     */
    public void setEnviosSeleccionados(String[] envios){
        
        this.enviosSelecionados = envios;
    }
    /**
     * Propiedad get de los envios seleccionado
     * @return
     * Lista de envíos seleccionados
     */
    public String[] getEnviosSeleccionados(){
        if(enviosSelecionados == null){
            enviosSelecionados = new String[]{};
        }
        return enviosSelecionados;
    }
    public void setEnviosSeleccionados2(String[] envios){

        this.enviosSelecionados2 = envios;
    }
    public String[] getEnviosSeleccionados2(){
        if(enviosSelecionados2 == null){
            enviosSelecionados2 = new String[]{};
        }
        return enviosSelecionados2;
    }
    /**
     * Propiedad set de los Envios asignados a la factura
     * @param envios
     * Lista de envíos nueva que quiere cambiar
     */
    public void setEnviosAsignados(ArrayList<SelectItem> envios){
        this.enviosAsignados = envios;
    }
    /**
     * Propiedad get de los envios asiganados
     * @return
     * Lista de envíos asignados
     */
    public ArrayList<SelectItem> getEnviosAsignados(){
        if(enviosAsignados == null){
            try{
                enviosAsignados = new ArrayList<SelectItem>();
            }catch(Exception e){

            }

        }
        return enviosAsignados;
    }
    /**
     * Propiedad set de los Envios sin asignar a la factura
     * @param envios
     * Lista de envíos nueva que quiere cambiar
     */
    public void setEnviosSinAsignar(ArrayList<SelectItem> envios){
        this.enviosSinAsignar = envios;
    }
    /**
     * Propiedad get de los envios sin asiganar
     * @return
     * Lista de envíos sin asignar
     */
    public ArrayList<SelectItem> getEnviosSinAsignar(){
        try{
            if(enviosSinAsignar == null){
                enviosSinAsignar = new ArrayList<SelectItem>();
            }
            enviosSinAsignar.clear();
            List<CorrespondenciaExterna> envios = correspondenciaExternaFacade.findAll();
            
            for(CorrespondenciaExterna envio : envios){
                if(envio.getFactura() == null){
                    enviosSinAsignar.add(new SelectItem(envio.getIdentificador(),envio.getIdentificador()+", "+envio.getPais().getNombre()+", "+envio.getPrecio()));
                }
            }
        }catch(Exception e){

        }
        return enviosSinAsignar;
    }
    /**
     * Agregar los envíos seleccionados a los envíos asignados
     */
    public void agregarEnvios(){

        try{
            if(enviosAsignados == null){
                enviosAsignados = new ArrayList<SelectItem>();
            }
            for(String envio : enviosSelecionados){
                CorrespondenciaExterna e = correspondenciaExternaFacade.find(Integer.parseInt(envio));
                SelectItem i = new SelectItem(e.getIdentificador(), e.getIdentificador()+", "+e.getPais().getNombre()+", "+e.getPrecio());
                if(!contains(enviosAsignados,i)){
                    enviosAsignados.add(i);
                    addMonto(e.getPrecio());
                    System.out.println("Nuevo Envio: "+envio);
                    eliminarEnvio(enviosSinAsignar, i);
                    enviosSelecionados = new String[]{};
                }

            }

        }catch(Exception e){

        }
    }
    /**
     * Remover uno o varios envíos asignados a la factura
     */
    public void quitarEnvios(){

        try{
            if(enviosSinAsignar == null){
                enviosSinAsignar = new ArrayList<SelectItem>();
            }
            for(String envio : enviosSelecionados2){
                CorrespondenciaExterna e = correspondenciaExternaFacade.find(envio);
                SelectItem i = new SelectItem(e.getCodigo(),e.getCodigo()+","+e.getDireccion()+","+e.getPrecio());
                enviosSinAsignar.add(i);
                subMonto(e.getPrecio());
                System.out.println("Quitar envio: "+envio);
                eliminarEnvio(enviosAsignados, i);
                enviosSelecionados2 = new String[]{};
            }

        }catch(Exception e){

        }
    }
    /**
     * Eliminar un elemento i de la Lista lista
     * @param lista
     * Lista de la cual se quiere eliminar el elemento
     * @param i
     * Elemento que quiere eliminar
     */
    public void eliminarEnvio(ArrayList<SelectItem> lista,SelectItem i){
        System.out.println("Item " + i.getValue().toString());
        for(SelectItem si : lista){
            if(i.getValue().toString().compareTo(si.getValue().toString()) == 0){
                lista.remove(si);
                
            } 
        }
    }
    /**
     * Determinar si un elemento esta presente en una lista
     * @param lista
     * Lista que se quiere recorrer
     * @param i
     * Elemento que se quiere determinar
     * @return
     * true si el valor esta presente en la lista, false en caso contrario
     */
    public Boolean contains(ArrayList<SelectItem> lista,SelectItem i){
        for(SelectItem si : lista){
            if(i.getValue().toString().compareTo(si.getValue().toString()) == 0){
                return true;
            }
        }
        return false;
    }
    /**
     * Controla el evento de cambio de valor de la lista envios sin asignar
     * @param event
     */
    public void valueChange_smlb_enviosSinAsignar(ValueChangeEvent event){
         if (!event.getPhaseId().equals(PhaseId.INVOKE_APPLICATION)) {
            event.setPhaseId(PhaseId.INVOKE_APPLICATION);
            event.queue();
            return;
        }

    }
    public void valueChange_smlb_enviosAsignados(ValueChangeEvent event){
         

    }
    /**
     * Incrementar el monto de la factura
     * @param m
     * Valor que se quiere aumentar al presupuesto
     */
    public void addMonto(Double m){
        Double monto = facturaLocal.getMonto() + m;
        facturaLocal.setMonto(monto);
    }
    /**
     * Restar el monto de la factura
     * @param m
     * Valor que se quiere restar al presupuesto
     */
    public void subMonto(Double m){
        Double monto = facturaLocal.getMonto() - m;
        facturaLocal.setMonto(monto);
    }
    private ArrayList<SelectItem> enviosSinAsignar;
    private ArrayList<SelectItem> enviosAsignados;
    private String[] enviosSelecionados;
    private String[] enviosSelecionados2;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">

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
     * Guardar una factura con las valor en pantalla
     */
    public void guardar(){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        Factura f = new Factura();
        try{
            f.setFecha(facturaLocal.getFecha());
            f.setNumero(facturaLocal.getNumero());
            f.setMonto(facturaLocal.getMonto());
            f.setNotaCollection(null);
            f.setNumeroOrden(facturaLocal.getNumeroOrden());
          
            if(validar()){
                facturaFacade.create(f);
                manejarPresupuesto();
                listaFacturas.add(new FacturaLocal(f));
                agregarFacturaEnvios(f);
                getLogFacade().create(this);
                message.setSeverity(FacesMessage.SEVERITY_INFO);
                message.setSummary("Factura Creada Correctamente");
                context.addMessage("frm_principal", message);
                limpiarCampos();
            }else{
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("No se ha podido ingresar la factura. Por favor revise que todos los campos sean correctos");
                context.addMessage("frm_principal", message);
            }
            
        }catch(Exception e){
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("No se ha podido ingresar la factura. Por favor revise que todos los campos sean correctos");
            context.addMessage("frm_principal", message);
            getLogFacade().error(this, e.getMessage());
        }
    }
    /**
     * Agrega los envíos que pertenecen a una factura
     * @param f
     * Factura a la que se le quieren agregar los envios
     * @return
     * true si se pudo agregar los envíos, false en caso contrario
     */
    public Boolean agregarFacturaEnvios(Factura f){
        Boolean ok = true;
        try{
            for(SelectItem si : enviosAsignados){
                CorrespondenciaExterna ce = correspondenciaExternaFacade.find(si.getValue());
                ce.setFactura(f);
                correspondenciaExternaFacade.edit(ce);
                //System.out.println("Envio agregado :" + ce.getCodigo());
            }
        }catch(Exception e){
            ok = false;
        }
        return ok;
    }
    /**
     * Diminuir el presupuesto con el monto de la factura
     */
    public void manejarPresupuesto(){
        try{
            Presupuesto p = presupuestoFacade.find("001");
            if(validarImporte()){
                p.setMonto(p.getMonto() - facturaLocal.getMonto());
                System.out.println(p.getMonto());
                presupuestoFacade.edit(p);
            }else{
                throw new Exception("El importe de la factura es mayor al monto del presupuesto");
            }
        }catch(Exception e){

        }
    }
    /**
     * Limpia los campos de la pantalla
     */
    public void limpiarCampos(){
        facturaLocal = new FacturaLocal();
        enviosAsignados.clear();
        enviosSinAsignar.clear();
        enviosSelecionados = new String[]{};
        enviosSelecionados2 = new String[]{};
    }

   
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    /**
     * Valida que el importe y los envíos sean correctos
     * @return
     * true sí la información es correcta, false en caso contrario
     */
    private Boolean validar(){
        Boolean flag = false;
        if(validarImporte() && validarEnvios())
            flag = true;
        return flag;
    }
    /**
     * Valida el importe de la factura
     * @return
     * true sí el monto de la factura es mayor que creo y menor que que el monto del presupuesto
     */
    private Boolean validarImporte(){
        Presupuesto p = presupuestoFacade.find("001");
        if(facturaLocal.getMonto() > 0 && p.getMonto() >= facturaLocal.getMonto())
            return true;
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("El importe de la factura es mayor a el monto del presupuesto.");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage("it_monto", message);

        return false;
    }
    /**
     * Valida si la factura tiene envíos asignados
     * @return
     * true sí la factura tiene envíos asignados, false en caso contrario
     */
    private Boolean validarEnvios(){
        if(!enviosAsignados.isEmpty())
            return true;
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("No hay ningún envío por facturar");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage("it_monto", message);
        return false;
    }
    /**
     * Valida que el número de factura no sea el de otra factura
     * @param context
     * @param validate
     * @param value
     */
    public void validateNumeroFactura(FacesContext context, UIComponent validate,Object value) {
        String numero = (String) value;
        Factura f = facturaFacade.find(numero);
        if (f != null) {
            FacesMessage msg = new FacesMessage("El número de factura pertenece a una factura ya ingresada");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(validate.getClientId(context), msg);
        }
    }
    /**
     * Valida que el importe de la factura sea menor que el del presupuesto
     * @param context
     * @param validate
     * @param value
     */
    public void validateImporte(FacesContext context, UIComponent validate,Object value){
        Double importe = (Double) value;
        Presupuesto p = presupuestoFacade.find("001");
        if (p.getMonto() < importe ) {
            FacesMessage msg = new FacesMessage("El importe de la factura es mayor a el monto del presupuesto.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(validate.getClientId(context), msg);
            facturaLocal.setMonto(0.0);
        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        FacturaLocal f = facturaLocal;
        String query = "INSERT INTO factura(numero,monto, fecha, numero_orden)" +
                "VALUES ({0},{1},{2},{3});";

        query = query.replace("{0}", f.getNumero() == null? "" : f.getNumero());
        query = query.replace("{1}", String.valueOf(f.getMonto()));
        query = query.replace("{2}", f.getFecha() == null? "" : f.getFecha().toString());
        query = query.replace("{3}", f.getNumeroOrden() == null? "" : f.getNumeroOrden());

        return query;
    }

    public String getDeleteString() {
        FacturaLocal f = facturaLocal;
        
        String query = "DELETE FROM factura WHERE numero = {0};";
        query = query.replace("{0}", f.getNumero());

        return query;

    }

    public String getUpdateString() {
        FacturaLocal f = facturaLocal;
        String query = "UPDATE factura SET monto = {0}, fecha = {1}, numero_orden = {2}" +
                "WHERE numero = {3});";

       query = query.replace("{0}", String.valueOf(f.getMonto()));
       query = query.replace("{1}", f.getFecha() == null? "" : f.getFecha().toString());
       query = query.replace("{2}", f.getNumeroOrden() == null? "" : f.getNumeroOrden());
       query = query.replace("{3}", f.getNumero() == null? "" : f.getNumero());

       return query;
    }

    public String getTablaString() {
        return "factura";
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
    
    public ArrayList<FacturaLocal> getListaFacturas(){
        seguridad();
        listaFacturas = new ArrayList<FacturaLocal>();
        ArrayList<Factura> auxLista = new ArrayList(facturaFacade.findAll());
        Collections.reverse(auxLista);
        ArrayList<Factura> list;
        if(auxLista.size() > 25)
            list = new ArrayList<Factura>(auxLista.subList(0, 25));
        else
            list = new ArrayList<Factura>(auxLista);
        for(Factura f : list){
            FacturaLocal fl =  new FacturaLocal(f);
            fl.setEnvios(getEnvios(f));
            listaFacturas.add(fl);
        }
        return listaFacturas;
    }

    private String getEnvios(Factura f){
        String e="";
        ArrayList<CorrespondenciaExterna> en =  new ArrayList<CorrespondenciaExterna>(correspondenciaExternaFacade.findByFactura(f));
        for(CorrespondenciaExterna ce : en)
            e += ce.getIdentificador() + "," + ce.getPais().getNombre() + "," +String.valueOf(ce.getPrecio()) + "\n" ;
        return e;
    }
    public FacturaLocal getFacturaLocal() {
        return facturaLocal;
    }

    public void setFacturaLocal(FacturaLocal facturaLocal) {
        this.facturaLocal = facturaLocal;
    }

    private String codigoPermiso = "13";
    private FacturaLocal facturaLocal = new FacturaLocal();
    private ArrayList<FacturaLocal> listaFacturas = null;

    
    //</editor-fold>



}
