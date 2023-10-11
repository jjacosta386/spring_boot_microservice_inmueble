package com.formation.microservice_inmueble.service;

import com.formation.microservice_inmueble.model.Inmueble;
import com.formation.microservice_inmueble.repository.InmuebleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Transactional
public class InmuebleServiceImpl implements InmuebleService {
    @Autowired
    private InmuebleDao inmuebleDao;

    @Override
    public Inmueble createInmueble(Inmueble inmueble){
        //Optional<Inmueble> result;
        var result = Optional.of(inmuebleDao.save(inmueble));
        if(result.isPresent()) {
            return result.get();
        }
        return null;
    }
}
