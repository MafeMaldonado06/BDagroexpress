package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.Ord_Compra;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_OrdenCompra;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_OrdenCompra {

    Servicio_OrdenCompra servicioOrdenCompra;

    public Controlador_OrdenCompra(Servicio_OrdenCompra servicioOrdenCompra) {
        this.servicioOrdenCompra = servicioOrdenCompra;
    }

    @GetMapping("/ListarOrdenesCompra")
    public ArrayList<Ord_Compra> getOrdenesCompra(){
        return servicioOrdenCompra.getOrdenCompra();
    }

    @PostMapping("/AgregarProductoCarrito/{producto}/{cantidad}")
    public Boolean agregarProducto(@RequestBody DetalleProducto producto, @PathVariable("cantidad") int cantidad){
        return servicioOrdenCompra.agregarProducto(producto, cantidad);
    }

}
