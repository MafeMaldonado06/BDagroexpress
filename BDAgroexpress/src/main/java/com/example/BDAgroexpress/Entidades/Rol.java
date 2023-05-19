package com.example.BDAgroexpress.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Rol_Id;
    @Column(length = 50)
    private String Rol_Nombre;

    @OneToMany(mappedBy = "Usu_Rol", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Usuario> usuarios;

    public Rol(int rol_Id, String rol_Nombre) {
        Rol_Id = rol_Id;
        Rol_Nombre = rol_Nombre;
    }

    public Rol() {
    }

    public int getRol_Id() {
        return Rol_Id;
    }

    public void setRol_Id(int rol_Id) {
        Rol_Id = rol_Id;
    }

    public String getRol_Nombre() {
        return Rol_Nombre;
    }

    public void setRol_Nombre(String rol_Nombre) {
        Rol_Nombre = rol_Nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "Rol_Id=" + Rol_Id +
                ", Rol_Nombre='" + Rol_Nombre + '\'' +
                '}';
    }
}
