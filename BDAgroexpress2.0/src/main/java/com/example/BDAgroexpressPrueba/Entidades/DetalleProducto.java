package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "detalleproducto")
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Det_Referencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "Usu_Documento", nullable = false)
    @JsonIgnore
    private Usuario Det_IdUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "LisP_Id",nullable = false)
    @JsonIgnore
    private ListaProductos Det_producto;

    @Column(nullable = false, length = 25)
    private int Det_precio;

    @Column(nullable = false, length = 150)
    private int Det_cantidad;

    @OneToMany(mappedBy = "OrdC_Id", fetch = FetchType.LAZY)
    private Set<Ord_Compra> ord_compras;

    public DetalleProducto(int det_Referencia, Usuario det_IdUsuario, ListaProductos det_producto, int det_precio, int det_cantidad) {
        Det_Referencia = det_Referencia;
        Det_IdUsuario = det_IdUsuario;
        Det_producto = det_producto;
        Det_precio = det_precio;
        Det_cantidad = det_cantidad;
    }

    public DetalleProducto() {
    }

    public int getDet_Referencia() {
        return Det_Referencia;
    }

    public void setDet_Referencia(int det_Referencia) {
        Det_Referencia = det_Referencia;
    }

    public Usuario getDet_IdUsuario() {
        return Det_IdUsuario;
    }

    public void setDet_IdUsuario(Usuario det_IdUsuario) {
        Det_IdUsuario = det_IdUsuario;
    }

    public ListaProductos getDet_producto() {
        return Det_producto;
    }

    public void setDet_producto(ListaProductos det_producto) {
        Det_producto = det_producto;
    }

    public int getDet_precio() {
        return Det_precio;
    }

    public void setDet_precio(int det_precio) {
        Det_precio = det_precio;
    }

    public int getDet_cantidad() {
        return Det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        Det_cantidad = det_cantidad;
    }

    public Set<Ord_Compra> getOrd_compras() {
        return ord_compras;
    }

    public void setOrd_compras(Set<Ord_Compra> ord_compras) {
        this.ord_compras = ord_compras;
    }

    @Override
    public String toString() {
        return "DetalleProducto{" +
                "Det_Referencia=" + Det_Referencia +
                ", Det_IdUsuario=" + Det_IdUsuario +
                ", Det_producto=" + Det_producto +
                ", Det_precio=" + Det_precio +
                ", Det_cantidad=" + Det_cantidad +
                ", ord_compras=" + ord_compras +
                '}';
    }
}


