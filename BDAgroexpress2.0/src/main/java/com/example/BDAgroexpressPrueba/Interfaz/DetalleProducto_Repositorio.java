package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleProducto_Repositorio extends CrudRepository<DetalleProducto,Integer> {

    @Query(value = "SELECT d FROM DetalleProducto d JOIN d.Det_IdUsuario u WHERE u.Usu_Documento = :documento")
    List<DetalleProducto> ProductosPorCampesino(@Param("documento") String Documento);

}
