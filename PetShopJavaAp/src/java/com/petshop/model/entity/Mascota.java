package com.petshop.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Mascota")
    private Integer idMascota;
    @Size(min = 8, max = 50)
    @Column(length = 50)
    private String nombre;
    @Size(min = 3, max = 20)
    @Column(length = 20)
    private String raza;
    @ManyToOne
    @JoinColumn(name = "idTipoMascota")
    private TipoMascota tipo;
    @ManyToOne
    @JoinColumn(name = "idDueno")
    private Dueno dueno;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idMascota fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", nombre=" + nombre + ", raza=" + raza + ", tipo=" + tipo + ", dueno=" + dueno + '}';
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

}
