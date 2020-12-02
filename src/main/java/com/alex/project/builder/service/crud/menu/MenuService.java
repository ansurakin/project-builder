package com.alex.project.builder.service.crud.menu;

import com.alex.project.builder.common.crud.BaseService;
import com.alex.project.builder.domain.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService extends BaseService<Menu, Long> {

    @Override
    public List<Menu> findAll() {
        return findAll(SORT_BY_ORDER_NUMBER_AND_ID);
    }

}
