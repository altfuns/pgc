package Seguridad;

import Logs.Log;
import com.icesoft.faces.component.menubar.MenuItem;
import com.icesoft.faces.context.effects.Highlight;
import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
import cr.ac.una.cgi.pgc.session.EmpleadoFacadeRemote;
import cr.ac.una.cgi.pgc.session.PermisoFacadeRemote;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpSession;

public class SeguridadManagedBean {

    @EJB
    private EmpleadoFacadeRemote empleadoFacade;
    @EJB
    private PermisoFacadeRemote permisoFacade;

    public SeguridadManagedBean() {
        facesContext = FacesContext.getCurrentInstance();
    }

    //<editor-fold defaultstate="collapsed" desc="Ingreso al Sistema">
    public void dispararEfecto() {
        efectoFooter.setFired(false);
    }

    public boolean EmpleadoIngreso() {

        try {
            empleadoIngreso = empleadoFacade.find(id);

            //if(autentificarLDAP(id, contra)){
                if (empleadoIngreso != null && empleadoIngreso.getActivo()) {
                    armarPermisos(permisoFacade.findByEmpleado(empleadoIngreso));
                    id = "";
                    contra = "";
                    return true;
                }
                else{
                    empleadoIngreso = new Empleado();
                    ArrayList<Permiso> permisos= new ArrayList<Permiso>();
                    // Conociendo que estos son los permisos de consulta en la base de datos
                    permisos.add(permisoFacade.find("3"));
                    permisos.add(permisoFacade.find("4"));
                    armarPermisos(permisos);
                    id = "";
                    contra = "";
                    facesContext.getExternalContext().redirect("/pgc-una/ModuloRutas/ConsultaRutas.jspx");
                }
            //}


        } catch (Exception ex) {
            infoFooter = "Los datos ingresados son incorrectos." + ex.getMessage();
            contra = "";
            dispararEfecto();
        }

        return false;
    }

