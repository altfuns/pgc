package ModuloAdministracion;

import Estructuras.RutaUserObject;
import Estructuras.UnidadUserObject;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.Unidad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Es una clase que sirve de apoyo a la clase RutaFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxRuta {

    public AuxRuta() {
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de Rutas">

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Limpia el modelo que muestra las rutas con su asignación de unidades. Así como 
     * datos que se encargan del control del mismo.
     */
    public void limpiarModelo() {
        model = null;
        modelExterna = null;
        unidadSel = null;
        rutaSel = null;
        nuevaRuta = "";
    }

    /**
     * Separa las unidades de la ruta seleccionada que se encuentran dentro del arbol,
     * para que al momento de eliminar una ruta, estas sean eliminadas de la misma.
     *
     * @return Arreglo con unidades de una ruta.
     */
    public ArrayList<Unidad> unidadesModeloRuta() {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) model.getRoot();

        DefaultMutableTreeNode ruta = null;

        for (int i = 0; i < raiz.getChildCount(); i++) {
            Ruta aux = ((RutaUserObject) ((DefaultMutableTreeNode) raiz.getChildAt(i)).getUserObject()).getRuta();
            if (aux.equals(rutaSel)) {
                ruta = (DefaultMutableTreeNode) raiz.getChildAt(i);
                i = raiz.getChildCount();
            }
        }

        ArrayList<Unidad> unidadesRuta = new ArrayList<Unidad>();

        if (ruta != null) {
            for (int i = 0; i < ruta.getChildCount(); i++) {
                unidadesRuta.add(((UnidadUserObject) ((DefaultMutableTreeNode) ruta.getChildAt(i)).getUserObject()).getUnidad());
            }
        }

        return unidadesRuta;
    }

    /**
     * Separa las unidades por una ruta en específico.
     *
     * @param r Ruta por la cual se van a seleccionar las unidades
     * @return Arreglo con las unidades de esa ruta
     */
    private ArrayList<Unidad> unidadesRuta(Ruta r) {
        ArrayList<Unidad> u = new ArrayList<Unidad>();

        for (Unidad aux : unidades) {
            Ruta r1 = aux.getNumeroRuta();
            if (r1 != null && r1.equals(r)) {
                u.add(aux);
            }
        }

        unidades.removeAll(u);

        return u;
    }

    /**
     * Arma los modelos de los árboles que presenta la asignacion de las rutas internas y las rutas externas.
     *
     * @param rutas Arreglo con todas las rutas
     * @param unid Arreglo con todas las unidades
     */
    public void armarModelos(List<Ruta> rutas, List<Unidad> unid) {

        DefaultMutableTreeNode raiz = agregarNodoUnidad(null, new Unidad("0", "Rutas Internas","RI"));
        DefaultMutableTreeNode raizE = agregarNodoUnidad(null, new Unidad("0", "Rutas Externas","RE"));

        if (rutas != null && rutas.size() != 0) {

            unidades = new ArrayList<Unidad>();
            unidades.addAll(unid);

            for (Ruta auxRuta : rutas) {

                if (auxRuta.getInterna()) {
                    DefaultMutableTreeNode ruta = agregarNodoRuta(raiz, auxRuta);
                    ArrayList<Unidad> u = unidadesRuta(auxRuta);
                    if (u.size() != 0) {
                        for (Unidad auxUnidad : u) {
                            agregarNodoUnidad(ruta, auxUnidad);
                        }
                    }

                } else {
                    agregarNodoRuta(raizE, auxRuta);
                }

            }

        }

        model = new DefaultTreeModel(raiz);
        modelExterna = new DefaultTreeModel(raizE);
    }

    /**
     * Selecciona una unidad de un nodo de ruta interna, que se encuentra dentro del árbol.
     *
     * @param codigo Código de la unidad buscada dentro del árbol.
     */
    public void seleccionarItemInterna(String codigo) {

        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < raiz.getChildCount(); i++) {

            DefaultMutableTreeNode ruta = (DefaultMutableTreeNode) raiz.getChildAt(i);

            if (((RutaUserObject) ruta.getUserObject()).getRuta().getNumero().compareTo(codigo) == 0) {
                rutaSel = ((RutaUserObject) ruta.getUserObject()).getRuta();
                mensajeroSel = rutaSel.getEmpleadoId() != null ? rutaSel.getEmpleadoId().getId() : "";
                i = raiz.getChildCount();
            } else {

                for (int j = 0; j < ruta.getChildCount(); j++) {
                    DefaultMutableTreeNode unidad = (DefaultMutableTreeNode) ruta.getChildAt(j);
                    if (((UnidadUserObject) unidad.getUserObject()).getUnidad().getNombre().compareTo(codigo) == 0) {
                        rutaSel = ((RutaUserObject) ruta.getUserObject()).getRuta();
                        mensajeroSel = rutaSel.getEmpleadoId() != null ? rutaSel.getEmpleadoId().getId() : "";
                        unidadSel = ((UnidadUserObject) unidad.getUserObject()).getUnidad();
                        j = ruta.getChildCount();
                        i = raiz.getChildCount();
                    }

                }

            }

        }
    }

    /**
     * Selecciona una ruta externa del árbol.
     *
     * @param codigo Código de la unidad buscada dentro del árbol.
     */
    public void seleccionarItemExterna(String codigo) {
        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) modelExterna.getRoot();
        for (int i = 0; i < raiz.getChildCount(); i++) {

            DefaultMutableTreeNode ruta = (DefaultMutableTreeNode) raiz.getChildAt(i);

            if (((RutaUserObject) ruta.getUserObject()).getRuta().getNumero().compareTo(codigo) == 0) {
                rutaSel = ((RutaUserObject) ruta.getUserObject()).getRuta();
                i = raiz.getChildCount();
            }

        }
    }

    /**
     * Agrega un nodo de una ruta, a un nodo padre.
     *
     * @param padre Nodo padre, al que se le asignará la ruta.
     * @param ruta Información de la ruta que se asignará a nuevo nodo.
     * @return Nodo que fué asignado al padre, y contiene la información de la ruta.
     */
    public DefaultMutableTreeNode agregarNodoRuta(DefaultMutableTreeNode padre, Ruta ruta) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        RutaUserObject userObject = new RutaUserObject(node);
        node.setUserObject(userObject);
        userObject.setRuta(ruta);

        userObject.setText(ruta.getNumero());
        userObject.setLeaf(false);
        userObject.setExpanded(true);
        node.setAllowsChildren(true);

        if (padre != null) {
            padre.add(node);
        }

        return node;

    }

    /**
     * Agrega un nodo de una unidad, a un nodo padre.
     *
     * @param padre Nodo padre, al que se le asignará la unidad.
     * @param unidad Información de la unidad que se asignará a nuevo nodo.
     * @return Nodo que fué asignado al padre, y contiene la información de la unidad.
     */
    public DefaultMutableTreeNode agregarNodoUnidad(DefaultMutableTreeNode padre, Unidad unidad) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        UnidadUserObject userObject = new UnidadUserObject(node);
        node.setUserObject(userObject);
        userObject.setUnidad(unidad);

        userObject.setText(unidad.getNombre());
        userObject.setLeaf(false);
        userObject.setExpanded(true);
        node.setAllowsChildren(true);

        if (padre != null) {
            padre.add(node);
        }

        return node;

    }

    /**
     * Selecciona una unidad que se encuentra dentro de la lista de unidades no asignadas
     * a ninguna ruta.
     *
     * @param nombre Nombre de la unidad.
     */
    public void seleccionarUnidad(String nombre) {

        ArrayList<SelectItem> noAsignadas = getUnidadesNoAsignadas();

        for (SelectItem s : noAsignadas) {
            if (s.getValue().toString().compareTo(nombre) == 0) {
                unidadSel = (Unidad) s.getValue();
                break;
            }
        }


    }

    /**
     * Selecciona la primera unidad de la lista, si no se ha seleccionado ninguna,
     * para poder agregarla a una ruta.
     */
    public void seleccionarPorDefecto() {
        if (getUnidadesNoAsignadas() != null && getUnidadesNoAsignadas().size() == 1) {
            unidadSel = (Unidad) getUnidadesNoAsignadas().get(0).getValue();
        }
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public String getNuevaRuta() {
        return nuevaRuta;
    }

    public void setNuevaRuta(String nuevaRuta) {
        this.nuevaRuta = nuevaRuta;
    }

    public String getMensajeroSel() {
        return mensajeroSel;
    }

    public void setMensajeroSel(String mensajero) {
        mensajeroSel = mensajero;
    }

    public String getNuevaRutaTipo() {
        return nuevaRutaTipo;
    }

    public void setNuevaRutaTipo(String tipo) {
        nuevaRutaTipo = tipo;
    }

    public Unidad getUnidadSel() {
        return unidadSel;
    }

    public boolean isInterna() {
        if (nuevaRutaTipo.compareTo("interna") == 0) {
            return true;
        }
        return false;
    }

    public void setUnidadSel(Unidad unidad) {
        unidadSel = unidad;
    }

    public DefaultTreeModel getModel() throws Exception {
        if (model == null) {
            throw new Exception();
        }

        return model;
    }

    public DefaultTreeModel getModelExterna() throws Exception {
        if (modelExterna == null) {
            throw new Exception();
        }

        return modelExterna;
    }

    public boolean getDisableCambiarMensajero() {
        if (rutaSel == null) {
            return true;
        }
        return false;
    }

    public Ruta getRutaSel() {
        return rutaSel;
    }

    public void setRutaSel(Ruta ruta) {
        rutaSel = ruta;
    }

    public ArrayList<Empleado> getMensajeros(List<Empleado> empleados) {
        ArrayList<Empleado> mensajeros = new ArrayList<Empleado>();

        if (empleados != null) {
            for (Empleado e : empleados) {
                if (e.getTipo().getCodigo() == '3') {
                    mensajeros.add(e);
                }
            }

        }

        return mensajeros;
    }

    public ArrayList<Unidad> getUnidades() {
        if (unidades == null) {
            unidades = new ArrayList<Unidad>();
        }
        return unidades;
    }

    public ArrayList<SelectItem> getUnidadesNoAsignadas() {
        ArrayList<SelectItem> unid = new ArrayList<SelectItem>();

        ArrayList<Unidad> u = getUnidades();

        for (Unidad aux : u) {
            if (aux.getTipo() != 0 && aux.getTipo() != 1) {
                unid.add(new SelectItem(aux, aux.getNombre()));
            }
        }

        return unid;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private String nuevaRuta;
    private String mensajeroSel;
    private String nuevaRutaTipo = "interna";
    private Unidad unidadSel;
    private Ruta rutaSel;
    private ArrayList<Unidad> unidades;
    private DefaultTreeModel model;
    private DefaultTreeModel modelExterna;
    //</editor-fold>

    //</editor-fold>
}
