package com.alex.project.builder.ui.page.catalog.menu;

import com.alex.project.builder.domain.entity.Menu;
import com.alex.project.builder.service.crud.menu.MenuService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class MenuPageAction {

    @Autowired
    private MenuService service;

    @Getter
    @Setter
    private Menu data;

    @PostConstruct
    public void init() {
        this.data = new Menu();
    }

    public void save() {
        service.save(data);
        init();
        FacesUtil.addMessageInfo("Сохранено");
    }

    public void cancell() {
        init();
        FacesUtil.addMessageInfo("Отменено");
    }

}
