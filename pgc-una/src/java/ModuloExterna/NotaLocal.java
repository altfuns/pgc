
package ModuloExterna;

import cr.ac.una.cgi.pgc.entity.Nota;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
public class NotaLocal extends Nota{

    /**
     * Constructor de la clase. Cambia los atributos de la clase por lo de la instancia recibida
     * @param n
     * Nota de la cual se quiere generar un Local
     */
    public NotaLocal(Nota n){
        this.setFecha(n.getFecha());
        this.setMonto(n.getMonto());
        this.setNumero(n.getNumero());
        this.setNumeroFactura(n.getNumeroFactura());
        this.setTipo(n.getTipo());
        if(n.getTipo() == 0){
            this.setTipoString("Crédito");
            this.setCssClass("credito");
        }
        else{
            this.setTipoString("Débito");
            this.setCssClass("debito");
        }
    }
    public NotaLocal(){
        
    }

    public String getNumeroFacturaString() {
        return numeroFacturaString;
    }

    public void setNumeroFacturaString(String numeroFacturaString) {
        this.numeroFacturaString = numeroFacturaString;
    }

    public String getTipoString() {
        return tipoString;
    }

    public void setTipoString(String tipoString) {
        this.tipoString = tipoString;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }


    private String tipoString;

    private String numeroFacturaString;

    private String cssClass;

}
