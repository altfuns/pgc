/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author red
 */
@Entity
@Table(name = "tarifa")
@NamedQueries({@NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t"), @NamedQuery(name = "Tarifa.findByCodigo", query = "SELECT t FROM Tarifa t WHERE t.codigo = :codigo"), @NamedQuery(name = "Tarifa.findByPesoInicio", query = "SELECT t FROM Tarifa t WHERE t.pesoInicio = :pesoInicio"), @NamedQuery(name = "Tarifa.findByPesoFinal", query = "SELECT t FROM Tarifa t WHERE t.pesoFinal = :pesoFinal"), @NamedQuery(name = "Tarifa.findByPrecio", query = "SELECT t FROM Tarifa t WHERE t.precio = :precio")})
public class Tarifa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "peso_inicio")
    private double pesoInicio;
    @Basic(optional = false)
    @Column(name = "peso_final")
    private double pesoFinal;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "codigo_grupo_envio", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private GrupoEnvio codigoGrupoEnvio;
    @JoinColumn(name = "tipo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private TipoEnvio tipo;

    public Tarifa() {
    }

    public Tarifa(Integer codigo) {
        this.codigo = codigo;
    }

    public Tarifa(Integer codigo, double pesoInicio, double pesoFinal, double precio) {
        this.codigo = codigo;
        this.pesoInicio = pesoInicio;
        this.pesoFinal = pesoFinal;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getPesoInicio() {
        return pesoInicio;
    }

    public void setPesoInicio(double pesoInicio) {
        this.pesoInicio = pesoInicio;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public GrupoEnvio getCodigoGrupoEnvio() {
        return codigoGrupoEnvio;
    }

    public void setCodigoGrupoEnvio(GrupoEnvio codigoGrupoEnvio) {
        this.codigoGrupoEnvio = codigoGrupoEnvio;
    }

    public TipoEnvio getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnvio tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.cgi.pgc.entity.Tarifa[codigo=" + codigo + "]";
    }

}
