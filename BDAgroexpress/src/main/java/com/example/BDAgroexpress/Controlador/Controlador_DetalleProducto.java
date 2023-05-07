package com.example.BDAgroexpress.Controlador;

import com.example.BDAgroexpress.Servicios.Servicios_Detalle_Producto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleProducto {

    Servicios_Detalle_Producto servicio;

    public Controlador_DetalleProducto(Servicios_Detalle_Producto servicio) {
        this.servicio = servicio;
    }


}
