package com.formation.microservice_inmueble.repository;

import com.formation.microservice_inmueble.model.Inmueble;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InmuebleDao extends CrudRepository<Inmueble, Long> {
    public Optional<Inmueble> findByCodigoInmueble(int codigoInmueble);
}
