package com.example.BDAgroexpressPrueba.Entidades;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Fac_Id;

    @Column(nullable = false)
    private Date Fac_FechaVenta;
    @Column(nullable = false)
    private Double Fac_Total;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "OrdC_Id",nullable = false)
    private DetalleCompra Fac_OrdC_Id;

    @PrePersist
    public void prePersist(){
        this.Fac_FechaVenta = new Date();
    }

    public Factura(int fac_Id,Date fac_FechaVenta, Double fac_Total, DetalleCompra fac_OrdC_Id) {
        Fac_Id = fac_Id;
        Fac_FechaVenta = fac_FechaVenta;
        Fac_Total = fac_Total;
        Fac_OrdC_Id = fac_OrdC_Id;
    }

    public Factura() {
    }

    public int getFac_Id() {
        return Fac_Id;
    }

    public void setFac_Id(int fac_Id) {
        Fac_Id = fac_Id;
    }

    public Date getFac_FechaVenta() {
        return Fac_FechaVenta;
    }

    public void setFac_FechaVenta(Date fac_FechaVenta) {
        Fac_FechaVenta = fac_FechaVenta;
    }

    public Double getFac_Total() {
        return Fac_Total;
    }

    public void setFac_Total(Double fac_Total) {
        Fac_Total = fac_Total;
    }

    public DetalleCompra getFac_OrdC_Id() {
        return Fac_OrdC_Id;
    }

    public void setFac_OrdC_Id(DetalleCompra fac_OrdC_Id) {
        Fac_OrdC_Id = fac_OrdC_Id;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Fac_Id='" + Fac_Id + '\'' +
                ", Fac_FechaVenta=" + Fac_FechaVenta +
                ", Fac_Total=" + Fac_Total +
                ", Fac_OrdC_Id='" + Fac_OrdC_Id + '\'' +
                '}';
    }
}
