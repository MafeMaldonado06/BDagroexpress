package com.example.BDAgroexpress.Entidades;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "listaproductos")
public class listaProductos {

    @Id
    @Column(name = "Id",unique = true, length = 25)
    private int Usu_id;

    @Column(name = "Nombre",nullable = false, length = 25)
    private String Usu_nombre;

    @OneToOne(mappedBy = "detalleproducto",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<listaProductos> listaproductos;



    public listaProductos(int id, String nombre) {
        this.Usu_id = id;
        this.Usu_nombre = nombre;
    }

    public listaProductos(){

    }

    public int getId() {
        return Usu_id;
    }

    public void setId(int id) {
        this.Usu_id = id;
    }

    public String getNombre() {
        return Usu_nombre;
    }

    public void setNombre(String nombre) {
        this.Usu_nombre = nombre;
    }

    public Set<listaProductos> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(Set<listaProductos> listaproductos) {
        this.listaproductos = listaproductos;
    }

    @Override
    public String toString() {
        return "listaProductos{" +
                "id=" + Usu_id +
                ", nombre='" + Usu_nombre + '\'' +
                '}';
    }
}
