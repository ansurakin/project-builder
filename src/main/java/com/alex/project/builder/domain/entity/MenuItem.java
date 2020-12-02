package com.alex.project.builder.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "menu_item")
public class MenuItem extends BaseEntity {

    @NotNull
    @Column(name = "value")
    private String value;

    @Column(name = "icon")
    private String icon;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "url_id")
    private Url url;

}
