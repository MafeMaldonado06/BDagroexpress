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

}
