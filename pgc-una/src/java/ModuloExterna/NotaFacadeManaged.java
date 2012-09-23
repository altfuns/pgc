
package ModuloExterna;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Factura;
import cr.ac.una.cgi.pgc.entity.Nota;
import cr.ac.una.cgi.pgc.entity.Presupuesto;
import cr.ac.una.cgi.pgc.session.FacturaFacadeRemote;
import cr.ac.una.cgi.pgc.session.NotaFacadeRemote;
import cr.ac.una.cgi.pgc.session.PresupuestoFacadeRemote;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */

public class NotaFacadeManaged implements Logeable{
    @EJB
    private PresupuestoFacadeRemote presupuestoFacade;
    @EJB
    private FacturaFacadeRemote facturaFacade;
    @EJB
    private NotaFacadeRemote notaFacade;

    /** Creates a new instance of NotaFacadeManaged */
    public NotaFacadeManaged() {
        tipos = new ArrayList<SelectItem>();
        tipos.add(new SelectItem(0,"Crédito"));
        tipos.add(new SelectItem(1,"Débito"));
    }

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
     * Crea una nueva Nota
     */
    public void guardar(){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        Nota n = new Nota();
        try{
            n.setFecha(notaLocal.getFecha());
            n.setNumero(notaLocal.getNumero());
            n.setMonto(notaLocal.getMonto());
            n.setTipo(notaLocal.getTipo());
            
            n.setNumeroFactura(notaLocal.getNumeroFactura());
            if(validarImporte()){
                 notaFacade.create(n);
                manejarPresupuesto();
                getLogFacade().create(this);
                message.setSeverity(FacesMessage.SEVERITY_INFO);
                message.setSummary("Nota Creada Correctamente");
                context.addMessage("frm_principal", message);
                listaNotas.add(new NotaLocal(n));
                limpiarCampos();
            }
           
        }catch(Exception e){
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            message.setSummary(e.getMessage());
            message.setDetail(e.getMessage());
            context.addMessage("frm_principal", message);
            getLogFacade().error(this, e.getMessage());
        }
    }
    /**
     * Aumenta o disminuye el presupuesto con el monto de la Nota, dependiendo del tipo de Nota
     */
    public void manejarPresupuesto(){
        try{
            Presupuesto p = presupuestoFacade.find("001");
            if(notaLocal.getTipo() == 1){
                p.setMonto(p.getMonto() - notaLocal.getMonto());
                presupuestoFacade.edit(p);

            }else if(notaLocal.getTipo() == 0){
                p.setMonto(p.getMonto() + notaLocal.getMonto());
                presupuestoFacade.edit(p);
            }
        }catch(Exception e){
            getLogFacade().error(this, e.getMessage());
        }
    }
    /**
     * Limpia los campos de la pantalla
     */
    public void limpiarCampos(){
        notaLocal = new NotaLocal();
        
    }


    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    /**
     * Valida que el número de nota sea único
     * @param context
     * @param validate
     * @param value
     */
    public void validateNumeroNota(FacesContext context, UIComponent validate,Object value) {
        String numero = (String) value;
        Nota n = notaFacade.find(numero);
        if (n != null) {
            FacesMessage msg = new FacesMessage("El número de nota ya existe");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(validate.getClientId(context), msg);
        }
    }
    /**
     * Valida el monto de la nota con el monto del presupuesto
     * @param context
     * @param validate
     * @param value
     */
    public void validateImporte(FacesContext context, UIComponent validate,Object value){
        try{
            Double monto = (Double)value;
            Presupuesto p = presupuestoFacade.find("001");
            if(notaLocal.getTipo() == 0 && notaLocal.getNumeroFactura().getMonto() < monto){
                FacesMessage msg = new FacesMessage("El monto de la nota de crédito no puede sobrepasar el monto de la factura");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(validate.getClientId(context), msg);
            }else {
                if(notaLocal.getTipo() == 1 && p.getMonto() < monto){
                    FacesMessage msg = new FacesMessage("No hay fondos suficientes para pagar la nota. Por favor revise el presupuesto");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    context.addMessage(validate.getClientId(context), msg);
                }
            }
        }catch(Exception e){

        }

    }
    /**
     * Valida el monto de la nota con el monto del presupuesto
     * @return
     * true sí el monto de la nota es menor a el de la factura es caso de que sea una Nota de Crédito,
     * o el monto del presupuesto es mayor a el de la nota que caso de que sea una Nota de Débito. false en caso contrario
     */
    public Boolean validarImporte(){
        Double monto = notaLocal.getMonto();
        Presupuesto p = presupuestoFacade.find("001");
        if(notaLocal.getTipo() == 0 && notaLocal.getNumeroFactura().getMonto() < monto){
            return false;
        }else {
            if(notaLocal.getTipo() == 1 && p.getMonto() < monto){
                return false;
            }
        }
        return true;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Control del autocompletar de facturas">
    /**
      * Controla el autocompletar de Facturas, cambia las facturas dependiendo de la palabra digitada.
      * @param event
      */
    public void ValueChange_sit_facturaAutocompletar(ValueChangeEvent event){
        if (event.getComponent() instanceof SelectInputText) {
             // get the number of displayable records from the component
            SelectInputText autoComplete =
                    (SelectInputText) event.getComponent();
            // get the new value typed by component user.
            String newWord = (String) event.getNewValue();

            posiblesFacturas = generarPosibilidades(newWord, 16);

            if (autoComplete.getSelectedItem() != null) {
                facturaSeleccionado = (Factura) autoComplete.getSelectedItem().getValue();
                notaLocal.setNumeroFactura(facturaSeleccionado);
                // fire effect to draw attention

            }else{
                Factura tmp = getFindFacturaMatch(newWord);
                //System.out.println("Factura :" + tmp.getCodigo() + tmp.getNombre());
                if (tmp != null){
                    facturaSeleccionado = tmp;
                    //System.out.println("Factura :" + tmp.get() + tmp.getNombre());
                    notaLocal.setNumeroFactura(tmp);
                     // fire effect to draw attention
                    //valueChangeEffect.setFired(false);
                }
            }


        }
    }
    /**
     * Busca una factura por medio del número
     * @param nombre
     * Numero de la factura que quiere buscar
     * @return
     * La Factura si lo encontro o null en caso contrário
     */
    private Factura getFindFacturaMatch(String nombre){
        if(posiblesFacturas != null){
            for(SelectItem factura : posiblesFacturas){
                //System.out.println("Factura :" + Factura.getLabel() + nombre);
                if(factura.getLabel().compareToIgnoreCase(nombre)==0)
                    return (Factura)factura.getValue();
            }
        }
        return null;
    }
    /**
     * Genera una lista de posibles facturas que empiecen con la palabra dada.
     * @param palabra
     * Palabra por la que se desea buscar, los facturas encontradas deben empezar con está
     * @param cant
     * Tamaño de la lista que se desea generar
     * @return
     * Lista de SelectItem con valor Factura y etiqueta numero de la factura
     */
    private ArrayList<SelectItem> generarPosibilidades(String palabra,int cant){
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>(cant);
        if(palabra == null)
            return lista;
        try{
            List<Factura> facturas = facturaFacade.findAll();
            for(Factura f : facturas){
                if(f.getNumero().toUpperCase().startsWith(palabra.toUpperCase())){
                    lista.add(new SelectItem(f,f.getNumero()));
                }
            }
        }catch(Exception e){

        }
        return lista;
    }
    /**
     * Obtener la cantidad de facturas que se encuentran en la lista de posibilidades
     * @return
     * Cantidad de elementos en la lista de posible facturas
     */
    public int getCantidadFacturas(){
        return posiblesFacturas.size();
    }
    /**
     * Obtener la lista de posibles facturas
     * @return
     * Lista de posibles facturas
     */
    public ArrayList<SelectItem> getPosiblesFacturas() {
        return posiblesFacturas;
    }
    /**
     * Obtener la factura seleccionado en la pantalla
     * @return
     * Factura seleccionada
     */
    public Factura getFacturaSeleccionado() {
        return facturaSeleccionado;
    }
    private ArrayList<SelectItem> posiblesFacturas = new ArrayList<SelectItem>();
    private Factura facturaSeleccionado = new Factura();

//</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        NotaLocal n = notaLocal;

        String query = "INSERT INTO nota(numero, numero_factura ,monto, fecha, tipo)" +
                "VALUES ({0},{1},{2},{3},{4});";
        query = query.replace("{0}", n.getNumero() == null? "" : n.getNumero());
        query = query.replace("{1}", n.getNumeroFactura() == null? "" : n.getNumeroFactura().getNumero());
        query = query.replace("{2}", String.valueOf(n.getMonto()));
        query = query.replace("{3}", n.getFecha() == null? "" : n.getFecha().toString());
        query = query.replace("{4}", String.valueOf(n.getTipo()));

        return query;
    }

