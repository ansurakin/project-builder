package com.alex.project.builder.ui.page.project;

import com.alex.project.builder.model.Project;
import com.alex.project.builder.service.ProjectService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped//TODO проверить как будет себя вести при @ViewScoped
public class NameAndLocationPageAction {

    @Getter
    @Setter
    private Project project;

    @Autowired
    private ProjectService projectService;

    @PostConstruct
    public void init() {
        project = Project.getDefaultInstance();
    }

    public void next() {
        FacesUtil.addMessageInfo("Далее");
    }

    public void finish() {
        projectService.create(project);
        FacesUtil.addMessageInfo("Проект создан успешно");
    }

    public void cancell() {
        FacesUtil.addMessageInfo("Отменено");
    }

}
