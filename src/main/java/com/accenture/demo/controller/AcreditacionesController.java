package com.accenture.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.IAcreditacionesService;
import com.accenture.demo.service.IPuntoVentaService;

@RestController
@RequestMapping(path = "/acreditaciones")
public class AcreditacionesController {

	@Autowired
	private IPuntoVentaService puntoVentaService;
	@Autowired
	private IAcreditacionesService acreditacionesService;

	@PostMapping("/recibirAcreditacion")
	public ResponseEntity<String> recibirAcreditacion(@RequestParam double importe, @RequestParam int idPuntoVenta) {
		
		List<PuntoVentaDTO> puntosCache = puntoVentaService.getAllPuntoVenta();
		List<PuntoVentaDTO> puntosVentaCosto = puntosCache.stream()
				.filter(aux -> aux.getId().equals((long) idPuntoVenta)).collect(Collectors.toList());
		if (puntosVentaCosto.isEmpty()) throw new IllegalArgumentException("No se encontro el punto de venta en la cache.");
		String nombrePuntoVenta = puntosVentaCosto.get(0).getNombre();
		
		this.acreditacionesService.guardarAcreditacion(importe, (long) idPuntoVenta, LocalDateTime.now(),
				nombrePuntoVenta);
		
		return ResponseEntity.ok("Se guardo la acreditacion con exito.");
	}

}
