package com.alex.project.builder.domain.model;

import lombok.Getter;

public class ProjectFile {

    @Getter
    private String location;

    @Getter
    private byte[] content;

    public ProjectFile(String location, byte[] content) {
        this.location = location;
        this.content = content;
    }

}
