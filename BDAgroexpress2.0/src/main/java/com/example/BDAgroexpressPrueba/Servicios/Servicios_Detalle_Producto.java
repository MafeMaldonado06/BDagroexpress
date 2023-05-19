package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicios_Detalle_Producto {
    DetalleProducto_Repositorio repositorio;

    public Servicios_Detalle_Producto(DetalleProducto_Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<DetalleProducto> listarDetalleProducto(){
        return  (ArrayList<DetalleProducto>) repositorio.findAll();
    }

}
