package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import com.example.BDAgroexpressPrueba.Entidades.Factura;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleCompra_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio_DetalleCompra {

    DetalleCompra_Repositorio ordenCompraRepositorio;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    //almacena los productos
    List<DetalleProducto> detalles= new ArrayList<DetalleProducto>();

    //Datos de entrega
    Factura factura = new Factura();


    public Servicio_DetalleCompra(DetalleCompra_Repositorio ordenCompraRepositorio, DetalleProducto_Repositorio detalleProductoRepositorio) {
        this.ordenCompraRepositorio = ordenCompraRepositorio;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
    }

    public ArrayList<DetalleCompra> getOrdenCompra(){
        return (ArrayList<DetalleCompra>) ordenCompraRepositorio.findAll();
    }

    public Boolean agregarProducto(DetalleProducto producto, int cantidad){
        Boolean status = false;

        DetalleCompra ordenCompra = new DetalleCompra();

        if(detalleProductoRepositorio.findById(producto.getDet_Referencia()).isPresent()){
            ordenCompra.setOrdC_Producto(producto);
            ordenCompra.setOrdC_Cantcomprada(cantidad);
            ordenCompraRepositorio.save(ordenCompra);
        }

        return status;
    }

    public  String agregarcarrito(Integer id, Integer cantidad){
        DetalleProducto detalleProducto = new DetalleProducto();
        double sumatotal=0;

        Optional<DetalleProducto> optionalDetalleProducto = detalleProductoRepositorio.findById(id);
        optionalDetalleProducto.get();

        System.out.println("prodcutos "+optionalDetalleProducto.get());
        return "producto agreegado";
    }



}
