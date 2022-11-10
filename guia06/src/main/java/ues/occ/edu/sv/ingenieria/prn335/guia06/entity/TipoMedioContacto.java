/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ues.occ.edu.sv.ingenieria.prn335.guia06.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author ascg
 */
@Entity
@Table(name = "tipo_medio_contacto", catalog = "bolsa_trabajo", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoMedioContacto.findAll", query = "SELECT t FROM TipoMedioContacto t"),
    @NamedQuery(name = "TipoMedioContacto.findByIdTipoMedioContacto", query = "SELECT t FROM TipoMedioContacto t WHERE t.idTipoMedioContacto = :idTipoMedioContacto"),
    @NamedQuery(name = "TipoMedioContacto.findByNombre", query = "SELECT t FROM TipoMedioContacto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoMedioContacto.findByNombreVisible", query = "SELECT t FROM TipoMedioContacto t WHERE t.nombreVisible = :nombreVisible")})
public class TipoMedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_medio_contacto", nullable = false)
    private Integer idTipoMedioContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nombre", nullable = false, length = 155)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nombre_visible", nullable = false, length = 155)
    private String nombreVisible;
    @Lob
    @Size(max = 65535)
    @Column(name = "indicaciones_llenado", length = 65535)
    private String indicacionesLlenado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "expresion_regular", nullable = false, length = 65535)
    private String expresionRegular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMedioContacto", fetch = FetchType.LAZY)
    private List<MedioContacto> medioContactoList;

    public TipoMedioContacto() {
    }

    public TipoMedioContacto(Integer idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    public TipoMedioContacto(Integer idTipoMedioContacto, String nombre, String nombreVisible, String expresionRegular) {
        this.idTipoMedioContacto = idTipoMedioContacto;
        this.nombre = nombre;
        this.nombreVisible = nombreVisible;
        this.expresionRegular = expresionRegular;
    }

    public Integer getIdTipoMedioContacto() {
        return idTipoMedioContacto;
    }

    public void setIdTipoMedioContacto(Integer idTipoMedioContacto) {
        this.idTipoMedioContacto = idTipoMedioContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }

    public void setNombreVisible(String nombreVisible) {
        this.nombreVisible = nombreVisible;
    }

    public String getIndicacionesLlenado() {
        return indicacionesLlenado;
    }

    public void setIndicacionesLlenado(String indicacionesLlenado) {
        this.indicacionesLlenado = indicacionesLlenado;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public List<MedioContacto> getMedioContactoList() {
        return medioContactoList;
    }

    public void setMedioContactoList(List<MedioContacto> medioContactoList) {
        this.medioContactoList = medioContactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMedioContacto != null ? idTipoMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMedioContacto)) {
            return false;
        }
        TipoMedioContacto other = (TipoMedioContacto) object;
        if ((this.idTipoMedioContacto == null && other.idTipoMedioContacto != null) || (this.idTipoMedioContacto != null && !this.idTipoMedioContacto.equals(other.idTipoMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.guia06.entity.TipoMedioContacto[ idTipoMedioContacto=" + idTipoMedioContacto + " ]";
    }
    
}
