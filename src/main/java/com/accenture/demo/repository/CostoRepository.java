package com.accenture.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.demo.model.Costo;
import com.accenture.demo.model.IdCosto;

@Repository
public interface CostoRepository extends JpaRepository<Costo, IdCosto> {
	
	@Query(value = "SELECT pv FROM Costo pv where pv.idCosto.idA = ?1")
	public List<Costo> getPuntoVentaCosto(Long idPuntoVenta);
}