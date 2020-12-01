package com.alex.project.builder.ui.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Iterator;

public class FacesUtil {

    /**
     * Вывод информационного сообщения
     *
     * @param summary Краткая информация
     */
    public static void addMessageInfo(String summary) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, null);
    }

    private static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage facesMessage = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    /**
     * Поиск компонента на странице
     *
     * @param base Базовый компонент. Чаще всего FacesContext.getCurrentInstance().getViewRoot()
     * @param id   Id компонента
     * @return компонент. Пример использования: CommandButton button = (CommandButton) findComponent(viewRoot, "button");
     */
    private static UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId())) {
            return base;
        }

        UIComponent children = null;
        UIComponent result = null;
        Iterator childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = (UIComponent) childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }

        return result;
    }

    /**
     * Редирект на страницу url
     *
     * @param url
     * @throws IOException
     */
    public static void redirect(String url) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(url);
    }

}
