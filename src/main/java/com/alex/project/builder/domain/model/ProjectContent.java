package com.alex.project.builder.domain.model;

import lombok.Getter;

import static com.alex.project.builder.domain.model.FileType.FILE;

public class ProjectContent {

    @Getter
    private FileType fileType;

    @Getter
    private String location;

    @Getter
    private byte[] content;

    public ProjectContent(FileType fileType, String location, byte[] content) {
        this.fileType = fileType;
        this.location = location;
        this.content = content;
    }

    public ProjectContent(FileType fileType, String location) {
        this.fileType = fileType;
        this.location = location;
    }

    public boolean isFile() {
        return fileType == FILE;
    }

}
