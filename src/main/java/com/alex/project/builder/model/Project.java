package com.alex.project.builder.model;

import com.alex.project.builder.model.pom.Pom;
import lombok.Getter;
import lombok.Setter;

public class Project {

    private static final Pom DEFAULT_POM = Pom.getDefaultInstance();

    private static final String DEFAULT_LOCATION = "C:\\";//TODO

    private static final String DEFAULT_PACKAGE_NAME = "com.example.demo";

    @Getter
    @Setter
    private Pom pom;

    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    private String packageName;

    public static Project getDefaultInstance() {
        Project instance = new Project();
        instance.setPom(DEFAULT_POM);
        instance.setLocation(DEFAULT_LOCATION);
        instance.setPackageName(DEFAULT_PACKAGE_NAME);
        return instance;
    }

}
