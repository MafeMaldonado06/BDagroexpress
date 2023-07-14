package com.example.BDAgroexpress.Entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "ordencompra")
public class Ord_Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrdC_Id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Usu_Id",nullable = false)
    private Usuario OrdC_IdComp;
    @Column(unique = true, length = 20)
    private String OrdC_IdVenta;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia" ,nullable = false)
    @JsonIgnore
    private DetalleProducto OrdC_IdProducto;

    @Column(unique = true, length = 20)
    private String OrdC_Fecha;

    @Column(nullable = false)
    private int OrdC_Totalpagar;

    @Column(nullable = false)
    private int OrdC_Cantcomprada;

    @OneToMany(mappedBy = "OrdE_Compra", fetch = FetchType.LAZY)
    private Set<Ord_Entrega> Entregas;

    @OneToOne(mappedBy = "Fac_OrdC_Id",fetch = FetchType.LAZY)
    private Factura Facturas;

    public Ord_Compra(int ordC_Id, Usuario ordC_IdComp, String ordC_IdVenta, DetalleProducto ordC_IdProducto, String ordC_Fecha, int ordC_Totalpagar, int ordC_Cantcoprada) {
        OrdC_Id = ordC_Id;
        OrdC_IdComp = ordC_IdComp;
        OrdC_IdVenta = ordC_IdVenta;
        OrdC_IdProducto = ordC_IdProducto;
        OrdC_Fecha = ordC_Fecha;
        OrdC_Totalpagar = ordC_Totalpagar;
        OrdC_Cantcomprada = ordC_Cantcoprada;
    }

    public Ord_Compra() {
    }

    public int getOrdC_Id() {
        return OrdC_Id;
    }

    public void setOrdC_Id(int ordC_Id) {
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
        return OrdC_Cantcomprada;
    }

    public void setOrdC_Cantcoprada(int ordC_Cantcoprada) {
        OrdC_Cantcomprada = ordC_Cantcoprada;
    }


    public Set<Ord_Entrega> getOrd_entrega() {
        return Entregas;
    }

    public void setOrd_entrega(Set<Ord_Entrega> ord_entrega) {
        this.Entregas = ord_entrega;
    }

    public Factura getFacturas() {
        return Facturas;
    }

    public void setFacturas(Factura facturas) {
        this.Facturas = facturas;
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
                ", OrdC_Cantcoprada=" + OrdC_Cantcomprada +
                '}';
    }
}
