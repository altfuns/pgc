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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "empleado")
@NamedQueries({@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"), @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"), @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"), @NamedQuery(name = "Empleado.findByMiddleName", query = "SELECT e FROM Empleado e WHERE e.middleName = :middleName"), @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"), @NamedQuery(name = "Empleado.findByActivo", query = "SELECT e FROM Empleado e WHERE e.activo = :activo")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinTable(name = "empleado_permisos", joinColumns = {@JoinColumn(name = "id_empleado", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "codigo_permiso", referencedColumnName = "codigo")})
    @ManyToMany
    private Collection<Permiso> permisoCollection;
    @JoinColumn(name = "tipo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Rol tipo;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<ErrorLog> errorLogCollection;
    @OneToMany(mappedBy = "empleadoId")
    private Collection<Ruta> rutaCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<TransactionLog> transactionLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecibeEmpleado")
    private Collection<CorrespondenciaInterna> correspondenciaInternaCollection;
    @OneToMany(mappedBy = "idEntregaEmpleado")
    private Collection<CorrespondenciaInterna> correspondenciaInternaCollection1;

    public Empleado() {
    }

    public Empleado(String id) {
        this.id = id;
    }

    public Empleado(String id, String nombre, String apellidos, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.activo = activo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Collection<Permiso> getPermisoCollection() {
        return permisoCollection;
    }

    public void setPermisoCollection(Collection<Permiso> permisoCollection) {
        this.permisoCollection = permisoCollection;
    }

    public Rol getTipo() {
        return tipo;
    }

    public void setTipo(Rol tipo) {
        this.tipo = tipo;
    }

    public Collection<ErrorLog> getErrorLogCollection() {
        return errorLogCollection;
    }

    public void setErrorLogCollection(Collection<ErrorLog> errorLogCollection) {
        this.errorLogCollection = errorLogCollection;
    }

    public Collection<Ruta> getRutaCollection() {
        return rutaCollection;
    }

    public void setRutaCollection(Collection<Ruta> rutaCollection) {
        this.rutaCollection = rutaCollection;
    }

    public Collection<TransactionLog> getTransactionLogCollection() {
        return transactionLogCollection;
    }

    public void setTransactionLogCollection(Collection<TransactionLog> transactionLogCollection) {
        this.transactionLogCollection = transactionLogCollection;
    }

    public Collection<CorrespondenciaInterna> getCorrespondenciaInternaCollection() {
        return correspondenciaInternaCollection;
    }

    public void setCorrespondenciaInternaCollection(Collection<CorrespondenciaInterna> correspondenciaInternaCollection) {
        this.correspondenciaInternaCollection = correspondenciaInternaCollection;
    }

    public Collection<CorrespondenciaInterna> getCorrespondenciaInternaCollection1() {
        return correspondenciaInternaCollection1;
    }

    public void setCorrespondenciaInternaCollection1(Collection<CorrespondenciaInterna> correspondenciaInternaCollection1) {
        this.correspondenciaInternaCollection1 = correspondenciaInternaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Empleado[id=" + id + "]";
    }

}
