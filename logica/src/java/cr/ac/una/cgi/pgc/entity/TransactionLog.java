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
@Table(name = "transaction_log")
@NamedQueries({@NamedQuery(name = "TransactionLog.findAll", query = "SELECT t FROM TransactionLog t"), @NamedQuery(name = "TransactionLog.findByCodigo", query = "SELECT t FROM TransactionLog t WHERE t.codigo = :codigo"), @NamedQuery(name = "TransactionLog.findByFecha", query = "SELECT t FROM TransactionLog t WHERE t.fecha = :fecha"), @NamedQuery(name = "TransactionLog.findByNombreTabla", query = "SELECT t FROM TransactionLog t WHERE t.nombreTabla = :nombreTabla"), @NamedQuery(name = "TransactionLog.findByConsulta", query = "SELECT t FROM TransactionLog t WHERE t.consulta = :consulta")})
public class TransactionLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "nombre_tabla")
    private String nombreTabla;
    @Column(name = "consulta")
    private String consulta;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    @ManyToOne
    private Empleado idEmpleado;

    public TransactionLog() {
    }

    public TransactionLog(Integer codigo) {
        this.codigo = codigo;
    }

    public TransactionLog(Integer codigo, Date fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        if (!(object instanceof TransactionLog)) {
            return false;
        }
        TransactionLog other = (TransactionLog) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.TransactionLog[codigo=" + codigo + "]";
    }

}
