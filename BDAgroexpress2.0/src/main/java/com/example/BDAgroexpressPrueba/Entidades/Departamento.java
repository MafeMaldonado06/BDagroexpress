package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Departamento {

    @Id
    private int Dep_Id;

    @Column(nullable = false)
    private String Dep_Nombre;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuario;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Municipio> municipio;

    public Departamento(String dep_Nombre) {
        Dep_Nombre = dep_Nombre;
    }

    public Departamento() {
    }

    public int getDep_Id() {
        return Dep_Id;
    }

    public String getDep_Nombre() {
        return Dep_Nombre;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public Set<Municipio> getMunicipio() {
        return municipio;
    }

    public void setDep_Id(int dep_Id) {
        Dep_Id = dep_Id;
    }

    public void setDep_Nombre(String dep_Nombre) {
        Dep_Nombre = dep_Nombre;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public void setMunicipio(Set<Municipio> municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "Dep_Id=" + Dep_Id +
                ", Dep_Nombre='" + Dep_Nombre + '\'' +
                '}';
    }
}
