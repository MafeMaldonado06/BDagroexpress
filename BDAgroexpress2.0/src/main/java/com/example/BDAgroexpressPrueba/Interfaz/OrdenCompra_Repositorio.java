package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrdenCompra_Repositorio extends JpaRepository<OrdenCompra, Integer> {

    @Query(nativeQuery = true, value = "select oc.*,oe.orde_estado from orden_compra as oc \n" +
            "right join ordenentrega as oe on (oc.ordc_id = oe.orde_id) where oc.comprador_usu_documento like :documento")
    List<Map<String, Object>> getOrdenesCompraComprador(@Param("documento") String documento);

    @Query(nativeQuery = true, value = "select dp.*, dc.detc_cantidad_comprada,u.usu_nombre,u.usu_apellidos from detalleproducto as dp\n" +
            "inner join detalle_compra as dc on (dp.det_referencia = dc.detc_producto_det_referencia)\n" +
            "inner join orden_compra as oc on (dc.orden_compra_ordc_id = oc.ordc_id)\n" +
            "inner join usuario as u on (dp.det_id_usuario_usu_documento = u.usu_documento) where oc.ordc_id like :ordenCompra")
    List<Map<String, Object>> getProductosPedido(@Param("ordenCompra") int ordenCompra);

}
