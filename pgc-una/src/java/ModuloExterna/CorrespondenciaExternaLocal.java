
package ModuloExterna;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
public class CorrespondenciaExternaLocal  extends CorrespondenciaExterna{

    /**
     * Constructor de la clase. Cambia los atributos de la clase por lo de la instancia recibida
     * @param c
     * CorrespondenciaExterna de la cual se quiere generar un Local
     */
    public CorrespondenciaExternaLocal(CorrespondenciaExterna c){
        this.setIdentificador(c.getIdentificador());
        this.setCodigo(c.getCodigo());
        this.setFecha(c.getFecha());
        this.setPeso(c.getPeso());
        this.setTipo(c.getTipo());
        this.setPais(c.getPais());
        this.setPrecio(c.getPrecio());
        this.setDireccion(c.getDireccion());
        this.setDestinatario(c.getDestinatario());
        this.setRemitente(c.getRemitente());
        this.setFactura(c.getFactura());
        this.setCantidad(c.getCantidad());
        this.setCodigoPais(c.getPais().getNombre());
        this.setTipoEnvio(c.getTipo().getNombre());
        this.setUnidad(c.getUnidad());
        this.setUnidadLocal(c.getUnidad().getNombre());
    }

    public CorrespondenciaExternaLocal(){

    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public void setButtonLabel(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getUnidadLocal() {
        return unidadLocal;
    }

    public void setUnidadLocal(String unidadLocal) {
        this.unidadLocal = unidadLocal;
    }


    
    
    private Boolean selected = false;
    private String codigoPais;
    private String tipoEnvio;
    private String unidadLocal;
    private Boolean disable = false;
    private String buttonLabel = "Ingresar";

}
