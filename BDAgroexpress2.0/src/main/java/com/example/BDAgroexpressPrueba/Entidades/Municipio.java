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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "Dep_Id", nullable = false)
    @JsonIgnore
    private Departamento Mun_Departamento;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuario;

}
