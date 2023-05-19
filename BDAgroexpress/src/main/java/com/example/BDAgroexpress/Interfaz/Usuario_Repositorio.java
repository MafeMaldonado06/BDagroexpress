package com.example.BDAgroexpress.Interfaz;


import com.example.BDAgroexpress.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Usuario_Repositorio extends CrudRepository<Usuario,String> {
}
