package com.evaluacion.backend.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author b44rto
 */
public interface IGenericService<T, ID extends Serializable> {

    public T save(T entity);

    public T findById(ID id);

    public List<T> findByAll();

    public void delete(ID id);
}
