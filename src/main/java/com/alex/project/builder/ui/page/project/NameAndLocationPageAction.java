package com.alex.project.builder.ui.page.project;

import com.alex.project.builder.domain.model.Project;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.IOException;

@Component
@ViewScoped//TODO проверить как будет себя вести при @ViewScoped
public class NameAndLocationPageAction {

    @Getter
    @Autowired
    private Project project;

    public void next() {
        FacesUtil.addMessageInfo("Далее");
    }

    public void finish() throws IOException {
        FacesUtil.redirect("/page/project/finish");
    }

    public void cancell() throws IOException {
        FacesUtil.addMessageInfo("Отменено");
        FacesUtil.redirect("/page/project/nameAndLocation");
    }

}
