package com.accenture.demo.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.accenture.demo.model.PuntoVentaDTO;
import com.accenture.demo.service.IPunto1Service;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@WebMvcTest(Punto1Controller.class)
//@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public class Punto1ControllerTest {

	
	@MockitoBean
	private CommandLineRunner commandLineRunner;
	
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IPunto1Service service1;
    
//    @TestConfiguration
//    static class TestConfig {
//        @Bean
//        public CommandLineRunner loadData(CostoRepository costoRepo, PuntoVentaRepository puntoVentaRepo) {
//            return args -> {}; // No hace nada
//        }
//    }

    @Test
    void getAllPuntoVenta_DeberiaRetornarLista() throws Exception {
        PuntoVentaDTO punto1 = new PuntoVentaDTO(1L, "Punto A");
        PuntoVentaDTO punto2 = new PuntoVentaDTO(2L, "Punto B");
        when(service1.getAllPuntoVenta()).thenReturn(Arrays.asList(punto1, punto2));

        mockMvc.perform(MockMvcRequestBuilders.get("/punto1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Punto A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nombre").value("Punto B"))
                .andDo(MockMvcResultHandlers.print());

        verify(service1, times(1)).getAllPuntoVenta();
    }


}
