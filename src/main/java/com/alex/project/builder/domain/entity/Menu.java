package com.alex.project.builder.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    @NotNull
    @Column(name = "label")
    private String label;

}
