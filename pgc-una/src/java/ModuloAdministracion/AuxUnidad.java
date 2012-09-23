package ModuloAdministracion;

import Estructuras.UnidadUserObject;
import cr.ac.una.cgi.pgc.entity.Unidad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Es una clase que sirve de apoyo a la clase UnidadFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxUnidad {

    public AuxUnidad() {
    }

    //<editor-fold defaultstate="collapsed" desc="Página de Administración de Unidades"
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Limpia el modelo del árbol, que se utiliza para representar el organigrama de la
     * Universidad Nacional. También limpia todos los datos que tienen que ver con el árbol.     *
     *
     */
    public void limpiarModelo() {
        model = null;
        unidadSeleccionada = null;
        nuevaUnidad = "";
        nuevoAcron = "";
    }

    /**
     * Agrega una nueva unidad al árbol, como hijo de un nodo padre
     *
     * @param padre Padre de la nueva unidad
     * @param nuevaUnidad Nueva unidad
     *
     * @return El nodo con la unidad dentro, ya asignado al padre
     */
    public DefaultMutableTreeNode agregarNodo(DefaultMutableTreeNode padre, Unidad nuevaUnidad) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        UnidadUserObject userObject = new UnidadUserObject(node);
        node.setUserObject(userObject);
        userObject.setUnidad(nuevaUnidad);

        node.setAllowsChildren(true);
        userObject.setText(nuevaUnidad.getNombre());
        userObject.setLeaf(false);

        if (nuevaUnidad.getTipo() == 0) {
            userObject.setExpanded(true);
        } else {
            userObject.setExpanded(false);
        }

        if (padre != null) {
            padre.add(node);
        }

        return node;

    }

    /**
     * Busca un nodo dentro del arbol
     *
     * @param raiz Nodo raíz de la consulta
     * @param codigo Código buscado
     * @param nivel Nivel de profundidad del árbol
     * @return Nodo encontrado, null si no lo encuentra
     */
    private DefaultMutableTreeNode buscarNodo(DefaultMutableTreeNode raiz, String codigo, int nivel) {

        DefaultMutableTreeNode nodo = null;

        String auxCodigo = codigoBuscar(codigo, nivel);

        if (raiz != null) {
            if (auxCodigo.compareTo(((UnidadUserObject) raiz.getUserObject()).getUnidad().getCodigo()) == 0) {
                return raiz;
            } else {
                for (int i = 0; i < raiz.getChildCount(); i++) {
                    Unidad comparacion = ((UnidadUserObject) ((DefaultMutableTreeNode) raiz.getChildAt(i)).getUserObject()).getUnidad();
                    if (auxCodigo.compareTo(comparacion.getCodigo()) == 0) {
                        nodo = (DefaultMutableTreeNode) raiz.getChildAt(i);
                        break;
                    }
                }

                if (nodo != null) {
                    return buscarNodo(nodo, codigo, nivel + 1);
                }
            }
        }

        return nodo;
    }

    /**
     * Método utilizado para reemplazar el split, separando cadenas de caracteres
     * por el '.'
     *
     * @param codigo Codigo que se desea separar por puntos
     *
     * @return Un arreglo que contienen la separación del código.
     *
     */
    private ArrayList<String> separarCodigo(String codigo) {
        ArrayList<String> resultado = new ArrayList<String>();

        if (codigo != null && codigo.trim().compareTo("") != 0) {
            char auxCodigo[] = codigo.toCharArray();
            String nuevoResultado = "";
            for (char caracter : auxCodigo) {
                if (caracter == '.') {
                    resultado.add(nuevoResultado);
                    nuevoResultado = "";
                } else {
                    nuevoResultado += Character.toString(caracter);
                }
            }

            if (nuevoResultado.trim().compareTo("") != 0) {
                resultado.add(nuevoResultado);
            }
        }

        return resultado;
    }

    /**
     * Extrae el código del padre de una unidad para ser buscado dentro del árbol.
     *
     * @param codigo Codigo de la unidad buscada
     * @param nivel Profundidad de búsqueda dentro del árbol
     * @return La separación en el nivel de profundida buscado.
     */
    private String codigoBuscar(String codigo, int nivel) {

        ArrayList<String> aux = separarCodigo(codigo);

        if (aux.size() >= nivel) {
            String auxCodigo = "";
            for (int i = 0; i < nivel; i++) {
                auxCodigo += aux.get(i) + ".";
            }
            return auxCodigo.substring(0, auxCodigo.length() - 1);
        }

        return codigo;
    }

    /**
     * Interfaz para buscar un nodo y seleccionarlo.
     *
     * @param codigo Código que va a ser buscado
     */
    public void seleccionarNodo(String codigo) {
        unidadSeleccionada = buscarNodo((DefaultMutableTreeNode) model.getRoot(), codigo, 1);
    }

    /**
     * Consigue el nodo padre de un nodo cualquiera.
     *
     * @param raiz Raíz del árbol
     * @param codigo Código a ser buscado.
     * @param nivel Nivel de profundidad de la consulta.
     * @return El nodo padre encintrado, null si no lo encuentra.
     */
    private DefaultMutableTreeNode conseguirPadre(DefaultMutableTreeNode raiz, String codigo, int nivel) {

        if (nivel == 1) {
            return raiz;
        }

        String codigoPadre = codigoBuscar(codigo, nivel - 1);

        return buscarNodo(raiz, codigoPadre, 1);
    }

    /**
     * Método que separa todas las unidades del sistema, en el organigrama de la
     * Universidad Nacional. Para ello mientras recorre el arreglo de las unidades
     * las va asignando a los lugares convenientes.
     *
     * @param padre Nodo que se agregará al organigrama
     * @param raiz Raíz del árbol
     */
    private void separarUnidades(DefaultMutableTreeNode padre, DefaultMutableTreeNode raiz) {

        if (unidades.size() >= 1) {
            DefaultMutableTreeNode nodo = agregarNodo(padre, unidades.get(0));
            unidades.remove(unidades.get(0));
            if (unidades.size() != 0) {
                separarUnidades(conseguirPadre(raiz, unidades.get(0).getCodigo(), unidades.get(0).getTipo()), raiz);
            }
        }

    }

    /**
     * Interfaz que inicia la construcción del organigrama.
     *
     * @param auxUnidades Lista de unidades extraidan de la base de datos
     */
    public void armarModelo(List<Unidad> auxUnidades) {

        if (auxUnidades != null && auxUnidades.size() != 0) {

            unidades = new ArrayList<Unidad>();
            unidades.addAll(auxUnidades);

            Unidad universidad = new Unidad("0", "Universidad Nacional", "UNA");
            universidad.setTipo(0);
            DefaultMutableTreeNode raiz = agregarNodo(null, universidad);

            separarUnidades(raiz, raiz);

            model = new DefaultTreeModel(raiz);
        }

    }

    /**
     * Selecciona la unidad y la lista con sus hijos, para poder ser eliminados de
     * la base de datos.
     *
     * @param raiz Nodo por el que se comienza a contar las unidades que se van a eliminar.
     *
     * @return Lista con todas las unidades que se van a eliminar.
     */
    private ArrayList<Unidad> seleccionarAEliminar(DefaultMutableTreeNode raiz) {

        ArrayList<Unidad> aEliminar = new ArrayList<Unidad>();

        if (raiz.getChildCount() != 0) {
            for (int i = 0; i < raiz.getChildCount(); i++) {
                aEliminar.addAll(seleccionarAEliminar((DefaultMutableTreeNode) raiz.getChildAt(i)));
            }
        }

        aEliminar.add(((UnidadUserObject) raiz.getUserObject()).getUnidad());

        return aEliminar;
    }

    /**
     * Método para extraer la lista de unidades hijas de la unidad seleccionada que
     * se van a extraer de la base de datos.
     *
     * @return Lista con las unidades hijas de la unidad seleccionada.
     */
    public ArrayList<Unidad> getAEliminar() {
        return seleccionarAEliminar(unidadSeleccionada);
    }

    /**
     * Recolecta los datos para asignarlos a una unidad, que va a ser la que se ingresará
     * a la base de datos.
     *
     * @return Nueva unidad formada con los datos de los campos en la página.
     */
    public Unidad crearUnidad() {
        String codigo = "";

        if (((UnidadUserObject) unidadSeleccionada.getUserObject()).getUnidad().getCodigo().compareTo("0") != 0) {
            codigo += ((UnidadUserObject) unidadSeleccionada.getUserObject()).getUnidad().getCodigo() + ".";
        }

        if (unidadSeleccionada.getChildCount() > 0) {
            UnidadUserObject nuevo = (UnidadUserObject) ((DefaultMutableTreeNode) unidadSeleccionada.getChildAt(unidadSeleccionada.getChildCount() - 1)).getUserObject();
            String cod = nuevo.getUnidad().getCodigo();
            cod = getCodigoUltimaUnidad();
            if (cod.length() > 1) {
                cod = cod.substring(cod.length() - 2, cod.length());
                cod = cod.replace(".", "");
            }

            codigo += Integer.toString(Integer.parseInt(cod) + 1);
        } else {
            codigo += "1";
        }

        Unidad unidad = new Unidad(codigo, nuevaUnidad, nuevoAcron);
        unidad.setTipo(((UnidadUserObject) unidadSeleccionada.getUserObject()).getUnidad().getTipo() + 1);

        return unidad;
    }

    private String getCodigoUltimaUnidad() {
        String resultado = "";
        Enumeration children = unidadSeleccionada.children();

        List<Unidad> unidades2 = new LinkedList<Unidad>();
        while (children.hasMoreElements()) {
            Unidad unidad = ((UnidadUserObject) ((DefaultMutableTreeNode) children.nextElement()).getUserObject()).getUnidad();
            unidades2.add(unidad);
        }
        Collections.sort(unidades2, unidadComparator);
        resultado = unidades2.get(unidades2.size()-1).getCodigo();
        return resultado;
    }
    
    Comparator<Unidad> unidadComparator = new Comparator<Unidad>() {

        public int compare(Unidad und1, Unidad und2) {
            int resultado = -1;
            String[] codigosUnidad1 = und1.getCodigo().split("\\.");
            String[] codigosUnidad2 = und2.getCodigo().split("\\.");
            int parte1;
            int parte2;
            for (int i = 0; i < codigosUnidad1.length && i < codigosUnidad2.length; i++) {
                parte1 = Integer.valueOf(codigosUnidad1[i]);
                parte2 = Integer.valueOf(codigosUnidad2[i]);

                resultado = parte1 == parte2 ? 0 : parte1 < parte2 ? -1 : 1;
                if (resultado != 0) {
                    return resultado;
                }
            }

            return resultado;
        }
    };

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    public String getNuevaUnidad() {
        return nuevaUnidad;
    }

    public void setNuevaUnidad(String unidad) {
        nuevaUnidad = unidad;
    }

    public String getNuevoAcron() {
        return nuevoAcron;
    }

    public void setNuevoAcron(String acron) {
        nuevoAcron = acron;
    }

    public DefaultTreeModel getModel() throws Exception {
        if (model == null) {
            throw new Exception();
        }

        return model;
    }

    public void setModel(DefaultTreeModel model) {
        this.model = model;
    }

    public DefaultMutableTreeNode getUnidadSeleccionada() {
        return unidadSeleccionada;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ArrayList<Unidad> unidades;
    private String nuevaUnidad;
    private String nuevoAcron;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode unidadSeleccionada;
    //</editor-fold>
    //</editor-fold>
}
