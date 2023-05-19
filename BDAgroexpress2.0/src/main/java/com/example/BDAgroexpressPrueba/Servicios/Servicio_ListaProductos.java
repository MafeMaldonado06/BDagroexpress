package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.ListaProductos;
import com.example.BDAgroexpressPrueba.Interfaz.ListaProductos_Respositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_ListaProductos {

    ListaProductos_Respositorio listaProductos_respositorio;

    public Servicio_ListaProductos(ListaProductos_Respositorio listaProductos_respositorio) {
        this.listaProductos_respositorio = listaProductos_respositorio;
    }

    public ArrayList<ListaProductos> listaProductos(){
        return (ArrayList<ListaProductos>) listaProductos_respositorio.findAll();
    }

    public String AgregarProducto(String nombre, String img){

        ListaProductos producto = new ListaProductos();

        producto.setLisP_nombre(nombre);
        producto.setLisP_Img(img);

        listaProductos_respositorio.save(producto);
        return "Se agregó correctamente";
    }
}
