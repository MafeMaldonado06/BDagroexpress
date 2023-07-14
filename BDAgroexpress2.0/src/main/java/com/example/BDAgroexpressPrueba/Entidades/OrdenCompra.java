package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Orden_compra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrdC_Id;

    @Column(nullable = true)
    private Double OrdC_TotalCompra;

    @Column(nullable = true)
    private int OrdC_CantidadProductos;

    @Column(nullable = true)
    private String OrdC_FechaCompra;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "Usu_Documento", nullable = false)
    @JsonIgnore
    private Usuario Comprador;

    @OneToMany(mappedBy = "ordenCompra",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<DetalleCompra> detallesCompra;

    @OneToOne(mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    @JsonIgnore
    private Factura factura;

    @OneToOne(mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    @JsonIgnore
    private Ord_Entrega ordenEntrega;

    public OrdenCompra(Double ordC_TotalCompra, int ordC_CantidadProductos, String ordC_FechaCompra) {
        OrdC_TotalCompra = ordC_TotalCompra;
        OrdC_CantidadProductos = ordC_CantidadProductos;
        OrdC_FechaCompra = ordC_FechaCompra;
    }

    public OrdenCompra() {
    }

    public int getOrdC_Id() {
        return OrdC_Id;
    }

    public void setOrdC_Id(int ordC_Id) {
        OrdC_Id = ordC_Id;
    }

    public Double getOrdC_TotalCompra() {
        return OrdC_TotalCompra;
    }

    public void setOrdC_TotalCompra(Double ordC_TotalCompra) {
        OrdC_TotalCompra = ordC_TotalCompra;
    }

    public int getOrdC_CantidadProductos() {
        return OrdC_CantidadProductos;
    }

    public void setOrdC_CantidadProductos(int ordC_CantidadProductos) {
        OrdC_CantidadProductos = ordC_CantidadProductos;
    }

    public String getOrdC_FechaCompra() {
        return OrdC_FechaCompra;
    }

    public void setOrdC_FechaCompra(String ordC_FechaCompra) {
        OrdC_FechaCompra = ordC_FechaCompra;
    }

    public Usuario getComprador() {
        return Comprador;
    }

    public void setComprador(Usuario comprador) {
        Comprador = comprador;
    }

    public Set<DetalleCompra> getDetallesCompra() {
        return detallesCompra;
    }

    public void setDetallesCompra(Set<DetalleCompra> detallesCompra) {
        this.detallesCompra = detallesCompra;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Ord_Entrega getOrdenEntrega() {
        return ordenEntrega;
    }

    public void setOrdenEntrega(Ord_Entrega ordenEntrega) {
        this.ordenEntrega = ordenEntrega;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
                "OrdC_Id=" + OrdC_Id +
                ", OrdC_TotalCompra=" + OrdC_TotalCompra +
                ", OrdC_CantidadProductos=" + OrdC_CantidadProductos +
                ", OrdC_FechaCompra=" + OrdC_FechaCompra +
                ", Comprador=" + Comprador +
                ", factura=" + factura +
                ", ordenEntrega=" + ordenEntrega +
                '}';
    }
}
