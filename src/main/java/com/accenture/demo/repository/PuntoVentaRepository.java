package com.accenture.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.demo.model.PuntoVenta;

@Repository
public interface PuntoVentaRepository extends JpaRepository<PuntoVenta, Long> {
	
	
}