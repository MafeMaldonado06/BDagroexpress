package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Carrito;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Carrito;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Carrito {

    Servicio_Carrito servicioCarrito;

    public Controlador_Carrito(Servicio_Carrito servicioCarrito) {
        this.servicioCarrito = servicioCarrito;
    }

    @GetMapping("/GetCarrito")
    public List<Carrito> getCarrito(){
        return servicioCarrito.getCarrito();
    }

    @PostMapping("/Carrito/{referencia}/{cantidad}")
    public String saveProduct(@PathVariable("referencia") int referencia, @PathVariable("cantidad") int cantidad){
        return servicioCarrito.saveProduct(referencia, cantidad);
    }

    @DeleteMapping("/BorrarProducto/{referencia}")
    public void deleteProducto(@PathVariable("referencia") int referencia){
        servicioCarrito.deleteProducto(referencia);
    }
    @PutMapping("/Update")
    public void updateProducto(@RequestBody Carrito producto){
        servicioCarrito.updateProducto(producto);
    }

    @DeleteMapping("/ClearCart")
    public void clearCart(){
        servicioCarrito.vaciarCarrito();
    }
}
