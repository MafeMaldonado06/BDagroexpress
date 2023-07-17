package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Carrito;
import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Interfaz.Carrito_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Servicio_Carrito {

    Carrito_Repositorio carritoRepositorio;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    public Servicio_Carrito(Carrito_Repositorio carritoRepositorio, DetalleProducto_Repositorio detalleProductoRepositorio) {
        this.carritoRepositorio = carritoRepositorio;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
    }

    public List<Carrito> getCarrito(){
        return carritoRepositorio.findAll();
    }

    public String saveProduct(int referencia, int cantidad){
        Carrito cart = new Carrito();

        String message = "No se agregó el producto al carrito correctamente";
        DetalleProducto producto = detalleProductoRepositorio.getProducto(referencia);

        if(producto != null){
            cart.setCantidad(cantidad);
            cart.setProducto(producto);
            carritoRepositorio.save(cart);
            message = "Se agregó correctamente el producto";
        }
        return message;
    }

    public void deleteProducto(int referencia){
        carritoRepositorio.deleteById(referencia);
    }
}
