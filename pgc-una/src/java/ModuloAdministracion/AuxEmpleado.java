package ModuloAdministracion;

import cr.ac.una.cgi.pgc.entity.Empleado;
import cr.ac.una.cgi.pgc.entity.Permiso;
import cr.ac.una.cgi.pgc.entity.Rol;
import java.util.ArrayList;
import java.util.List;

/**
 * Es una clase que sirve de apoyo a la clase EmpleadoFacadeManaged
 *
 * @author Jeremy Guzmán Salazar
 */
public class AuxEmpleado {

    public AuxEmpleado() {
    }    

    //<editor-fold defaultstate="collapsed" desc="Página de Administracion de Empleados">

    //<editor-fold defaultstate="collapsed" desc="Métodos">

    /**
     * Método que limpiar el formulario de ingreso de empleados.
     *
     */
    public void vaciarFormulario(){
        empleadoIngreso = new Empleado();
    }

    /**
     * Método que limpiar la consulta de empleados. Se realiza para volver a consultar
     * esta información de la base de datos.
     */
    public void limpiarConsulta(){
        empleados = null;
    }

    /**
     * Método que verifica si los datos ingresados del empleado son correctos
     *
     * @return true si están correctos.
     */

    public boolean validarEmpleadoIngreso(){
        boolean valid = true;
        
        if(empleadoIngreso == null)
            return false;

        valid = valid && empleadoIngreso.getId() != null && empleadoIngreso.getId().compareTo("") != 0;
        valid = valid && empleadoIngreso.getNombre() != null && empleadoIngreso.getNombre().compareTo("") != 0;
        valid = valid && empleadoIngreso.getApellidos() != null && empleadoIngreso.getApellidos().compareTo("") != 0;
        
        return valid;
    }

    /**
     * Asigna la opción elegida en el campo de cargo, al empleado que se esta agregando.
     *
     */
    public void llenarCargoEmpleado(){
        Rol nuevoRol = new Rol(cargo.toCharArray()[0]);
        if(cargo.compareTo("1") == 0)
            nuevoRol.setDescripcion("Jefe");
        else{
            if(cargo.compareTo("2") == 0)
                nuevoRol.setDescripcion("Secretaria");
            else
                nuevoRol.setDescripcion("Mensajero");
        }
        empleadoIngreso.setTipo(nuevoRol);
    }

    /**
     * Asigna una lista de permisos al empleado que se está ingresando.
     *
     * @param permisos
     */
    public void asignarPermisos(List<Permiso> permisos){
        if(permisos != null)
            empleadoIngreso.setPermisoCollection(permisos);
        empleadoIngreso.setActivo(true);
    }

    /**
     * Busca en todos los empleados al único con el rol Jefe
     *
     * @return Empleado con rol de jefe si lo encuentra, null de lo contrario.
     */
    public Empleado buscarJefe(){
        if(empleados != null){

            for(Empleado e : empleados){
                if(e.getTipo().getCodigo() == '1')
                    return e;
            }

        }

        return null;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    /**
     *
     * @return
     */
    public ArrayList<Empleado> getEmpleadosVacios(){
        empleados = new ArrayList<Empleado>();
        empleados.add(new Empleado());
        return empleados;
    }
    
    public ArrayList<Empleado> getEmpleados() throws Exception{
        if(empleados == null || empleados.size() == 0){
            Exception e = new Exception();
            throw e;
        }
        
        return empleados;
    }
    
    public void setEmpleados(List<Empleado> auxEmpleados){
        if(auxEmpleados != null){
            empleados = new ArrayList<Empleado>();
            for(Empleado e : auxEmpleados)
                empleados.add(e);            
        }
    }   

    public Empleado getEmpleadoIngreso(){
        if(empleadoIngreso == null)
            empleadoIngreso = new Empleado();
        return empleadoIngreso;
    }
    
    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">

    private String cargo = "1";
    private ArrayList<Empleado> empleados;
    private Empleado empleadoIngreso;

    //</editor-fold>

    //</editor-fold>

}
