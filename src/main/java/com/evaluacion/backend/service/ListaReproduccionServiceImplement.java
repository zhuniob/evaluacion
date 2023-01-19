package com.evaluacion.backend.service;

import com.evaluacion.backend.model.ListaReproduccion;

import java.io.Serializable;
import com.evaluacion.backend.repository.IListaReproduccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author b44rto
 */
@Service
public class ListaReproduccionServiceImplement extends GenericServiceImplement<ListaReproduccion, Integer> implements IListaReproduccionService {

    @Autowired
    IListaReproduccionRepository listaRepository;

    @Override
    public CrudRepository<ListaReproduccion, Integer> getDao() {
        return listaRepository;
    }

}
