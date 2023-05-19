package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Servicios.Servicios_Detalle_Producto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleProducto {

    Servicios_Detalle_Producto servicio;

    public Controlador_DetalleProducto(Servicios_Detalle_Producto servicio) {
        this.servicio = servicio;
    }



}
