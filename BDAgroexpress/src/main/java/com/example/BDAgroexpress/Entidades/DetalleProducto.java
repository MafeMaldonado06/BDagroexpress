package com.example.BDAgroexpress.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "detalleproducto")
public class DetalleProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Det_Referencia;

    @Column(name = "Usu_Id", nullable = false)
    private int Det_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usu_Id")
    @JsonIgnore
    private Usuario Det_IdUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Producto",referencedColumnName = "Producto",nullable = false)
    @JsonIgnore
    private DetalleProducto Det_producto;

    @Column(name = "Precio",nullable = false, length = 25)
    private int Det_precio;

    @Column(name = "Cantidad",nullable = false, length = 150)
    private int Det_cantidad;

    @OneToMany(mappedBy = "Ord_Compra", fetch = FetchType.LAZY)
    private Set<Ord_Compra> ord_compras;

    public DetalleProducto(int det_Referencia, int det_id, Usuario det_IdUsuario, DetalleProducto det_producto, int det_precio, int det_cantidad, Set<Ord_Compra> ord_compras) {
        Det_Referencia = det_Referencia;
        Det_id = det_id;
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

    public int getDet_id() {
        return Det_id;
    }

    public void setDet_id(int det_id) {
        Det_id = det_id;
    }

    public Usuario getDet_IdUsuario() {
        return Det_IdUsuario;
    }

    public void setDet_IdUsuario(Usuario det_IdUsuario) {
        Det_IdUsuario = det_IdUsuario;
    }

    public DetalleProducto getDet_producto() {
        return Det_producto;
    }

    public void setDet_producto(DetalleProducto det_producto) {
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
                ", Det_id=" + Det_id +
                ", Det_IdUsuario=" + Det_IdUsuario +
                ", Det_producto=" + Det_producto +
                ", Det_precio=" + Det_precio +
                ", Det_cantidad=" + Det_cantidad +
                ", ord_compras=" + ord_compras +
                '}';
    }
}


