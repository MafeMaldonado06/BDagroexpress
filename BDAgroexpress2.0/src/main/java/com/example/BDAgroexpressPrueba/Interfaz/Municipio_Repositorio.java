package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Municipio_Repositorio extends JpaRepository<Municipio, Integer> {

    @Query(nativeQuery = true,value="SELECT mun_nombre FROM municipio")
    List<Map<String, Object>> findMunicipio();
}
