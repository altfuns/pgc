/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author red
 */
@Entity
@Table(name = "factura")
@NamedQueries({@NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"), @NamedQuery(name = "Factura.findByNumero", query = "SELECT f FROM Factura f WHERE f.numero = :numero"), @NamedQuery(name = "Factura.findByMonto", query = "SELECT f FROM Factura f WHERE f.monto = :monto"), @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"), @NamedQuery(name = "Factura.findByNumeroOrden", query = "SELECT f FROM Factura f WHERE f.numeroOrden = :numeroOrden")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "numero_orden")
    private String numeroOrden;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFactura")
    private Collection<Nota> notaCollection;
    @OneToMany(mappedBy = "factura")
    private Collection<CorrespondenciaExterna> correspondenciaExternaCollection;

    public Factura() {
    }

    public Factura(String numero) {
        this.numero = numero;
    }

    public Factura(String numero, double monto, Date fecha, String numeroOrden) {
        this.numero = numero;
        this.monto = monto;
        this.fecha = fecha;
        this.numeroOrden = numeroOrden;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

    public Collection<CorrespondenciaExterna> getCorrespondenciaExternaCollection() {
        return correspondenciaExternaCollection;
    }

    public void setCorrespondenciaExternaCollection(Collection<CorrespondenciaExterna> correspondenciaExternaCollection) {
        this.correspondenciaExternaCollection = correspondenciaExternaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Factura[numero=" + numero + "]";
    }

}
