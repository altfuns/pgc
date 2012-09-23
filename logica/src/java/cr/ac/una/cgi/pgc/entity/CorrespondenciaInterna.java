/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author red
 */
@Entity
@Table(name = "correspondencia_interna")
@NamedQueries({@NamedQuery(name = "CorrespondenciaInterna.findAll", query = "SELECT c FROM CorrespondenciaInterna c"), @NamedQuery(name = "CorrespondenciaInterna.findByIdentificador", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.identificador = :identificador"), @NamedQuery(name = "CorrespondenciaInterna.findByCodigo", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.codigo = :codigo"), @NamedQuery(name = "CorrespondenciaInterna.findByFechaEntregaMensajero", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.fechaEntregaMensajero = :fechaEntregaMensajero"), @NamedQuery(name = "CorrespondenciaInterna.findByProcedenciaUnidad", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.procedenciaUnidad = :procedenciaUnidad"), @NamedQuery(name = "CorrespondenciaInterna.findByDestinoUnidad", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.destinoUnidad = :destinoUnidad"), @NamedQuery(name = "CorrespondenciaInterna.findByFechaRecibido", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.fechaRecibido = :fechaRecibido"), @NamedQuery(name = "CorrespondenciaInterna.findByNombreRecibido", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.nombreRecibido = :nombreRecibido"), @NamedQuery(name = "CorrespondenciaInterna.findByDestinatario", query = "SELECT c FROM CorrespondenciaInterna c WHERE c.destinatario = :destinatario")})
public class CorrespondenciaInterna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "fecha_entrega_mensajero")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaMensajero;
    @Basic(optional = false)
    @Column(name = "procedencia_unidad")
    private String procedenciaUnidad;
    @Basic(optional = false)
    @Column(name = "destino_unidad")
    private String destinoUnidad;
    @Column(name = "fecha_recibido")
    @Temporal(TemporalType.DATE)
    private Date fechaRecibido;
    @Column(name = "nombre_recibido")
    private String nombreRecibido;
    @Column(name = "destinatario")
    private String destinatario;
    @JoinColumn(name = "id_recibe_empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado idRecibeEmpleado;
    @JoinColumn(name = "id_entrega_empleado", referencedColumnName = "id")
    @ManyToOne
    private Empleado idEntregaEmpleado;
    @JoinColumn(name = "ruta_asignada", referencedColumnName = "numero")
    @ManyToOne
    private Ruta rutaAsignada;
    @JoinColumn(name = "tipo", referencedColumnName = "acron")
    @ManyToOne(optional = false)
    private TipoInterno tipo;

    public CorrespondenciaInterna() {
    }

    public CorrespondenciaInterna(Integer identificador) {
        this.identificador = identificador;
    }

    public CorrespondenciaInterna(Integer identificador, Date fechaEntregaMensajero, String procedenciaUnidad, String destinoUnidad) {
        this.identificador = identificador;
        this.fechaEntregaMensajero = fechaEntregaMensajero;
        this.procedenciaUnidad = procedenciaUnidad;
        this.destinoUnidad = destinoUnidad;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEntregaMensajero() {
        return fechaEntregaMensajero;
    }

    public void setFechaEntregaMensajero(Date fechaEntregaMensajero) {
        this.fechaEntregaMensajero = fechaEntregaMensajero;
    }

    public String getProcedenciaUnidad() {
        return procedenciaUnidad;
    }

    public void setProcedenciaUnidad(String procedenciaUnidad) {
        this.procedenciaUnidad = procedenciaUnidad;
    }

    public String getDestinoUnidad() {
        return destinoUnidad;
    }

    public void setDestinoUnidad(String destinoUnidad) {
        this.destinoUnidad = destinoUnidad;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getNombreRecibido() {
        return nombreRecibido;
    }

    public void setNombreRecibido(String nombreRecibido) {
        this.nombreRecibido = nombreRecibido;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Empleado getIdRecibeEmpleado() {
        return idRecibeEmpleado;
    }

    public void setIdRecibeEmpleado(Empleado idRecibeEmpleado) {
        this.idRecibeEmpleado = idRecibeEmpleado;
    }

    public Empleado getIdEntregaEmpleado() {
        return idEntregaEmpleado;
    }

    public void setIdEntregaEmpleado(Empleado idEntregaEmpleado) {
        this.idEntregaEmpleado = idEntregaEmpleado;
    }

    public Ruta getRutaAsignada() {
        return rutaAsignada;
    }

    public void setRutaAsignada(Ruta rutaAsignada) {
        this.rutaAsignada = rutaAsignada;
    }

    public TipoInterno getTipo() {
        return tipo;
    }

    public void setTipo(TipoInterno tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorrespondenciaInterna)) {
            return false;
        }
        CorrespondenciaInterna other = (CorrespondenciaInterna) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.CorrespondenciaInterna[identificador=" + identificador + "]";
    }

}
