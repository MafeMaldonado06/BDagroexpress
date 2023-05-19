package com.example.BDAgroexpress.Entidades;
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

    @OneToMany(mappedBy = "Det_producto", fetch = FetchType.LAZY)
    private Set<DetalleProducto> detalleProductos;

    public ListaProductos(int lisP_id, String lisP_nombre) {
        LisP_id = lisP_id;
        LisP_nombre = lisP_nombre;
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
                '}';
    }
}
