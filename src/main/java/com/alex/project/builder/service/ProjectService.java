package com.alex.project.builder.service;

import com.alex.project.builder.model.Project;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ProjectService {

    @Autowired
    private PomService pomService;

    public void create(Project project) {
        String projectDirName = project.getLocation() + "Tmp";

        String pom = pomService.create(project.getPom());
//        Resource pomResource = new ByteArrayResource(pom.getBytes());
        File pomFile = new File(projectDirName, "pom.xml");
        try {
            FileUtils.writeByteArrayToFile(pomFile, pom.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    private void createFiles(List<File> files) throws IOException {
//        for (File file : files) {
//            FileUtil.createDir(file.getAbsolutePath());
//        }
//    }


//
//        File projectDir = new File(projectDirName);
//        content.add(projectDir);
//
//        String packageDirName = projectDirName
//                + SystemUtil.fileSeparator
//                + String.join(SystemUtil.fileSeparator, project.getPackageName().split("\\."));
//        content.add(new File(packageDirName));
//
//        createFiles(content);

}
