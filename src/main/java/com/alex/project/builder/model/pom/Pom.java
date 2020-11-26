package com.alex.project.builder.model.pom;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class Pom {

    public static final String DEFAULT_GROUP_ID = "com.example";

    public static final String DEFAULT_ARTIFACT_ID = "demo";

    public static final String DEFAULT_VERSION = "0.1-SNAPSHOT";

    public static final String DEFAULT_NAME = "demo";

    public static final String DEFAULT_DESCRIPTION = "Demo Project";

    public static final List<Property> DEFAULT_PROPERTIES = Arrays.asList(Property.getDefaultJavaVersionInstance());

    @Getter
    @Setter
    private String groupId;

    @Getter
    @Setter
    private String artifactId;

    @Getter
    @Setter
    private String version;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private List<Property> properties;

    public static Pom getDefaultInstance() {
        Pom instance = new Pom();
        instance.setGroupId(DEFAULT_GROUP_ID);
        instance.setArtifactId(DEFAULT_ARTIFACT_ID);
        instance.setVersion(DEFAULT_VERSION);
        instance.setName(DEFAULT_NAME);
        instance.setDescription(DEFAULT_DESCRIPTION);
        instance.setProperties(DEFAULT_PROPERTIES);
        return instance;
    }

}
