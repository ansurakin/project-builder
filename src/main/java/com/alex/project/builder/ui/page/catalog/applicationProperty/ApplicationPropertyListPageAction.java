package com.alex.project.builder.ui.page.catalog.applicationProperty;

import com.alex.project.builder.domain.entity.ApplicationProperty;
import com.alex.project.builder.service.crud.applicationProperty.placeholder.ApplicationPropertyService;
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
public class ApplicationPropertyListPageAction {

    @Getter
    @Setter
    private List<ApplicationProperty> list;

    @Getter
    @Setter
    private List<ApplicationProperty> filteredList;

    @Autowired
    private ApplicationPropertyService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        ApplicationProperty item = (ApplicationProperty) event.getObject();
        this.service.save(item);
        FacesUtil.addMessageInfo("Обновлено");
    }

    public void delete(ApplicationProperty item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        FacesUtil.addMessageInfo("Удалено");
    }


    public void onRowCancel(RowEditEvent event) {
        FacesUtil.addMessageInfo("Отменено");
    }

}
