package com.example.BDAgroexpressPrueba.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "Detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrdC_Id;

    @Column
    private int precio_producto;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia")
    @JsonIgnore
    private DetalleProducto OrdC_Producto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usu_documento", referencedColumnName = "Usu_Documento")
    private Usuario usuario;

    @OneToMany(mappedBy = "OrdE_Compra", fetch = FetchType.LAZY)
    private Set<Ord_Entrega> Entregas;

    @OneToOne(mappedBy = "Fac_OrdC_Id",fetch = FetchType.LAZY)
    private Factura Facturas;

    public DetalleCompra(DetalleProducto ordC_IdProducto,int precio_producto) {
        OrdC_Producto = ordC_IdProducto;
        this.precio_producto = precio_producto;
    }


    public DetalleCompra() {
    }


    //getter y setter


    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public int getOrdC_Id() {
        return OrdC_Id;
    }


    public DetalleProducto getOrdC_Producto() {
        return OrdC_Producto;
    }



    public Set<Ord_Entrega> getEntregas() {
        return Entregas;
    }

    public Factura getFacturas() {
        return Facturas;
    }

    public void setOrdC_Id(int ordC_Id) {
        OrdC_Id = ordC_Id;
    }


    public void setOrdC_Producto(DetalleProducto ordC_Producto) {
        OrdC_Producto = ordC_Producto;
    }


    public void setEntregas(Set<Ord_Entrega> entregas) {
        Entregas = entregas;
    }

    public void setFacturas(Factura facturas) {
        Facturas = facturas;
    }

    @Override
    public String toString() {
        return "Ord_Compra{" +
                "OrdC_Id=" + OrdC_Id +
                ", OrdC_IdProducto=" + OrdC_Producto +
                ",precio_producto="+ precio_producto +
                '}';
    }
}
