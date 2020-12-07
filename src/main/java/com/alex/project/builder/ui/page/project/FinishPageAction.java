package com.alex.project.builder.ui.page.project;

import com.alex.project.builder.domain.model.Project;
import com.alex.project.builder.domain.model.ProjectFile;
import com.alex.project.builder.service.ProjectService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.IOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
@ViewScoped
public class FinishPageAction {

    @Getter
    private List<ProjectFile> projectFiles;

    @Getter
    @Autowired
    private Project project;

    @Autowired
    private ProjectService projectService;

    @PostConstruct
    public void init() {
        projectFiles = projectService.getProjectFiles(project);
    }

    public void prevous() throws IOException {
        FacesUtil.addMessageInfo("Назад");
    }

    public void cancell() throws IOException {
        FacesUtil.addMessageInfo("Отменено");
        FacesUtil.redirect("/page/project/nameAndLocation");
    }

    public void create() {
        projectService.create(project);
        FacesUtil.addMessageInfo("Проект создан успешно");
    }

    public String bytesToString(byte[] bytes) {
        return new String(bytes, UTF_8);
    }

}
