package com.alex.project.builder.service.crud.menu;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.Menu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menu")
public class MenuController extends BaseController<Menu, Long> {

}
