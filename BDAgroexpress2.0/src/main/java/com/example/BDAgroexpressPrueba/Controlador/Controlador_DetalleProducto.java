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

    @PostMapping("/Agregarproducto/{doc}")
    public String Agregarproducto(@PathVariable("doc")String documento,@RequestBody DetalleProducto campesino){
        return  servicio.agregarproducto(documento,campesino);

    }


}
