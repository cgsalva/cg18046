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
import javax.persistence.Lob;
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
@Table(name = "formacion", catalog = "bolsa_trabajo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Formacion.findAll", query = "SELECT f FROM Formacion f"),
    @NamedQuery(name = "Formacion.findByIdFormacion", query = "SELECT f FROM Formacion f WHERE f.idFormacion = :idFormacion"),
    @NamedQuery(name = "Formacion.findByNivelEducativo", query = "SELECT f FROM Formacion f WHERE f.nivelEducativo = :nivelEducativo"),
    @NamedQuery(name = "Formacion.findByFechaDesde", query = "SELECT f FROM Formacion f WHERE f.fechaDesde = :fechaDesde"),
    @NamedQuery(name = "Formacion.findByFechaHasta", query = "SELECT f FROM Formacion f WHERE f.fechaHasta = :fechaHasta"),
    @NamedQuery(name = "Formacion.findByInstitucion", query = "SELECT f FROM Formacion f WHERE f.institucion = :institucion"),
    @NamedQuery(name = "Formacion.findByTitulado", query = "SELECT f FROM Formacion f WHERE f.titulado = :titulado")})
public class Formacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formacion", nullable = false)
    private Long idFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nivel_educativo", nullable = false, length = 25)
    private String nivelEducativo;
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
    @Column(name = "institucion", nullable = false, length = 255)
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "titulado", nullable = false)
    private boolean titulado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "titulo", nullable = false, length = 65535)
    private String titulo;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;

    public Formacion() {
    }

    public Formacion(Long idFormacion) {
        this.idFormacion = idFormacion;
    }

    public Formacion(Long idFormacion, String nivelEducativo, Date fechaDesde, Date fechaHasta, String institucion, boolean titulado, String titulo) {
        this.idFormacion = idFormacion;
        this.nivelEducativo = nivelEducativo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.institucion = institucion;
        this.titulado = titulado;
        this.titulo = titulo;
    }

    public Long getIdFormacion() {
        return idFormacion;
    }

    public void setIdFormacion(Long idFormacion) {
        this.idFormacion = idFormacion;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
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

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public boolean getTitulado() {
        return titulado;
    }

    public void setTitulado(boolean titulado) {
        this.titulado = titulado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        hash += (idFormacion != null ? idFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formacion)) {
            return false;
        }
        Formacion other = (Formacion) object;
        if ((this.idFormacion == null && other.idFormacion != null) || (this.idFormacion != null && !this.idFormacion.equals(other.idFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia03.entity.Formacion[ idFormacion=" + idFormacion + " ]";
    }
    
}
