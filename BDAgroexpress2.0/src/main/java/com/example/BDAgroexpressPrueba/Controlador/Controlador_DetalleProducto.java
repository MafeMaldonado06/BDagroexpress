package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Servicios.Servicios_Detalle_Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleProducto {

    Servicios_Detalle_Producto servicio;

    public Controlador_DetalleProducto(Servicios_Detalle_Producto servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/Listarprductos")
    public ArrayList<DetalleProducto> listarproductos(){
        return servicio.listarDetalleProducto();
    }

    @GetMapping("/ListarProductosCampesino")
    public List<DetalleProducto> getProductosCampesino(){
        return servicio.getProductosPorCampesino();
    }

    @PostMapping("/AgregarProducto")
    public String Agregarproducto(@RequestBody DetalleProducto producto){
        return  servicio.agregarproducto(producto);
    }

    @PutMapping("/ActualizarProducto/{id}")
    public String actualizarProducto(@PathVariable("id") int id, @RequestBody DetalleProducto producto){
        if(servicio.actualizarProducto(id, producto)){
            return "El producto ha sido actualizado";
        }else {
            return "El producto no se logró actualizar";
        }
    }

    @DeleteMapping("/EliminarProducto/{id}")
    public String eliminarProducto(@PathVariable("id") int id){
        String message = "No se pudo eliminar el producto";

        if(servicio.EliminarProducto(id)){
            message = "Se eliminó el producto";
        }

        return message;
    }

    @GetMapping("/Frutas")
    public List<DetalleProducto> getProductosFrutas(){
        return servicio.listarProductosCategoriaFrutas();
    }

    @GetMapping("/Verduras")
    public List<DetalleProducto> getProductosVerduras(){
        return servicio.listarProductosCategoriaVerduras();
    }

    @GetMapping("/Legumbres")
    public List<DetalleProducto> getProductosLegumbres(){
        return servicio.listarProductosCategoriaLegumbres();
    }
}
