package com.example.BDAgroexpress30.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Rol_Id;
    @Column(nullable = false)
    private String Rol_Nombre;

    public Rol(String rol_Nombre) {
        this.Rol_Nombre = rol_Nombre;
    }
    public Rol() {
    }

    //Getters
    public int getRol_Id() {
        return Rol_Id;
    }

    public String getRol_Nombre() {
        return Rol_Nombre;
    }

    //Setter

    public void setRol_Id(int rol_Id) {
        Rol_Id = rol_Id;
    }

    public void setRol_Nombre(String rol_Nombre) {
        Rol_Nombre = rol_Nombre;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "Rol_Id=" + Rol_Id +
                ", Rol_Nombre='" + Rol_Nombre + '\'' +
                '}';
    }
}
