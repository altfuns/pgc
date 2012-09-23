
package Reportes;

import cr.ac.una.cgi.pgc.entity.Ruta;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


/**
 * Clase que se encarga de la unión del sistema con jasperReports
 * @author Jeremy Guzmán Salazar
 */
public class Reporte {

    public Reporte(){
    }

    /**
    * Método que establece la conexión con una base de datos.
    */
    private void conectar()
    {
        try
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String DB_URL = facesContext.getExternalContext().getInitParameter("DB_URL");
            String DB_usuario = facesContext.getExternalContext().getInitParameter("DB_usuario");
            String DB_password = facesContext.getExternalContext().getInitParameter("DB_password");

            Class.forName("org.postgresql.Driver").newInstance();

            conexion = java.sql.DriverManager.getConnection(DB_URL, DB_usuario, DB_password);
        }
        catch (Exception ex)
        {           
        }

    }

    /**
     * Método que se encarga de cerrar la conexión con una base de datos.
     */
    private void cerrarConexion(){
        try {
            conexion.close();
        }
        catch(Exception e){
        }
    }

    /**
     * Método encargado de cargar los reportes y crear el PDF con los datos
     * @param archivo URL del archivo jrxml
     * @param parametros Mapa que contiene los Parámetros para llenar los reportes
     * @param nombreArchivo URL del destino del archivo
     */
    private void guardarPDF(String archivo, Map parametros, String nombreArchivo){
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String direccionReportes = facesContext.getExternalContext().getInitParameter("direccionReportes");
            /*JasperDesign jasperDesign =JRXmlLoader.load(direccionReportes + archivo);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);*/
            JasperPrint jasperPrintPDF = JasperFillManager.fillReport(direccionReportes + archivo, parametros, conexion);
            String direccionGuardar = facesContext.getExternalContext().getInitParameter("direccionGuardar");
            JasperExportManager.exportReportToPdfFile(jasperPrintPDF, direccionGuardar + nombreArchivo + ".pdf");
        }
        catch(Exception e){
        }

    }

    private Connection conexion;    

    //<editor-fold defaultstate="collapsed" desc="Control de Correspondencia Interna">

    /**
     * Método que crea los paŕametros para crear el reporte que se encarga
     * de llenar la hoja de control de correspondencia
     * @param ruta Ruta seleccionada para consultar registros de esta.
     * @param responsable Nombre del mensajero responsable de esa ruta.
     * @param fechas Fechas bajo las cuales se realizará la consulta
     * @param nombreArchivo Nombre del archivo con el cual el reporte se nombrará
     */
    public void registrosCorrespondenciaInterna(Ruta ruta, String responsable, Date[] fechas, String nombreArchivo){

        Map parametros = new HashMap();
        
        parametros.put("fecha1", fechas[0]);
        parametros.put("fecha2", fechas[1]);
        parametros.put("fecha3", fechas[2]);
        parametros.put("fecha4", fechas[3]);
        parametros.put("fecha5", fechas[4]);

        conectar();

        if(ruta != null && ruta.getInterna()){
            parametros.put("ruta", ruta.getNumero());
            parametros.put("responsable", responsable);
            guardarPDF(archivoInterna, parametros, nombreArchivo);
        }
        else
            guardarPDF(archivoExterna, parametros, nombreArchivo);


        cerrarConexion();

    }    
   
    private static String archivoInterna = "correspondenciaInterna.jasper";
    private static String archivoExterna = "correspondenciaExterna.jasper";

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reporte de Rutas">

    /**
     * Método encargado de crear el reporte de rutas
     * @param anio Año bajo el cuál se generará el reporte
     * @param nombreArchivo Nombre del archivo con que se nombrará el reporte
     */
    public void reporteRutas(int anio, String nombreArchivo){
        Map parametros = new HashMap();

        parametros.put("anio", anio);

        conectar();

        guardarPDF(archivoRutas, parametros, nombreArchivo);

        cerrarConexion();
    }

    private static String archivoRutas = "Rutas.jasper";

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reporte de Correspondencia Expedida">

    /**
     * Método encargado de crear el reporte de correspondencia expedida
     * @param anio Año bajo el cual se generará el reporte
     * @param nombreArchivo Nombre del archivo con que se nombrará el reporte
     */
    public void reporteExpedida(int anio, String nombreArchivo){
        Map parametros = new HashMap();

        parametros.put("anio", anio);

        conectar();

        guardarPDF(archivoExpedida, parametros, nombreArchivo);

        cerrarConexion();
    }

    private static String archivoExpedida = "Tabla_ExpedidaCCR.jasper";

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reporte Expedida por unidad">

    /**
     * Método encargado de crear el reporte de ubicación
     * @param anio Año con el cuál se generará el reporte por ubicación
     * @param nombreArchivo Nombre del archivo con que se nombrará el reporte
     */
    public void reporteUbicacion(int anio, String nombreArchivo){
        Map parametros = new HashMap();

        parametros.put("anio", anio);

        conectar();

        guardarPDF(archivoUbicacion, parametros, nombreArchivo);

        cerrarConexion();
    }

    private static String archivoUbicacion = "expedidaUnidad.jasper";

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reporte de peso por unidad">

    /**
     * Método que se encarga de 
     * @param anio
     * @param nombreArchivo
     */
    public void reportePeso(int anio, String nombreArchivo){
        Map parametros = new HashMap();

        parametros.put("anio", anio);

        conectar();

        guardarPDF(archivoPeso, parametros, nombreArchivo);

        cerrarConexion();
    }

    private static String archivoPeso = "pesoUnidad.jasper";
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Reporte anual de gastos">

    /**
     * Método encargado de crear el reporte anual de gastos
     * @param fechaInicio Fecha inicio del reporte
     * @param fechaFinal Fecha final del reporte
     * @param nombreArchivo Nombre del archivo con que se nombrará el reporte
     */
    public void reporteGastos(Date fechaInicio, Date fechaFinal, String nombreArchivo){
        
        if(fechaFinal == null){
            fechaFinal = new Date(fechaInicio.getTime());
            fechaInicio.setYear(fechaInicio.getYear() - 1);
        }

        Map parametros = new HashMap();

        parametros.put("inicio", fechaInicio);
        parametros.put("final", fechaFinal);

        conectar();

        guardarPDF(archivoGastos, parametros, nombreArchivo);

        cerrarConexion();
    }

    private static String archivoGastos = "reporteGastos.jasper";

    //</editor-fold>


}
