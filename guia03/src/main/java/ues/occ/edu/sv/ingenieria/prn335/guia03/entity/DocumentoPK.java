/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.ingenieria.prn335.guia03.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ascg
 */
@Embeddable
public class DocumentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_documento", nullable = false)
    private int idTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private long idPersona;

    public DocumentoPK() {
    }

    public DocumentoPK(int idTipoDocumento, long idPersona) {
        this.idTipoDocumento = idTipoDocumento;
        this.idPersona = idPersona;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoDocumento;
        hash += (int) idPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPK)) {
            return false;
        }
        DocumentoPK other = (DocumentoPK) object;
        if (this.idTipoDocumento != other.idTipoDocumento) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia03.entity.DocumentoPK[ idTipoDocumento=" + idTipoDocumento + ", idPersona=" + idPersona + " ]";
    }
    
}
