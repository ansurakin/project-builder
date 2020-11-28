package com.alex.project.builder.service;

import com.alex.project.builder.lib.FileUtil;
import com.alex.project.builder.model.Project;
import com.alex.project.builder.model.ProjectContent;
import com.alex.project.builder.model.pom.Pom;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.alex.project.builder.lib.SystemUtil.fileSeparator;
import static com.alex.project.builder.model.FileType.DIR;
import static com.alex.project.builder.model.FileType.FILE;

@Service
public class ProjectService {

    @Autowired
    private PomService pomService;

    public void create(Project project) {
        String projectTmpDirName = project.getLocation().substring(0, project.getLocation().lastIndexOf(fileSeparator))
                + fileSeparator
                + "tmp"
                + project.getLocation().substring(project.getLocation().lastIndexOf(fileSeparator));

        List<ProjectContent> projectContents = new ArrayList<>();
        projectContents.add(getPom(projectTmpDirName, project.getPom()));
        projectContents.add(getPackage(projectTmpDirName, project));

        createFiles(projectContents);
    }

    private ProjectContent getPom(String projectDirName, Pom pom) {
        String pomLocation = projectDirName + fileSeparator + "pom.xml";
        byte[] pomContent = pomService.getBytes(pom);
        return new ProjectContent(FILE, pomLocation, pomContent);
    }

    private ProjectContent getPackage(String projectDirName, Project project) {
        String packageDirLocation = projectDirName
                + fileSeparator
                + String.join(fileSeparator, "src/main/java".split("/"))
                + fileSeparator
                + String.join(fileSeparator, project.getPackageName().split("\\."));
        return new ProjectContent(DIR, packageDirLocation);
    }

    private void createFiles(List<ProjectContent> contents) {
        for (ProjectContent content : contents) {
            if (content.isFile()) {
                try {
                    FileUtils.writeByteArrayToFile(new File(content.getLocation()), content.getContent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    FileUtil.createDir(content.getLocation());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
