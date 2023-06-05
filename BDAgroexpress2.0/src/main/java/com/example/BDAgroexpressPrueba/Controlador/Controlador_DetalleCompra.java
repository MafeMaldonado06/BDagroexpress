package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_DetalleCompra;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleCompra {

    Servicio_DetalleCompra servicioOrdenCompra;

    //Almacenar los datalles del producto
    List<DetalleProducto> detalles= new ArrayList<DetalleProducto>();




    public Controlador_DetalleCompra(Servicio_DetalleCompra servicioOrdenCompra) {
        this.servicioOrdenCompra = servicioOrdenCompra;
    }

    @GetMapping("/ListarOrdenesCompra")
    public ArrayList<DetalleCompra> getOrdenesCompra(){
        return servicioOrdenCompra.getOrdenCompra();
    }

    @PostMapping("/AgregarProductoCarrito/{producto}/{cantidad}")
    public Boolean agregarProducto(@RequestBody DetalleProducto producto, @PathVariable("cantidad") int cantidad){
        return servicioOrdenCompra.agregarProducto(producto, cantidad);
    }

    @PostMapping("/agregarcarrito/{id}/{cantidad}")
    public String carrito(@PathVariable("Id")int id,@PathVariable("cantidad")int cantidad){
        return servicioOrdenCompra.agregarcarrito(id, cantidad);
    }
}
