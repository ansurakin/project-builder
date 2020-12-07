package com.alex.project.builder.ui.page.catalog.applicationProperty;

import com.alex.project.builder.domain.entity.ApplicationProperty;
import com.alex.project.builder.service.crud.applicationProperty.placeholder.ApplicationPropertyService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class ApplicationPropertyPageAction {

    @Autowired
    private ApplicationPropertyService service;

    @Getter
    @Setter
    private ApplicationProperty data;

    @PostConstruct
    public void init() {
        this.data = new ApplicationProperty();
    }

    public void save() {
        service.save(data);
        init();
        FacesUtil.addMessageInfo("Сохранено");
    }

    public void cancell() {
        init();
        FacesUtil.addMessageInfo("Отменено");
    }

}
