package com.alex.project.builder.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "application_property")
public class ApplicationProperty extends BaseEntity {

    @NotNull
    @Column(name = "key")
    private String key;

    @NotNull
    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

}
