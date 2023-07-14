package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Fac_Id;

    @OneToOne(fetch = FetchType.LAZY ,optional = false)
    @JoinColumn(referencedColumnName = "OrdC_Id")
    @JsonIgnore
    private OrdenCompra ordenCompra;

    public Factura() {
    }

    public int getFac_Id() {
        return Fac_Id;
    }

    public void setFac_Id(int fac_Id) {
        Fac_Id = fac_Id;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Fac_Id=" + Fac_Id +
                ", ordenCompra=" + ordenCompra +
                '}';
    }
}
