package com.example.BDAgroexpress.Entidades;

import java.util.Date;

public class Factura {

    private String Fac_Id;
    private int Fac_Cantidad;
    private Date Fac_FechaVenta;
    private Double Fac_Total;
    private String Fac_OrdC_Id;

    public Factura(String fac_Id, int fac_Cantidad, Date fac_FechaVenta, Double fac_Total, String fac_OrdC_Id) {
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

    public String getFac_OrdC_Id() {
        return Fac_OrdC_Id;
    }

    public void setFac_OrdC_Id(String fac_OrdC_Id) {
        Fac_OrdC_Id = fac_OrdC_Id;
    }
}
