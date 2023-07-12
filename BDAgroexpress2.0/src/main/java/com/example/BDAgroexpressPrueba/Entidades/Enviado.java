package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "enviados")
public class Enviado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int envio_id;

    @Column(nullable = false)
    private int precio_producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Det_Referecia")
    @JsonIgnore
    private DetalleProducto id_producto;

    public Enviado(int precio_producto, DetalleProducto id_producto) {
        this.precio_producto = precio_producto;
        this.id_producto = id_producto;
    }

    public Enviado() {
    }

    public int getEnvio_id() {
        return envio_id;
    }

    public void setEnvio_id(int envio_id) {
        this.envio_id = envio_id;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public DetalleProducto getId_producto() {
        return id_producto;
    }

    public void setId_producto(DetalleProducto id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "Enviado{" +
                "envio_id=" + envio_id +
                ", precio_producto=" + precio_producto +
                ", id_producto=" + id_producto +
                '}';
    }
}

