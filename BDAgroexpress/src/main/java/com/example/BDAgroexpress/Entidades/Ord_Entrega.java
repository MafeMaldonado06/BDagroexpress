package com.example.BDAgroexpress.Entidades;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Ordenentrega")
public class Ord_Entrega {
    @Id
    @Column(unique = true, length = 20)
    private String orden_id;

    @Column(unique = true, length = 20)
    private String orden_idCompra;

    @Column(nullable = false)
    private int orden_idTrasportador;

    @Column(nullable = false)
    private int orden_Cantidad;

    @Column(unique = true, length = 20)
    private String orden_Fecha;

    @Column(nullable = false)
    private int orden_Total_pagar;

    @Column(unique = true, length = 20)
    private String orden_Fecha_despacho;

    @Column(unique = true, length = 20)
    private String getOrden_Fecha_entrega;

    @OneToMany(mappedBy = "ordenentrega", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set <Ord_Compra> ordencompra;

    public Ord_Entrega(String orden_id, String orden_idCompra, int orden_idTrasportador, int orden_Cantidad, String orden_Fecha, int orden_Total_pagar, String orden_Fecha_despacho, String getOrden_Fecha_entrega) {
        this.orden_id = orden_id;
        this.orden_idCompra = orden_idCompra;
        this.orden_idTrasportador = orden_idTrasportador;
        this.orden_Cantidad = orden_Cantidad;
        this.orden_Fecha = orden_Fecha;
        this.orden_Total_pagar = orden_Total_pagar;
        this.orden_Fecha_despacho = orden_Fecha_despacho;
        this.getOrden_Fecha_entrega = getOrden_Fecha_entrega;
    }

    public Ord_Entrega() {
    }

    public String getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(String orden_id) {
        this.orden_id = orden_id;
    }

    public String getOrden_idCompra() {
        return orden_idCompra;
    }

    public void setOrden_idCompra(String orden_idCompra) {
        this.orden_idCompra = orden_idCompra;
    }

    public int getOrden_idTrasportador() {
        return orden_idTrasportador;
    }

    public void setOrden_idTrasportador(int orden_idTrasportador) {
        this.orden_idTrasportador = orden_idTrasportador;
    }

    public int getOrden_Cantidad() {
        return orden_Cantidad;
    }

    public void setOrden_Cantidad(int orden_Cantidad) {
        this.orden_Cantidad = orden_Cantidad;
    }

    public String getOrden_Fecha() {
        return orden_Fecha;
    }

    public void setOrden_Fecha(String orden_Fecha) {
        this.orden_Fecha = orden_Fecha;
    }

    public int getOrden_Total_pagar() {
        return orden_Total_pagar;
    }

    public void setOrden_Total_pagar(int orden_Total_pagar) {
        this.orden_Total_pagar = orden_Total_pagar;
    }

    public String getOrden_Fecha_despacho() {
        return orden_Fecha_despacho;
    }

    public void setOrden_Fecha_despacho(String orden_Fecha_despacho) {
        this.orden_Fecha_despacho = orden_Fecha_despacho;
    }

    public String getGetOrden_Fecha_entrega() {
        return getOrden_Fecha_entrega;
    }

    public void setGetOrden_Fecha_entrega(String getOrden_Fecha_entrega) {
        this.getOrden_Fecha_entrega = getOrden_Fecha_entrega;
    }

    @Override
    public String toString() {
        return "Ord_Entrega{" +
                "orden_id='" + orden_id + '\'' +
                ", orden_idCompra='" + orden_idCompra + '\'' +
                ", orden_idTrasportador=" + orden_idTrasportador +
                ", orden_Cantidad=" + orden_Cantidad +
                ", orden_Fecha='" + orden_Fecha + '\'' +
                ", orden_Total_pagar=" + orden_Total_pagar +
                ", orden_Fecha_despacho='" + orden_Fecha_despacho + '\'' +
                ", getOrden_Fecha_entrega='" + getOrden_Fecha_entrega + '\'' +
                '}';
    }
}
