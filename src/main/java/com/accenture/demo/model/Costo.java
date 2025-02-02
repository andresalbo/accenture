package com.accenture.demo.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Costo implements Serializable {

	private static final long serialVersionUID = -442087102118374474L;

	@EmbeddedId
	private IdCosto idCosto;
	private Long costo;

	public Costo() {
		super();
	}

	public Costo(IdCosto idCosto, Long costo) {
		super();
		this.idCosto = idCosto;
		this.costo = costo;
	}

	public Long getCosto() {
		return costo;
	}

	public IdCosto getIdCosto() {
		return idCosto;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public void setIdCosto(IdCosto idCosto) {
		this.idCosto = idCosto;
	}

}
