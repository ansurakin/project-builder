package com.alex.project.builder.service.crud.menuItem;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.MenuItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menuItem")
public class MenuItemController extends BaseController<MenuItem, Long> {

}
