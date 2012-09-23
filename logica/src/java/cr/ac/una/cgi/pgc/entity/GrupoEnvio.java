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
@Table(name = "grupo_envio")
@NamedQueries({@NamedQuery(name = "GrupoEnvio.findAll", query = "SELECT g FROM GrupoEnvio g"), @NamedQuery(name = "GrupoEnvio.findByCodigo", query = "SELECT g FROM GrupoEnvio g WHERE g.codigo = :codigo"), @NamedQuery(name = "GrupoEnvio.findByNombre", query = "SELECT g FROM GrupoEnvio g WHERE g.nombre = :nombre")})
public class GrupoEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoGrupoEnvio")
    private Collection<Pais> paisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoGrupoEnvio")
    private Collection<Tarifa> tarifaCollection;

    public GrupoEnvio() {
    }

    public GrupoEnvio(String codigo) {
        this.codigo = codigo;
    }

    public GrupoEnvio(String codigo, String nombre) {
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

    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
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
        if (!(object instanceof GrupoEnvio)) {
            return false;
        }
        GrupoEnvio other = (GrupoEnvio) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.GrupoEnvio[codigo=" + codigo + "]";
    }

}
