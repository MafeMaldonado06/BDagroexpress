package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.Factura;
import com.example.BDAgroexpressPrueba.Entidades.Ord_Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Factura_Repositorio extends JpaRepository<Factura, Integer>{

}
