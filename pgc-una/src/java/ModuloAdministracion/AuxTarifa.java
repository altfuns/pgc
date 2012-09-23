package ModuloAdministracion;

import cr.ac.una.cgi.pgc.entity.Tarifa;
import cr.ac.una.cgi.pgc.entity.TipoEnvio;
import java.util.ArrayList;
import java.util.List;

/**
 * Es una clase que sirve de apoyo a la clase TarifaFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxTarifa {

    public AuxTarifa() {
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración del Tarifario">

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    
    /**
     * Limpia los datos de la consulta actual.
     */
    public void limpiarConsulta() {
        consultados = null;
    }

    /**
     * Reinicia la consulta del tarifario.
     */
    public void reiniciarConsulta() {
        limpiarConsulta();
        tarifario = null;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public boolean getOrdinariosVisible(){
        if(grupoSeleccionado.compareTo("NAC") == 0){
            return false;
        }
        else{
            tipoEnvio = tipoEnvio.compareTo("1") == 0 ? "4" : tipoEnvio;
        }
        return true;
    }

    public boolean getEncomiendaNacVisible(){
        if(grupoSeleccionado.compareTo("NAC") == 0){
            return false;
        }
        else{
            tipoEnvio = tipoEnvio.compareTo("2") == 0 ? "4" : tipoEnvio;
        }
        return true;
    }
    
    public boolean getCurierNacVisible(){
        if(grupoSeleccionado.compareTo("NAC") == 0){
            return false;
        }
        else{
            tipoEnvio = tipoEnvio.compareTo("3") == 0 ? "4" : tipoEnvio;
        }
        return true;
    }

    public boolean getNoPrioritariosVisible(){
        if(grupoSeleccionado.compareTo("NAC") != 0){
            return false;
        }
        else{
            tipoEnvio =  tipoEnvio.compareTo("4") == 0 ? "1" : tipoEnvio;
        }
        return true;
    }

    public boolean getPrioritariosVisible(){
        if(grupoSeleccionado.compareTo("NAC") != 0){
            return false;
        }
        else{
            tipoEnvio =  tipoEnvio.compareTo("5") == 0 ? "1" : tipoEnvio;
        }
        return true;
    }    

    public boolean getTarjetasVisible(){
        if(grupoSeleccionado.compareTo("NAC") != 0){
            return false;
        }
        else{
            tipoEnvio =  tipoEnvio.compareTo("7") == 0 ? "1" : tipoEnvio;
        }
        return true;
    }

    public int getCantidadTarifas(){
        if(consultados == null)
            return 0;
        return consultados.size();
    }

    public ArrayList<Tarifa> getConsultados() throws Exception {
        if (consultados == null || consultados.size() == 0) {
            if (tarifario == null) {
                throw new Exception();
            } else {
                consultados = new ArrayList<Tarifa>();

                for (Tarifa auxTarifa : tarifario) {
                    if (auxTarifa.getCodigoGrupoEnvio().getCodigo().compareTo(grupoSeleccionado) == 0 && auxTarifa.getTipo().getCodigo().compareTo(tipoEnvio) == 0) {
                        consultados.add(auxTarifa);                        
                    }
                }
            }
        }

        return consultados;

    }

    public void setTarifario(List<Tarifa> total) {
        if (tarifario == null) {
            tarifario = new ArrayList<Tarifa>();
            tarifario.addAll(total);
        }
    }

    public String getGrupoSeleccionado() {        
        return grupoSeleccionado;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setGrupoSeleccionado(String grupoSeleccionado) {
        this.grupoSeleccionado = grupoSeleccionado;
        limpiarConsulta();
    }

    public void settipoEnvio(String tipo) {
        this.tipoEnvio = tipo;
        limpiarConsulta();
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String grupoSeleccionado = "G1";
    private String tipoEnvio = "1";
    private ArrayList<TipoEnvio> tipos;
    private ArrayList<Tarifa> consultados;
    private ArrayList<Tarifa> tarifario;

    //</editor-fold>

    //</editor-fold>
}
