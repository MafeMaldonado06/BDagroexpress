package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DetalleCompra_Repositorio extends JpaRepository<DetalleCompra, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Detalle_compra WHERE ordc_producto_det_referencia = :productoId")
    DetalleCompra findByProductoId(@Param("productoId") int productoId);

    @Query(nativeQuery = true, value = "select * from detalle_compra where usu_documento = ?1")
    List<Map<String, Object>>prodcutocompra(int docusu);


}
