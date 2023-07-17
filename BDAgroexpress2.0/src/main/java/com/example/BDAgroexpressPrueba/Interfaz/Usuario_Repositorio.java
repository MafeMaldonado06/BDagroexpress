package com.example.BDAgroexpressPrueba.Interfaz;


import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Repository
public interface Usuario_Repositorio extends JpaRepository<Usuario,String> {

    @Query(nativeQuery = true, value = "select * from usuario as u where u.usu_cantidad_entregas = (select min(usu_cantidad_entregas) from usuario where usu_rol = 'Transportador') limit 1")
    Usuario findTransportador();

    @Query(nativeQuery = true, value = "select * from usuario where usu_rol like 'Comprador'")
    List<Usuario> findCompradores();

    @Query(value = "SELECT u FROM Usuario u WHERE u.Usu_Rol = 'Campesino'")
    List<Usuario> findCampesinos();

    @Query(nativeQuery = true, value = "select * from usuario where usu_rol like 'Transportador'")
    List<Usuario> Transportador();

    @Query(nativeQuery = true, value = "select * from usuario where usu_rol like 'Administrador'")
    List<Usuario> findAdministrador();


}
