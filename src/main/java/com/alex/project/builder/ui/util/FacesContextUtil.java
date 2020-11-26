package com.alex.project.builder.ui.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesContextUtil {

    public static void addMessageInfo(String summary) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, null);
    }

    private static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage facesMessage = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
