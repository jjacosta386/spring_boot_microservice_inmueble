package com.formation.microservice_inmueble;

import com.formation.microservice_inmueble.model.Inmueble;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
public class InmuebleControllerTest {
	@Autowired
	private ObjectMapper objectMapper;
	private static MockHttpServletRequest request;
	@Autowired
	private MockMvc mockMvc;
	private Inmueble inmueble;

	@Autowired
	private JdbcTemplate jdbc;
	@BeforeEach
	public void setup(){
		jdbc.execute("insert into users(id, username, password) values (1, 'jhon', '12345')");
	}
	@Test
	public void createInmuebleHttpRequest() throws Exception{
		LocalDate fecha = LocalDate.now();
		inmueble = new Inmueble();
		inmueble.setCodigoInmueble(1);
		inmueble.setNombre("Los Rosales");
		inmueble.setDireccion("8831 rue Saint Hubert");
		inmueble.setFoto("/tmp/casa1.jpg");
		inmueble.setPrecio(500000.0);
		inmueble.setFechaCreacion(fecha);
		inmueble.setTipo("casa");
		inmueble.setTamano(80);


		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/inmueble")
						.with(httpBasic("jhon", "12345"))
						.with(csrf())
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(inmueble)))
						.andExpect(status().isCreated())
						.andExpect(jsonPath("$.id", is(1)))
						.andExpect(jsonPath("$.codigoInmueble", is(1)))
						.andExpect(jsonPath("$.nombre", is("Los Rosales")))
						.andExpect(jsonPath("$.foto", is("/tmp/casa1.jpg")))
						.andExpect(jsonPath("$.precio", is(500000.0)))
						.andExpect(jsonPath("$.fechaCreacion", is(fecha.toString())))
						.andExpect(jsonPath("$.tipo", is("casa")))
						.andExpect(jsonPath("$.direccion", is("8831 rue Saint Hubert")))
						.andExpect(jsonPath("$.tamano", is(80)));
	}

	@Test
	public void getHelloWorld() throws Exception{
		mockMvc.perform(get("/api/v1/inmueble")
						.with(httpBasic("jhon", "12345")))
				.andExpect(status().isOk());
	}

}
