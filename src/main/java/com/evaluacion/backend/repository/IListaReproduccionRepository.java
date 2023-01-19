package com.evaluacion.backend.repository;

import com.evaluacion.backend.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author b44rto
 */
public interface IListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {
    
}
