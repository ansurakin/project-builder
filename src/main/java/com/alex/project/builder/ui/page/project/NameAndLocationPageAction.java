package com.alex.project.builder.ui.page.project;

import com.alex.project.builder.model.Project;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Component
@SessionScope//TODO проверить как будет себя вести при @ViewScoped
public class NameAndLocationPageAction {

    @Getter
    @Setter
    private Project project;

    @PostConstruct
    public void init() {
        project = Project.getDefaultInstance();
    }

}
