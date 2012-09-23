/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModuloEstadistica;


import Reportes.Reporte;
import Seguridad.SeguridadManagedBean;
import com.icesoft.faces.context.FileResource;
import com.icesoft.faces.context.Resource;
import cr.ac.una.cgi.pgc.session.CorrespondenciaExternaFacadeRemote;
import cr.ac.una.cgi.pgc.session.CorrespondenciaInternaFacadeRemote;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Luis Alfonso Aguilar Sánchez
 */

public class EstadisticaFacadeManaged {
    @EJB
    private CorrespondenciaInternaFacadeRemote correspondenciaInternaFacade;
    @EJB
    private CorrespondenciaExternaFacadeRemote correspondenciaExternaFacade;
    
    /** Creates a new instance of EstadisticaFacadeManaged */
    public EstadisticaFacadeManaged() {
        xLabels = new ArrayList(Arrays.asList(new String[]{"Filas"}));
        data = new double[1][1];
        data[0] = new double[1];
        data[0][0] = 100;
        setVisible(Boolean.FALSE);
        controlR = new Reporte();
    }

    //<editor-fold defaultstate="collapsed" desc="Eventos">


    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">

    private void seguridad(){
       
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SeguridadManagedBean seguridad = (SeguridadManagedBean)session.getAttribute("SeguridadManagedBean");
        if(seguridad != null){
            seguridad.validarPermiso(codigoPermiso);
        }
        else{
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pgc-una/login.iface");
            }
            catch(Exception e){
            }
        }        
    }
    /**
     * Transforma el valor de un entero en la palabra que corresponde al ese mes
     * @param mes
     * Número de mes que se quiere transformar
     * @return
     * Nombre del mes
     */
    private String integerToMonth(int mes){
        switch(mes){
            case 1: return "Enero";
            case 2 : return "Febrero";
            case 3 : return "Marzo";
            case 4 : return "Abril";
            case 5 : return "Mayo";
            case 6 : return "Junio";
            case 7 : return "Julio";
            case 8 : return "Agosto";
            case 9 : return "Setiembre";
            case 10 : return "Octubre";
            case 11 : return "Noviembre";
            case 12 : return "Diciembre";
        }
        return null;
    }
    /**
     * Genera el reporte anual de gastos, se comunica con la interfaz
     */
    public void generarReporteAnual(){
        generarHashAnual();
    }
    public SelectItem[] getTiposItems() {
        SelectItem[] languageItems = new SelectItem[2];
        languageItems[0] = new SelectItem(1, "Enviada");
        languageItems[1] = new SelectItem(2, "Recibida");

        return languageItems;
    }
    //<editor-fold defaultstate="collapsed" desc="Informe Expedida">
    /**
     * Genera el informe de la correspondencia expedida
     */
    public void generarInformeExpedida(){
         hash1.clear();
         rows.clear();
         rowDataModel = null;
         columnDataModel = null;
         tGenerales.clear();
         ArrayList columnList = new ArrayList();
         
         columnList.add("Cantidad");
         columnList.add("Costo");
         columnList.add("Facultad");
         consultarExpedida();
         
         Collections.sort(rows);
         if(rowDataModel == null)
             rowDataModel = new ListDataModel(rows);
         else
             rowDataModel.setWrappedData(rows);
         if(columnDataModel == null)
             columnDataModel = new ListDataModel(columnList);
         else
            columnDataModel.setWrappedData(columnList);
         setGraphicData(rows, tGenerales,"Informe de Correspondencia Expedida por Correos de Costa Rica","Unidad Remitente","Costo total");
         if(hash1.isEmpty())
              setVisible(Boolean.FALSE);
         else{
            setVisible(Boolean.TRUE);
            crearResourceUbicacion();
            crearResourcePeso();
         }
    }
    /**
     * Toma los datos de la Lista y los ordena en un HashTable, esté se usa para mostrar los datos en las tablas
     * y la información de los gráficos
     */
    public void consultarExpedida(){
        ArrayList lista =  new ArrayList();
        if(mes > 0 && anyo > 0){
             lista = new ArrayList(correspondenciaExternaFacade.reporteExpidida(mes,anyo));
             Double tco = 0.0;
             Integer tca = 0;

             if(lista != null){
                 for(Object o : lista){
                     Object[] v = (Object[])o;
                     String unidad = v[0].toString();
                     String facultad = v[3].toString();
                     Integer cantidad = Integer.parseInt(v[1].toString());
                     Double costo = Double.parseDouble(v[2].toString());
                     rows.add(unidad);
                     
                     hash1.put(unidad+"Cantidad",cantidad);
                     hash1.put(unidad+"Costo", costo);
                     hash1.put(unidad+"Facultad",facultad);
                     tGenerales.put(unidad, costo);
                     tca += cantidad;
                     tco += costo;
                 }
                 rows.add("Total");
                 hash1.put("TotalCantidad", tca);
                 hash1.put("TotalCosto", tco);
                 tGenerales.put("Total", tco);
             }

        }else{
            setVisible(Boolean.FALSE);
        }

    }
    /**
     * Devuelve el valor de una celda, dada la columna y la fila
     * @return
     * El valor de la celda
     */
    public Object getExpedidaCellValue(){
        return getCellValue(hash1);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Informe Anual de Gastos">
    /**
     * Genera el HashTable del reporte el cual se usa para las información de la tablas
     * y el gráfico
     */
    private void generarHashAnual(){
         cambiarFechas();
         filas.clear();
         rows.clear();
         tGenerales.clear();
         rowDataModel = null;
         columnDataModel = null;
         ArrayList columnList = new ArrayList();

         while(mes <= mesFinal || anyo < anyoFinal){
             consultarMes(mes, anyo);
             columnList.add(integerToMonth(mes) + "/" + String.valueOf(anyo));
             if(mes == 12 && anyo < anyoFinal){
                 mes = 1;
                 anyo++;
             }else{
                mes ++;
             }
             

         }
         columnList.add("Total Anual");
         Collections.sort(rows);
         if(rowDataModel == null)
             rowDataModel = new ListDataModel(rows);
         else
             rowDataModel.setWrappedData(rows);
         if(columnDataModel == null)
             columnDataModel = new ListDataModel(columnList);
         else
            columnDataModel.setWrappedData(columnList);
         setGraphicData(rows, tGenerales,"Informe Anual de Gastos","Unidad","Costo Anual");
         if(filas.isEmpty())
            setVisible(Boolean.FALSE);
         else{
             setVisible(Boolean.TRUE);
             crearResourceGastos();
         }

     }
    /**
     * Asigna el valor de las fechas por la cuales se quiere consultar.
     * 
     */
    public void cambiarFechas(){
         mes = fechaInicial.getMonth();
         anyo = fechaInicial.getYear();
         if(fechaFinal == null){
             if(mes == 11){
                 mes = 1;
                 mesFinal = 12;
                 anyoFinal = fechaInicial.getYear();
             }
             else{
                 mes = fechaInicial.getMonth() + 2;
                 anyo = fechaInicial.getYear() - 1;
                 mesFinal = fechaInicial.getMonth() + 1;
                anyoFinal = fechaInicial.getYear();
             }
             
         }else{
             if(fechaInicial.after(fechaFinal)){
                 Date tmp = fechaInicial;
                 fechaInicial = fechaFinal;
                 fechaFinal = tmp;
             }
             mes = fechaInicial.getMonth() + 1;
             anyo = fechaInicial.getYear();
             mesFinal = fechaFinal.getMonth() + 1;
             anyoFinal = fechaFinal.getYear();
         }
         anyo += 1900;
         anyoFinal += 1900;
     }
    /**
     * Consulta la información por un mes específico.
     * Mete los valores el listas y HashTables
     * @param mes
     * Mes por el cual se quiere consultar
     * @param year
     * Año por el cual se quiere consultar
     */
    private void consultarMes(int mes,int year){
         ArrayList lista =
                     new ArrayList(correspondenciaExternaFacade.reporteAnualGatos(mes, year));
         String mesString = integerToMonth(mes) + "/" + String.valueOf(year);
         Double totalMensual = 0.0;
         if(lista != null){
             for(Object o : lista){
                 Object[] v = (Object[])o;
                 String unidad = v[0].toString();
                 Double costo = (Double)v[1];
                 if(!rows.contains(unidad)){
                     rows.add(unidad);
                     filas.put(unidad+"Total Anual",costo);
                     tGenerales.put(unidad, costo);
                 }else{
                     Double c = filas.get(unidad+"Total Anual");
                     if(c != null ){
                         c += costo;
                         filas.put(unidad+"Total Anual",c);
                         tGenerales.put(unidad, c);
                     }
                 }
                 filas.put(unidad+mesString,costo);
                 totalMensual += costo; filas.put(unidad+mesString,costo);
             }
             String etqMensual = "Total Mensual";
             if(!rows.contains(etqMensual)){
                rows.add(etqMensual);
                filas.put(etqMensual+"Total Anual", totalMensual);
                tGenerales.put(etqMensual, totalMensual);
             }else{
                 
                 Double costo = (Double)filas.get(etqMensual+"Total Anual");
                 if(costo != null){
                    
                     costo += totalMensual;
                     filas.put(etqMensual+"Total Anual", costo);
                     tGenerales.put(etqMensual, costo);
                 }

             }
             
             filas.put(etqMensual+mesString, totalMensual);
         }
     }
    /**
     * Obtine el valor de una celda dado el nombre de la fila y la columna
     * @return
     * El valor de la celda
     */
    public  Object getAnualCellValue(){
        return getCellValue(filas);
    }
     
     //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Informe Rutas">
    /**
     * Genera el informe de correspondencia enviada en una Ruta.
     * Coloca los datos en Listas y HashTables
     */
     public  void generarInformeRutas(){
         hashRutas.clear();
         rowDataModel = null;
         columnDataModel = null;
         tGenerales.clear();
         ArrayList columnList = new ArrayList();
         rutas = new ArrayList<String>();
         for(int i=1;i<=12;i++){
             consultarRutasMes(i, anyo);
             columnList.add(integerToMonth(i) + "/" + String.valueOf(anyo));
         }
         columnList.add("Total Anual");
         Collections.sort(rutas);
         if(rowDataModel == null)
             rowDataModel = new ListDataModel(rutas);
         else
             rowDataModel.setWrappedData(rutas);
         if(columnDataModel == null)
             columnDataModel = new ListDataModel(columnList);
         else
            columnDataModel.setWrappedData(columnList);
         setGraphicData(rutas, tGenerales, "Cantidad de correspondencia expedida por rutas", "Rutas", "Cantidad");
         if(hashRutas.isEmpty())
            setVisible(Boolean.FALSE);
         else{
             setVisible(Boolean.TRUE);
             crearResourceRutas();
         }
     }
     /**
      * Se encarga de llenar los datos con la información obtenida de un mes específico
      * @param mes
      * Mes por el que se desea obtener la información
      * @param anyo
      * Año por el que se desea obtener la información
      */
     public void consultarRutasMes(int mes,int anyo){
         ArrayList lista = new ArrayList(correspondenciaInternaFacade.reporteRutas(mes,anyo));
         String mesString = integerToMonth(mes) + "/" + String.valueOf(anyo);
         Long totalMensual = 0L;
         if(lista != null){
             for(Object o : lista){
                 Object[] v = (Object[])o;
                 String rutaStr = "Ruta "+ v[0].toString();
                 Integer tr = Integer.parseInt(v[1].toString());
                 Long totalRuta = Math.round(tr * 0.3 + tr);
                 if(!rutas.contains(rutaStr)){
                         rutas.add(rutaStr);
                         hashRutas.put(rutaStr+"Total Anual",totalRuta);
                         tGenerales.put(rutaStr, totalRuta);
                 }else{
                         Long t = hashRutas.get(rutaStr+"Total Anual");
                         if(t != null){
                             t += totalRuta;
                            hashRutas.put(rutaStr+"Total Anual",t);
                            tGenerales.put(rutaStr, t);
                         }
                         
                 }
                 hashRutas.put(rutaStr+mesString,totalRuta);
                 totalMensual += totalRuta;
             }
             String etqMensual = "Total Mensual";
             if(!rutas.contains(etqMensual)){
                rutas.add(etqMensual);                
                hashRutas.put(etqMensual+"Total Anual",totalMensual);
                tGenerales.put(etqMensual, totalMensual);
             }else{
                 Long t = hashRutas.get(etqMensual+"Total Anual");
                 if(t != null){                   
                     t +=totalMensual;
                     hashRutas.put(etqMensual+"Total Anual",t);
                     tGenerales.put(etqMensual, t);
                 }
                
             }
             hashRutas.put(etqMensual+mesString,totalMensual);
             
         }
     }
     /**
      * Obtiene el valor de una entrada del HashTable,
      * que contenga el nombre de la columna y la fila como llave (key)
      * @return
      * El valor de la celda
      */
     public Object getRutaCellValue(){

         if (rowDataModel.isRowAvailable())
        {
          Object row = rowDataModel.getRowData();
          if (columnDataModel.isRowAvailable())
          {
            Object column = columnDataModel.getRowData();
            return hashRutas.get(row+column.toString());
          }
        }
        return null;
     }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Informe Ubicacion">
     /**
      * Genera los datos usuados por la tabla y el gráfico.
      * Se guardan en varios HashTable.
      */
     public  void generarInformeUbicacion(){
         hashEnvios.clear();
         hashEnviosCantidad.clear();
         rows.clear();
         rowDataModel = null;
         columnDataModel = null;
         ArrayList columnList = new ArrayList();
         rutas = new ArrayList<String>();
         for(int i=1;i<=12;i++){
             consultarUbicacion(i, anyo);
             columnList.add(integerToMonth(i) + "/" + String.valueOf(anyo));
         }
         columnList.add("Total Anual");
         Collections.sort(rows);
         if(rowDataModel == null)
             rowDataModel = new ListDataModel(rows);
         else
             rowDataModel.setWrappedData(rows);
         if(columnDataModel == null)
             columnDataModel = new ListDataModel(columnList);
         else{
            columnDataModel.setWrappedData(columnList);             
         }
         crearResourceExpedida();
         setGraphicData(rows, tGenerales,"Informe de envíos por ubicación","Grupo envío","Costo total");
     }
     /**
      * Genera la información de un mes específico
      * @param mes
      * Mes por el que se desea generar la información
      * @param anyo
      * Año por el que se desea generar la información
      */
     public void consultarUbicacion(int mes,int anyo){
         ArrayList lista = new ArrayList(correspondenciaExternaFacade.reporteGrupoEnvio(mes, anyo));
         String mesString = integerToMonth(mes) + "/" + String.valueOf(anyo);
         Integer totalMensualCantidad = 0;
         Double totalMensualCosto = 0.0;
         if(lista != null){
             for(Object o : lista){
                 Object[] v = (Object[])o;
                 String grupoStr = v[0].toString();
                 Integer cantidadGrupo = Integer.parseInt(v[1].toString());
                 Double costoGrupo = Double.parseDouble(v[2].toString());
                 if(!rows.contains(grupoStr)){
                         rows.add(grupoStr);
                         hashEnvios.put(grupoStr+"Total Anual",costoGrupo);
                         hashEnviosCantidad.put(grupoStr+"Total Anual", cantidadGrupo);
                         tGenerales.put(grupoStr, costoGrupo);
                 }else{
                         Integer c = (Integer)hashEnviosCantidad.get(grupoStr+"Total Anual");
                         Double costo = (Double)hashEnvios.get(grupoStr+"Total Anual");
                         if(c != null && costo != null){
                             c += cantidadGrupo;
                            hashEnviosCantidad.put(grupoStr+"Total Anual",c);
                            hashEnvios.put(grupoStr+"Total Anual",costo);
                            tGenerales.put(grupoStr, costo);
                         }

                 }
                 hashEnvios.put(grupoStr+mesString,costoGrupo);
                 hashEnviosCantidad.put(grupoStr+mesString, cantidadGrupo);
                 totalMensualCantidad += cantidadGrupo;
                 totalMensualCosto += costoGrupo;
             }
             String etqMensual = "Total Mensual";
             if(!rows.contains(etqMensual)){
                rows.add(etqMensual);
                hashEnvios.put(etqMensual+"Total Anual", totalMensualCosto);
                hashEnviosCantidad.put(etqMensual+"Total Anual", totalMensualCantidad);
                tGenerales.put(etqMensual, totalMensualCosto);
             }else{
                 Integer t = (Integer)hashEnviosCantidad.get(etqMensual+"Total Anual");
                 Double costo = (Double)hashEnvios.get(etqMensual+"Total Anual");
                 if(t != null & costo != null){
                     t += totalMensualCantidad;
                     costo += totalMensualCosto;
                     hashEnviosCantidad.put(etqMensual+"Total Anual",t);
                     hashEnvios.put(etqMensual+"Total Anual", costo);
                     tGenerales.put(etqMensual, costo);
                 }

             }
             hashEnviosCantidad.put(etqMensual+mesString,totalMensualCantidad);
             hashEnvios.put(etqMensual+mesString, totalMensualCosto);
         }
     }
     /**
      * Obtiene el valor de una celda dato un HashTable.
      * La información debe tener como llave(key) el nombre de la fila + el nombre de la columna
      * @param hash
      * El HashTable de donde se obtendra el valor
      * @return
      * El valor de la celda
      */
     public Object getCellValue(Hashtable hash){

         if (rowDataModel.isRowAvailable())
        {
          Object row = rowDataModel.getRowData();
          if (columnDataModel.isRowAvailable())
          {
            Object column = columnDataModel.getRowData();
            return hash.get(row+column.toString());
          }
        }
        return null;
     }
     /**
      * Obtiene el valor de una celda para la tabla de Cantidad de envíos por Grupo
      * @return
      * El valor de la celda
      */
     public Integer getCantidadGrupoCellValue(){
         return (Integer)getCellValue(hashEnviosCantidad);
     }
     /**
      * Obtiene el valor de una celda para la tabla de Costos de envíos por Grupo
      * @return
      * El valor de la celda
      */
     public Double getCostoGrupoCellValue(){
         return (Double)getCellValue(hashEnvios);
     }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Manejo del Grafico">
     /**
      * Coloca los valores en las estructuras de datos que necesitan los gráficos para generarse
      * @param rows
      * Los nombres de la filas
      * @param hash
      * HashTable con los datos que requiere el gráfico
      * @param title
      * Titulo del gráfico
      * @param xlabel
      * Nombre de la etiqueta del eje x
      * @param ylabel
      * Nombre de la etiqueta del eje y
      */
     private void setGraphicData(ArrayList<String> rows,Hashtable hash,String title,String xlabel,String ylabel){
        
        rows.remove(rows.get(rows.size() - 1));
        xLabels = rows;
        data = new double[1][1];
        data[0] = new double[rows.size()];
        int i = 0;
        for(String s : rows){           
            Double d = Double.parseDouble(hash.get(s).toString());
            data[0][i] = d;
            i++;
        }
            
        setTitle(title);
        setXlabel(xlabel);
        setYlabel(ylabel);
        setVisible(Boolean.TRUE);
     }
     //</editor-fold>

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validaciones">
    /**
     * Valida que el año ingresado sea correcto y no mayor al año actual
     * @param context
     * @param validate
     * @param value
     */
     public void validate_year(FacesContext context, UIComponent validate,Object value) {
        Integer year = (Integer) value;
        Integer currentYear = new Date().getYear() + 1900;
        if (year < 1900 || year > currentYear) {
            FacesMessage msg = new FacesMessage("El año debe ser un valor entre 1900 y " + currentYear);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(validate.getClientId(context), msg);
            setVisible(Boolean.FALSE);
        }
     }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    public int getAnyo() {        
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

     public double[][] getData() {
        return data;
    }

    public void setData(double[][]  data) {
        this.data = data;
    }

    public ArrayList getxLabels() {
        return xLabels;
    }

    public void setxLabels(ArrayList xLabels) {
        this.xLabels = xLabels;
    }

    public String getXlabel() {
        return xlabel;
    }

    public void setXlabel(String xlabel) {
        this.xlabel = xlabel;
    }

    public String getYlabel() {
        return ylabel;
    }

    public void setYlabel(String ylabel) {
        this.ylabel = ylabel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public DataModel getRowDataModel() {
        return rowDataModel;
    }

    public void setRowDataModel(DataModel rowDataModel) {
        this.rowDataModel = rowDataModel;
    }

    public DataModel getColumnDataModel() {
        return columnDataModel;
    }

    public void setColumnDataModel(DataModel columnDataModel) {
        this.columnDataModel = columnDataModel;
    }

    public Boolean getVisible() {
        seguridad();
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }



     //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Resources">
    
    public void crearResourceRutas(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            String nombreArchivo = "reporteRutas";
            try{

                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }           

            controlR.reporteRutas(anyo, nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            resourceRutas = new FileResource(archivo);
        }
        catch(Exception e){            
        }        
    }
    
    public void crearResourceExpedida(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            String nombreArchivo = "reporteExpedida";
            try{
                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }

            controlR.reporteExpedida(anyo, nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            resourceExpedida = new FileResource(archivo);
        }
        catch(Exception e){
        }
    }
    
    public void crearResourceUbicacion(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            String nombreArchivo = "reporteUbicacion";
            try{
                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }

            controlR.reporteUbicacion(anyo, nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            resourceUbicacion = new FileResource(archivo);
        }
        catch(Exception e){
        }
    }
    
    public void crearResourcePeso(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            String nombreArchivo = "reportePeso";
            try{
                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }

            controlR.reportePeso(anyo, nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            resourcePeso = new FileResource(archivo);
        }
        catch(Exception e){
        }
    }

    public void crearResourceGastos(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try{
            String nombreArchivo = "reporteGastos";
            try{
                File borrar = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
                borrar.delete();
            }
            catch(Exception e){
            }

            controlR.reporteGastos(fechaInicial, fechaFinal, nombreArchivo);

            File archivo = new File(facesContext.getExternalContext().getInitParameter("direccionGuardar") + nombreArchivo + ".pdf");
            resourceGastos = new FileResource(archivo);
        }
        catch(Exception e){
        }
    }

    public Resource getResourceExpedida() {
        return resourceExpedida;
    }

    public Resource getResourceGastos() {
        return resourceGastos;
    }

    public Resource getResourceRutas() {        
        return resourceRutas;
    }

    public Resource getResourcePeso(){
        return resourcePeso;
    }

    public Resource getResourceUbicacion() {
        return resourceUbicacion;
    }

    private Resource resourceRutas;
    private Resource resourceExpedida;
    private Resource resourceUbicacion;
    private Resource resourcePeso;
    private Resource resourceGastos;
    private Reporte controlR;
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private int  anyo  ;
    private String ruta;
    private String[] tipos;
    private int mes;
    private int mesFinal;
    private int anyoFinal;
    private double total;
    private double[][] data = new double[1][1];
    private ArrayList xLabels = new ArrayList();
    private String xlabel = "No hay información";;
    private String ylabel = "No hay información";
    private String title = "No hay información";
    private Date fechaInicial;
    private Date fechaFinal;
    private Hashtable<String,Double> filas = new Hashtable<String, Double>();

    private DataModel rowDataModel;
    private DataModel columnDataModel;
    private Hashtable<String,Long> hashRutas = new Hashtable<String, Long>();
    ArrayList<String> rutas = new ArrayList<String>();

    private Hashtable<String,Object> hashEnvios = new Hashtable<String, Object>();
    private Hashtable<String,Object> hashEnviosCantidad = new Hashtable<String, Object>();
    private ArrayList<String> rows = new ArrayList<String>();
    private Hashtable<String,Object> tGenerales = new Hashtable<String, Object>();

    private Hashtable<String,Object> hash1 = new Hashtable<String, Object>();

    private Boolean visible = false;
    private String codigoPermiso = "12";

    //</editor-fold>

}
