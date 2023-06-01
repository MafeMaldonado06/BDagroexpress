package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.Ord_Compra;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.OrdenCompra_Repositorio;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_OrdenCompra {

    OrdenCompra_Repositorio ordenCompraRepositorio;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    public Servicio_OrdenCompra(OrdenCompra_Repositorio ordenCompraRepositorio, DetalleProducto_Repositorio detalleProductoRepositorio) {
        this.ordenCompraRepositorio = ordenCompraRepositorio;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
    }

    public ArrayList<Ord_Compra> getOrdenCompra(){
        return (ArrayList<Ord_Compra>) ordenCompraRepositorio.findAll();
    }

    public Boolean agregarProducto(DetalleProducto producto, int cantidad){
        Boolean status = false;

        Ord_Compra ordenCompra = new Ord_Compra();

        if(detalleProductoRepositorio.findById(producto.getDet_Referencia()).isPresent()){
            ordenCompra.setOrdC_Producto(producto);
            ordenCompra.setOrdC_Cantcomprada(cantidad);
            ordenCompraRepositorio.save(ordenCompra);
        }

        return status;
    }

}
