package com.accenture.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.demo.model.Acreditacion;
import com.accenture.demo.repository.AcreditacionRepository;

@Service
public class AcreditacionesServiceImpl implements IAcreditacionesService {

	@Autowired
	private AcreditacionRepository acreditacionRepository;

	@Override
	public Acreditacion guardarAcreditacion(double importe, long idPuntoVenta, LocalDateTime now,
			String nombrePuntoVenta) {
		Acreditacion acreditacion = new Acreditacion(importe, idPuntoVenta, now, nombrePuntoVenta);
		return acreditacionRepository.save(acreditacion);

	}

}
