package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.OrdenCompra;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_OrdenCompra;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_OrdenCompra {

    Servicio_OrdenCompra servicioOrdenCompra;

    public Controlador_OrdenCompra(Servicio_OrdenCompra servicioOrdenCompra) {
        this.servicioOrdenCompra = servicioOrdenCompra;
    }

    @GetMapping("/OrdenCompra")
    public List<OrdenCompra> getOrdenesCompra(){
        return servicioOrdenCompra.getOrdenesCompra();
    }
}
