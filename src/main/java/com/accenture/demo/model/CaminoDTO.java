package com.accenture.demo.model;

import java.io.Serializable;
import java.util.List;

public record CaminoDTO(Long costoMinimo, List<String> camino) implements Serializable {

}
