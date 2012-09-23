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
@Table(name = "pais")
@NamedQueries({@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"), @NamedQuery(name = "Pais.findByCodigo", query = "SELECT p FROM Pais p WHERE p.codigo = :codigo"), @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "codigo_grupo_envio", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private GrupoEnvio codigoGrupoEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private Collection<CorrespondenciaExterna> correspondenciaExternaCollection;

    public Pais() {
    }

    public Pais(String codigo) {
        this.codigo = codigo;
    }

    public Pais(String codigo, String nombre) {
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

    public GrupoEnvio getCodigoGrupoEnvio() {
        return codigoGrupoEnvio;
    }

    public void setCodigoGrupoEnvio(GrupoEnvio codigoGrupoEnvio) {
        this.codigoGrupoEnvio = codigoGrupoEnvio;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Pais[codigo=" + codigo + "]";
    }

}
