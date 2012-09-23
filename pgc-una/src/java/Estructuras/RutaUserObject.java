
package Estructuras;

import com.icesoft.faces.component.tree.IceUserObject;
import cr.ac.una.cgi.pgc.entity.Ruta;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase utilizada para almacenar una ruta y mostrarla como parte de un árbol
 *
 * @author Jeremy Guzmán Salazar
 */
public class RutaUserObject extends IceUserObject{

    public RutaUserObject(DefaultMutableTreeNode defaultMutableTreeNode){
        super(defaultMutableTreeNode);
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    Ruta ruta;

}
