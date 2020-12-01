package com.alex.project.builder.common.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public class BaseController<T extends Object, ID extends Serializable> {

    @Autowired(required = true)
    private BaseService<T, ID> service;

    @RequestMapping(value = "/list", method = GET)
    public List<T> list() {
        return this.service.findAll();
    }

    @RequestMapping(value = "/get", params = {"id"}, method = GET)
    public T get(@RequestParam ID id) {
        return (T) this.service.findById(id);
    }

    //    TODO insert, update, upsert

    /**
     * Пример INSERT. input = {"id": 1000, "url": "/", "view": "/helloworld.xhtml"}
     * id=1000 не существует. :
     * select url0_.id as
     * id1_0_0_, url0_.url as url2_0_0_, url0_.view as view3_0_0_ from url url0_
     * where url0_.id=?
     * insert into url (url, view) values (?, ?)
     * Возращает: {"id": 2, "url": "/", "view": "/helloworld.xhtml"}
     * <p>
     * Пример UPDATE. input = {"id": 1, "url": "/test", "view": "/helloworld.xhtml"}
     * id=1 существует. Старое значение "url": "/".
     * select where url0_.id=1
     * update url set url=?, view=? where id=?
     * <p>
     * Пример UPDATE. input = {"id": 1, "url": "/", "view": "/helloworld.xhtml"}
     * id=1 существует. Старое значение совпадает с новым.
     * SQL update не происходит
     */
    @RequestMapping(value = "/save", method = POST)
    public T save(@RequestBody T input) {
        return (T) this.service.save(input);
    }

    @RequestMapping(value = "/delete", params = {"id"}, method = DELETE)
    public ID delete(@RequestParam ID id) {
        return this.service.delete(id);
    }

}
