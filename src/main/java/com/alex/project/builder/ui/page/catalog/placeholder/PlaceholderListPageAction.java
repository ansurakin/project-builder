package com.alex.project.builder.ui.page.catalog.placeholder;

import com.alex.project.builder.crud.placeholder.PlaceholderService;
import com.alex.project.builder.entity.Placeholder;
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
public class PlaceholderListPageAction {

    @Getter
    @Setter
    private List<Placeholder> list;

    @Getter
    @Setter
    private List<Placeholder> filteredList;

    @Autowired
    private PlaceholderService service;

    @PostConstruct
    public void init() {
        this.list = this.service.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        Placeholder item = (Placeholder) event.getObject();
        this.service.save(item);
        FacesUtil.addMessageInfo("Обновлено");
    }

    public void onRowCancel(RowEditEvent event) {
        FacesUtil.addMessageInfo("Отменено");
    }

    public void delete(Placeholder item) {
        this.service.delete(item.getId());
        this.list.remove(item);
        FacesUtil.addMessageInfo("Удалено");
    }

}
