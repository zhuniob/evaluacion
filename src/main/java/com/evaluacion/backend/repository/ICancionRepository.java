package com.evaluacion.backend.repository;

import com.evaluacion.backend.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author b44rto
 */
public interface ICancionRepository extends JpaRepository<Cancion, Integer> {

    @Query(value = "Select * from cancion c where c.title = :title", nativeQuery = true)
    public Cancion buscarCacnionTitle(String title);
}
