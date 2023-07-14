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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "Usu_Documento", nullable = false)
    @JsonIgnore
    private Usuario Det_IdUsuario;
    @Column
    private  String Det_Img;
    @Column
    private String Det_Nombre_product;

    @Column
    private String Det_Categoria;

    @Column(nullable = false, length = 25)
    private Double Det_precio;

    @Column(nullable = false, length = 150)
    private int Det_cantidad;

    @OneToMany(mappedBy = "DetC_Producto", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<DetalleCompra> detalle_compras;

    public DetalleProducto(int det_Referencia, Usuario det_IdUsuario, String det_Img, String det_Nombre_product, String det_Categoria, Double det_precio, int det_cantidad) {
        Det_Referencia = det_Referencia;
        Det_IdUsuario = det_IdUsuario;
        Det_Img = det_Img;
        Det_Nombre_product = det_Nombre_product;
        Det_Categoria = det_Categoria;
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

    public String getDet_Img() {
        return Det_Img;
    }

    public void setDet_Img(String det_Img) {
        Det_Img = det_Img;
    }

    public String getDet_Nombre_product() {
        return Det_Nombre_product;
    }

    public void setDet_Nombre_product(String det_Nombre_product) {
        Det_Nombre_product = det_Nombre_product;
    }

    public String getDet_Categoria() {
        return Det_Categoria;
    }

    public void setDet_Categoria(String det_Categoria) {
        Det_Categoria = det_Categoria;
    }

    public Double getDet_precio() {
        return Det_precio;
    }

    public void setDet_precio(Double det_precio) {
        Det_precio = det_precio;
    }

    public int getDet_cantidad() {
        return Det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        Det_cantidad = det_cantidad;
    }

    public Set<DetalleCompra> getDetalle_compras() {
        return detalle_compras;
    }

    public void setDetalle_compras(Set<DetalleCompra> detalle_compras) {
        this.detalle_compras = detalle_compras;
    }

    @Override
    public String toString() {
        return "DetalleProducto{" +
                "Det_Referencia=" + Det_Referencia +
                ", Det_IdUsuario=" + Det_IdUsuario +
                '}';
    }

}


