package com.accenture.demo.model;

import java.io.Serializable;

public class PuntoVentaCosto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4641990928092543806L;
	private PuntoVenta puntoVenta;
	private Costo costo;

	public PuntoVentaCosto() {
		super();
	}

	public PuntoVentaCosto(PuntoVenta puntoVenta, Costo costo) {
		super();
		this.puntoVenta = puntoVenta;
		this.costo = costo;
	}

	public Costo getCosto() {
		return costo;
	}

	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}

	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}

}
