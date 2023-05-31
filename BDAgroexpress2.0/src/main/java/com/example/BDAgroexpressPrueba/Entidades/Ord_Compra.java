package com.example.BDAgroexpressPrueba.Entidades;
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
    @JoinColumn(referencedColumnName = "Usu_Documento",nullable = false)
    private Usuario OrdC_IdComp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Det_Referencia" ,nullable = false)
    @JsonIgnore
    private DetalleProducto OrdC_IdProducto;

    @Column(nullable = false)
    private int OrdC_Cantcomprada;

    @OneToMany(mappedBy = "OrdE_Compra", fetch = FetchType.LAZY)
    private Set<Ord_Entrega> Entregas;

    @OneToOne(mappedBy = "Fac_OrdC_Id",fetch = FetchType.LAZY)
    private Factura Facturas;

    public Ord_Compra(Usuario ordC_IdComp, DetalleProducto ordC_IdProducto, int ordC_Cantcomprada) {
        OrdC_IdComp = ordC_IdComp;
        OrdC_IdProducto = ordC_IdProducto;
        OrdC_Cantcomprada = ordC_Cantcomprada;
    }

    public int getOrdC_Id() {
        return OrdC_Id;
    }

    public Usuario getOrdC_IdComp() {
        return OrdC_IdComp;
    }

    public DetalleProducto getOrdC_IdProducto() {
        return OrdC_IdProducto;
    }

    public int getOrdC_Cantcomprada() {
        return OrdC_Cantcomprada;
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

    public void setOrdC_IdComp(Usuario ordC_IdComp) {
        OrdC_IdComp = ordC_IdComp;
    }

    public void setOrdC_IdProducto(DetalleProducto ordC_IdProducto) {
        OrdC_IdProducto = ordC_IdProducto;
    }

    public void setOrdC_Cantcomprada(int ordC_Cantcomprada) {
        OrdC_Cantcomprada = ordC_Cantcomprada;
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
                ", OrdC_IdComp=" + OrdC_IdComp +
                ", OrdC_IdProducto=" + OrdC_IdProducto +
                ", OrdC_Cantcomprada=" + OrdC_Cantcomprada +
                '}';
    }
}
