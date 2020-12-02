package com.alex.project.builder.ui.converter;

import com.alex.project.builder.domain.entity.Menu;
import com.alex.project.builder.ui.page.catalog.menuItem.MenuItemListPageAction;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//https://memorynotfound.com/using-custom-converter-for-hselectonemenu/
//https://coderoad.ru/4734580/Значение-настройки-ошибки-преобразования-для-null-Converter-зачем-мне-нужен
@FacesConverter(value = "menuConverter")
public class MenuConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String id) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{menuItemListPageAction}", MenuItemListPageAction.class);

        MenuItemListPageAction menuItemListPageAction = (MenuItemListPageAction) vex.getValue(ctx.getELContext());
        return menuItemListPageAction.getMenuList()
                .stream()
                .filter(menu -> menu.getId() == Long.valueOf(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        return ((Menu) obj).getId().toString();
    }

}
