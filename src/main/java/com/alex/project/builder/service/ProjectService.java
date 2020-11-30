package com.alex.project.builder.service;

import com.alex.project.builder.crud.code.CodeService;
import com.alex.project.builder.entity.Code;
import com.alex.project.builder.lib.FileUtil;
import com.alex.project.builder.model.Project;
import com.alex.project.builder.model.ProjectContent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alex.project.builder.lib.SystemUtil.fileSeparator;
import static com.alex.project.builder.model.FileType.FILE;

@Service
public class ProjectService {

    @Autowired
    private CodeService codeService;

    @Autowired
    private FreemarkerService freemarkerService;

    public void create(Project project) {
        String projectTmpDirName = project.getLocation().substring(0, project.getLocation().lastIndexOf(fileSeparator))
                + fileSeparator
                + "tmp"
                + project.getLocation().substring(project.getLocation().lastIndexOf(fileSeparator));

        List<ProjectContent> projectContents = new ArrayList<>();
        List<Code> codes = codeService.findAll();

        Map<String, Object> data = new HashMap<String, Object>() {{
            put("pom", project.getPom());
            put("packageDir", project.getPackageDir());
            put("packageName", project.getPackageName());
        }};

        for (Code code : codes) {
            projectContents.add(templateToCode(code, data));
        }

        createFiles(projectTmpDirName, projectContents);
    }

    private ProjectContent templateToCode(Code code, Object placeholder) {
        byte[] content = freemarkerService.getBytes(code.getText(), placeholder);
        String location = freemarkerService.getString(code.getLocation(), placeholder);
        return new ProjectContent(FILE, location, content);
    }

    private void createFiles(String projectDir, List<ProjectContent> contents) {
        for (ProjectContent content : contents) {
            String location = projectDir + fileSeparator
                    + String.join(fileSeparator, content.getLocation().split("/"));
            if (content.isFile()) {
                try {
                    FileUtils.writeByteArrayToFile(new File(location), content.getContent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    FileUtil.createDir(location);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
