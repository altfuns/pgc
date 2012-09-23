/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author red
 */
@Entity
@Table(name = "permiso")
@NamedQueries({@NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"), @NamedQuery(name = "Permiso.findByCodigo", query = "SELECT p FROM Permiso p WHERE p.codigo = :codigo"), @NamedQuery(name = "Permiso.findByDireccion", query = "SELECT p FROM Permiso p WHERE p.direccion = :direccion"), @NamedQuery(name = "Permiso.findByDescripcion", query = "SELECT p FROM Permiso p WHERE p.descripcion = :descripcion"), @NamedQuery(name = "Permiso.findByModulo", query = "SELECT p FROM Permiso p WHERE p.modulo = :modulo")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "modulo")
    private String modulo;
    @JoinTable(name = "rol_permisos", joinColumns = {@JoinColumn(name = "codigo_permiso", referencedColumnName = "codigo")}, inverseJoinColumns = {@JoinColumn(name = "codigo_rol", referencedColumnName = "codigo")})
    @ManyToMany
    private Collection<Rol> rolCollection;
    @ManyToMany(mappedBy = "permisoCollection")
    private Collection<Empleado> empleadoCollection;

    public Permiso() {
    }

    public Permiso(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
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
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Permiso[codigo=" + codigo + "]";
    }

}
