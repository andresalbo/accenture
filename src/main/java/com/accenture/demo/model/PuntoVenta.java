package com.accenture.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PuntoVenta implements Serializable {
	
	private static final long serialVersionUID = 2038693458760372442L;

	@Id
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nombre")
	private String nombre;
	
	public PuntoVenta() {}

	public PuntoVenta(Long valueOf, String string) {
		this.setId(valueOf);
		this.setNombre(string);
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
