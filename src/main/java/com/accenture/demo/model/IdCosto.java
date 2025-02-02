package com.accenture.demo.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class IdCosto implements Serializable {

	private static final long serialVersionUID = -1553773830615914206L;

	private Long idA;
	private Long idB;

	public IdCosto() {
		super();
	}

	public IdCosto(Long idA, Long idB) {
		super();
		this.idA = idA;
		this.idB = idB;
	}

	public Long getIdA() {
		return idA;
	}

	public Long getIdB() {
		return idB;
	}

	public void setIdA(Long idA) {
		this.idA = idA;
	}

	public void setIdB(Long idB) {
		this.idB = idB;
	}

}
