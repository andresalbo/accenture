package com.accenture.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.accenture.demo.model.Costo;
import com.accenture.demo.model.IdCosto;
import com.accenture.demo.model.PuntoVenta;
import com.accenture.demo.repository.CostoRepository;
import com.accenture.demo.repository.PuntoVentaRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CostoRepository costoRepo, PuntoVentaRepository puntoVentaRepo) {
		return (args) -> {

			puntoVentaRepo.save(new PuntoVenta(1L, "CABA"));
			puntoVentaRepo.save(new PuntoVenta(2L, "GBA_1"));
			puntoVentaRepo.save(new PuntoVenta(3L, "GBA_2"));
			puntoVentaRepo.save(new PuntoVenta(4L, "Santa Fe"));
			puntoVentaRepo.save(new PuntoVenta(5L, "Cordoba"));
			puntoVentaRepo.save(new PuntoVenta(6L, "Misiones"));
			puntoVentaRepo.save(new PuntoVenta(7L, "Salta"));
			puntoVentaRepo.save(new PuntoVenta(8L, "Chubut"));
			puntoVentaRepo.save(new PuntoVenta(9L, "Santa Cruz"));
			puntoVentaRepo.save(new PuntoVenta(10L, "Catamarca"));

			costoRepo.save(new Costo(new IdCosto(1L, 2L), 2L));
			costoRepo.save(new Costo(new IdCosto(1L, 3L), 3L));
			costoRepo.save(new Costo(new IdCosto(2L, 3L), 5L));
			costoRepo.save(new Costo(new IdCosto(2L, 4L), 10L));
			costoRepo.save(new Costo(new IdCosto(1L, 4L), 14L));
			costoRepo.save(new Costo(new IdCosto(4L, 5L), 5L));
			costoRepo.save(new Costo(new IdCosto(2L, 5L), 14L));
			costoRepo.save(new Costo(new IdCosto(6L, 7L), 32L));
			costoRepo.save(new Costo(new IdCosto(8L, 9L), 11L));
			costoRepo.save(new Costo(new IdCosto(10L, 7L), 5L));
			costoRepo.save(new Costo(new IdCosto(3L, 8L), 10L));
			costoRepo.save(new Costo(new IdCosto(5L, 8L), 30L));
			costoRepo.save(new Costo(new IdCosto(10L, 5L), 5L));
			costoRepo.save(new Costo(new IdCosto(4L, 6L), 6L));
		};
	}
}
