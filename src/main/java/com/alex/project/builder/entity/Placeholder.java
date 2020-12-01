package com.alex.project.builder.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "placeholder")
public class Placeholder extends BaseEntity {

    @NotNull
    @Column(name = "key")
    private String key;

    @NotNull
    @Column(name = "value")
    private String value;

    @NotNull
    @Column(name = "description")
    private String description;

}
