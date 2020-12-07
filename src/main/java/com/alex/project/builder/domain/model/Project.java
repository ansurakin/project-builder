package com.alex.project.builder.domain.model;

import com.alex.project.builder.common.lib.SystemUtil;
import com.alex.project.builder.domain.model.pom.Pom;
import lombok.Getter;
import lombok.Setter;

import static com.alex.project.builder.common.lib.SystemUtil.fileSeparator;

public class Project {

    private static final Pom DEFAULT_POM = Pom.getDefaultInstance();

    private static final String DEFAULT_PARENT_DIR = String.join(fileSeparator, SystemUtil.getCurrentDir(), "output");

    @Getter
    @Setter
    private String projectName;

    @Getter
    @Setter
    private String parentDir;

    @Getter
    @Setter
    private Pom pom;

    public static Project getDefaultInstance() {
        Project instance = new Project();
        instance.setProjectName(DEFAULT_POM.getName());
        instance.setParentDir(DEFAULT_PARENT_DIR);
        instance.setPom(DEFAULT_POM);
        return instance;
    }

    public String getPackageName() {
        return String.join(".", pom.getGroupId(), pom.getArtifactId());
    }

    public String getProjectDir() {
        return String.join(fileSeparator, parentDir, projectName);
    }

    public String getPackageDir() {
        return String.join(fileSeparator, getPackageName().split("\\."));
    }

}
