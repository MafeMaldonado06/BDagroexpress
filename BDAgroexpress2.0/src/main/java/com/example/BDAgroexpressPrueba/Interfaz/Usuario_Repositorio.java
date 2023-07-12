package com.example.BDAgroexpressPrueba.Interfaz;


import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface Usuario_Repositorio extends JpaRepository<Usuario,String> {

    @Query(value = "SELECT u FROM Usuario u JOIN u.Usu_Rol r WHERE r.Rol_Id = 4")
    List<Usuario> findCampesinos();

    @Query(nativeQuery = true, value = "select * from usuario where usu_cantidad_entregas = (select min(usu_cantidad_entregas) from usuario) and usu_rol_rol_id = 3 limit 1")
    Usuario findTransportador();
}
