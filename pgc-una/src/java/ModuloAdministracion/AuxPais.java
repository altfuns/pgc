
package ModuloAdministracion;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import cr.ac.una.cgi.pgc.entity.Pais;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 * Es una clase que sirve de apoyo a la clase PaisFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxPais{

    public AuxPais(){

    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administracion de Países">

    //<editor-fold defaultstate="collapsed" desc="Métodos">

    /**
     * Limpia la información de los países consultados.
     *
     */
    public void limpiarConsulta(){
        paisesConsultados = null;
    }    

    /**
     * Realiza la elección del país que el usuario seleccionó
     *
     * @param itemes Arreglo con todas las opciones.
     * @param nuevoPais Nuevo valor ingresado por el usuario.
     */
    public void seleccionarPaisAEliminar(List<SelectItem> itemes, String nuevoPais){
        paisSeleccionado = null;
        for(SelectItem auxSelectItem : itemes){
            if(((Pais)auxSelectItem.getValue()).getCodigo().compareTo(nuevoPais) == 0)
                paisSeleccionado = (Pais)auxSelectItem.getValue();
        }
    }

    /**
     * Recolecta los datos de los campos de la pantalla y crea un nuevo país.
     *
     * @param grupo Grupo de envío al cuál se le asignará el nuevo páis.
     * @return Nuevo país con los datos de los campos y la asignación del grupo de envío.
     */
    public Pais crearNuevoPais(GrupoEnvio grupo){
        Pais auxPais = new Pais();

        String split[] = nuevoPais.split(" ");
        String codigo = grupoSeleccionado;
        codigo += split.length >= 2 ?
           split[0].charAt(0) + split[split.length - 1].charAt(1):
           nuevoPais.charAt(0) + nuevoPais.charAt(1);

        auxPais.setCodigo(codigo);
        auxPais.setNombre(nuevoPais);
        auxPais.setCodigoGrupoEnvio(grupo);
        
        return auxPais;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public void setGrupoSeleccionado(String nuevoGrupo){
        grupoSeleccionado = nuevoGrupo;
    }

    public String getGrupoSeleccionado() {
        return grupoSeleccionado;
    }

    public void setNuevoPais(String pais){
        nuevoPais = pais;
    }

    public String getNuevoPais() {
        return nuevoPais;
    }

    public Pais getPaisSeleccionado() {
        return paisSeleccionado;
    }

    public void setPaisSeleccionado(Pais nuevoPais){
        paisSeleccionado = nuevoPais;
    }

    /**
     * Verifica que existe una consulta.
     *
     * @return Arreglo con todos los páises consultados
     * @throws Exception Para avisar que no hay datos consultados.
     */
    public ArrayList<SelectItem> getPaisesConsultados() throws Exception{
        if(paisesConsultados == null || paisesConsultados.size() == 0){
            Exception e = new Exception();
            throw e;
        }
        
        ArrayList<SelectItem> auxPaises = new ArrayList<SelectItem>();
        
        for(SelectItem auxPais : paisesConsultados){
            if(((Pais)auxPais.getValue()).getCodigoGrupoEnvio().getCodigo().compareTo(grupoSeleccionado) == 0)
                auxPaises.add(auxPais);
        }

        return auxPaises;
    }

    public void setPaisesConsultados(List<Pais> paises){
        if(paises != null){
            paisesConsultados = new ArrayList<SelectItem>();
            for(Pais auxPais : paises)
                paisesConsultados.add(new SelectItem(auxPais, auxPais.getNombre()));            
        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String grupoSeleccionado = "G1";
    private Pais paisSeleccionado;
    private String nuevoPais;
    private ArrayList<SelectItem> paisesConsultados;

    //</editor-fold>

    //</editor-fold>

}
