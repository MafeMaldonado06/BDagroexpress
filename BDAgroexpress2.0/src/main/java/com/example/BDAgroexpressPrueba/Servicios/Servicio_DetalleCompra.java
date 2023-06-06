package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import com.example.BDAgroexpressPrueba.Entidades.Factura;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleCompra_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Servicio_DetalleCompra {

    Usuario_Repositorio RepositorioUsuario;

    DetalleCompra_Repositorio ordenCompraRepositorio;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    Servicio_Usuario servicioUsuario;



    //Datos de entrega
    Factura factura = new Factura();


    public Servicio_DetalleCompra(DetalleCompra_Repositorio ordenCompraRepositorio, DetalleProducto_Repositorio detalleProductoRepositorio, Usuario_Repositorio RepositorioUsuario) {
        this.ordenCompraRepositorio = ordenCompraRepositorio;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
        this.RepositorioUsuario= RepositorioUsuario;
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


    public String agregarcarrito(String doc) {
        if (RepositorioUsuario.findById(doc).isPresent()) {
            Usuario usuario = RepositorioUsuario.findById(doc).get();
            Set<DetalleProducto> detalleProductos = usuario.getDetalleProductos();

            // Crear el ArrayList para almacenar los productos
            List<DetalleProducto> productos = new ArrayList<>(detalleProductos);

            // Imprimir los detalles de los productos
            for (DetalleProducto producto : productos) {
                System.out.println("Nombre: " + producto.getDet_Nombre_poduct());
                System.out.println("Cantidad: " + producto.getDet_cantidad());
                System.out.println("Precio: " + producto.getDet_precio());
                System.out.println("------------------------");
            }

            System.out.println("Productos obtenidos correctamente");
        } else {
            System.out.println("Usuario no encontrado");
        }
        return doc;
    }






}
