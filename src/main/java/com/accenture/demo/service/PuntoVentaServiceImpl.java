package com.accenture.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.accenture.demo.model.PuntoVenta;
import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.repository.PuntoVentaRepository;
@Service
public class PuntoVentaServiceImpl implements IPuntoVentaService {
	
	private final PuntoVentaRepository puntoVentaRepository;

    public PuntoVentaServiceImpl(PuntoVentaRepository puntoVentaRepository) {
        this.puntoVentaRepository = puntoVentaRepository;
    }

    @Override
    @Cacheable(value="elCache")
    public List<PuntoVentaDTO> getAllPuntoVenta() {
    	System.out.println("buscando puntos de venta");
        return puntoVentaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PuntoVentaDTO> getPuntoVentaById(Long id) {
        return puntoVentaRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public PuntoVentaDTO savePuntoVenta(PuntoVentaDTO puntoVentaDTO) {
        PuntoVenta pv = convertToEntity(puntoVentaDTO);
        PuntoVenta savedPuntoVenta = puntoVentaRepository.save(pv);
        return convertToDTO(savedPuntoVenta);
    }

    @Override
    public PuntoVentaDTO updatePuntoVenta(Long id, PuntoVentaDTO puntoVentaDTO) {
    	PuntoVenta product = puntoVentaRepository.findById(id).orElseThrow();
        product.setNombre(puntoVentaDTO.getNombre());
        PuntoVenta updatedProduct = puntoVentaRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deletePuntoVenta(Long id) {
    	puntoVentaRepository.deleteById(id);
    }

    private PuntoVentaDTO convertToDTO(PuntoVenta pv) {
        return new PuntoVentaDTO(pv.getId(), pv.getNombre());
    }

    private PuntoVenta convertToEntity(PuntoVentaDTO PuntoVentaDTO) {
        PuntoVenta product = new PuntoVenta();
        product.setId(PuntoVentaDTO.getId());
        product.setNombre(PuntoVentaDTO.getNombre());
        return product;
    }
}
