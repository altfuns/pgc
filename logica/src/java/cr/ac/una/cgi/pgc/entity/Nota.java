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
@Table(name = "nota")
@NamedQueries({@NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"), @NamedQuery(name = "Nota.findByNumero", query = "SELECT n FROM Nota n WHERE n.numero = :numero"), @NamedQuery(name = "Nota.findByMonto", query = "SELECT n FROM Nota n WHERE n.monto = :monto"), @NamedQuery(name = "Nota.findByFecha", query = "SELECT n FROM Nota n WHERE n.fecha = :fecha"), @NamedQuery(name = "Nota.findByTipo", query = "SELECT n FROM Nota n WHERE n.tipo = :tipo")})
public class Nota implements Serializable {
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
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name = "numero_factura", referencedColumnName = "numero")
    @ManyToOne(optional = false)
    private Factura numeroFactura;

    public Nota() {
    }

    public Nota(String numero) {
        this.numero = numero;
    }

    public Nota(String numero, double monto, Date fecha, int tipo) {
        this.numero = numero;
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Factura getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Factura numeroFactura) {
        this.numeroFactura = numeroFactura;
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
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Nota[numero=" + numero + "]";
    }

}