    public void action_cb_ingresarUsuario(ActionEvent event) {
        if (event != null) {
            // Verificar que ambos esten llenos

            if (EmpleadoIngreso()) {
                
                HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
                Log log = new Log();
                session.setAttribute("Log", log);

                try {
                    switch (empleadoIngreso.getTipo().getCodigo()) {
                        case '1':
                            facesContext.getExternalContext().redirect("/pgc-una/bienvenidaJefe.iface");
                            break;
                        case '2':
                            facesContext.getExternalContext().redirect("/pgc-una/bienvenidaSecretaria.iface");
                            break;
                        case '3':
                            facesContext.getExternalContext().redirect("/pgc-una/bienvenidaMensajero.iface");
                            break;
                    }
                } catch (Exception e) {
                }
            } else {
                infoFooter = "Los datos son incorrectos. Vuelva a ingresarlos e intente de nuevo.";
                dispararEfecto();
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getInfoFooter() {
        return infoFooter;
    }

    public Highlight getEfecto() {
        return efectoFooter;
    }

    public Empleado getEmpleadoIngreso(){
        return empleadoIngreso;
    }

    private String id = "";
    private String contra = "";
    private String infoFooter = "No hay información relevante.";
    private Empleado empleadoIngreso;
    private Highlight efectoFooter = new Highlight();

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Control de permisos">
    
    /**
     * Redirige al usuario a la página de ingreso de usuario.
     */
    public void salir() {
        try {
            facesContext.getExternalContext().getSession(true);
            facesContext.getExternalContext().redirect("/pgc-una/login.iface");
        } catch (Exception e) {
        }
    }

    /**
     * Verifica si existe el permiso, de lo contrario lo redirige a la página de
     * bienvenida
     * @param key Llave de consulta del permiso
     */
    public void validarPermiso(String key) {

        try {
            Permiso p = (Permiso) tablaPermisos.get(key);
            if (p == null) {
                 facesContext.getExternalContext().redirect(getLinkBienvenida());
            }
        } catch (Exception e) {            
        }


    }

    /**
     * Método que extrae los permisos para administrar la correspondencia interna
     * del empleado ingresado
     * @return Arreglo con los permisos de administración de correspondencia interna
     */
    public ArrayList<Permiso> getPermisosRegistroInterna(){
        ArrayList<Permiso> permisos = new ArrayList<Permiso>();
        
        if(tablaPermisos != null){
            Permiso aux1 = (Permiso)tablaPermisos.get("1");
            
            if(aux1 != null)
                permisos.add(aux1);
            
            Permiso aux2 = (Permiso)tablaPermisos.get("2");
            
            if(aux2 != null)
                permisos.add(aux2);
        }
        
        return permisos;
    }

    /**
     * Método que devuelve los permisos para consultar del empleado ingresado
     * @return Permisos para consultar
     */
    public ArrayList<Permiso> getPermisosConsultaInterna(){
        ArrayList<Permiso> permisos = new ArrayList<Permiso>();
        
        if(tablaPermisos != null){
            Permiso aux1 = (Permiso)tablaPermisos.get("3");
            
            if(aux1 != null)
                permisos.add(aux1);
            
            Permiso aux2 = (Permiso)tablaPermisos.get("4");
            
            if(aux2 != null)
                permisos.add(aux2);
        }
        
        return permisos;
    }

    /**
     * Método que se utiliza para agregar los permisos a una tabla que los controla
     * @param permisos Arreglo con todos los permiss de usuario
     */
    private void armarPermisos(List<Permiso> permisos) {
        tablaPermisos = new HashMap();

        for (Permiso p : permisos) {
            tablaPermisos.put(p.getCodigo(), p);
        }

        armarMenu();
    }


    /**
     * Método que se encarga de armar la lista de permisos con respecto
     * a los asignados al empleado que ingresó.
     */
    private void armarMenu() {

        itemesRutas = new ArrayList<MenuItem>();
        itemesExterna = new ArrayList<MenuItem>();
        itemesAdministracion = new ArrayList<MenuItem>();
        itemesEstadistica = new ArrayList<MenuItem>();

        //Direcciones del modulo interno - externo por mensajero propio

        if (tablaPermisos.get("1") != null || tablaPermisos.get("2") != null) {
            MenuItem permiso = new MenuItem();
            permiso.setValue("Ingreso de Envíos");
            permiso.setLink("/pgc-una/ModuloRutas/ControlCorrespondencia.iface");
            itemesRutas.add(permiso);
        }

        if (tablaPermisos.get("3") != null || tablaPermisos.get("4") != null) {
            MenuItem permiso = new MenuItem();
            permiso.setValue("Consulta de Envíos");
            permiso.setLink("/pgc-una/ModuloRutas/ConsultaRutas.iface");
            itemesRutas.add(permiso);
        }

        //Direcciones del modulo administrativo

        for (int i = 5; i < 12; i++) {
            if (tablaPermisos.get(Integer.toString(i)) != null) {
                MenuItem permiso = new MenuItem();
                permiso.setValue(((Permiso) tablaPermisos.get(Integer.toString(i))).getDescripcion());
                permiso.setLink("/pgc-una" + ((Permiso) tablaPermisos.get(Integer.toString(i))).getDireccion());
                itemesAdministracion.add(permiso);
            }
        }

        for (int i = 13; i < 19; i++) {
            if (tablaPermisos.get(Integer.toString(i)) != null) {
                MenuItem permiso = new MenuItem();
                permiso.setValue(((Permiso) tablaPermisos.get(Integer.toString(i))).getDescripcion());
                permiso.setLink("/pgc-una" + ((Permiso) tablaPermisos.get(Integer.toString(i))).getDireccion());
                itemesExterna.add(permiso);
            }
        }

        if (tablaPermisos.get("12") != null) {
            MenuItem permiso1 = new MenuItem();
            permiso1.setValue("Gastos Anuales");
            permiso1.setLink("/pgc-una/ModuloEstadistica/gastosAnuales.iface");
            itemesEstadistica.add(permiso1);
            MenuItem permiso2 = new MenuItem();
            permiso2.setValue("Informe de Rutas");
            permiso2.setLink("/pgc-una/ModuloEstadistica/informeRuta.iface");
            itemesEstadistica.add(permiso2);
            MenuItem permiso3 = new MenuItem();
            permiso3.setValue("Ubicación");
            permiso3.setLink("/pgc-una/ModuloEstadistica/informeUbicacion.iface");
            itemesEstadistica.add(permiso3);
            MenuItem permiso4 = new MenuItem();
            permiso4.setValue("Expedida");
            permiso4.setLink("/pgc-una/ModuloEstadistica/expedida.iface");
            itemesEstadistica.add(permiso4);
        }

    }

    /**
     * Método que devuelve la dirección del link de bienvenida, con respecto a el
     * tipo de usuario
     * @return URL de la pantalla de bienvenida
     */
    public String getLinkBienvenida() {

        if (empleadoIngreso != null) {
            switch (empleadoIngreso.getTipo().getCodigo()) {
                case '1':
                    return "/pgc-una/bienvenidaJefe.iface";
                case '2':
                    return "/pgc-una/bienvenidaSecretaria.iface";
                case '3':
                    return "/pgc-una/bienvenidaMensajero.iface";
            }
        } else {
            salir();
        }

        return null;
    }

    public ArrayList<MenuItem> getItemesRutas() {
        if (itemesRutas == null) {
            salir();
        }
        return itemesRutas;
    }

    public ArrayList<MenuItem> getItemesExterna() {
        if (itemesExterna == null) {
            salir();
        }
        return itemesExterna;
    }

    public ArrayList<MenuItem> getItemesAdministracion() {
        if (itemesAdministracion == null) {
            salir();
        }
        return itemesAdministracion;
    }

    public ArrayList<MenuItem> getItemesEstadistica() {
        if (itemesEstadistica == null) {
            salir();
        }
        return itemesEstadistica;
    }
    private ArrayList<MenuItem> itemesRutas;
    private ArrayList<MenuItem> itemesExterna;
    private ArrayList<MenuItem> itemesAdministracion;
    private ArrayList<MenuItem> itemesEstadistica;
    private HashMap tablaPermisos;
    //</editor-fold>

    /**
     * Método que valida si los datos ingresados por el usuario pertenecen a
     * el servidor de autentificación LDAP
     * @param user Nombre de usuario
     * @param password Contraseña
     * @return TRUE si la validación fué exitosa, FALSE de lo contrario.
     */
    private Boolean autentificarLDAP(String user,String password){

        String uid = facesContext.getExternalContext().getInitParameter("LDAP_ID");
        String principal = facesContext.getExternalContext().getInitParameter("LDAP_PRINCIPAL");
        String authentication = facesContext.getExternalContext().getInitParameter("LDAP_AUTHENTICATION");
        String url = facesContext.getExternalContext().getInitParameter("LDAP_URL");

        Hashtable env =  new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory" );
        env.put(Context.PROVIDER_URL, url);

        env.put(Context.SECURITY_AUTHENTICATION,authentication);

        uid += "=" + user;
        principal = uid + "," + principal;


        env.put(Context.SECURITY_PRINCIPAL,principal);
        env.put(Context.SECURITY_CREDENTIALS, password);
        try{
            DirContext cnx = new InitialDirContext(env);

        }catch(Exception e){
            return false;
        }

        return true;
    }

    /**
     * Este método averigua si el usuario ingresado es un funcionario o
     * es un empleado de la oficina postal.
     *
     * @return Verdadero si pertenece a la oficina, falso si no.
     */
    public Boolean getIsNotEmpleado(){
        return !(empleadoIngreso != null && empleadoIngreso.getId() != null);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Salida del sistema">

    /**
     * Cancela al usuario y a sus permisos
     */
    private void limpiarUsuario(){
        empleadoIngreso = null;
        tablaPermisos = null;
    }

    /**
     * Evento que se utiliza para salir del sistema
     * @param event Evento de la Acción
     */
    public void action_mi_salir(ActionEvent event){
        if(event != null){

            limpiarUsuario();
            try{
                facesContext.getExternalContext().redirect("/pgc-una/login.iface");
            }
            catch(Exception e){
            }

        }
    }
    
    //</editor-fold>

    private FacesContext facesContext;

}
