package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface DetalleCompra_Repositorio extends JpaRepository<DetalleCompra, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Detalle_compra WHERE ordc_producto_det_referencia = :productoId")
    DetalleCompra findByProductoId(@Param("productoId") int productoId);

    @Query(nativeQuery = true, value = "select * from detalle_compra where usu_documento = ?1")
    List<Map<String, Object>>prodcutocompra(int docusu);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM Detalle_Compra WHERE usu_documento = :idUsuario")
    int getCantidadCompra(@Param("idUsuario") String documento);

    @Query(nativeQuery = true, value = "SELECT SUM(precio_producto) FROM Detalle_Compra WHERE usu_documento = :idUsuario")
    Double getTotalPagar(@Param("idUsuario") String documento);

}
