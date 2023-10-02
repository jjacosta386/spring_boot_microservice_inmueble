package com.formation.microservice_inmueble.controller;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InmuebleController {
    private Inmueble inmueble;
    @Autowired
    InmuebleService inmuebleService;

    @PostMapping(value = "/")
    public Inmueble createInmueble(@RequestBody Inmueble inmueble){
        this.inmueble = inmuebleService.createInmueble(inmueble.getCodigoInmueble(), inmueble.getDireccion(), inmueble.getTipo(), inmueble.getTamano());
        return this.inmueble;
    }
}
