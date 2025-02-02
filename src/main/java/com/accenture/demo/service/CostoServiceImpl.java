package com.accenture.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.accenture.demo.model.CaminoDTO;
import com.accenture.demo.model.Costo;
import com.accenture.demo.model.CostoDTO;
import com.accenture.demo.model.IdCosto;
import com.accenture.demo.model.PuntoVenta;
import com.accenture.demo.model.PuntoVentaCosto;
import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.repository.CostoRepository;
import com.accenture.demo.repository.PuntoVentaRepository;

@Service
public class CostoServiceImpl implements IPunto2Service {

	private final CostoRepository costoRepository;
	private final PuntoVentaRepository puntoVentaRepository;

	public CostoServiceImpl(CostoRepository costoRepository, PuntoVentaRepository puntoVentaRepository) {
		this.costoRepository = costoRepository;
		this.puntoVentaRepository = puntoVentaRepository;
	}

	private CostoDTO convertToDTO(Costo costo) {
		return new CostoDTO(costo.getIdCosto().getIdA(), costo.getIdCosto().getIdB(), costo.getCosto());
	}

	private PuntoVentaDTO convertToDTOPuntoVenta(PuntoVenta pv) {
		return new PuntoVentaDTO(pv.getId(), pv.getNombre());
	}

	private Costo convertToEntity(CostoDTO costoDTO) {
		Costo costo = new Costo();
		costo.setIdCosto(new IdCosto(costoDTO.idA(), costoDTO.idB()));
		costo.setCosto(costoDTO.costo());
		return costo;
	}

	@Override
	public CostoDTO saveCosto(CostoDTO costoDTO) {
		Costo costo = convertToEntity(costoDTO);
		Costo savedCosto = costoRepository.save(costo);
		return convertToDTO(savedCosto);
	}

	@Override
	public void deleteCosto(IdCosto id) {
		costoRepository.deleteById(id);
	}

	@Override
	@Cacheable(value = "cache2")
	public List<PuntoVentaCosto> getAllPuntoVentaCosto(PuntoVentaDTO puntoVentaDTO) {
		List<Costo> costos = this.costoRepository.getPuntoVentaCosto(puntoVentaDTO.getId());
//		List<CostoDTO> costosDTO = costos.stream().map(this::convertToDTO).collect(Collectors.toList());

		List<PuntoVenta> puntos = new ArrayList<PuntoVenta>();
		List<PuntoVentaCosto> puntosConCosto = new ArrayList<PuntoVentaCosto>();
		for (Costo costo : costos) {
			Long idB = costo.getIdCosto().getIdB();
			PuntoVenta pv = this.puntoVentaRepository.findById(idB).get();
			puntos.add(pv);

			PuntoVentaCosto pvc = new PuntoVentaCosto(pv, costo);
			puntosConCosto.add(pvc);
		}

		return puntosConCosto;
	}

	@Override
	public CaminoDTO getCaminoCostoMinimo(Long ida, Long idb) {
		Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Map<Long, String> nombresPuntosVenta = new ConcurrentHashMap<>();
		List<PuntoVenta> todosLosPuntos = this.puntoVentaRepository.findAll();
		List<Costo> todosLosCostos = this.costoRepository.findAll();
		for (PuntoVenta pv : todosLosPuntos) {
			nombresPuntosVenta.put(pv.getId(), pv.getNombre());
			graph.addVertex(pv.getNombre());
		}

		for (Costo costo : todosLosCostos) {
			System.out.println(nombresPuntosVenta.get(costo.getIdCosto().getIdA()));
			System.out.println(nombresPuntosVenta.get(costo.getIdCosto().getIdB()));
			graph.setEdgeWeight(graph.addEdge(nombresPuntosVenta.get(costo.getIdCosto().getIdA()),
					nombresPuntosVenta.get(costo.getIdCosto().getIdB())), costo.getCosto());
		}

		// Algoritmo de Dijkstra para encontrar la ruta más corta
		DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
		List<String> camino = dijkstra.getPath(nombresPuntosVenta.get(ida), nombresPuntosVenta.get(idb)).getVertexList();

		// Imprimir resultado
		System.out.println("Ruta más corta: " + camino);
		var path = dijkstra.getPath(nombresPuntosVenta.get(ida), nombresPuntosVenta.get(idb));
		List<String> vertices = path.getVertexList();
		double costoTotal = path.getWeight();
		CaminoDTO output = new CaminoDTO((long)costoTotal, camino);
		return output;
	}
}
