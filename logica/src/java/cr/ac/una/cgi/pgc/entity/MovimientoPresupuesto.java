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
@Table(name = "movimiento_presupuesto")
@NamedQueries({@NamedQuery(name = "MovimientoPresupuesto.findAll", query = "SELECT m FROM MovimientoPresupuesto m"), @NamedQuery(name = "MovimientoPresupuesto.findByCodigo", query = "SELECT m FROM MovimientoPresupuesto m WHERE m.codigo = :codigo"), @NamedQuery(name = "MovimientoPresupuesto.findByFecha", query = "SELECT m FROM MovimientoPresupuesto m WHERE m.fecha = :fecha"), @NamedQuery(name = "MovimientoPresupuesto.findByNumeroDeposito", query = "SELECT m FROM MovimientoPresupuesto m WHERE m.numeroDeposito = :numeroDeposito"), @NamedQuery(name = "MovimientoPresupuesto.findByNumeroCheque", query = "SELECT m FROM MovimientoPresupuesto m WHERE m.numeroCheque = :numeroCheque"), @NamedQuery(name = "MovimientoPresupuesto.findByImporte", query = "SELECT m FROM MovimientoPresupuesto m WHERE m.importe = :importe")})
public class MovimientoPresupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "numero_deposito")
    private String numeroDeposito;
    @Column(name = "numero_cheque")
    private String numeroCheque;
    @Basic(optional = false)
    @Column(name = "importe")
    private double importe;
    @JoinColumn(name = "codigo_presupuesto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Presupuesto codigoPresupuesto;

    public MovimientoPresupuesto() {
    }

    public MovimientoPresupuesto(String codigo) {
        this.codigo = codigo;
    }

    public MovimientoPresupuesto(String codigo, Date fecha, double importe) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.importe = importe;
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

    public String getNumeroDeposito() {
        return numeroDeposito;
    }

    public void setNumeroDeposito(String numeroDeposito) {
        this.numeroDeposito = numeroDeposito;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Presupuesto getCodigoPresupuesto() {
        return codigoPresupuesto;
    }

    public void setCodigoPresupuesto(Presupuesto codigoPresupuesto) {
        this.codigoPresupuesto = codigoPresupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoPresupuesto)) {
            return false;
        }
        MovimientoPresupuesto other = (MovimientoPresupuesto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.MovimientoPresupuesto[codigo=" + codigo + "]";
    }

}
