package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Android;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Android_Repositorio extends JpaRepository<Android, String> {
    @Query(nativeQuery = true, value = "select * from android;")
    List<Android> Documentoandroid();

}
