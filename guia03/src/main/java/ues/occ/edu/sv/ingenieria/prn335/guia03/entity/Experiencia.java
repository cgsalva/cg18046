/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.ingenieria.prn335.guia03.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ascg
 */
@Entity
@Table(name = "experiencia", catalog = "bolsa_trabajo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Experiencia.findAll", query = "SELECT e FROM Experiencia e"),
    @NamedQuery(name = "Experiencia.findByIdExperiencia", query = "SELECT e FROM Experiencia e WHERE e.idExperiencia = :idExperiencia"),
    @NamedQuery(name = "Experiencia.findByInstitucion", query = "SELECT e FROM Experiencia e WHERE e.institucion = :institucion"),
    @NamedQuery(name = "Experiencia.findByFechaDesde", query = "SELECT e FROM Experiencia e WHERE e.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "Experiencia.findByFechaHasta", query = "SELECT e FROM Experiencia e WHERE e.fechaHasta = :fechaHasta"),
    @NamedQuery(name = "Experiencia.findByPosicionLaboral", query = "SELECT e FROM Experiencia e WHERE e.posicionLaboral = :posicionLaboral"),
    @NamedQuery(name = "Experiencia.findByReferencia", query = "SELECT e FROM Experiencia e WHERE e.referencia = :referencia")})
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_experiencia", nullable = false)
    private Long idExperiencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "institucion", nullable = false, length = 255)
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hasta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "posicion_laboral", nullable = false, length = 255)
    private String posicionLaboral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "referencia", nullable = false, length = 255)
    private String referencia;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;

    public Experiencia() {
    }

    public Experiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public Experiencia(Long idExperiencia, String institucion, Date fechaDesde, Date fechaHasta, String posicionLaboral, String referencia) {
        this.idExperiencia = idExperiencia;
        this.institucion = institucion;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.posicionLaboral = posicionLaboral;
        this.referencia = referencia;
    }

    public Long getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Long idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getPosicionLaboral() {
        return posicionLaboral;
    }

    public void setPosicionLaboral(String posicionLaboral) {
        this.posicionLaboral = posicionLaboral;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExperiencia != null ? idExperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.idExperiencia == null && other.idExperiencia != null) || (this.idExperiencia != null && !this.idExperiencia.equals(other.idExperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Experiencia[ idExperiencia=" + idExperiencia + " ]";
    }
    
}
