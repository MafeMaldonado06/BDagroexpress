package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Servicios.Servicio_OrdenEntrega;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_OrdenEntrega {

    Servicio_OrdenEntrega servicioOrdenEntrega;

    public Controlador_OrdenEntrega(Servicio_OrdenEntrega servicioOrdenEntrega) {
        this.servicioOrdenEntrega = servicioOrdenEntrega;
    }


    @GetMapping("/Entregado/{doc}")
    public List<Map<String, Object>> finentrgado(@PathVariable("doc") int doc){
        return servicioOrdenEntrega.findrntrgado(doc);
    }

    @GetMapping("/Entregando/{doc}")
    public List<Map<String, Object>>finentregando(@PathVariable("doc")int doc){
        return servicioOrdenEntrega.finentregando(doc);
    }

    @GetMapping("/Odenentrega/{doc}")
    public List<Map<String, Object>>Ordenentrega(@PathVariable("doc")int doc){
        return servicioOrdenEntrega.getOrdenentrega(doc);
    }
}
