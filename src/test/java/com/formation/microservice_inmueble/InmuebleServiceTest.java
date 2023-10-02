package com.formation.microservice_inmueble;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.repository.InmuebleDao;
import com.formation.microservice_inmueble.service.InmuebleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class InmuebleServiceTest {
    @Autowired
    private InmuebleService inmuebleService;

    @Autowired
    private InmuebleDao inmuebleDao;
    @Test
    public void createInmuebleService(){
        Inmueble inmueble;
        Optional<Inmueble> result;
        inmueble = inmuebleService.createInmueble(2,"8831 rue Saint Hubert", "casa", 80);
        result = inmuebleDao.findById(1);
        assertEquals(result.get().getId(), inmueble.getId(), "find by id");
    }
}
