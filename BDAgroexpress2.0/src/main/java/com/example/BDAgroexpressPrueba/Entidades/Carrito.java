package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int cantidad;
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia", nullable = false)
    private DetalleProducto producto;

    public Carrito(int cantidad, DetalleProducto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Carrito() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleProducto getProducto() {
        return producto;
    }

    public void setProducto(DetalleProducto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
