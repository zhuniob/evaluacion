package com.evaluacion.backend.repository;

import com.evaluacion.backend.model.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author b44rto
 */
public interface IListaReproduccionRepository extends JpaRepository<ListaReproduccion, Integer> {

    @Query(value = "Select * from lista_repository l where l.name = :name", nativeQuery = true)
    public ListaReproduccion buscarListaName(String name);
}
