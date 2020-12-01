package com.alex.project.builder.domain.model.pom;

import lombok.Getter;
import lombok.Setter;

public class Property {

    public static final String DEFAULT_KEY_JAVA_VERSION = "java.version";

    public static final String DEFAULT_VALUE_JAVA_VERSION = "1.8";

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;

    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Property getDefaultJavaVersionInstance() {
        Property instance = new Property(DEFAULT_KEY_JAVA_VERSION, DEFAULT_VALUE_JAVA_VERSION);
        return instance;
    }

}
