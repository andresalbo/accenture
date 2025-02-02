package com.accenture.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.IPunto1Service;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/punto1")
public class Punto1Controller {
	
	
	@Autowired
	private IPunto1Service service1;
	

    @GetMapping
    public List<PuntoVentaDTO> getAllPuntoVenta() {
        return service1.getAllPuntoVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoVentaDTO> getPuntoVentaById(@PathVariable Long id) {
        Optional<PuntoVentaDTO> pv = service1.getPuntoVentaById(id);
        return pv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PuntoVentaDTO createPuntoVenta(@RequestBody PuntoVentaDTO productDTO) {
        return service1.savePuntoVenta(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntoVentaDTO> updatePuntoVenta(@PathVariable Long id, @RequestBody PuntoVentaDTO pvDTO) {
        try {
        	PuntoVentaDTO updatePuntoVenta = service1.updatePuntoVenta(id, pvDTO);
            return ResponseEntity.ok(updatePuntoVenta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuntoVenta(@PathVariable Long id) {
    	service1.deletePuntoVenta(id);
        return ResponseEntity.noContent().build();
    }

}
