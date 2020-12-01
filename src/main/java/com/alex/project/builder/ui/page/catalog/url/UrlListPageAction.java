package com.alex.project.builder.ui.page.catalog.url;

import com.alex.project.builder.domain.entity.Url;
import com.alex.project.builder.service.crud.url.UrlService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class UrlListPageAction {

    @Getter
    @Setter
    private List<Url> list;

    @Getter
    @Setter
    private List<Url> filteredList;

    @Autowired
    private UrlService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Url item = (Url) event.getObject();
        this.service.save(item);
        this.showMessage("Обновлено", String.valueOf(item.getId()));
    }

    public void onRowCancel(RowEditEvent event) {
        Url item = (Url) event.getObject();
        this.showMessage("Отменено", String.valueOf(item.getId()));
    }

    public void delete(Url item) {
        this.service.delete(item.getId());
        this.list.remove(item);
//        TODO filteredLid тоже?
        this.showMessage("Удалено", String.valueOf(item.getId()));
    }

    private void showMessage(String message, String detail) {
        FacesMessage facesMessage = new FacesMessage(message, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
