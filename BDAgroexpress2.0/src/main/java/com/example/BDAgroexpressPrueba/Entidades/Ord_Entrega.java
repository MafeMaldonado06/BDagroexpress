package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ordenentrega")
public class Ord_Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrdE_Id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Usu_Documento",nullable = false)
    @JsonIgnore
    private Usuario OrdE_IdTrasportador;
    @Column(length = 20)
    private String OrdE_FechaDespachoAproximada;
    @Column(length = 20)
    private String Orden_FechaEntregaAproximada;
    @Column(length = 15)
    private String OrdE_Estado;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(referencedColumnName = "OrdC_Id")
    @JsonIgnore
    private OrdenCompra ordenCompra;

    public Ord_Entrega(String ordE_FechaDespachoAproximada, String orden_FechaEntregaAproximada, String ordE_Estado) {
        OrdE_FechaDespachoAproximada = ordE_FechaDespachoAproximada;
        Orden_FechaEntregaAproximada = orden_FechaEntregaAproximada;
        OrdE_Estado = ordE_Estado;
    }

    public Ord_Entrega() {
    }

    public int getOrdE_Id() {
        return OrdE_Id;
    }

    public void setOrdE_Id(int ordE_Id) {
        OrdE_Id = ordE_Id;
    }

    public Usuario getOrdE_IdTrasportador() {
        return OrdE_IdTrasportador;
    }

    public void setOrdE_IdTrasportador(Usuario ordE_IdTrasportador) {
        OrdE_IdTrasportador = ordE_IdTrasportador;
    }

    public String getOrdE_FechaDespachoAproximada() {
        return OrdE_FechaDespachoAproximada;
    }

    public void setOrdE_FechaDespachoAproximada(String ordE_FechaDespachoAproximada) {
        OrdE_FechaDespachoAproximada = ordE_FechaDespachoAproximada;
    }

    public String getOrden_FechaEntregaAproximada() {
        return Orden_FechaEntregaAproximada;
    }

    public void setOrden_FechaEntregaAproximada(String orden_FechaEntregaAproximada) {
        Orden_FechaEntregaAproximada = orden_FechaEntregaAproximada;
    }

    public String getOrdE_Estado() {
        return OrdE_Estado;
    }

    public void setOrdE_Estado(String ordE_Estado) {
        OrdE_Estado = ordE_Estado;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public String toString() {
        return "Ord_Entrega{" +
                "OrdE_Id=" + OrdE_Id +
                ", OrdE_IdTrasportador=" + OrdE_IdTrasportador +
                ", OrdE_FechaDespachoAproximada='" + OrdE_FechaDespachoAproximada + '\'' +
                ", Orden_FechaEntregaAproximada='" + Orden_FechaEntregaAproximada + '\'' +
                ", OrdE_Estado='" + OrdE_Estado + '\'' +
                ", ordenCompra=" + ordenCompra +
                '}';
    }
}
