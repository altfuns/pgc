/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author red
 */
@Entity
@Table(name = "presupuesto")
@NamedQueries({@NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"), @NamedQuery(name = "Presupuesto.findByCodigo", query = "SELECT p FROM Presupuesto p WHERE p.codigo = :codigo"), @NamedQuery(name = "Presupuesto.findByTitulo", query = "SELECT p FROM Presupuesto p WHERE p.titulo = :titulo"), @NamedQuery(name = "Presupuesto.findByMonto", query = "SELECT p FROM Presupuesto p WHERE p.monto = :monto")})
public class Presupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "monto")
    private Double monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPresupuesto")
    private Collection<MovimientoPresupuesto> movimientoPresupuestoCollection;

    public Presupuesto() {
    }

    public Presupuesto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Collection<MovimientoPresupuesto> getMovimientoPresupuestoCollection() {
        return movimientoPresupuestoCollection;
    }

    public void setMovimientoPresupuestoCollection(Collection<MovimientoPresupuesto> movimientoPresupuestoCollection) {
        this.movimientoPresupuestoCollection = movimientoPresupuestoCollection;
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
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Presupuesto[codigo=" + codigo + "]";
    }

}
