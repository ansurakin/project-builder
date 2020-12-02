package com.alex.project.builder.service.crud.menuItem;

import com.alex.project.builder.common.crud.BaseRepository;
import com.alex.project.builder.domain.entity.MenuItem;

import java.util.List;

public interface MenuItemRepository extends BaseRepository<MenuItem, Long> {

    List<MenuItem> findByMenuId(Long menuId);

}
