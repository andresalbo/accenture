package com.accenture.demo.service;

import java.util.List;

import com.accenture.demo.model.CaminoDTO;
import com.accenture.demo.model.CostoDTO;
import com.accenture.demo.model.IdCosto;
import com.accenture.demo.model.PuntoVentaCosto;
import com.accenture.demo.model.PuntoVentaCostoDTO;
import com.accenture.demo.model.PuntoVentaDTO;

public interface IPunto2Service {
	
	CostoDTO saveCosto(CostoDTO costoDTO);
	
	void deleteCosto(IdCosto id);
	
	List<PuntoVentaCosto> getAllPuntoVentaCosto(PuntoVentaDTO puntoVentaDTO);
	
	CaminoDTO getCaminoCostoMinimo(Long idA, Long idB);
}
