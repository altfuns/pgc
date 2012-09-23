
package Estructuras;

import com.icesoft.faces.component.tree.IceUserObject;
import cr.ac.una.cgi.pgc.entity.Unidad;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase utilizada para almacenar una ruta y mostrarla como parte de un árbol
 *
 * @author Jeremy Guzmán Salazar
 */

public class UnidadUserObject extends IceUserObject{

    public UnidadUserObject(DefaultMutableTreeNode defaultMutableTreeNode){
        super(defaultMutableTreeNode);
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    /**
     * Método que devuelve es estilo de un nodo de unidad dependiendo de su nivel en el
     * organigrama
     *
     * @return style Estilo del Nodo
     */
    public String getStyle(){
        String style = "";

        if(unidad != null){

            if(unidad.getTipo() == 0)
                return "font-size: 15px; font-weight: bolder;";

            if(unidad.getTipo() == 1){
                style = "font-size: 14px; font-style: italic; font-weight: bold;";
            }
            else{
                style = unidad.getTipo() == 2 ? "font-size: 13px; font-style: italic;" : "font-size: 12px;";
            }
        }
        
        return style;
    }

    Unidad unidad;

}
