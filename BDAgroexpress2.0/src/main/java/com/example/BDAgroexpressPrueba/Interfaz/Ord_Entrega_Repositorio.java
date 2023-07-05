package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Ord_Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;



@Repository
public interface Ord_Entrega_Repositorio extends JpaRepository<Ord_Entrega, Integer> {

    @Query(nativeQuery = true, value = "select * from ordenentrega where orde_estado ='entregado' and orde_id_trasportador_usu_documento = ?1")
    List<Map<String, Object>> finentrgado(int doc);

    @Query(nativeQuery = true, value = "select * from ordenentrega where orde_estado ='entregando'and orde_id_trasportador_usu_documento = ?1")
    List<Map<String, Object>> finentregando(int doc);


}
