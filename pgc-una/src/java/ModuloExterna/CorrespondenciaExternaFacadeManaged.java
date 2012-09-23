

package ModuloExterna;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.component.ext.ClickActionEvent;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import cr.ac.una.cgi.pgc.entity.Pais;
import cr.ac.una.cgi.pgc.entity.Tarifa;
import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import cr.ac.una.cgi.pgc.entity.Unidad;
import cr.ac.una.cgi.pgc.session.CorrespondenciaExternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.PaisFacadeRemote;
import cr.ac.una.cgi.pgc.session.TarifaFacadeRemote;
import cr.ac.una.cgi.pgc.session.TipoEnvioFacadeRemote;
import cr.ac.una.cgi.pgc.session.UnidadFacadeRemote;
import java.util.ArrayList;

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

public class CorrespondenciaExternaFacadeManaged implements Logeable{
    @EJB
    private UnidadFacadeRemote unidadFacade;
    @EJB
    private TipoEnvioFacadeRemote tipoEnvioFacade;
    @EJB
    private TarifaFacadeRemote tarifaFacade;
    @EJB
    private PaisFacadeRemote paisFacade;
    @EJB
    private CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade;

    public CorrespondenciaExternaFacadeManaged() {
    }


    //<editor-fold defaultstate="collapsed" desc="Eventos de la Página de Correspondencia Externa">
    /**
     * Calcula el precio de cada envío, cuando cambian los parámetros en la pantalla
     * @param event
     */
     public void valueChange_sit_calcular(ValueChangeEvent event){
         calcularPrecio();
     }

    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Control del autocompletar de paises">

     /**
      * Controla el autocompletar de Paises, cambia los países dependiendo de la palabra digitada.
      * @param event
      */
    public void ValueChange_sit_paisAutocompletar(ValueChangeEvent event){
        if (event.getComponent() instanceof SelectInputText) {
             // get the number of displayable records from the component
            SelectInputText autoComplete =
                    (SelectInputText) event.getComponent();
            // get the new value typed by component user.
            String newWord = (String) event.getNewValue();

            posiblesPaises = generarPosibilidades(newWord, 16);

            if (autoComplete.getSelectedItem() != null) {
                paisSeleccionado = (Pais) autoComplete.getSelectedItem().getValue();
                correspondenciaExternaLocal.setPais(paisSeleccionado);
                // fire effect to draw attention

            }else{
                Pais tmp = getFindPaisMatch(newWord);
                //System.out.println("Pais :" + tmp.getCodigo() + tmp.getNombre());
                if (tmp != null){
                    paisSeleccionado = tmp;
                    correspondenciaExternaLocal.setPais(tmp);
                    calcularPrecio();
                     // fire effect to draw attention
                    //valueChangeEffect.setFired(false);
                }
            }


        }
    }
    /**
     * Busca un país por medio del Nombre
     * @param nombre
     * Nombre del país que quiere buscar
     * @return
     * El país si lo encontro o null en caso contrário
     */
    private Pais getFindPaisMatch(String nombre){
        if(posiblesPaises != null){
            for(SelectItem pais : posiblesPaises){
                if(pais.getLabel().compareToIgnoreCase(nombre)==0)
                    return (Pais)pais.getValue();
            }
        }
        return null;
    }
    /**
     * Genera una lista de posibles país que empiecen con la palabra dada.
     * @param palabra
     * Palabra por la que se desea buscar, los paises encontrados deben empezar con está
     * @param cant
     * Tamaño de la lista que se desea generar
     * @return
     * Lista de SelectItem con valor Pais y etiqueta nombre del país
     */
    private ArrayList<SelectItem> generarPosibilidades(String palabra,int cant){
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>(cant);
        if((palabra == null) || (palabra.trim().length()==0))
            return lista;
        try{
            List<Pais> paises = paisFacade.findAll();
            for(Pais p : paises){
                if(p.getNombre().toUpperCase().startsWith(palabra.toUpperCase())){
                    lista.add(new SelectItem(p,p.getNombre()));
                }
            }
        }catch(Exception e){

        }
        return lista;
    }
    /**
     * Obtener la cantidad de países que se encuentran en la lista de posibilidades
     * @return
     * Cantidad de elementos en la lista de posible países
     */
    public int getCantidadPaises(){
        return posiblesPaises.size();
    }
    /**
     * Obtener la lista de posibles países
     * @return
     * Lista de posibles países
     */
    public ArrayList<SelectItem> getPosiblesPaises() {
        return posiblesPaises;
    }
    /**
     * Obtener el país seleccionado en la pantalla
     * @return
     * Pais seleccionado
     */
    public Pais getPaisSeleccionado() {
        return paisSeleccionado;
    }
    private ArrayList<SelectItem> posiblesPaises = new ArrayList<SelectItem>();
    private Pais paisSeleccionado = new Pais();

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Control del autocompletar de Tipos de envio">

