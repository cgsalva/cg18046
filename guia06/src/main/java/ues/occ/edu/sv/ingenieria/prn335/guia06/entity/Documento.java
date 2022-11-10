/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.ingenieria.prn335.guia06.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "documento", catalog = "bolsa_trabajo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIdTipoDocumento", query = "SELECT d FROM Documento d WHERE d.documentoPK.idTipoDocumento = :idTipoDocumento"),
    @NamedQuery(name = "Documento.findByIdPersona", query = "SELECT d FROM Documento d WHERE d.documentoPK.idPersona = :idPersona"),
    @NamedQuery(name = "Documento.findByFechaModificacion", query = "SELECT d FROM Documento d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Documento.countByIdPersona", query = "SELECT count(d.documentoPK) FROM Documento d WHERE d.documentoPK.idPersona = :idPersona")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPK documentoPK;
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
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;

    public Documento() {
    }

    public Documento(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(DocumentoPK documentoPK, String valor, Date fechaModificacion) {
        this.documentoPK = documentoPK;
        this.valor = valor;
        this.fechaModificacion = fechaModificacion;
    }

    public Documento(int idTipoDocumento, long idPersona) {
        this.documentoPK = new DocumentoPK(idTipoDocumento, idPersona);
    }

    public DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @JsonbTransient
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia06.entity.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
