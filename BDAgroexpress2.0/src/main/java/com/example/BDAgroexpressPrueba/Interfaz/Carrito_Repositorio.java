package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface Carrito_Repositorio extends JpaRepository<Carrito, Integer> {
    @Query(nativeQuery = true ,value = "select c.*, d.* from carrito as c inner join detalleproducto as d on (c.producto_det_referencia = d.det_referencia)")
    List<Map<String, Object>> getCarrito();
}
