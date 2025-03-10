package com.accenture.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;

import com.accenture.demo.model.PuntoVentaDTO;

public interface IPuntoVentaService {

	@Cacheable(value = "elCache")
	List<PuntoVentaDTO> getAllPuntoVenta();

	Optional<PuntoVentaDTO> getPuntoVentaById(Long id);

	PuntoVentaDTO savePuntoVenta(PuntoVentaDTO puntoVentaDTO);

	PuntoVentaDTO updatePuntoVenta(Long id, PuntoVentaDTO productDTO);

	void deletePuntoVenta(Long id);
}
