package com.alex.project.builder.ui.page.catalog.url;

import com.alex.project.builder.crud.url.UrlService;
import com.alex.project.builder.entity.Url;
import com.alex.project.builder.ui.util.FacesContextUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.IOException;

@Component
@ViewScoped
public class UrlPageAction {

    @Autowired
    private UrlService service;

    @Getter
    @Setter
    private Url url;

    @PostConstruct
    public void init() {
        this.url = new Url();
    }

    public void save() throws IOException {
        service.save(url);
        init();
        FacesContextUtil.addMessageInfo("Сохранено");
    }

    public void cancell() {
        init();
        FacesContextUtil.addMessageInfo("Отменено");
    }

}
