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
@Table(name = "tipo_interno")
@NamedQueries({@NamedQuery(name = "TipoInterno.findAll", query = "SELECT t FROM TipoInterno t"), @NamedQuery(name = "TipoInterno.findByAcron", query = "SELECT t FROM TipoInterno t WHERE t.acron = :acron"), @NamedQuery(name = "TipoInterno.findByDescripcion", query = "SELECT t FROM TipoInterno t WHERE t.descripcion = :descripcion")})
public class TipoInterno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acron")
    private String acron;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<CorrespondenciaInterna> correspondenciaInternaCollection;

    public TipoInterno() {
    }

    public TipoInterno(String acron) {
        this.acron = acron;
    }

    public TipoInterno(String acron, String descripcion) {
        this.acron = acron;
        this.descripcion = descripcion;
    }

    public String getAcron() {
        return acron;
    }

    public void setAcron(String acron) {
        this.acron = acron;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<CorrespondenciaInterna> getCorrespondenciaInternaCollection() {
        return correspondenciaInternaCollection;
    }

    public void setCorrespondenciaInternaCollection(Collection<CorrespondenciaInterna> correspondenciaInternaCollection) {
        this.correspondenciaInternaCollection = correspondenciaInternaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acron != null ? acron.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInterno)) {
            return false;
        }
        TipoInterno other = (TipoInterno) object;
        if ((this.acron == null && other.acron != null) || (this.acron != null && !this.acron.equals(other.acron))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.TipoInterno[acron=" + acron + "]";
    }

}
