package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DetalleProducto_Repositorio extends JpaRepository<DetalleProducto,Integer> {

    /*@Query(nativeQuery = true, value = "select dp.det_referencia,dp.det_nombre_product,dp.det_precio,dp.det_categoria,dp.det_img,dp.det_cantidad,dp.det_precio,u.usu_nombre, u.usu_apellidos from detalleproducto as dp inner join usuario as u on (dp.det_id_usuario_usu_documento = u.usu_documento)")
    List<Map<String, Object>> getProductos();*/

    @Query(nativeQuery = true, value = "select * from detalleproducto")
    List<Map<String, Object>> getProductos();

    @Query(nativeQuery = true, value = "select * from detalleproducto where det_id_usuario_usu_documento = ?1")
    List<DetalleProducto> ProductosPorCampesino(@Param("documento") String Documento);

    @Query(value = "Select d From DetalleProducto d Where d.Det_Categoria = 'Frutas'")
    List<DetalleProducto> ProductosFrutas();

    @Query(value = "Select d From DetalleProducto d Where d.Det_Categoria = 'Verduras'")
    List<DetalleProducto> ProductosVerduras();

    @Query(value = "Select d From DetalleProducto d Where d.Det_Categoria = 'Legumbres'")
    List<DetalleProducto> ProductosLegumbres();

    @Query(value = "Select d From DetalleProducto d Where d.Det_Referencia = :referencia")
    DetalleProducto getProducto(@Param("referencia") int referencia);

    @Query(value = "SELECT COUNT(*) FROM detalleproducto WHERE det_id_usuario_usu_documento = ?1", nativeQuery = true)
    int countProductsByUserId(int doc);

}
