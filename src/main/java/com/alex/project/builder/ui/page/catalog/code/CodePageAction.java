package com.alex.project.builder.ui.page.catalog.code;

import com.alex.project.builder.crud.code.CodeService;
import com.alex.project.builder.entity.Code;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class CodePageAction {

    @Autowired
    private CodeService service;

    @Getter
    @Setter
    private Code code;

    @PostConstruct
    public void init() {
        this.code = new Code();
    }

    public void save() {
        service.save(code);
        init();
        FacesUtil.addMessageInfo("Сохранено");
    }

    public void cancell() {
        init();
        FacesUtil.addMessageInfo("Отменено");
    }

}
