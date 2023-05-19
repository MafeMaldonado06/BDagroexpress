package com.example.BDAgroexpressPrueba.Entidades;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "listaproductos")
public class ListaProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LisP_id;

    @Column(nullable = false, length = 25)
    private String LisP_nombre;

    @Column
    private String LisP_Img;

    @OneToMany(mappedBy = "Det_producto", fetch = FetchType.LAZY)
    private Set<DetalleProducto> detalleProductos;

    public ListaProductos(int lisP_id, String lisP_nombre, String lisP_Img) {
        LisP_id = lisP_id;
        LisP_nombre = lisP_nombre;
        LisP_Img = lisP_Img;
    }

    public ListaProductos() {
    }

    public int getLisP_id() {
        return LisP_id;
    }

    public void setLisP_id(int lisP_id) {
        LisP_id = lisP_id;
    }

    public String getLisP_nombre() {
        return LisP_nombre;
    }

    public void setLisP_nombre(String lisP_nombre) {
        LisP_nombre = lisP_nombre;
    }

    public String getLisP_Img() {
        return LisP_Img;
    }

    public void setLisP_Img(String lisP_Img) {
        LisP_Img = lisP_Img;
    }

    public Set<DetalleProducto> getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(Set<DetalleProducto> detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    @Override
    public String toString() {
        return "ListaProductos{" +
                "LisP_id=" + LisP_id +
                ", LisP_nombre='" + LisP_nombre + '\'' +
                ", LisP_Img='" + LisP_Img + '\'' +
                '}';
    }
}
