package com.example.BDAgroexpress.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "Ordencomra")
public class Ord_Compra {

    @Id
    @Column(unique = true, length = 20)
    private String OrdC_Id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Usu_Id",nullable = false)
    private Usuario OrdC_IdComp;

    //Falta tabla de relacion
    @Column(unique = true, length = 20)
    private String OrdC_IdVenta;

    //Falta tabla de relacion
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia" ,nullable = false)
    @JsonIgnore
    private DetalleProducto OrdC_IdProducto;

    @Column(unique = true, length = 20)
    private String OrdC_Fecha;

    @Column(nullable = false)
    private int OrdC_Totalpagar;

    @Column(nullable = false)
    private int OrdC_Cantcoprada;

    @OneToMany(mappedBy = "ordenId", fetch = FetchType.LAZY)
    private Set<Ord_Entrega> ord_entrega;

    @OneToOne(mappedBy = "Ordc_Id",fetch = FetchType.LAZY)
    private  Set<Factura>facturas;

    public Ord_Compra(String ordC_Id, Usuario ordC_IdComp, String ordC_IdVenta, DetalleProducto ordC_IdProducto, String ordC_Fecha, int ordC_Totalpagar, int ordC_Cantcoprada) {
        OrdC_Id = ordC_Id;
        OrdC_IdComp = ordC_IdComp;
        OrdC_IdVenta = ordC_IdVenta;
        OrdC_IdProducto = ordC_IdProducto;
        OrdC_Fecha = ordC_Fecha;
        OrdC_Totalpagar = ordC_Totalpagar;
        OrdC_Cantcoprada = ordC_Cantcoprada;
    }

    public Ord_Compra() {
    }

    public String getOrdC_Id() {
        return OrdC_Id;
    }

    public void setOrdC_Id(String ordC_Id) {
        OrdC_Id = ordC_Id;
    }

    public Usuario getOrdC_IdComp() {
        return OrdC_IdComp;
    }

    public void setOrdC_IdComp(Usuario ordC_IdComp) {
        OrdC_IdComp = ordC_IdComp;
    }

    public String getOrdC_IdVenta() {
        return OrdC_IdVenta;
    }

    public void setOrdC_IdVenta(String ordC_IdVenta) {
        OrdC_IdVenta = ordC_IdVenta;
    }

    public DetalleProducto getOrdC_IdProducto() {
        return OrdC_IdProducto;
    }

    public void setOrdC_IdProducto(DetalleProducto ordC_IdProducto) {
        OrdC_IdProducto = ordC_IdProducto;
    }

    public String getOrdC_Fecha() {
        return OrdC_Fecha;
    }

    public void setOrdC_Fecha(String ordC_Fecha) {
        OrdC_Fecha = ordC_Fecha;
    }

    public int getOrdC_Totalpagar() {
        return OrdC_Totalpagar;
    }

    public void setOrdC_Totalpagar(int ordC_Totalpagar) {
        OrdC_Totalpagar = ordC_Totalpagar;
    }

    public int getOrdC_Cantcoprada() {
        return OrdC_Cantcoprada;
    }

    public void setOrdC_Cantcoprada(int ordC_Cantcoprada) {
        OrdC_Cantcoprada = ordC_Cantcoprada;
    }


    public Set<Ord_Entrega> getOrd_entrega() {
        return ord_entrega;
    }

    public void setOrd_entrega(Set<Ord_Entrega> ord_entrega) {
        this.ord_entrega = ord_entrega;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Ord_Compra{" +
                "OrdC_Id='" + OrdC_Id + '\'' +
                ", OrdC_IdComp=" + OrdC_IdComp +
                ", OrdC_IdVenta='" + OrdC_IdVenta + '\'' +
                ", OrdC_IdProducto=" + OrdC_IdProducto +
                ", OrdC_Fecha='" + OrdC_Fecha + '\'' +
                ", OrdC_Totalpagar=" + OrdC_Totalpagar +
                ", OrdC_Cantcoprada=" + OrdC_Cantcoprada +
                '}';
    }
}
