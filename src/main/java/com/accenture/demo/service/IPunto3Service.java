package com.accenture.demo.service;

import java.time.LocalDateTime;

import com.accenture.demo.model.Acreditacion;

public interface IPunto3Service {

	Acreditacion guardarAcreditacion(double importe, long idPuntoVenta, LocalDateTime now, String nombrePuntoVenta);

}
