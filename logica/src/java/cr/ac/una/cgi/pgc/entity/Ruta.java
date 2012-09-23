/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ruta")
@NamedQueries({@NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"), @NamedQuery(name = "Ruta.findByNumero", query = "SELECT r FROM Ruta r WHERE r.numero = :numero"), @NamedQuery(name = "Ruta.findByFecha", query = "SELECT r FROM Ruta r WHERE r.fecha = :fecha"), @NamedQuery(name = "Ruta.findByInterna", query = "SELECT r FROM Ruta r WHERE r.interna = :interna")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "interna")
    private boolean interna;
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    @ManyToOne
    private Empleado empleadoId;
    @OneToMany(mappedBy = "rutaAsignada")
    private Collection<CorrespondenciaInterna> correspondenciaInternaCollection;
    @OneToMany(mappedBy = "numeroRuta")
    private Collection<Unidad> unidadCollection;

    public Ruta() {
    }

    public Ruta(String numero) {
        this.numero = numero;
    }

    public Ruta(String numero, Date fecha, boolean interna) {
        this.numero = numero;
        this.fecha = fecha;
        this.interna = interna;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getInterna() {
        return interna;
    }

    public void setInterna(boolean interna) {
        this.interna = interna;
    }

    public Empleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Empleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    public Collection<CorrespondenciaInterna> getCorrespondenciaInternaCollection() {
        return correspondenciaInternaCollection;
    }

    public void setCorrespondenciaInternaCollection(Collection<CorrespondenciaInterna> correspondenciaInternaCollection) {
        this.correspondenciaInternaCollection = correspondenciaInternaCollection;
    }

    public Collection<Unidad> getUnidadCollection() {
        return unidadCollection;
    }

    public void setUnidadCollection(Collection<Unidad> unidadCollection) {
        this.unidadCollection = unidadCollection;
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
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Ruta[numero=" + numero + "]";
    }

}