    /**
      * Controla el autocompletar de Tipos de Envío, cambia los tipos dependiendo de la palabra digitada.
      * @param event
      */
    public void ValueChange_sit_tipoAutocompletar(ValueChangeEvent event){
        if (event.getComponent() instanceof SelectInputText) {
             // get the number of displayable records from the component
            SelectInputText autoComplete =
                    (SelectInputText) event.getComponent();
            // get the new value typed by component user.
            String newWord = (String) event.getNewValue();

            posiblesTipos = generarPosibilidadesTipos(newWord, 16);

            if (autoComplete.getSelectedItem() != null) {
                tipoSeleccionado = (TipoEnvio) autoComplete.getSelectedItem().getValue();
                correspondenciaExternaLocal.setTipo(tipoSeleccionado);
                // fire effect to draw attention

            }else{
                TipoEnvio tmp = getFindTipoMatch(newWord);
                //System.out.println("Pais :" + tmp.getCodigo() + tmp.getNombre());
                if (tmp != null){
                    tipoSeleccionado = tmp;
                    correspondenciaExternaLocal.setTipo(tmp);
                    calcularPrecio();
                     // fire effect to draw attention
                    //valueChangeEffect.setFired(false);
                }
            }


        }
    }
    /**
     * Busca una unidad por medio del Nombre
     * @param nombre
     * Nombre del tipo de envío que quiere buscar
     * @return
     * El TipoEnvío si lo encontro o null en caso contrário
     */
    private TipoEnvio getFindTipoMatch(String nombre){
        if(posiblesTipos != null){
            for(SelectItem tipo : posiblesTipos){
                if(tipo.getLabel().compareToIgnoreCase(nombre)==0)
                    return (TipoEnvio)tipo.getValue();
            }
        }
        return null;
    }

