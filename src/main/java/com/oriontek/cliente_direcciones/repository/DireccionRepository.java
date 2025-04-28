package com.oriontek.cliente_direcciones.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oriontek.cliente_direcciones.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}