package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    private String Usu_Documento;
    @Column(nullable = false, length = 50)
    private String Usu_Nombre;
    @Column(nullable = false, length = 50)
    private String Usu_Apellidos;
    @Column(nullable = false, length = 150)
    private String Usu_Correo;
    @Column(length = 20)
    private String Usu_Celular;
    @Column
    private String Usu_Img;
    @Column(length = 20)
    private String Usu_Telefono;

    @Column(nullable = false , length = 50)
    private String Usu_Direccion;
    @Column(nullable = false)
    private String Usu_Contrasena;
    @Column(nullable = true)
    private int usu_CantidadEntregas;
    @Column(nullable = false)
    private String Usu_Rol;
    @OneToMany(mappedBy = "OrdE_IdTrasportador", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ord_Entrega> ord_entregas;
    @OneToMany(mappedBy = "Det_IdUsuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<DetalleProducto> detalleProductos;
    @OneToMany(mappedBy = "Comprador", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<OrdenCompra> ordenesCompra;

    public Usuario(String usu_Documento, String usu_Nombre, String usu_Apellidos, String usu_Correo, String usu_Celular, String usu_Img, String usu_Telefono, String usu_Direccion, String usu_Contrasena, int usu_CantidadEntregas, String usu_Rol) {
        Usu_Documento = usu_Documento;
        Usu_Nombre = usu_Nombre;
        Usu_Apellidos = usu_Apellidos;
        Usu_Correo = usu_Correo;
        Usu_Celular = usu_Celular;
        Usu_Img = usu_Img;
        Usu_Telefono = usu_Telefono;
        Usu_Direccion = usu_Direccion;
        Usu_Contrasena = usu_Contrasena;
        this.usu_CantidadEntregas = usu_CantidadEntregas;
        Usu_Rol = usu_Rol;
    }

    public Usuario() {
    }

    public String getUsu_Documento() {
        return Usu_Documento;
    }

    public String getUsu_Nombre() {
        return Usu_Nombre;
    }

    public String getUsu_Apellidos() {
        return Usu_Apellidos;
    }

    public String getUsu_Correo() {
        return Usu_Correo;
    }

    public String getUsu_Celular() {
        return Usu_Celular;
    }

    public String getUsu_Img() {
        return Usu_Img;
    }

    public String getUsu_Telefono() {
        return Usu_Telefono;
    }


    public String getUsu_Direccion() {
        return Usu_Direccion;
    }

    public String getUsu_Contrasena() {
        return Usu_Contrasena;
    }

    public String getUsu_Rol() {
        return Usu_Rol;
    }

    public int getUsu_CantidadEntregas() {
        return usu_CantidadEntregas;
    }

    public Set<Ord_Entrega> getOrd_entregas() {
        return ord_entregas;
    }


    public Set<DetalleProducto> getDetalleProductos() {
        return detalleProductos;
    }

    public void setUsu_Documento(String usu_Documento) {
        Usu_Documento = usu_Documento;
    }

    public void setUsu_Nombre(String usu_Nombre) {
        Usu_Nombre = usu_Nombre;
    }

    public void setUsu_Apellidos(String usu_Apellidos) {
        Usu_Apellidos = usu_Apellidos;
    }

    public void setUsu_Correo(String usu_Correo) {
        Usu_Correo = usu_Correo;
    }

    public void setUsu_Celular(String usu_Celular) {
        Usu_Celular = usu_Celular;
    }

    public void setUsu_Img(String usu_Img) {
        Usu_Img = usu_Img;
    }

    public void setUsu_Telefono(String usu_Telefono) {
        Usu_Telefono = usu_Telefono;
    }



    public void setUsu_Direccion(String usu_Direccion) {
        Usu_Direccion = usu_Direccion;
    }

    public void setUsu_Contrasena(String usu_Contrasena) {
        Usu_Contrasena = usu_Contrasena;
    }

    public void setUsu_Rol(String usu_Rol) {
        Usu_Rol = usu_Rol;
    }

    public void setOrd_entregas(Set<Ord_Entrega> ord_entregas) {
        this.ord_entregas = ord_entregas;
    }

    public void setDetalleProductos(Set<DetalleProducto> detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    public void setUsu_CantidadEntregas(int usu_CantidadEntregas) {
        this.usu_CantidadEntregas = usu_CantidadEntregas;
    }

    public Set<OrdenCompra> getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(Set<OrdenCompra> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Usu_Documento='" + Usu_Documento + '\'' +
                ", Usu_Nombre='" + Usu_Nombre + '\'' +
                ", Usu_Apellidos='" + Usu_Apellidos + '\'' +
                ", Usu_Correo='" + Usu_Correo + '\'' +
                ", Usu_Celular='" + Usu_Celular + '\'' +
                ", Usu_Img='" + Usu_Img + '\'' +
                ", Usu_Telefono='" + Usu_Telefono + '\'' +
                ", Usu_Direccion='" + Usu_Direccion + '\'' +
                ", Usu_Contrasena='" + Usu_Contrasena + '\'' +
                ", usu_CantidadEntregas=" + usu_CantidadEntregas +
                ", Usu_Rol='" + Usu_Rol + '\'' +
                '}';
    }
}
