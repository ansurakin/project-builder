package com.alex.project.builder.service.crud.menuItem;

import com.alex.project.builder.common.crud.BaseService;
import com.alex.project.builder.domain.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService extends BaseService<MenuItem, Long> {

    @Autowired
    private MenuItemRepository repository;

    public List<MenuItem> findByMenuId(Long menuId) {
        return repository.findByMenuId(menuId);
    }

    ;

}
