package com.example.BDAgroexpressPrueba.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "Detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DetC_Id;

    @Column(nullable = false)
    private int DetC_CantidadComprada;

    @Column(nullable = false)
    private Double DetC_PrecioUnidad;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia")
    @JsonIgnore
    private DetalleProducto DetC_Producto;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(referencedColumnName = "OrdC_Id")
    @JsonIgnore
    private OrdenCompra ordenCompra;

    public DetalleCompra(int detC_CantidadComprada) {
        DetC_CantidadComprada = detC_CantidadComprada;
    }

    public DetalleCompra() {
    }

    public int getDetC_Id() {
        return DetC_Id;
    }

    public void setDetC_Id(int detC_Id) {
        DetC_Id = detC_Id;
    }

    public int getDetC_CantidadComprada() {
        return DetC_CantidadComprada;
    }

    public void setDetC_CantidadComprada(int detC_CantidadComprada) {
        DetC_CantidadComprada = detC_CantidadComprada;
    }

    public Double getDetC_PrecioUnidad() {
        return DetC_PrecioUnidad;
    }

    public void setDetC_PrecioUnidad(Double detC_PrecioUnidad) {
        DetC_PrecioUnidad = detC_PrecioUnidad;
    }

    public DetalleProducto getDetC_Producto() {
        return DetC_Producto;
    }

    public void setDetC_Producto(DetalleProducto detC_Producto) {
        DetC_Producto = detC_Producto;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "DetC_Id=" + DetC_Id +
                ", DetC_CantidadComprada=" + DetC_CantidadComprada +
                ", DetC_PrecioUnidad=" + DetC_PrecioUnidad +
                ", DetC_Producto=" + DetC_Producto +
                ", ordenCompra=" + ordenCompra +
                '}';
    }
}