    public String getDeleteString() {
        NotaLocal n = notaLocal;
        
        String query = "DELETE FROM nota WHERE numero = {0};";
        query = query.replace("{0}", n.getNumero());

        return query;
    }

    public String getUpdateString() {
        NotaLocal n = notaLocal;

        String query = "UPDATE nota SET numero = {0}, monto = {1}, fecha = {2}, tipo = {3}" +
                "WHERE numero = {4});";
        query = query.replace("{0}", n.getNumeroFactura() == null? "" : n.getNumeroFactura().getNumero());
        query = query.replace("{1}", String.valueOf(n.getMonto()));
        query = query.replace("{2}", n.getFecha() == null? "" : n.getFecha().toString());
        query = query.replace("{3}", String.valueOf(n.getTipo()));
        query = query.replace("{4}", n.getNumero() == null? "" : n.getNumero());

        return query;
    }

    public String getTablaString() {
        return "nota";
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

    //<editor-fold defaultstate="" desc="Propiedades y atributos">

    public void setListaNotas(ArrayList<NotaLocal> lista){
        this.listaNotas = lista;
    }

    public ArrayList<NotaLocal> getListaNotas(){
        if(listaNotas.isEmpty()){
            seguridad();
            listaNotas = new ArrayList<NotaLocal>();
            ArrayList<Nota> auxLista = new ArrayList(notaFacade.findAll());
            for(Nota n : auxLista){
                listaNotas.add(new NotaLocal(n));
            }
        }
        return listaNotas;
    }

    public ArrayList<SelectItem> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<SelectItem> tipos) {
        this.tipos = tipos;
    }

    public NotaLocal getNotaLocal() {
        return notaLocal;
    }

    public void setNotaLocal(NotaLocal notaLocal) {
        this.notaLocal = notaLocal;
    }

    private String codigoPermiso = "14";
    private NotaLocal notaLocal = new NotaLocal();
    private ArrayList<SelectItem> tipos = new ArrayList<SelectItem>();
    private ArrayList<NotaLocal> listaNotas = new ArrayList<NotaLocal>();
    //</editor-fold>
}
