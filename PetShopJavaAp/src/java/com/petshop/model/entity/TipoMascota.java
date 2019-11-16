package com.petshop.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class TipoMascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Tipo_Mascota")
    private Integer idTipoMascota;
    @Size(min = 3, max = 50)
    @Column(length = 50)
    private String nombre;
    @OneToMany(mappedBy = "tipo")
    private List<Mascota> mascotas;

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMascota != null ? idTipoMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idTipoMascota fields are not set
        if (!(object instanceof TipoMascota)) {
            return false;
        }
        TipoMascota other = (TipoMascota) object;
        if ((this.idTipoMascota == null && other.idTipoMascota != null) || (this.idTipoMascota != null && !this.idTipoMascota.equals(other.idTipoMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMascota{" + "idTipoMascota=" + idTipoMascota + ", nombre=" + nombre + ", mascotas=" + mascotas + '}';
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoMascota() {
        return idTipoMascota;
    }

    public void setIdTipoMascota(Integer idTipoMascota) {
        this.idTipoMascota = idTipoMascota;
    }

}
