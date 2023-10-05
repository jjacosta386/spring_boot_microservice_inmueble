package com.formation.microservice_inmueble.controller;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/inmueble")
public class InmuebleController {
    private Inmueble inmueble;
    @Autowired
    InmuebleService inmuebleServiceImpl;

    @PostMapping
    public ResponseEntity<?> createInmueble(@RequestBody Inmueble inmueble){
        return new ResponseEntity(inmuebleServiceImpl.createInmueble(inmueble), HttpStatus.CREATED);
    }
}
