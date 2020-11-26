package com.alex.project.builder.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "url")
public class Url extends BaseEntity {

    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "page")
    private String page;

}
