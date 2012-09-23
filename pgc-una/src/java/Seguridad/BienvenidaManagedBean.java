package Seguridad;

import Estructuras.UnidadUserObject;
import cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Ruta;
import cr.ac.una.cgi.pgc.entity.Unidad;
import cr.ac.una.cgi.pgc.session.CorrespondenciaExternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.CorrespondenciaInternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.PresupuestoFacadeRemote;
import cr.ac.una.cgi.pgc.session.RutaFacadeRemote;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class BienvenidaManagedBean {

    @EJB
    private PresupuestoFacadeRemote presupuestoFacade;
    @EJB
    private CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade;
    @EJB
    private RutaFacadeRemote rutaFacade;
    @EJB
    private CorrespondenciaInternaFacadeRemote correspondenciaInternaFacade;

    /**
     * Constructor de la instancia
     */
    public BienvenidaManagedBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        seguridad = (SeguridadManagedBean) session.getAttribute("SeguridadManagedBean");
    }

    //<editor-fold defaultstate="collapsed" desc="Bienvenida del Mensajero">

    /**
    * Crea el árbol donde se muestra las rutas y las unidades asignadas a esas rutas
    * del mensajero que ingresó al sistema
    * @param login Empleado que ingresó al sistema
    * @return Modelo con las rutas y las unidades asignadas al mensajero que ingresó al sistema
    */
    private DefaultTreeModel getModelMensajero(Empleado login) {

        DefaultMutableTreeNode raiz = agregarNodo(null, "Asignación de Rutas:");

        if (model == null) {
            try {
                List<Ruta> rutas = rutaFacade.findByEmpleado(login);

                for (Ruta r : rutas) {
                    DefaultMutableTreeNode nodo = agregarNodo(raiz, "Ruta " + r.getNumero());

                    try {
                        for (Unidad u : r.getUnidadCollection()) {
                            if (u.getNumeroRuta() != null && u.getNumeroRuta().getNumero().compareTo(r.getNumero()) == 0) {
                                agregarNodo(nodo, u.getNombre());
                            }
                        }
                    } catch (Exception x) {
                    }
                }

                setCantEnviosSinEntregar(rutas);
            } catch (Exception e) {
            }
        }

        return new DefaultTreeModel(raiz);
    }

    /**
     * Método que calcula la cantidad de envíos sin entregar en una cierta cantidad de
     * rutas
     * @param rutas Rutas con las cuales se calculará la cantidad de envíos sin entregar.
     */
    private void setCantEnviosSinEntregar(List<Ruta> rutas) {

        cantEnviosSinEntregar = 0;

        Date[] fechas = fechasEntrega();

        if (isMensajeroExterno(rutas)) {
            try {
                cantEnviosSinEntregar += correspondenciaInternaFacade.findNoEntregadosExterna(fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]).size();
            } catch (Exception e) {
            }
        }

        for (Ruta r : rutas) {
            try {
                if (r.getInterna()) {
                    List<CorrespondenciaInterna> c1 = correspondenciaInternaFacade.findNoEntregadosInterna(r, fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]);
                    cantEnviosSinEntregar += c1.size();
                }
            } catch (Exception e) {
                String algo = e.toString();
            }
        }



    }

    /**
     * Método que verifica si un mensajero es externo o no
     * @param rutas Rutas asignadas a un mensajero
     * @return TRUE si encuentra una ruta externa, FALSE de lo contrario
     */
    private boolean isMensajeroExterno(List<Ruta> rutas) {
        if (rutas != null) {
            for (Ruta r : rutas) {
                if (!r.getInterna()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setCantEnviosSinEntregar(int cant) {
        cantEnviosSinEntregar = cant;
    }

    public int getCantEnviosSinEntregar() {
        return cantEnviosSinEntregar;
    }
    private int cantEnviosSinEntregar = 0;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Bienvenida de la Secretaria">
    
    /**
     * Método que calcula la cantidad de envíos por Correos de Costa Rica, que no se
     * han facturado aún.
     * @return Cantidad de envíos que no se han calculado aún
     */
    public int getCantidadEnviosSinFacturar() {
        int cantidad = 0;

        try {
            cantidad += correspondenciaExternaFacade.cantidadSinFactura();
        } catch (Exception e) {
        }

        return cantidad;
    }

    /**
     * Método que extrae de la base de datos el presupuesto que tiene la oficina con
     * la Universidad Nacional
     * @return Persupuesto de la UNA
     */
    public float getPresupuestoUNA() {
        float presupuesto = 0;

        try {
            presupuesto += presupuestoFacade.find("002").getMonto();
        } catch (Exception e) {
        }

        return presupuesto;
    }

    /**
     * Método que extrae de la base de datos el presupuesto de operación con
     * Correos e Costa Rica
     *
     * @return Presupuesto de Operación con Correos de Costa Rica
     */
    public float getPresupuestoCCR() {
        float presupuesto = 0;

        try {
            presupuesto += presupuestoFacade.find("001").getMonto();
        } catch (Exception e) {
        }

        return presupuesto;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Bienvenida del Jefe">
    /**
     * Método encargado de crear un árbol con todas las rutas, y la cantidad de envíos sin
     * entregar por cada una de estas.
     * @return Árbol con todas las rutas
     */
    private DefaultTreeModel getModelJefe() {

        DefaultMutableTreeNode raiz = agregarNodo(null, "Cantidad de Envíos sin entregar por ruta:");

        try {
            List<Ruta> rutas = rutaFacade.findAll();

            Date fechas[] = fechasEntrega();

            for (Ruta r : rutas) {

                int cont = 0;
                try {
                    cont = r.getInterna() ? correspondenciaInternaFacade.findNoEntregadosInterna(r, fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]).size() : correspondenciaInternaFacade.findNoEntregadosExterna(fechas[0], fechas[1], fechas[2], fechas[3], fechas[4]).size();
                } catch (Exception e) {
                }

                agregarNodo(raiz, "Ruta " + r.getNumero() + ": " + Integer.toString(cont));

            }

            setCantEnviosSinEntregar(rutas);
        } catch (Exception e) {
        }

        return new DefaultTreeModel(raiz);
    }

    //</editor-fold>

    /**
     * Método que se encarga de agregar a un árbol cualquiera, información a un
     * nodo padre
     * @param padre Padre del nuevo nodo
     * @param informacion Información del nuevo nodo
     * @return Nodo que ha sido agregado al padre, y que continene la nueva información
     */
    private DefaultMutableTreeNode agregarNodo(DefaultMutableTreeNode padre, String informacion) {

        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        UnidadUserObject userObject = new UnidadUserObject(node);
        node.setUserObject(userObject);
        userObject.setUnidad(new Unidad("0", informacion, "info"));

        userObject.setText(informacion);
        userObject.setLeaf(false);
        userObject.setExpanded(true);
        node.setAllowsChildren(true);

        if (padre != null) {
            padre.add(node);
        }

        return node;

    }

    /**
     * Método que calcula 5 fechas distintas. La fecha actual, y de cuatro dias anteriores, sin contar fines de semana.
     * @return Arreglo con las cinco fechas
     */
    public Date[] fechasEntrega() {
        Date[] fechas = new Date[5];

        fechas[0] = new Date();

        for (int i = 1; i < 5; i++) {
            Date aux = new Date(fechas[i - 1].getTime());

            if (aux.getDay() == 1) {
                aux.setDate(aux.getDate() - 3);
            } else {
                aux.setDate(aux.getDate() - 1);
            }

            fechas[i] = aux;
        }

        return fechas;
    }

    /**
     * 
     * @return
     */
    public String getEmpleadoIngreso() {

        if (seguridad != null && seguridad.getEmpleadoIngreso() != null) {
            Empleado empleado = seguridad.getEmpleadoIngreso();

            return empleado.getNombre() + " " + empleado.getMiddleName() + " " + empleado.getApellidos();
        }

        return "";

    }

    /**
     * Método que crea y accede al aŕbol, que será diferente en cada pantalla de
     * bienvenida
     * @return Modelo de un árbol, dependiendo de la pantalla de bienvenida
     */
    public DefaultTreeModel getModel() {

        if (model == null) {
            Empleado login = seguridad.getEmpleadoIngreso();

            if (login != null) {
                switch (login.getTipo().getCodigo()) {
                    case '1':
                        return getModelJefe();
                    case '2':
                        break;
                    case '3':
                        return getModelMensajero(login);
                }
            }

            return new DefaultTreeModel(agregarNodo(null, "modelo"));


        }

        return model;
    }

    /**
     * @return La fecha actual en formato local
     */
    public String getFechaHoy() {
        return (new Date()).toLocaleString();
    }
    private DefaultTreeModel model;
    private SeguridadManagedBean seguridad;
}
