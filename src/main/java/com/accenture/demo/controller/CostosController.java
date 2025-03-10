package com.accenture.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.model.CaminoDTO;
import com.accenture.demo.model.CostoDTO;
import com.accenture.demo.model.IdCosto;
import com.accenture.demo.model.PuntoVentaCosto;
import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.ICostoService;

@RestController
@RequestMapping(path = "/costos")
public class CostosController {

	@Autowired
	private ICostoService costoService;

	@PostMapping(path = "/create")
	public ResponseEntity<CostoDTO> createCosto(@RequestBody CostoDTO dto) {
		return ResponseEntity.ok(costoService.saveCosto(dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCosto(@RequestBody IdCosto id) {
		try {
			costoService.deleteCosto(id);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/consultarPuntosVenta")
	public ResponseEntity<List<PuntoVentaCosto>> getAllCosto(PuntoVentaDTO puntoVentaDTO) {
		return ResponseEntity.ok(costoService.getAllPuntoVentaCosto(puntoVentaDTO));
	}

	@GetMapping(path = "/caminoCostoMinimo/{idA}/{idB}")
	public ResponseEntity<CaminoDTO> getCaminoCostoMinimo(@PathVariable Long idA, @PathVariable Long idB) {
		CaminoDTO dto = costoService.getCaminoCostoMinimo(idA, idB);
		return ResponseEntity.ok(dto);
	}

}
