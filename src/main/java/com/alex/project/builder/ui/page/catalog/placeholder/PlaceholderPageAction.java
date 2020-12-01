package com.alex.project.builder.ui.page.catalog.placeholder;

import com.alex.project.builder.domain.entity.Placeholder;
import com.alex.project.builder.service.crud.placeholder.PlaceholderService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class PlaceholderPageAction {

    @Autowired
    private PlaceholderService service;

    @Getter
    @Setter
    private Placeholder data;

    @PostConstruct
    public void init() {
        this.data = new Placeholder();
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
