package com.accenture.demo.model;

import java.io.Serializable;

public class PuntoVentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984369668636651613L;
	private Long id;
	private String nombre;

	public PuntoVentaDTO() {
		super();
	}

	public PuntoVentaDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
