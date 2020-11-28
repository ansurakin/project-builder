package com.alex.project.builder.ui.page.project;

import com.alex.project.builder.model.Project;
import com.alex.project.builder.service.ProjectService;
import com.alex.project.builder.ui.util.FacesContextUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Component
@SessionScope//TODO проверить как будет себя вести при @ViewScoped
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

    public void finish() {
        projectService.create(project);
        FacesContextUtil.addMessageInfo("Проект создан успешно");
    }

}
