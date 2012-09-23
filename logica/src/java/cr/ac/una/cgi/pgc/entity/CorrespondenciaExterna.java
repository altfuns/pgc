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
@Table(name = "correspondencia_externa")
@NamedQueries({@NamedQuery(name = "CorrespondenciaExterna.findAll", query = "SELECT c FROM CorrespondenciaExterna c"), @NamedQuery(name = "CorrespondenciaExterna.findByIdentificador", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.identificador = :identificador"), @NamedQuery(name = "CorrespondenciaExterna.findByCodigo", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.codigo = :codigo"), @NamedQuery(name = "CorrespondenciaExterna.findByFecha", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.fecha = :fecha"), @NamedQuery(name = "CorrespondenciaExterna.findByPeso", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.peso = :peso"), @NamedQuery(name = "CorrespondenciaExterna.findByPrecio", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.precio = :precio"), @NamedQuery(name = "CorrespondenciaExterna.findByDireccion", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.direccion = :direccion"), @NamedQuery(name = "CorrespondenciaExterna.findByDestinatario", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.destinatario = :destinatario"), @NamedQuery(name = "CorrespondenciaExterna.findByRemitente", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.remitente = :remitente"), @NamedQuery(name = "CorrespondenciaExterna.findByCantidad", query = "SELECT c FROM CorrespondenciaExterna c WHERE c.cantidad = :cantidad")})
public class CorrespondenciaExterna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificador")
    private Integer identificador;
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "destinatario")
    private String destinatario;
    @Column(name = "remitente")
    private String remitente;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "factura", referencedColumnName = "numero")
    @ManyToOne
    private Factura factura;
    @JoinColumn(name = "pais", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumn(name = "tipo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private TipoEnvio tipo;
    @JoinColumn(name = "unidad", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Unidad unidad;

    public CorrespondenciaExterna() {
    }

    public CorrespondenciaExterna(Integer identificador) {
        this.identificador = identificador;
    }

    public CorrespondenciaExterna(Integer identificador, Date fecha, double peso, double precio, int cantidad) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.peso = peso;
        this.precio = precio;
        this.cantidad = cantidad;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public TipoEnvio getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnvio tipo) {
        this.tipo = tipo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
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
        if (!(object instanceof CorrespondenciaExterna)) {
            return false;
        }
        CorrespondenciaExterna other = (CorrespondenciaExterna) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.CorrespondenciaExterna[identificador=" + identificador + "]";
    }

}
