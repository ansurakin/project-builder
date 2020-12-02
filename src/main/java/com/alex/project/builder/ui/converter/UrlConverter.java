package com.alex.project.builder.ui.converter;

import com.alex.project.builder.domain.entity.Url;
import com.alex.project.builder.ui.page.catalog.menuItem.MenuItemListPageAction;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "urlConverter")
public class UrlConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String id) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{menuItemListPageAction}", MenuItemListPageAction.class);

        MenuItemListPageAction menuItemListPageAction = (MenuItemListPageAction) vex.getValue(ctx.getELContext());
        return menuItemListPageAction.getUrlList()
                .stream()
                .filter(url -> url.getId() == Long.valueOf(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        return ((Url) obj).getId().toString();
    }

}
