
package ModuloRutas;

import Logs.Logeable;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;

/**
 * Clase para apoyar las funciones de la clase CorrespondenciaInterna
 * @author Jeremy Guzmán Salazar
 */
public class CorrespondenciaInternaLocal extends CorrespondenciaInterna implements Logeable{

    public CorrespondenciaInternaLocal(CorrespondenciaInterna c){
        this.setCodigo(c.getCodigo());
        this.setDestinatario(c.getDestinatario());
        this.setDestinoUnidad(c.getDestinoUnidad());
        this.setFechaEntregaMensajero(c.getFechaEntregaMensajero());
        this.setFechaRecibido(c.getFechaRecibido());
        this.setIdRecibeEmpleado(c.getIdRecibeEmpleado());
        this.setIdEntregaEmpleado(c.getIdEntregaEmpleado());
        this.setIdentificador(c.getIdentificador());
        this.setNombreRecibido(c.getNombreRecibido());
        this.setProcedenciaUnidad(c.getProcedenciaUnidad());
        this.setTipo(c.getTipo());
        this.setRutaAsignada(c.getRutaAsignada());
    }

    public CorrespondenciaInternaLocal(){
    }

    //<editor-fold defaultstate="collapsed" desc="Log">

    public String getInsertString() {
        String query ="INSERT INTO correspondencia_interna(identificador, codigo, tipo, fecha_entrega_mensajero," +
                " procedencia_unidad, destino_unidad, fecha_recibido, nombre_recibido, id_recibe_empleado, id_entrega_empleado," +
                " destinatario, ruta_asignada) " +
                "VALUES ({0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11})";
        query = query.replace("{0}", getIdentificador() == null? "" : getIdentificador().toString());
        query = query.replace("{1}", getCodigo() == null? "" : getCodigo());
        query = query.replace("{2}", getTipo() == null? "" : getTipo().getDescripcion());
        query = query.replace("{3}", getFechaEntregaMensajero() == null? "" : getFechaEntregaMensajero().toString());
        query = query.replace("{4}", getProcedenciaUnidad() == null? "" : getProcedenciaUnidad());
        query = query.replace("{5}", getDestinoUnidad() == null? "" : getDestinoUnidad());
        query = query.replace("{6}", getFechaRecibido() == null? "" : getFechaRecibido().toString());
        query = query.replace("{7}", getNombreRecibido() == null? "" : getNombreRecibido());
        query = query.replace("{8}", getIdRecibeEmpleado() == null? "" : getIdRecibeEmpleado().getId());
        query = query.replace("{9}", getIdEntregaEmpleado() == null? "" : getIdEntregaEmpleado().getId());
        query = query.replace("{10}", getDestinatario() == null? "" : getDestinatario());
        query = query.replace("{11}", getRutaAsignada() == null? "Externa" : getRutaAsignada().getNumero());
               
        return query;
    }

    public String getDeleteString() {
        String query = "DELETE FROM correspondencia_interna WHERE identificador = {0};";
        
        query = query.replace("{0}", getIdentificador().toString());
        
        return query;

    }

    public String getUpdateString() {
        String query = "UPDATE correspondencia_interna SET codigo = {0}, tipo = {1}, fecha_entrega_mensajero = {2}," +
                " procedencia_unidad = {3}, destino_unidad = {4}, fecha_recibido = {5}, nombre_recibido = {6}," +
                " id_recibe_empleado = {7}, id_entrega_empleado = {8}, destinatario = {9}, ruta_asignada = {10}" +
                "WHERE identificador = {11}";

        query = query.replace("{0}", getCodigo() == null? "" : getCodigo());
        query = query.replace("{1}", getTipo() == null? "" : getTipo().getDescripcion());
        query = query.replace("{2}", getFechaEntregaMensajero() == null? "" : getFechaEntregaMensajero().toString());
        query = query.replace("{3}", getProcedenciaUnidad() == null? "" : getProcedenciaUnidad());
        query = query.replace("{4}", getDestinoUnidad() == null? "" : getDestinoUnidad());
        query = query.replace("{5}", getFechaRecibido() == null? "" : getFechaRecibido().toString());
        query = query.replace("{6}", getNombreRecibido() == null? "" : getNombreRecibido());
        query = query.replace("{7}", getIdRecibeEmpleado() == null? "" : getIdRecibeEmpleado().getId());
        query = query.replace("{8}", getIdEntregaEmpleado() == null? "" : getIdEntregaEmpleado().getId());
        query = query.replace("{9}", getDestinatario() == null? "" : getDestinatario());
        query = query.replace("{10}", getRutaAsignada() == null? "Externa" : getRutaAsignada().getNumero());

        query = query.replace("{11}", getIdentificador() == null? "" : getIdentificador().toString());

       return query;
    }

    public String getTablaString() {
        return "correspondencia_interna";
    }
  

     //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos y Propiedades">
    
    public CorrespondenciaInterna getCorrespondenciaInterna(){
        CorrespondenciaInterna c = new CorrespondenciaInterna(this.getIdentificador());
        
        c.setCodigo(this.getCodigo());
        c.setDestinatario(this.getDestinatario());
        c.setDestinoUnidad(this.getDestinoUnidad());
        c.setFechaEntregaMensajero(this.getFechaEntregaMensajero());
        c.setFechaRecibido(this.getFechaRecibido());
        c.setIdEntregaEmpleado(this.getIdEntregaEmpleado());
        c.setIdRecibeEmpleado(this.getIdRecibeEmpleado());
        c.setNombreRecibido(this.getNombreRecibido());
        c.setProcedenciaUnidad(this.getProcedenciaUnidad());
        c.setTipo(this.getTipo());
        c.setRutaAsignada(this.getRutaAsignada());

        return c;
    }  

    public String getMensajeroResponsable(){
        if(this.getIdEntregaEmpleado() != null)
            return this.getIdEntregaEmpleado().getNombre() + " " + this.getIdEntregaEmpleado().getApellidos();
        return "";
    }

    public void setMensajeroResponsable(String responsable){
    }

    public String getTipoLocal(){
        if(this.getTipo() != null)
            return this.getTipo().toString();
        return "";
    }

    public void setTipoLocal(String nuevoTipo){
    }

    public boolean isaEliminar() {
        return aEliminar;
    }

    public void setaEliminar(boolean aEliminar) {
        this.aEliminar = aEliminar;
    }

    public boolean getDisable(){
        if(this.getIdentificador() == null || this.getIdentificador() == 0)
            return false;
        
        return disable;
    }
    
    public void setDisable(boolean enab){
        disable = enab;
    }
    
    private boolean aEliminar = false;
    private boolean disable = true;
    
    //</editor-fold>

}