    /**
     * Genera una lista de posibles tipos de envío que empiecen con la palabra dada.
     * @param palabra
     * Palabra por la que se desea buscar, los tipos encontrados deben empezar con está
     * @param cant
     * Tamaño de la lista que se desea generar
     * @return
     * Lista de SelectItem con valor TipoEnvio y etiqueta nombre del tipo
     */
    private ArrayList<SelectItem> generarPosibilidadesTipos(String palabra,int cant){
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>(cant);
        if((palabra == null) || (palabra.trim().length()==0))
            return lista;
        try{
            List<TipoEnvio> tipos = tipoEnvioFacade.findAll();
            for(TipoEnvio p : tipos){
                if(p.getNombre().toUpperCase().startsWith(palabra.toUpperCase())){
                    lista.add(new SelectItem(p,p.getNombre()));
                }
            }
        }catch(Exception e){

        }
        return lista;
    }
    /**
     * Obtener la cantidad de tipos de envio que se encuentran en la lista de posibilidades
     * @return
     * Cantidad de elementos en la lista de posible tipos
     */
    public int getCantidadTipos(){
        System.out.println("Cantidad :" + posiblesTipos.size());
        return posiblesTipos.size();
    }
    /**
     * Obtener la lista de posibles tipos
     * @return
     * Lista de posibles tipos
     */
    public ArrayList<SelectItem> getPosiblesTipos() {
        return posiblesTipos;
    }
    /**
     * Obtener el tipo de envío seleccionado en la pantalla
     * @return
     * TipoEnvio seleccionado
     */
    public TipoEnvio getTipoSeleccionado() {
        return tipoSeleccionado;
    }
    private ArrayList<SelectItem> posiblesTipos = new ArrayList<SelectItem>();
    private TipoEnvio tipoSeleccionado = new TipoEnvio();

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Control del autocompletar de Unidades">
    /**
      * Controla el autocompletar de Unidades, cambia las unidades dependiendo de la palabra digitada.
      * @param event
      */
    public void ValueChange_sit_unidadAutocompletar(ValueChangeEvent event){
        if (event.getComponent() instanceof SelectInputText) {
             // get the number of displayable records from the component
            SelectInputText autoComplete =
                    (SelectInputText) event.getComponent();
            // get the new value typed by component user.
            String newWord = (String) event.getNewValue();

            posiblesUnidades = generarPosibilidadesUnidades(newWord, 16);

            if (autoComplete.getSelectedItem() != null) {
                unidadSeleccionada = (Unidad) autoComplete.getSelectedItem().getValue();
                correspondenciaExternaLocal.setUnidad(unidadSeleccionada);
                // fire effect to draw attention

            }else{
                Unidad tmp = getFindUnidadMatch(newWord);
                //System.out.println("Pais :" + tmp.getCodigo() + tmp.getNombre());
                if (tmp != null){
                    unidadSeleccionada = tmp;
                    correspondenciaExternaLocal.setUnidad(tmp);
                     // fire effect to draw attention
                    //valueChangeEffect.setFired(false);
                }
            }


        }
    }
    /**
     * Busca una unidad por medio del Nombre
     * @param nombre
     * Nombre de la unidad que quiere buscar
     * @return
     * La Unidad si la encontro o null en caso contrário
     */
    private Unidad getFindUnidadMatch(String nombre){
        if(posiblesUnidades != null){
            for(SelectItem unidad : posiblesUnidades){
                //System.out.println("Tipo :" + tipo.getLabel() + nombre);
                if(unidad.getLabel().compareToIgnoreCase(nombre)==0)
                    return (Unidad)unidad.getValue();
            }
        }
        return null;
    }
    /**
     * Genera una lista de posibles unidades que empiecen con la palabra dada.
     * @param palabra
     * Palabra por la que se desea buscar, las unidades encontradas deben empezar con está
     * @param cant
     * Tamaño de la lista que se desea generar
     * @return
     * Lista de SelectItem con valor Unidad y etiqueta nombre de la unidad
     */
    private ArrayList<SelectItem> generarPosibilidadesUnidades(String palabra,int cant){
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>(cant);
        if((palabra == null))
            return lista;
        try{
            List<Unidad> unidades = unidadFacade.findAll();
            for(Unidad u : unidades){
                if(u.getNombre().toUpperCase().startsWith(palabra.toUpperCase())){
                    lista.add(new SelectItem(u,u.getNombre()));
                }
            }
        }catch(Exception e){

        }
        return lista;
    }
    /**
     * Obtener la cantidad de unidades que se encuentran en la lista de posibilidades
     * @return
     * Cantidad de elementos en la lista de posibles unidades
     */
    public int getCantidadUnidades(){
        return posiblesUnidades.size();
    }
    /**
     * Obtener la lista de posibles unidades
     * @return
     * Lista de posibles unidades
     */
    public ArrayList<SelectItem> getPosiblesUnidades() {
        return posiblesUnidades;
    }
    /**
     * Obtener la unidad seleccionado en la pantalla
     * @return
     * Unidad seleccionado
     */
    public Unidad getUnidadSeleccionada() {
        return unidadSeleccionada;
    }
    private ArrayList<SelectItem> posiblesUnidades = new ArrayList<SelectItem>();
    private Unidad unidadSeleccionada = new Unidad();

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
     * Crea o actualiza un Envío
     */
     public void guardar(){

        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        CorrespondenciaExterna envio = new CorrespondenciaExterna();
        Log l = new Log();
        try{
            envio.setFecha(getCorrespondenciaExternaLocal().getFecha());
            envio.setCodigo(getCorrespondenciaExternaLocal().getCodigo());
            envio.setTipo(getCorrespondenciaExternaLocal().getTipo());
            envio.setPeso(getCorrespondenciaExternaLocal().getPeso());
            envio.setPais(getCorrespondenciaExternaLocal().getPais());
            envio.setPrecio(getCorrespondenciaExternaLocal().getPrecio());
            envio.setDireccion(getCorrespondenciaExternaLocal().getDireccion());
            envio.setDestinatario(getCorrespondenciaExternaLocal().getDestinatario());
            envio.setRemitente(getCorrespondenciaExternaLocal().getRemitente());
            envio.setCantidad(getCorrespondenciaExternaLocal().getCantidad());
            envio.setUnidad(getCorrespondenciaExternaLocal().getUnidad());
            envio.setFactura(null);
            if(validarPrecio()){
               if(correspondenciaExternaLocal.getButtonLabel().compareTo("Ingresar") == 0){
                   Integer max = correspondenciaExternaFacade.findIdentificadorMax();
                   if (max == null)
                       max = 0;
                   envio.setIdentificador(max + 1);
                   System.out.println(envio.getIdentificador());
                   correspondenciaExternaFacade.create(envio);
                   listaEnvios.add(correspondenciaExternaLocal);
                   message.setSummary("Envio Creado Correctamente");
                   getLogFacade().create(this);
                   limpiarCampos();
                }else{
                   envio.setIdentificador(correspondenciaExternaLocal.getIdentificador());
                    correspondenciaExternaFacade.edit(envio);
                    getLogFacade().update(this);
                    limpiarCampos();
                }
            }else{
                message.setSummary("No existe ninguna tarifa correspondiente al peso, país y tipo de envío ingresados");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage("it_precio", message);
            }
            
            
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage("frm_principal", message);
            
        }catch(Exception e){
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("El envío no se a podido ingresar. Por favor verifique que los campos sean correctos" + e.getMessage());
            context.addMessage("frm_principal", message);
            getLogFacade().error(this, e.getMessage());
        }
    }
     /**
      * Limpia los campos de la pantalla
      */
     public void limpiarCampos(){
         correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
         precioCalculado = 0.0;
     }
     /**
      * Responde a los eventos del mouse en la tabla de envíos
      * @param e
      */
     public void rowSelector(RowSelectorEvent e) {
         if (e.isSelected()) {
             CorrespondenciaExternaLocal ce = (CorrespondenciaExternaLocal) listaEnvios.get(e.getRow());
             for(CorrespondenciaExternaLocal envio : listaEnvios){
                 if(envio.getCodigo().compareTo(ce.getCodigo())!=0)
                     envio.setSelected(Boolean.FALSE);
             }
             correspondenciaExternaLocal = ce;
             paisSeleccionado = ce.getPais();
             unidadSeleccionada = ce.getUnidad();
             correspondenciaExternaLocal.setButtonLabel("Editar");
             correspondenciaExternaLocal.setDisable(Boolean.TRUE);
             correspondenciaExternaLocal.setUnidad(ce.getUnidad());
             correspondenciaExternaLocal.setUnidadLocal(ce.getUnidadLocal());
             precioCalculado = ce.getPrecio();
             //está seleccionado un cliente se supone modificar
             //this.estado = "modifica";
         }else {
             correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
             //No está seleccionado nada se supone nuevo
             //this.estado = "inserta";
         }
     }
     /**
      * Responde al evento Click en la tabla de envíos, toma el envío seleccionado y lo coloca en los campos de edición
      * @param event
      */
     public void rowClicked(ClickActionEvent event){
        if (event.getRow()>=0) {

                 CorrespondenciaExternaLocal ce = (CorrespondenciaExternaLocal) listaEnvios.get(event.getRow());
                 for(CorrespondenciaExternaLocal envio : listaEnvios){
                     if(envio.getCodigo().compareTo(ce.getCodigo())!=0)
                        envio.setSelected(Boolean.FALSE);
             }

             correspondenciaExternaLocal = ce;
             paisSeleccionado = ce.getPais();
             unidadSeleccionada = ce.getUnidad();
             correspondenciaExternaLocal.setButtonLabel("Editar");
             correspondenciaExternaLocal.setDisable(Boolean.TRUE);
             correspondenciaExternaLocal.setCodigoPais(ce.getPais().getNombre());
             correspondenciaExternaLocal.setUnidad(ce.getUnidad());
             correspondenciaExternaLocal.setUnidadLocal(ce.getUnidadLocal());
             precioCalculado = ce.getPrecio();
             //está seleccionado un cliente se supone modificar
             //this.estado = "modifica";
             } else {
                 correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
                 //No está seleccionado nada se supone nuevo
                 //this.estado = "inserta";
             }
     }
     /**
      * Calcula el precio, toma en cuanta el país, peso, tipo y cantidad.
      * Sí no lo puede terminar lo coloca en 0.0
      */
     public void calcularPrecio(){
         Double precio = 0.0;

         if(correspondenciaExternaLocal.getPais() != null && correspondenciaExternaLocal.getPeso() > 0.0 && correspondenciaExternaLocal.getTipo() != null){
            GrupoEnvio g = correspondenciaExternaLocal.getPais().getCodigoGrupoEnvio();
            Tarifa t = tarifaFacade.findByParameters(correspondenciaExternaLocal.getPeso(), g,correspondenciaExternaLocal.getTipo());
            if(t != null){
                
                precio = correspondenciaExternaLocal.getCantidad() * t.getPrecio();
            }
            

         }
         correspondenciaExternaLocal.setPrecio(precio);
         
     }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
     /**
      * Valida el número de oficio, si este se ya se encuentra lanza un error
      * @param context
      * @param validate
      * @param value
      */
    public void validateNumeroOficio(FacesContext context, UIComponent validate,Object value) {
        String numero = (String) value;
        CorrespondenciaExterna ce = correspondenciaExternaFacade.find(numero);
        if (ce != null) {
            FacesMessage msg = new FacesMessage("El número de oficio pertenece a un envío ya ingresado");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(validate.getClientId(context), msg);
        }
    }
    /**
     * Valida si el precio es mayor a 0.0
     * @return
     * true si el precio es mayor a 0.0, false en caso contrário
     */
    private Boolean validarPrecio(){
        if(correspondenciaExternaLocal.getPrecio() < 0)
            return false;
        return true;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Log">
    
    public String getInsertString() {
        CorrespondenciaExternaLocal e  = correspondenciaExternaLocal;

        String query = "INSERT INTO correspondencia_externa(identificador,codigo, fecha, peso, tipo, pais," +
                " precio, direccion, destinatario, remitente, cantidad, factura, unidad)" +
                "VALUES ({0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12})";

        query = query.replace("{0}", e.getIdentificador() == null? "" : e.getIdentificador().toString());
        query = query.replace("{1}", e.getCodigo() == null? "" : e.getCodigo());
        query = query.replace("{2}", e.getFecha() == null? "" : e.getFecha().toString());
        query = query.replace("{3}", String.valueOf(e.getPeso()));
        query = query.replace("{4}", e.getTipo() == null? "" : e.getTipo().getCodigo());
        query = query.replace("{5}", e.getPais() == null? "" : e.getPais().getCodigo());
        query = query.replace("{6}", String.valueOf(e.getPrecio()));
        query = query.replace("{7}", e.getDireccion() == null? "" : e.getDireccion());
        query = query.replace("{8}", e.getDestinatario() == null? "" : e.getDestinatario());
        query = query.replace("{9}", e.getRemitente() == null? "" : e.getRemitente());
        query = query.replace("{10}", String.valueOf(e.getCantidad()));
        query = query.replace("{11}", e.getFactura() == null? "" : e.getFactura().getNumero());
        query = query.replace("{12}", e.getUnidad() == null? "" : e.getUnidad().getCodigo());
     
        return query;
    }

    public String getDeleteString() {
        CorrespondenciaExternaLocal e  = correspondenciaExternaLocal;
        
        String query = "DELETE FROM correspondencia_externa WHERE indentificador = {0};";
        query = query.replace("{0}", e.getIdentificador().toString());

        return query;
    }

    public String getUpdateString() {
        CorrespondenciaExternaLocal e  = correspondenciaExternaLocal;
        String query = "UPDATE correspondencia_externa SET codigo = {0}, fecha = {1}, peso = {2}, tipo = {3}, pais = {4}," +
                " precio = {5}, direccion = {6}, destinatario = {7}, remitente = {8}, cantidad = {9}, factura = {10}, unidad = {11}" +
                "WHERE identificador = {12});";

        query = query.replace("{0}", e.getCodigo() == null? "" : e.getCodigo());
        query = query.replace("{1}", e.getFecha() == null? "" : e.getFecha().toString());
        query = query.replace("{2}", String.valueOf(e.getPeso()));
        query = query.replace("{3}", e.getTipo() == null? "" : e.getTipo().getCodigo());
        query = query.replace("{4}", e.getPais() == null? "" : e.getPais().getCodigo());
        query = query.replace("{5}", String.valueOf(e.getPrecio()));
        query = query.replace("{6}", e.getDireccion() == null? "" : e.getDireccion());
        query = query.replace("{7}", e.getDestinatario() == null? "" : e.getDestinatario());
        query = query.replace("{8}", e.getRemitente() == null? "" : e.getRemitente());
        query = query.replace("{9}", String.valueOf(e.getCantidad()));
        query = query.replace("{10}", e.getFactura() == null? "" : e.getFactura().getNumero());
        query = query.replace("{11}", e.getUnidad() == null? "" : e.getUnidad().getCodigo());
        query = query.replace("{12}", e.getIdentificador() == null? "" : e.getIdentificador().toString());

        return query;
    }

    public String getTablaString() {
        return "correspondencia_externa";
    }
    

    private Log getLogFacade(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (Log)session.getAttribute("Log");
    }

     //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades y atributos">
    
    public void setListaEnvios(ArrayList<CorrespondenciaExternaLocal> lista){
        this.listaEnvios = lista;
    }
    
    public ArrayList<CorrespondenciaExternaLocal> getListaEnvios(){
        seguridad();
        listaEnvios = new ArrayList<CorrespondenciaExternaLocal>();
        ArrayList<CorrespondenciaExterna> auxLista = new ArrayList(correspondenciaExternaFacade.findAll());
        for(CorrespondenciaExterna c : auxLista){
            if(c.getFactura() == null)
                listaEnvios.add(new CorrespondenciaExternaLocal(c));
        }
        return listaEnvios;
    }
     public ArrayList<Boolean> getEstadosTabla(){
        if(estadosTabla == null)
            estadosTabla = new ArrayList<Boolean>();
        return estadosTabla;
     }

    public ArrayList<CorrespondenciaExterna> getRegistros(){
        if(registros == null)
            registros = new ArrayList<CorrespondenciaExterna>();
        return registros;
    }
     public CorrespondenciaExternaFacadeRemote getCorrespondenciaExternaFacade() {
        return correspondenciaExternaFacade;
    }

    public void setCorrespondenciaExternaFacade(CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade) {
        this.correspondenciaExternaFacade = correspondenciaExternaFacade;
    }
    
    public CorrespondenciaExternaLocal getCorrespondenciaExternaLocal() {
        return correspondenciaExternaLocal;
    }

    public void setCorrespondenciaExternaLocal(CorrespondenciaExternaLocal correspondenciaExternaLocal) {
        this.correspondenciaExternaLocal = correspondenciaExternaLocal;
    }

    public Double getPrecioCalculado() {
        

        if(correspondenciaExternaLocal.getButtonLabel().compareTo("Ingresar")==0){
            Double precio = 0.0;
            if(correspondenciaExternaLocal.getPais() != null && correspondenciaExternaLocal.getPeso() > 0.0 && correspondenciaExternaLocal.getTipo() !=null){
                GrupoEnvio g = correspondenciaExternaLocal.getPais().getCodigoGrupoEnvio();
                Tarifa t = tarifaFacade.findByParameters(correspondenciaExternaLocal.getPeso(), g,correspondenciaExternaLocal.getTipo());
                if(t != null){

                    precio = correspondenciaExternaLocal.getCantidad() * t.getPrecio();
                }
             precioCalculado = precio;
            }
        }

         

        correspondenciaExternaLocal.setPrecio(precioCalculado);
         
        return precioCalculado;
    }

    public void setPrecioCalculado(Double precioCalculado) {
        this.precioCalculado = precioCalculado;
    }


    private String codigoPermiso = "15";
    private CorrespondenciaExternaLocal oldEnvio = new CorrespondenciaExternaLocal();
    private ArrayList<CorrespondenciaExterna> registros;
    private ArrayList<Boolean> estadosTabla;
    private CorrespondenciaExternaLocal correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
    private ArrayList<CorrespondenciaExternaLocal> listaEnvios;
    private Double precioCalculado = 0.0;

   
     //</editor-fold>

}
