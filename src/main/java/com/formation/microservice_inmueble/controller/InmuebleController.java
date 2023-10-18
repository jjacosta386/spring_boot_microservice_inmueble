package com.formation.microservice_inmueble.controller;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/v1/inmueble")
public class InmuebleController {
    private Inmueble inmueble;
    @Autowired
    InmuebleService inmuebleServiceImpl;

    @PostMapping("/api/v1/inmueble/createInmueble")
    public ResponseEntity<?> createInmueble(@RequestBody Inmueble inmueble){
        return new ResponseEntity(inmuebleServiceImpl.createInmueble(inmueble), HttpStatus.CREATED);
    }
    @GetMapping("api/v1/inmueble/hello")
    public ResponseEntity<?> helloWorld(){
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(a -> System.out.println("Prueba Authorities " + a.getAuthority()));
        return new ResponseEntity<>("Hello World.", HttpStatus.OK);
    }
}
