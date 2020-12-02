package com.alex.project.builder.ui.page.catalog.menuItem;

import com.alex.project.builder.domain.entity.Menu;
import com.alex.project.builder.domain.entity.MenuItem;
import com.alex.project.builder.domain.entity.Url;
import com.alex.project.builder.service.crud.menu.MenuService;
import com.alex.project.builder.service.crud.menuItem.MenuItemService;
import com.alex.project.builder.service.crud.url.UrlService;
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
public class MenuItemListPageAction {

    @Getter
    @Setter
    private List<MenuItem> list;

    @Getter
    @Setter
    private List<MenuItem> filteredList;

    @Getter
    @Setter
    private List<Menu> menuList;

    @Getter
    @Setter
    private List<Url> urlList;

    @Autowired
    private MenuItemService service;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UrlService urlService;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
        this.menuList = this.menuService.findAll();
        this.urlList = this.urlService.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        MenuItem item = (MenuItem) event.getObject();
        this.service.save(item);
        FacesUtil.addMessageInfo("Обновлено");
    }

    public void onRowCancel(RowEditEvent event) {
        FacesUtil.addMessageInfo("Отменено");
    }

    public void delete(MenuItem item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        FacesUtil.addMessageInfo("Удалено");
    }

}
