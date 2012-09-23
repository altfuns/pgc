/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModuloExterna;

import cr.ac.una.cgi.pgc.entity.MovimientoPresupuesto;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
public class MovimientoPresupuestoLocal extends MovimientoPresupuesto {

    /**
     * Constructor de la clase. Cambia los atributos de la clase por lo de la instancia recibida
     * @param mp
     * MovimientoPresupuesto del cual se quiere generar un Local
     */
    public MovimientoPresupuestoLocal(MovimientoPresupuesto mp){
        this.setCodigo(mp.getCodigo());
        this.setCodigoPresupuesto(mp.getCodigoPresupuesto());
        this.setFecha(mp.getFecha());
        this.setImporte(mp.getImporte());
        this.setNumeroCheque(mp.getNumeroCheque());
        this.setNumeroDeposito(mp.getNumeroDeposito());
    }

    public MovimientoPresupuestoLocal(){

    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    
    private String presupuesto = "001";
}
