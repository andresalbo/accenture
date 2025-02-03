package com.accenture.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acreditaciones")
public class Acreditacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6187947167631644611L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double importe;
	private Long idPuntoVenta;
	private LocalDateTime fechaRecepcion;
	private String nombrePuntoVenta;

	public Acreditacion() {
	}

	public Acreditacion(double importe, Long idPuntoVenta, LocalDateTime fechaRecepcion, String nombrePuntoVenta) {
		this.importe = importe;
		this.idPuntoVenta = idPuntoVenta;
		this.fechaRecepcion = fechaRecepcion;
		this.nombrePuntoVenta = nombrePuntoVenta;
	}

	public LocalDateTime getFechaRecepcion() {
		return fechaRecepcion;
	}

	public Long getId() {
		return id;
	}

	public Long getIdPuntoVenta() {
		return idPuntoVenta;
	}

	public double getImporte() {
		return importe;
	}

	public String getNombrePuntoVenta() {
		return nombrePuntoVenta;
	}

	public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdPuntoVenta(Long idPuntoVenta) {
		this.idPuntoVenta = idPuntoVenta;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setNombrePuntoVenta(String nombrePuntoVenta) {
		this.nombrePuntoVenta = nombrePuntoVenta;
	}
}
