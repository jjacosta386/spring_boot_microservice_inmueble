package com.formation.microservice_inmueble;

import com.formation.microservice_inmueble.model.Inmueble;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
	/*@BeforeAll
	public static void setup(){
		request = new MockHttpServletRequest();
		request.setParameter("tipo", "casa");
		request.setParameter("direccion", "8831 rue Saint Hubert");
		request.setParameter("tamano", "70");
	}*/
	@Test
	public void createInmuebleHttpRequest() throws Exception{
		inmueble = new Inmueble();
		inmueble.setCodigoInmueble(1);
		inmueble.setDireccion("8831 rue Saint Hubert");
		inmueble.setTipo("casa");
		inmueble.setTamano(80);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(inmueble)))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.id", is(1)))
						.andExpect(jsonPath("$.codigoInmueble", is(1)))
						.andExpect(jsonPath("$.tipo", is("casa")))
						.andExpect(jsonPath("$.direccion", is("8831 rue Saint Hubert")))
						.andExpect(jsonPath("$.tamano", is(80)));
	}

}
