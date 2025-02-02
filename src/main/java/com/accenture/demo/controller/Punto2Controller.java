package com.accenture.demo.controller;

import java.util.List;
import java.util.Optional;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.model.CaminoDTO;
import com.accenture.demo.model.Costo;
import com.accenture.demo.model.CostoDTO;
import com.accenture.demo.model.IdCosto;
import com.accenture.demo.model.PuntoVenta;
import com.accenture.demo.model.PuntoVentaCosto;
import com.accenture.demo.model.PuntoVentaCostoDTO;
import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.IPunto2Service;

@RestController
@RequestMapping(path = "/punto2")
public class Punto2Controller {

	@Autowired
	private IPunto2Service service2;

	@GetMapping(path = "/test")
	public String test() {
		SimpleGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");

		graph.addEdge("A", "B");
		graph.addEdge("B", "C");

		System.out.println("Grafo: " + graph);
		return graph.toString();
	}

	@PostMapping(path = "/punto1")
	public CostoDTO createCosto(@RequestBody CostoDTO dto) {
		return service2.saveCosto(dto);
	}

	@GetMapping(path = "/punto3")
	public List<PuntoVentaCosto> getAllCosto(PuntoVentaDTO puntoVentaDTO) {
		return service2.getAllPuntoVentaCosto(puntoVentaDTO);
	}
	
	@GetMapping(path = "/punto4/{idA}/{idB}")
	public CaminoDTO getCaminoCostoMinimo(@PathVariable Long idA, @PathVariable Long idB) {
		 CaminoDTO dto = service2.getCaminoCostoMinimo(idA, idB);
		 return dto;
	}
	
	

	@DeleteMapping("/punto2/{id}")
	public ResponseEntity<Void> deleteCosto(@RequestBody IdCosto id) {
		service2.deleteCosto(id);
		return ResponseEntity.noContent().build();
	}

}
