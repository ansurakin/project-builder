package com.alex.project.builder.common.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

public class BaseService<T extends Object, ID extends Serializable> {

    public static final Sort SORT_BY_ORDER_NUMBER_AND_ID = Sort.by("orderNumber").and(Sort.by(DESC, "id"));

    @Autowired(required = true)
    private BaseRepository<T, ID> baseRepository;

    public List<T> findAll() {
        return this.baseRepository.findAll();
    }

    public List<T> findAll(Sort sort) {
        return this.baseRepository.findAll(sort);
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
