package com.example.BDAgroexpressPrueba.Interfaz;


import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Usuario_Repositorio extends JpaRepository<Usuario,String> {
}
