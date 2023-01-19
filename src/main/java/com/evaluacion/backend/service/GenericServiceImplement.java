package com.evaluacion.backend.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author b44rto
 */
public abstract class GenericServiceImplement<T, ID extends Serializable> implements IGenericService<T, ID> {

    public abstract CrudRepository<T, ID> getDao();

    @Override
    public T save(T Entity) {
        return getDao().save(Entity);
    }

    @Override
    public T findById(ID id) {
        Optional<T> obj = getDao().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(obj -> list.add(obj));
        return list;
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }
}
