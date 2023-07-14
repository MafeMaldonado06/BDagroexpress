package com.example.BDAgroexpressPrueba.Interfaz;

import com.example.BDAgroexpressPrueba.Entidades.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompra_Repositorio extends JpaRepository<OrdenCompra, Integer> {
}
