package com.example.BDAgroexpress.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "Documento", unique = true, nullable = false)
    private Integer Usu_Id;
    @Column(name = "Nombres", nullable = false, length = 50)
    private String Usu_Nombre;
    @Column(name = "Apellidos", nullable = false, length = 50)
    private String Usu_Apellidos;
    @Column(name = "Correo", nullable = false, length = 150)
    private String Usu_Correo;
    @Column(name = "Celular", length = 20)
    private String Usu_Celular;
    @Column(name = "Telefono", length = 20)
    private String Usu_Telefono;
    @Column(name = "Departamento", nullable = false ,length = 50)
    private String Usu_Departamento;
    @Column(name = "Ciudad", nullable = false , length = 50)
    private String Usu_Ciudad;
    @Column(name = "Direccion", nullable = false , length = 50)
    private String Usu_Direccion;
    @Column(name = "Password", nullable = false, length = 10)
    private String Usu_Contraseña;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Rol_Id", referencedColumnName = "Rol_Id", nullable = false)
    @JsonIgnore
    private int Usu_Rol;

    public Usuario(Integer usu_Id, String usu_Nombre, String usu_Apellidos, String usu_Correo, String usu_Celular, String usu_Telefono, String usu_Departamento, String usu_Ciudad, String usu_Direccion, String usu_Contraseña, int usu_Rol) {
        Usu_Id = usu_Id;
        Usu_Nombre = usu_Nombre;
        Usu_Apellidos = usu_Apellidos;
        Usu_Correo = usu_Correo;
        Usu_Celular = usu_Celular;
        Usu_Telefono = usu_Telefono;
        Usu_Departamento = usu_Departamento;
        Usu_Ciudad = usu_Ciudad;
        Usu_Direccion = usu_Direccion;
        Usu_Contraseña = usu_Contraseña;
        Usu_Rol = usu_Rol;
    }

    public Usuario() {
    }

    public Integer getUsu_Id() {
        return Usu_Id;
    }

    public void setUsu_Id(Integer usu_Id) {
        Usu_Id = usu_Id;
    }

    public String getUsu_Nombre() {
        return Usu_Nombre;
    }

    public void setUsu_Nombre(String usu_Nombre) {
        Usu_Nombre = usu_Nombre;
    }

    public String getUsu_Apellidos() {
        return Usu_Apellidos;
    }

    public void setUsu_Apellidos(String usu_Apellidos) {
        Usu_Apellidos = usu_Apellidos;
    }

    public String getUsu_Correo() {
        return Usu_Correo;
    }

    public void setUsu_Correo(String usu_Correo) {
        Usu_Correo = usu_Correo;
    }

    public String getUsu_Celular() {
        return Usu_Celular;
    }

    public void setUsu_Celular(String usu_Celular) {
        Usu_Celular = usu_Celular;
    }

    public String getUsu_Telefono() {
        return Usu_Telefono;
    }

    public void setUsu_Telefono(String usu_Telefono) {
        Usu_Telefono = usu_Telefono;
    }

    public String getUsu_Departamento() {
        return Usu_Departamento;
    }

    public void setUsu_Departamento(String usu_Departamento) {
        Usu_Departamento = usu_Departamento;
    }

    public String getUsu_Ciudad() {
        return Usu_Ciudad;
    }

    public void setUsu_Ciudad(String usu_Ciudad) {
        Usu_Ciudad = usu_Ciudad;
    }

    public String getUsu_Direccion() {
        return Usu_Direccion;
    }

    public void setUsu_Direccion(String usu_Direccion) {
        Usu_Direccion = usu_Direccion;
    }

    public String getUsu_Contraseña() {
        return Usu_Contraseña;
    }

    public void setUsu_Contraseña(String usu_Contraseña) {
        Usu_Contraseña = usu_Contraseña;
    }

    public int getUsu_Rol() {
        return Usu_Rol;
    }

    public void setUsu_Rol(int usu_Rol) {
        Usu_Rol = usu_Rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Usu_Id=" + Usu_Id +
                ", Usu_Nombre='" + Usu_Nombre + '\'' +
                ", Usu_Apellidos='" + Usu_Apellidos + '\'' +
                ", Usu_Correo='" + Usu_Correo + '\'' +
                ", Usu_Celular='" + Usu_Celular + '\'' +
                ", Usu_Telefono='" + Usu_Telefono + '\'' +
                ", Usu_Departamento='" + Usu_Departamento + '\'' +
                ", Usu_Ciudad='" + Usu_Ciudad + '\'' +
                ", Usu_Direccion='" + Usu_Direccion + '\'' +
                ", Usu_Contraseña='" + Usu_Contraseña + '\'' +
                ", Usu_Rol=" + Usu_Rol +
                '}';
    }
}
