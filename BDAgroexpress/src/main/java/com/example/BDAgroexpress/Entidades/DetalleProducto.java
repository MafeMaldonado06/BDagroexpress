package com.example.BDAgroexpress.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "detalleproducto")

public class DetalleProducto {

    @Id
    @Column(name = "Id", unique = true, length = 25)
    private int Usu_id;

    @Column(name = "Usuario", unique = true, length = 25)
    private int Usu_usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Producto",referencedColumnName = "Producto",nullable = false)
    @JsonIgnore
    private String Usu_producto;
    @Column(name = "Precio",nullable = false, length = 25)
    private int Usu_precio;
    @Column(name = "Cantidad",nullable = false, length = 150)
    private int Usu_cantidad;


    public DetalleProducto(int id, int usuario, String producto, int cantidad, int precio) {
        this.Usu_id = id;
        this.Usu_usuario = usuario;
        this.Usu_producto = producto;
        this.Usu_cantidad = cantidad;
        this.Usu_precio = precio;
    }

    public DetalleProducto() {

}
    public int getId() {
        return Usu_id;
    }

    public void setId(int id) {
        this.Usu_id = id;
    }

    public int getUsuario() {
        return Usu_usuario;
    }

    public void setUsuario(int usuario) {
        this.Usu_usuario = usuario;
    }

    public String getProducto() {
        return Usu_producto;
    }

    public void setProducto(String producto) {
        this.Usu_producto = producto;
    }

    public int getPrecio() {
        return Usu_precio;
    }

    public void setPrecio(int precio) {
        this.Usu_precio = precio;
    }

    public int getCantidad() {
        return Usu_cantidad;
    }

    public void setCantidad(int cantidad) {
        this.Usu_cantidad = cantidad;
    }


    public Set<listaProductos> getListaproductos() {
        return getListaproductos();
    }

    public void setListaproductos(Set<listaProductos> listaproductos) {
        this.setListaproductos(listaproductos);
    }


    @Override
    public String toString() {
        return "DetalleProducto{" +
                "id=" + Usu_id +
                ", usuario=" + Usu_usuario +
                ", producto='" + Usu_producto + '\'' +
                ", cantidad=" + Usu_cantidad +
                ", precio=" + Usu_precio +
                '}';
    }
}


