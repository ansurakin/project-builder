package com.alex.project.builder.ui.page.catalog.menuItem;

import com.alex.project.builder.domain.entity.MenuItem;
import com.alex.project.builder.service.crud.menuItem.MenuItemService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class MenuItemPageAction {

    @Autowired
    private MenuItemService service;

    @Getter
    @Setter
    private MenuItem data;

    @PostConstruct
    public void init() {
        this.data = new MenuItem();
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
