package com.accenture.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.model.Acreditacion;
import com.accenture.demo.model.PuntoVentaCosto;
import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.repository.AcreditacionRepository;
import com.accenture.demo.service.IPunto1Service;
import com.accenture.demo.service.IPunto2Service;
import com.accenture.demo.service.IPunto3Service;

@RestController
@RequestMapping(path = "/punto3")
public class Punto3Controller {

	@Autowired
	private IPunto1Service service1;
	@Autowired
	private IPunto3Service service3;

	@PostMapping("/acreditaciones")
	public String recibirAcreditacion(@RequestParam double importe, @RequestParam int idPuntoVenta) {
		
		List<PuntoVentaDTO> puntosCache = service1.getAllPuntoVenta();
		List<PuntoVentaDTO> puntosVentaCosto = puntosCache.stream()
				.filter(aux -> aux.getId().equals((long) idPuntoVenta)).collect(Collectors.toList());
		if (puntosVentaCosto.isEmpty()) throw new IllegalArgumentException("No se encontro el punto de venta en la cache.");
		String nombrePuntoVenta = puntosVentaCosto.get(0).getNombre();
		
		this.service3.guardarAcreditacion(importe, (long) idPuntoVenta, LocalDateTime.now(),
				nombrePuntoVenta);
		
		return "Acreditación registrada correctamente";
	}

}
