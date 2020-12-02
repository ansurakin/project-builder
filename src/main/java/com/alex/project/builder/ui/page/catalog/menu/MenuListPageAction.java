package com.alex.project.builder.ui.page.catalog.menu;

import com.alex.project.builder.domain.entity.Menu;
import com.alex.project.builder.service.crud.menu.MenuService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class MenuListPageAction {

    @Getter
    @Setter
    private List<Menu> list;

    @Getter
    @Setter
    private List<Menu> filteredList;

    @Autowired
    private MenuService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Menu item = (Menu) event.getObject();
        this.service.save(item);
        FacesUtil.addMessageInfo("Обновлено");
    }

    public void onRowCancel(RowEditEvent event) {
        FacesUtil.addMessageInfo("Отменено");
    }

    public void delete(Menu item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        FacesUtil.addMessageInfo("Удалено");
    }

}
