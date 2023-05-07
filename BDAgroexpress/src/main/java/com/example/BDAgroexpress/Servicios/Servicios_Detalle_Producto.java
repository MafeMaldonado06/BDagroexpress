package com.example.BDAgroexpress.Servicios;

import com.example.BDAgroexpress.Entidades.DetalleProducto;
import com.example.BDAgroexpress.Interfaz.DetalleProducto_Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicios_Detalle_Producto {

    @PersistenceContext
    EntityManager em;

    DetalleProducto_Repositorio repositorio;

    public Servicios_Detalle_Producto(DetalleProducto_Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<DetalleProducto> listarDetalleProducto(){
        return  (ArrayList<DetalleProducto>) repositorio.findAll();
    }

    public List<DetalleProducto> listarProductosCampesino(Integer Id){
        String consulta = "Select d.Det_IdUsuario.Usu_Nombre, d.Det_producto.LisP_Nombre from DetalleProducto d where d.Det_IdUsuario = " + Id;

        Query query = em.createQuery(consulta);

        return query.getResultList();
    }

}
