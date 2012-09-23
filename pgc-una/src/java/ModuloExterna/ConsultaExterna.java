/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModuloExterna;

import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;
import cr.ac.una.cgi.pgc.entity.Factura;
import cr.ac.una.cgi.pgc.entity.Pais;
import cr.ac.una.cgi.pgc.session.CorrespondenciaExternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.FacturaFacadeRemote;
import cr.ac.una.cgi.pgc.session.PaisFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */

public class ConsultaExterna {
    @EJB
    private FacturaFacadeRemote facturaFacade;
    @EJB
    private PaisFacadeRemote paisFacade;
    @EJB
    private CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade;

    /** Creates a new instance of ConsultaExterna */
    public ConsultaExterna() {

    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    private void seguridad(String codigoPermiso){
       
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
     * Limpia los campos del formulario
     */
    public void limpiarCampos(){
         correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
     }
     /**
      * Añade un nuevo filtro a lista de parametros de la consulta
      * @param name
      * Nombre del parámetro
      * @param value
      * Valor del parámetro
      */
     private void addFilter(String name,Object value){
         String valor = String.valueOf(value);
         if(value != null && name != null && valor.compareTo("")!=0){
             nombres.add(name);
             values.add(value);
         }
     }
     /**
      * Añade un nuevo filtro a lista de parámetros de la consulta por facturas
      * @param name
      * Nombre del filtro
      * @param value
      * Valor del filtro
      */
     private void addFilterFactura(String name,Object value){
         String valor = String.valueOf(value);
         if(value != null && name != null && valor.compareTo("")!=0){
             nombresFactura.add(name);
             valuesFactura.add(value);
         }
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
                    System.out.println("Pais :" + tmp.getCodigo() + tmp.getNombre());
                    correspondenciaExternaLocal.setPais(tmp);

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
                System.out.println("Pais :" + pais.getLabel() + nombre);
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

    //<editor-fold defaultstate="collapsed" desc="Propiedades y atributos">

    public void setListaEnvios(ArrayList<CorrespondenciaExternaLocal> lista){
        this.listaEnvios = lista;
    }
    /**
     * Obtiene la lista de envíos consultados filtrados por la parámetros del formulario
     * @return
     * Lista de envíos consultados
     */
    public ArrayList<CorrespondenciaExternaLocal> getListaEnvios(){
        seguridad("17");
        listaEnvios = new ArrayList<CorrespondenciaExternaLocal>();
        nombres.clear();
        values.clear();
        
        addFilter("fecha",correspondenciaExternaLocal.getFecha());
        addFilter("codigo",correspondenciaExternaLocal.getCodigo());
        addFilter("remitente",correspondenciaExternaLocal.getRemitente());
        addFilter("destinatario",correspondenciaExternaLocal.getDestinatario());
        addFilter("pais",correspondenciaExternaLocal.getPais());
        addFilter("direccion", correspondenciaExternaLocal.getDireccion());

        if((numeroFactura != null && numeroFactura.trim().compareTo("") != 0) || (!values.isEmpty() && !nombres.isEmpty() && values.size() == nombres.size())){
            ArrayList<CorrespondenciaExterna> auxLista = new ArrayList(correspondenciaExternaFacade.findByParameters(numeroFactura, nombres, values));
            for(CorrespondenciaExterna c : auxLista){
                listaEnvios.add(new CorrespondenciaExternaLocal(c));
            }
        }
    
        return listaEnvios;
    }

    public void setListaFacturas(ArrayList<FacturaLocal> listaFacturas) {


        this.listaFacturas = listaFacturas;
    }
    /**
     * Obtiene la lista de facturas consultadas filtradas por la parámetros del formulario
     * @return
     * Lista de facturas consultadas
     */
    public ArrayList<FacturaLocal> getListaFacturas() {
        seguridad("18");
        listaFacturas = new ArrayList<FacturaLocal>();
        nombresFactura.clear();
        valuesFactura.clear();
        addFilterFactura("fecha", facturaLocal.getFecha());
        addFilterFactura("numero", facturaLocal.getNumero());
        addFilterFactura("numeroOrden", facturaLocal.getNumeroOrden());
        if(!valuesFactura.isEmpty() && !nombresFactura.isEmpty() && valuesFactura.size() == nombresFactura.size()){
            ArrayList<FacturaLocal> auxLista = new ArrayList(facturaFacade.findByParameters(nombresFactura, valuesFactura));
            for(Factura f : auxLista){
                FacturaLocal fl =  new FacturaLocal(f);
                fl.setEnvios(getEnvios(f));
                listaFacturas.add(fl);

            }
        }
        return listaFacturas;
    }

    private String getEnvios(Factura f){
        String e="";
        ArrayList<CorrespondenciaExterna> en =  new ArrayList<CorrespondenciaExterna>(correspondenciaExternaFacade.findByFactura(f));
        for(CorrespondenciaExterna ce : en)
            e += ce.getCodigo() + "," + String.valueOf(ce.getPrecio()) + "\n" ;
        return e;
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

    public String getNumeroFactura(){
        return numeroFactura;
    }
    
    public void setNumeroFactura(String numero){
        numeroFactura = numero;
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

    public FacturaLocal getFacturaLocal() {
        return facturaLocal;
    }

    public void setFacturaLocal(FacturaLocal facturaLocal) {
        this.facturaLocal = facturaLocal;
    }

    private ArrayList<String> nombres = new ArrayList<String>();
    private ArrayList values =  new ArrayList();
    private ArrayList<String> nombresFactura = new ArrayList<String>();
    private ArrayList valuesFactura =  new ArrayList();
    private FacturaLocal facturaLocal = new FacturaLocal();
    private ArrayList<FacturaLocal> listaFacturas = new ArrayList<FacturaLocal>();
    private ArrayList<CorrespondenciaExterna> registros;
    private ArrayList<Boolean> estadosTabla;
    private CorrespondenciaExternaLocal correspondenciaExternaLocal = new CorrespondenciaExternaLocal();
    private ArrayList<CorrespondenciaExternaLocal> listaEnvios;
    private String numeroFactura;

    //</editor-fold>

}
