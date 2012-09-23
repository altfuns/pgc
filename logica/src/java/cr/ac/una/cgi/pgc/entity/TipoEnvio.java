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
@Table(name = "tipo_envio")
@NamedQueries({@NamedQuery(name = "TipoEnvio.findAll", query = "SELECT t FROM TipoEnvio t"), @NamedQuery(name = "TipoEnvio.findByCodigo", query = "SELECT t FROM TipoEnvio t WHERE t.codigo = :codigo"), @NamedQuery(name = "TipoEnvio.findByNombre", query = "SELECT t FROM TipoEnvio t WHERE t.nombre = :nombre")})
public class TipoEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<CorrespondenciaExterna> correspondenciaExternaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<Tarifa> tarifaCollection;

    public TipoEnvio() {
    }

    public TipoEnvio(String codigo) {
        this.codigo = codigo;
    }

    public TipoEnvio(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public Collection<CorrespondenciaExterna> getCorrespondenciaExternaCollection() {
        return correspondenciaExternaCollection;
    }

    public void setCorrespondenciaExternaCollection(Collection<CorrespondenciaExterna> correspondenciaExternaCollection) {
        this.correspondenciaExternaCollection = correspondenciaExternaCollection;
    }

    public Collection<Tarifa> getTarifaCollection() {
        return tarifaCollection;
    }

    public void setTarifaCollection(Collection<Tarifa> tarifaCollection) {
        this.tarifaCollection = tarifaCollection;
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
        if (!(object instanceof TipoEnvio)) {
            return false;
        }
        TipoEnvio other = (TipoEnvio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.TipoEnvio[codigo=" + codigo + "]";
    }

}
