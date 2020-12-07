package com.alex.project.builder.ui.component;

import com.alex.project.builder.domain.entity.Menu;
import com.alex.project.builder.domain.entity.MenuItem;
import com.alex.project.builder.service.crud.menu.MenuService;
import com.alex.project.builder.service.crud.menuItem.MenuItemService;
import com.alex.project.builder.ui.model.MyDefaultMenuItem;
import lombok.Getter;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class MenuViewComponent {

    @Getter
    private MenuModel model;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemService menuItemService;

    @PostConstruct
    public void init() {
        model = createMenuModel();
    }

    private MenuModel createMenuModel() {
        MenuModel result = new DefaultMenuModel();
        List<DefaultSubMenu> subMenuList = getSubMenuList();

        for (DefaultSubMenu subMenu : subMenuList) {
            result.getElements().add(subMenu);
        }

        return result;
    }

    private List<DefaultSubMenu> getSubMenuList() {
        List<DefaultSubMenu> result = new ArrayList<>();
        List<Menu> menuList = menuService.findAll();
        for (Menu menu : menuList) {
            DefaultSubMenu facesSubmenu = DefaultSubMenu.builder()
                    .label(menu.getName())
                    .build();
            fillSubMenu(facesSubmenu, menu.getId());
            result.add(facesSubmenu);
        }
        return result;
    }

    private void fillSubMenu(DefaultSubMenu subMenu, Long menuId) {
        List<MenuItem> menuItemList = menuItemService.findByMenuId(menuId);
        for (MenuItem menuItem : menuItemList) {
            MyDefaultMenuItem facesMenuItem = new MyDefaultMenuItem();
            facesMenuItem.setValue(menuItem.getName());
            facesMenuItem.setUrl(menuItem.getUrl().getUrl());
            facesMenuItem.setIcon(menuItem.getIcon());
            facesMenuItem.setStyleClass("#{view.viewId.equals('" + menuItem.getUrl().getPage() + "') ? 'ui-state-active' : ''}");
            subMenu.getElements().add(facesMenuItem);
        }
    }

}