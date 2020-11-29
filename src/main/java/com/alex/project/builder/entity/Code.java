package com.alex.project.builder.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "code")
public class Code extends BaseEntity {

    @NotNull
    @Column(name = "key")
    private String key;

    @NotNull
    @Column(name = "text")
    private String text;

    @NotNull
    @Column(name = "location")
    private String location;

}
