package com.petshop.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Dueno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Dueno")
    private Integer idDueno;
    @Size(min = 3, max = 50)
    @Column(length = 50)
    private String nombre;
    @Size(min = 9, max = 50)
    @Column(length = 50)
    private String celular;
    @Size(min = 10, max = 100)
    @Column(length = 100)
    private String direccion;
    @Size(min = 10, max = 100)
    @Column(length = 100)
    private String email;
    @OneToMany(mappedBy = "dueno")
    private List<Mascota> mascotas;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDueno != null ? idDueno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idDueno fields are not set
        if (!(object instanceof Dueno)) {
            return false;
        }
        Dueno other = (Dueno) object;
        if ((this.idDueno == null && other.idDueno != null) || (this.idDueno != null && !this.idDueno.equals(other.idDueno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dueno{" + "idDueno=" + idDueno + ", nombre=" + nombre + ", celular=" + celular + ", direccion=" + direccion + ", email=" + email + ", mascotas=" + mascotas + '}';
    }



    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Integer idDueno) {
        this.idDueno = idDueno;
    }

}
