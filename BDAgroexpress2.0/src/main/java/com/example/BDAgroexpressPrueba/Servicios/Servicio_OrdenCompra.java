package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.OrdenCompra;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleCompra_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.OrdenCompra_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicio_OrdenCompra {

    //Repositorios
    DetalleCompra_Repositorio detalleCompraRepositorio;
    Usuario_Repositorio usuarioRepositorio;
    OrdenCompra_Repositorio ordenCompraRepositorio;

    public Servicio_OrdenCompra(DetalleCompra_Repositorio detalleCompraRepositorio, Usuario_Repositorio usuarioRepositorio, OrdenCompra_Repositorio ordenCompraRepositorio) {
        this.detalleCompraRepositorio = detalleCompraRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.ordenCompraRepositorio = ordenCompraRepositorio;
    }

    public List<OrdenCompra> getOrdenesCompra(){
        return (List<OrdenCompra>) ordenCompraRepositorio.findAll();
    }
}
