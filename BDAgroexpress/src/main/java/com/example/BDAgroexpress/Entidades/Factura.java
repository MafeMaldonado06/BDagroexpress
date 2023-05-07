package com.example.BDAgroexpress.Entidades;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Fac_Id;
    @Column(name = "Fac_Cantidad", nullable = false)
    private int Fac_Cantidad;
    @Column(name = "Fac_FechaVenta", nullable = false)
    private Date Fac_FechaVenta;
    @Column(name = "Fac_TotalPagar", nullable = false)
    private Double Fac_Total;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Fac_OrdCId", referencedColumnName = "OrdC_Id",nullable = false)
    private Ord_Compra Fac_OrdC_Id;

    @PrePersist
    public void prePersist(){
        this.Fac_FechaVenta = new Date();
    }

    public Factura(String fac_Id, int fac_Cantidad, Date fac_FechaVenta, Double fac_Total, Ord_Compra fac_OrdC_Id) {
        Fac_Id = fac_Id;
        Fac_Cantidad = fac_Cantidad;
        Fac_FechaVenta = fac_FechaVenta;
        Fac_Total = fac_Total;
        Fac_OrdC_Id = fac_OrdC_Id;
    }

    public String getFac_Id() {
        return Fac_Id;
    }

    public void setFac_Id(String fac_Id) {
        Fac_Id = fac_Id;
    }

    public int getFac_Cantidad() {
        return Fac_Cantidad;
    }

    public void setFac_Cantidad(int fac_Cantidad) {
        Fac_Cantidad = fac_Cantidad;
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

    public Ord_Compra getFac_OrdC_Id() {
        return Fac_OrdC_Id;
    }

    public void setFac_OrdC_Id(Ord_Compra fac_OrdC_Id) {
        Fac_OrdC_Id = fac_OrdC_Id;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Fac_Id='" + Fac_Id + '\'' +
                ", Fac_Cantidad=" + Fac_Cantidad +
                ", Fac_FechaVenta=" + Fac_FechaVenta +
                ", Fac_Total=" + Fac_Total +
                ", Fac_OrdC_Id='" + Fac_OrdC_Id + '\'' +
                '}';
    }
}
