package com.accenture.demo.model;


public class PuntoVentaCosto {

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
