package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Departamento {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
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

}
