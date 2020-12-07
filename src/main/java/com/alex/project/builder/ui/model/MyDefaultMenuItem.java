package com.alex.project.builder.ui.model;

import org.primefaces.model.menu.DefaultMenuItem;

import javax.faces.context.FacesContext;

/**
 * Кастомизация DefaultMenuItem
 */
public class MyDefaultMenuItem extends DefaultMenuItem {

    /**
     * Выолняет EL выражение
     *
     * @return название класса стиля
     */
    @Override
    public String getStyleClass() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().evaluateExpressionGet(facesContext, super.getStyleClass(), String.class);
    }

}
