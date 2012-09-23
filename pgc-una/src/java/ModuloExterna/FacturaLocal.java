/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModuloExterna;

import cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna;
import cr.ac.una.cgi.pgc.entity.Factura;
import java.util.ArrayList;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
public class FacturaLocal extends Factura {

    /**
     * Constructor de la clase. Cambia los atributos de la clase por lo de la instancia recibida
     * @param f
     * Factura de la cual se quiere generar un Local
     */
    public FacturaLocal(Factura f){
        this.setFecha(f.getFecha());
        this.setNumero(f.getNumero());
        this.setMonto(f.getMonto());
        this.setCorrespondenciaExternaCollection(f.getCorrespondenciaExternaCollection());
        this.setNotaCollection(f.getNotaCollection());
        this.setNumeroOrden(f.getNumeroOrden());
    }
    public FacturaLocal(){
        
    }

    public String getEnvios() {
        return envios;
    }

    public void setEnvios(String envios) {
        this.envios = envios;
    }

    private String envios;
}
