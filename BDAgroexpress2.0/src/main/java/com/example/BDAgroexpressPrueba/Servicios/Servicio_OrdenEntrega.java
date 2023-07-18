package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Interfaz.Ord_Entrega_Repositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Servicio_OrdenEntrega {

    Ord_Entrega_Repositorio ordEntregaRepositorio;

    public Servicio_OrdenEntrega(Ord_Entrega_Repositorio ordEntregaRepositorio) {
        this.ordEntregaRepositorio = ordEntregaRepositorio;
    }

    public List<Map<String, Object>> findrntrgado(int doc){
        return ordEntregaRepositorio.finentrgado(doc);
    }

    public List<Map<String, Object>>finentregando(int doc){
        return ordEntregaRepositorio.finentregando(doc);
    }
}
