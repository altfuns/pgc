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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author red
 */
@Entity
@Table(name = "unidad")
@NamedQueries({@NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"), @NamedQuery(name = "Unidad.findByCodigo", query = "SELECT u FROM Unidad u WHERE u.codigo = :codigo"), @NamedQuery(name = "Unidad.findByNombre", query = "SELECT u FROM Unidad u WHERE u.nombre = :nombre"), @NamedQuery(name = "Unidad.findByAcron", query = "SELECT u FROM Unidad u WHERE u.acron = :acron"), @NamedQuery(name = "Unidad.findByTipo", query = "SELECT u FROM Unidad u WHERE u.tipo = :tipo")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "acron")
    private String acron;
    @Column(name = "tipo")
    private Integer tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private Collection<CorrespondenciaExterna> correspondenciaExternaCollection;
    @JoinColumn(name = "numero_ruta", referencedColumnName = "numero")
    @ManyToOne
    private Ruta numeroRuta;

    public Unidad() {
    }

    public Unidad(String codigo) {
        this.codigo = codigo;
    }

    public Unidad(String codigo, String nombre, String acron) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acron = acron;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcron() {
        return acron;
    }

    public void setAcron(String acron) {
        this.acron = acron;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Collection<CorrespondenciaExterna> getCorrespondenciaExternaCollection() {
        return correspondenciaExternaCollection;
    }

    public void setCorrespondenciaExternaCollection(Collection<CorrespondenciaExterna> correspondenciaExternaCollection) {
        this.correspondenciaExternaCollection = correspondenciaExternaCollection;
    }

    public Ruta getNumeroRuta() {
        return numeroRuta;
    }

    public void setNumeroRuta(Ruta numeroRuta) {
        this.numeroRuta = numeroRuta;
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
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Unidad[codigo=" + codigo + "]";
    }

}
