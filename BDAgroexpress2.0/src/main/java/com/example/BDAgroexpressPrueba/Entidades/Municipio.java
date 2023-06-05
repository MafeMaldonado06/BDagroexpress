package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Mun_Id;

    @Column(nullable = false)
    private String Mun_Nombre;

    @Column(nullable = false)
    private int Mun_estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "Dep_Id", nullable = false)
    @JsonIgnore
    private Departamento Mun_Departamento;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuario;

    public Municipio(String mun_Nombre, int mun_estado, Departamento mun_Departamento) {
        Mun_Nombre = mun_Nombre;
        Mun_estado = mun_estado;
        Mun_Departamento = mun_Departamento;
    }

    public Municipio() {
    }

    public int getMun_Id() {
        return Mun_Id;
    }

    public String getMun_Nombre() {
        return Mun_Nombre;
    }

    public int getMun_estado() {
        return Mun_estado;
    }

    public Departamento getMun_Departamento() {
        return Mun_Departamento;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setMun_Id(int mun_Id) {
        Mun_Id = mun_Id;
    }

    public void setMun_Nombre(String mun_Nombre) {
        Mun_Nombre = mun_Nombre;
    }

    public void setMun_estado(int mun_estado) {
        Mun_estado = mun_estado;
    }

    public void setMun_Departamento(Departamento mun_Departamento) {
        Mun_Departamento = mun_Departamento;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "Mun_Id=" + Mun_Id +
                ", Mun_Nombre='" + Mun_Nombre + '\'' +
                ", Mun_estado=" + Mun_estado +
                ", Mun_Departamento=" + Mun_Departamento +
                '}';
    }
}
