package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.ListaProductos;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_ListaProductos;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_ListaProductos {

    Servicio_ListaProductos servicio;

    public Controlador_ListaProductos(Servicio_ListaProductos servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/AgregarProducto/{Nombre}/{img}")
    public String AgregarProducto(@PathVariable("Nombre") String nombre, @PathVariable("img") String img){
        return servicio.AgregarProducto(nombre, img);
    }
}
