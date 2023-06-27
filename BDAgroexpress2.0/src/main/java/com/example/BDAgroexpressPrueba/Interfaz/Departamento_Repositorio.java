package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Departamento;
import com.example.BDAgroexpressPrueba.Entidades.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Departamento_Repositorio extends JpaRepository<Departamento, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT Dep_Nombre FROM Departamento")
    List<Map<String, Object>> findDepartamento();

}
