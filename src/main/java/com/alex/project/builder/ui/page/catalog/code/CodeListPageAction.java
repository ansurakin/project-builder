package com.alex.project.builder.ui.page.catalog.code;

import com.alex.project.builder.domain.entity.Code;
import com.alex.project.builder.service.crud.code.CodeService;
import com.alex.project.builder.ui.util.FacesUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class CodeListPageAction {

    @Getter
    @Setter
    private List<Code> list;

    @Getter
    @Setter
    private List<Code> filteredList;

    @Autowired
    private CodeService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Code item = (Code) event.getObject();
        this.service.save(item);
        FacesUtil.addMessageInfo("Обновлено");
    }

    public void onRowCancel(RowEditEvent event) {
        FacesUtil.addMessageInfo("Отменено");
    }

    public void delete(Code item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        FacesUtil.addMessageInfo("Удалено");
    }

}
