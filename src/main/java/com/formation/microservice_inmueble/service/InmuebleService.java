package com.formation.microservice_inmueble.service;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.repository.InmuebleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
//@Transactional
public class InmuebleService {
    @Autowired
    InmuebleDao inmuebleDao;
    public Inmueble createInmueble(int codigoInmueble, String direccion, String tipo, int tamano){
        Inmueble inmueble;
        Optional<Inmueble> result;
        inmueble = new Inmueble(0, codigoInmueble, direccion, tipo, tamano);
        inmuebleDao.save(inmueble);
        result = inmuebleDao.findByCodigoInmueble(codigoInmueble);
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
