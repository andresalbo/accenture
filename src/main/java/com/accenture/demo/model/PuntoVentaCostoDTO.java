package com.accenture.demo.model;

import java.io.Serializable;

public record PuntoVentaCostoDTO(PuntoVenta pv, Costo c) implements Serializable {

}
