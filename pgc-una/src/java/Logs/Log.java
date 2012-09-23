/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logs;

import Seguridad.SeguridadManagedBean;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.ErrorLog;
import cr.ac.una.cgi.pgc.entity.TransactionLog;
import cr.ac.una.cgi.pgc.session.ErrorLogFacadeRemote;
import cr.ac.una.cgi.pgc.session.TransactionLogFacadeRemote;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Luis Alfonos Aguilar Sánchez
 */

public class Log {
    @EJB
    private ErrorLogFacadeRemote errorLogFacade;
    @EJB
    private TransactionLogFacadeRemote transactionLogFacade;

    private Logger logger = Logger.getLogger(Log.class);

    /** Creates a new instance of Log */
    public Log() {
    }

    public String getInit(){
        return "Loaded";
    }
    
    /**
     * Crea un nuevo registro de error con el usuario y la descripción del error
     * @param entity
     * Entidad que genero el error
     * @param descripcion
     * Detalle del error
     */
     public  void error(Logeable entity,String descripcion){
        try{
            ErrorLog error = new ErrorLog();
            Integer max = -1;
            try{max = errorLogFacade.findMax();}
            catch(Exception e){ }
            error.setCodigo(max + 1);
            error.setFecha(new Date());
            Empleado e = getEmpleado();
            error.setIdEmpleado(e);
            error.setDescripcion(descripcion);
            errorLogFacade.create(error);
        }catch(Exception e){
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }

    }
     /**
      * Crea un registro de bitácora que guarda la sentencia SQL del INSERT y el usario que lo hizo
      * @param entity
      * Entidad que se quiere guardar
      */
    public void create(Logeable entity){
        try{
            TransactionLog tran = new TransactionLog();
            Integer max = -1;
            try{max = transactionLogFacade.findMax();}catch(Exception e){}
            
            tran.setCodigo(max + 1);
            tran.setFecha(new Date());
            tran.setIdEmpleado(getEmpleado());
            tran.setNombreTabla(entity.getTablaString());
            tran.setConsulta(entity.getInsertString());
            transactionLogFacade.create(tran);
        }catch(Exception e){
            System.out.println(e.getMessage());
            logger.error(e.getMessage());
        }

    }
    /**
      * Crea un registro de bitácora que guarda la sentencia SQL UPDATE y el usario que lo hizo
      * @param entity
      * Entidad que se quiere actualizar
      */
    public void update(Logeable entity){
        try{
            TransactionLog tran = new TransactionLog();
            Integer max = -1;
            try{
                max = transactionLogFacade.findMax();
            }
            catch(Exception e){               
            }

            tran.setCodigo(max + 1);
            tran.setFecha(new Date());
            tran.setIdEmpleado(getEmpleado());
            tran.setNombreTabla(entity.getTablaString());
            tran.setConsulta(entity.getUpdateString());
            transactionLogFacade.create(tran);
        }catch(Exception e){
            logger.error(e.getMessage());
        }

    }
    /**
      * Crea un registro de bitácora que guarda la sentencia SQL DELETE y el usario que lo hizo
      * @param entity
      * Entidad que se quiere borrar
      */
    public void delete(Logeable entity){
        try{
            TransactionLog tran = new TransactionLog();
            Integer max = -1;
            try{max = transactionLogFacade.findMax();}
            catch(Exception e){}
            
            tran.setCodigo(max + 1);
            tran.setFecha(new Date());
            tran.setIdEmpleado(getEmpleado());
            tran.setNombreTabla(entity.getTablaString());
            tran.setConsulta(entity.getDeleteString());
            transactionLogFacade.create(tran);
        }catch(Exception e){
            logger.error(e.getMessage());
        }

    }
    /**
     * Obtiene el empleado que se encuentra logeado en la sesión.
     * @return
     * Empleado logeado
     */
    public  Empleado getEmpleado() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        return seguridad.getEmpleadoIngreso();
    }
}
