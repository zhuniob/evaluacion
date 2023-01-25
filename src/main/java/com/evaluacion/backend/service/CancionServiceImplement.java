package com.evaluacion.backend.service;

import com.evaluacion.backend.model.Cancion;

import com.evaluacion.backend.repository.ICancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author b44rto
 */
@Service
public class CancionServiceImplement extends GenericServiceImplement<Cancion, Integer> implements ICancionService {

    @Autowired
    ICancionRepository cancionRepository;

    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }

    public Cancion buscarCacnionTitle(String title) {
        return cancionRepository.buscarCancionTitle(title);
    }
}
