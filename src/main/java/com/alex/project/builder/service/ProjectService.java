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

import static com.alex.project.builder.crud.code.CodeService.KEY_POM_XML;
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

        Map<String, Object> pomData = new HashMap<String, Object>() {{
            put("pom", project.getPom());
        }};

        List<ProjectContent> projectContents = new ArrayList<>();
        projectContents.add(templateToCode(codeService.findByKey(KEY_POM_XML), pomData));

        createFiles(projectTmpDirName, projectContents);
    }

    private ProjectContent templateToCode(Code code, Object placeholder) {
        byte[] content = freemarkerService.getBytes(code.getText(), placeholder);
        return new ProjectContent(FILE, code.getLocation(), content);
    }

    private void createFiles(String projectDir, List<ProjectContent> contents) {
        for (ProjectContent content : contents) {
            String location = projectDir + String.join(fileSeparator, content.getLocation().split("/"));
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
