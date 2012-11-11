package ModuloExterna;

import Logs.Log;
import Logs.Logeable;
import Seguridad.SeguridadManagedBean;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.MovimientoPresupuesto;
import cr.ac.una.cgi.pgc.entity.Presupuesto;
import cr.ac.una.cgi.pgc.session.MovimientoPresupuestoFacadeRemote;
import cr.ac.una.cgi.pgc.session.PresupuestoFacadeRemote;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */
public class MovimientoPresupuestoFacadeManaged implements Logeable {

    @EJB
    private PresupuestoFacadeRemote presupuestoFacade;
    @EJB
    private MovimientoPresupuestoFacadeRemote movimientoPresupuestoFacade;

    /**
     * Contructor del ManagedBean
     */
    public MovimientoPresupuestoFacadeManaged() {
        tipos = new ArrayList<SelectItem>();
        tipos.add(new SelectItem("001", "Correos de Costa Rica"));
        tipos.add(new SelectItem("002", "Universidad Nacional"));
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    private void seguridad() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean) session.getAttribute("SeguridadManagedBean");
        if (seguridad != null) {
            seguridad.validarPermiso(codigoPermiso);
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
            } catch (Exception e) {
            }
        }
    }

    /**
     * Crea un nuevo Movimiento de presupuesto con los datos presentes en la pantalla
     */
    public void guardar() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        MovimientoPresupuesto mp = new MovimientoPresupuesto();
        Log l = new Log();
        try {
            mp.setFecha(movimientoPresupuestoLocal.getFecha());
            mp.setNumeroCheque(movimientoPresupuestoLocal.getNumeroCheque());
            mp.setImporte(movimientoPresupuestoLocal.getImporte());
            mp.setNumeroDeposito(movimientoPresupuestoLocal.getNumeroDeposito());
            mp.setCodigo(movimientoPresupuestoLocal.getNumeroCheque() + movimientoPresupuestoLocal.getNumeroDeposito());

            Presupuesto p = presupuestoFacade.find(movimientoPresupuestoLocal.getPresupuesto());
            if (manejarPresupuesto(p, mp)) {
                message.setSeverity(FacesMessage.SEVERITY_INFO);
                message.setSummary("Movimiento agregado Correctamente");
                context.addMessage("frm_principal", message);
                listaMovimientos.add(movimientoPresupuestoLocal);
                limpiarCampos();
            }

        } catch (Exception e) {
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(e.getMessage());
            message.setDetail(e.getMessage());
            context.addMessage("frm_principal", message);
            getLogFacade().error(this, e.getMessage());
        }
    }

    /**
     * Maneja el presupuesto al cual se le quiere ingresar el movimiento
     * @param p
     * Presupuesto que se quiere alterar
     * @param mp
     * MovimientoPresupuesto que se quiere ingresar
     * @return
     * True si la operación se pudo realizar con exito, false en caso contrario
     */
    public Boolean manejarPresupuesto(Presupuesto p, MovimientoPresupuesto mp) {
        if (movimientoPresupuestoLocal.getImporte() > 0) {
            p.setMonto(p.getMonto() + movimientoPresupuestoLocal.getImporte());
            if (p.getCodigo().equals("001")) {
                Presupuesto puna = presupuestoFacade.find("002");
                if (movimientoPresupuestoLocal.getImporte() <= puna.getMonto()) {
                    puna.setMonto(puna.getMonto() - movimientoPresupuestoLocal.getImporte());
                    presupuestoFacade.edit(puna);
                    auxiliarTransaction = puna;
                    getLogFacade().update(this);
                    presupuestoFacade.edit(p);
                    auxiliarTransaction = p;
                    getLogFacade().update(this);
                    auxiliarTransaction = null;
                    mp.setCodigoPresupuesto(p);
                    movimientoPresupuestoFacade.create(mp);
                    getLogFacade().create(this);
                    return true;
                } else {
                    FacesContext context = FacesContext.getCurrentInstance();
                    FacesMessage message = new FacesMessage();
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    message.setSummary("No se puede realizar el movimiento de presupuesto. El monto no esta disponible en el presupuesto de la UNA");
                    context.addMessage("frm_principal", message);
                    return false;
                }
            } else {
                presupuestoFacade.edit(p);
                auxiliarTransaction = p;
                mp.setCodigoPresupuesto(p);
                movimientoPresupuestoFacade.create(mp);
                getLogFacade().update(this);
                auxiliarTransaction = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Limpiar los campos de la pantalla
     */
    public void limpiarCampos() {
        movimientoPresupuestoLocal.setFecha(null);
        movimientoPresupuestoLocal.setImporte(0);
        movimientoPresupuestoLocal.setNumeroCheque("");
        movimientoPresupuestoLocal.setNumeroDeposito("");

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Log">
    public String getInsertString() {
        MovimientoPresupuesto m = movimientoPresupuestoLocal;
        String query = "INSERT INTO movimiento_presupuesto(codigo, codigo_presupuesto, fecha, numero_deposito, numero_cheque, importe)" +
                "VALUES ({0},{1},{2},{3},{4},{5});";

        query = query.replace("{0}", m.getCodigo() == null ? "" : m.getCodigo());
        query = query.replace("{1}", m.getCodigoPresupuesto() == null ? "" : m.getCodigoPresupuesto().getCodigo());
        query = query.replace("{2}", m.getFecha() == null ? "" : m.getFecha().toString());
        query = query.replace("{3}", m.getNumeroDeposito() == null ? "" : m.getNumeroDeposito());
        query = query.replace("{4}", m.getNumeroCheque() == null ? "" : m.getNumeroCheque());
        query = query.replace("{5}", String.valueOf(m.getImporte()));

        return query;
    }

    public String getDeleteString() {
        MovimientoPresupuesto m = movimientoPresupuestoLocal;

        String query = "DELETE FROM movimiento_presupuesto WHERE codigo = {0};";
        query = query.replace("{0}", m.getCodigo());

        return query;
    }

    public String getUpdateString() {
        Presupuesto m = auxiliarTransaction;
        String query = "UPDATE presupuesto SET titulo = {0}, monto = {1} WHERE codigo = {2};";

        query = query.replace("{0}", m.getTitulo() == null ? "" : m.getTitulo());
        query = query.replace("{1}", String.valueOf(m.getMonto()));
        query = query.replace("{2}", m.getCodigo() == null ? "" : m.getCodigo());

        return query;
    }

    public String getTablaString() {
        return "movimiento_presupuesto";
    }

    public Empleado getEmpleado() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean) session.getAttribute("SeguridadManagedBean");
        return seguridad.getEmpleadoIngreso();
    }

    private Log getLogFacade() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return (Log) session.getAttribute("Log");
    }

    //</editor-fold>
    //<editor-fold defaultstate="" desc="Propiedades y atributos">
    public ArrayList<SelectItem> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<SelectItem> tipos) {
        this.tipos = tipos;
    }

    public MovimientoPresupuestoLocal getMovimientoPresupuestoLocal() {
        return movimientoPresupuestoLocal;
    }

    public void setMovimientoPresupuestoLocal(MovimientoPresupuestoLocal movimientoPresupuestoLocal) {
        this.movimientoPresupuestoLocal = movimientoPresupuestoLocal;
    }

    public void setListaMovimientos(ArrayList<MovimientoPresupuestoLocal> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public ArrayList<MovimientoPresupuestoLocal> getListaMovimientos() {
        //if(listaMovimientos.isEmpty()){
        seguridad();
        listaMovimientos = new ArrayList<MovimientoPresupuestoLocal>();
        ArrayList<MovimientoPresupuesto> aux = new ArrayList<MovimientoPresupuesto>(movimientoPresupuestoFacade.findAll());
        for (MovimientoPresupuesto mp : aux) {
            if (movimientoPresupuestoLocal.getPresupuesto().compareTo(mp.getCodigoPresupuesto().getCodigo()) == 0) {
                listaMovimientos.add(new MovimientoPresupuestoLocal(mp));
            }
        }
        // }

        return listaMovimientos;
    }

    public Presupuesto getPresupuestoCCR() {
        return presupuestoFacade.find("001");
    }

    public Presupuesto getPresupuestoUNA() {
        return presupuestoFacade.find("002");
    }
    private String codigoPermiso = "16";
    private Presupuesto auxiliarTransaction;
    private ArrayList<MovimientoPresupuestoLocal> listaMovimientos = new ArrayList<MovimientoPresupuestoLocal>();
    private MovimientoPresupuestoLocal movimientoPresupuestoLocal = new MovimientoPresupuestoLocal();
    private ArrayList<SelectItem> tipos = new ArrayList();
    //</editor-fold>
}
