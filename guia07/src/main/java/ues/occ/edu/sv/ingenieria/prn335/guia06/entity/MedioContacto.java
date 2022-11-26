/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.ingenieria.prn335.guia06.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author ascg
 */
@Entity
@Table(name = "medio_contacto", catalog = "bolsa_trabajo", schema = "")
@NamedQueries({
    @NamedQuery(name = "MedioContacto.findAll", query = "SELECT m FROM MedioContacto m"),
    @NamedQuery(name = "MedioContacto.findByIdMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.idMedioContacto = :idMedioContacto"),
    @NamedQuery(name = "MedioContacto.findByFechaModificacion", query = "SELECT m FROM MedioContacto m WHERE m.fechaModificacion = :fechaModificacion")})
public class MedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private Long idMedioContacto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "valor", nullable = false, length = 65535)
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;
    @JoinColumn(name = "id_tipo_medio_contacto", referencedColumnName = "id_tipo_medio_contacto", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMedioContacto idTipoMedioContacto;

    public MedioContacto() {
    }

    public MedioContacto(Long idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public MedioContacto(Long idMedioContacto, String valor, Date fechaModificacion) {
        this.idMedioContacto = idMedioContacto;
        this.valor = valor;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(Long idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoMedioContacto getIdTipoMedioContacto() {
        return idTipoMedioContacto;
    }

    public void setIdTipoMedioContacto(TipoMedioContacto idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioContacto != null ? idMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioContacto)) {
            return false;
        }
        MedioContacto other = (MedioContacto) object;
        if ((this.idMedioContacto == null && other.idMedioContacto != null) || (this.idMedioContacto != null && !this.idMedioContacto.equals(other.idMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia06.entity.MedioContacto[ idMedioContacto=" + idMedioContacto + " ]";
    }
    
}
