package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Servicios.Servicios_Detalle_Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleProducto {

    Servicios_Detalle_Producto servicio;

    public Controlador_DetalleProducto(Servicios_Detalle_Producto servicio) {
        this.servicio = servicio;
    }

    @GetMapping("Listarproductos")
    public List<DetalleProducto> listarproductos(){
        return servicio.listarDetalleProducto();
    }

    @PostMapping("/ListarProductosCampesino/{documento}")
    public List<DetalleProducto> getProductosCampesino(@PathVariable("documento") String documento){
        return servicio.getProductosPorCampesino(documento);
    }

    @PostMapping("/AgregarProducto/{documento}")
    public String Agregarproducto(@RequestBody DetalleProducto producto, @PathVariable("documento") String documento){
        return  servicio.agregarproducto(producto, documento);
    }

    @PutMapping("/ActualizarProducto/{id}/{documento}")
    public String actualizarProducto(@PathVariable("id") int id, @RequestBody DetalleProducto producto, @PathVariable("documento") String documento){
        if(servicio.actualizarProducto(id, producto, documento)){
            return "El producto ha sido actualizado";
        }else {
            return "El producto no se logró actualizar";
        }
    }

    @DeleteMapping("/EliminarProducto/{id}/{doc}")
    public String eliminarProducto(@PathVariable("id") int id,@PathVariable("doc") String Documento){
        String message = "No se pudo eliminar el producto";

        if(servicio.EliminarProducto(id, Documento)){
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

    @GetMapping("/Producto/{referencia}")
    public DetalleProducto getProducto(@PathVariable("referencia") int referencia){
        return servicio.getProducto(referencia);
    }

}
