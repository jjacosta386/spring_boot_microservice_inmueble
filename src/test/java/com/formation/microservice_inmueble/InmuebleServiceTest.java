package com.formation.microservice_inmueble;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.repository.InmuebleDao;
import com.formation.microservice_inmueble.service.InmuebleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class InmuebleServiceTest {
    @Autowired
    private InmuebleService inmuebleServiceImpl;

    @Autowired
    private InmuebleDao inmuebleDao;
    @Test
    public void createInmuebleService(){
        LocalDate fecha = LocalDate.now();
        Inmueble inmueble = new Inmueble("Los Rosales", 2,"8831 rue Saint Hubert", "/tmp/casa1.jpg", 500000.0, fecha, "casa", 80);
        Optional<Inmueble> result;
        inmueble = inmuebleServiceImpl.createInmueble(inmueble);
        result = inmuebleDao.findById(1L);
        assertEquals(result.get().getId(), inmueble.getId(), "find by id");
    }
}
