package com.alex.project.builder.crud.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseService<T extends Object, ID extends Serializable> {

    @Autowired(required = true)
    private BaseRepository<T, ID> baseRepository;

    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    public T findById(ID id) {
        return (T) this.baseRepository.findById(id);
    }

    //    TODO insert, update
    public <S extends T> S save(S entity) {
        return (S) this.baseRepository.save(entity);
    }

    public ID delete(ID id) {
        this.baseRepository.deleteById(id);
        return id;
    }

}
