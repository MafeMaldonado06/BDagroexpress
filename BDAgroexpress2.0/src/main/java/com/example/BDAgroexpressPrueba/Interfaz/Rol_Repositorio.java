package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Rol_Repositorio extends CrudRepository<Rol,Integer> {
    @Query(nativeQuery = true, value = "select * from usuario where usu_rol_rol_id = 3")
    List<Map<String, Object>> Transportador();

}
