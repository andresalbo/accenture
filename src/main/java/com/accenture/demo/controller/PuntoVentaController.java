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
import org.springframework.web.bind.annotation.RestController;

import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.IPuntoVentaService;

@RestController
@RequestMapping(path = "/punto-venta")
public class PuntoVentaController {
	
	
	@Autowired
	private IPuntoVentaService puntoVentaService;
	

    @PostMapping(value = "/create")
    public ResponseEntity<PuntoVentaDTO> createPuntoVenta(@RequestBody PuntoVentaDTO productDTO) {
        PuntoVentaDTO pv =  puntoVentaService.savePuntoVenta(productDTO);
        return ResponseEntity.ok(pv);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuntoVenta(@PathVariable Long id) {
    	puntoVentaService.deletePuntoVenta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<PuntoVentaDTO>> getAllPuntoVenta() {
        return ResponseEntity.ok(puntoVentaService.getAllPuntoVenta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoVentaDTO> getPuntoVentaById(@PathVariable Long id) {
        Optional<PuntoVentaDTO> pv = puntoVentaService.getPuntoVentaById(id);
        return pv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntoVentaDTO> updatePuntoVenta(@PathVariable Long id, @RequestBody PuntoVentaDTO pvDTO) {
        try {
        	PuntoVentaDTO updatePuntoVenta = puntoVentaService.updatePuntoVenta(id, pvDTO);
            return ResponseEntity.ok(updatePuntoVenta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
