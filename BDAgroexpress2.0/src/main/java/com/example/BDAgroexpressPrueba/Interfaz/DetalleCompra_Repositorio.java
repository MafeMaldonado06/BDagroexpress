package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetalleCompra_Repositorio extends JpaRepository<DetalleCompra, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Detalle_compra WHERE ordc_producto_det_referencia = :productoId")
    DetalleCompra findByProductoId(@Param("productoId") int productoId);
}
