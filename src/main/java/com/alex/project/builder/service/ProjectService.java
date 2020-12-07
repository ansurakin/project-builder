package com.alex.project.builder.service;

import com.alex.project.builder.common.lib.SystemUtil;
import com.alex.project.builder.domain.entity.Code;
import com.alex.project.builder.domain.model.Project;
import com.alex.project.builder.domain.model.ProjectFile;
import com.alex.project.builder.service.crud.code.CodeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alex.project.builder.common.lib.SystemUtil.fileSeparator;

@Service
public class ProjectService {

    @Autowired
    private CodeService codeService;

    @Autowired
    private FreemarkerService freemarkerService;

    public void create(Project project) {
        List<ProjectFile> projectFiles = getProjectFiles(project);
        createFiles(projectFiles);
    }

    public List<ProjectFile> getProjectFiles(Project project) {
        List<Code> templates = codeService.findAll();
        Map<String, Object> data = new HashMap<String, Object>() {{
            put("pom", project.getPom());
            put("packageDir", project.getPackageDir());
            put("packageName", project.getPackageName());
        }};

        String projectTmpDirName = String.join(fileSeparator, SystemUtil.getCurrentDir(), "tmp", "tmp" + System.currentTimeMillis());
        return getProjectFiles(projectTmpDirName, templates, data);
    }

    private List<ProjectFile> getProjectFiles(String parentDir, List<Code> templates, Map<String, Object> placeholder) {
        List<ProjectFile> result = new ArrayList<>();
        for (Code template : templates) {
            String location = String.join(fileSeparator, template.getLocation().split("/"));
            location = String.join(fileSeparator, parentDir, location);
            location = freemarkerService.getString(location, placeholder);
            byte[] content = freemarkerService.getBytes(template.getText(), placeholder);
            result.add(new ProjectFile(location, content));
        }
        return result;
    }

    private void createFiles(List<ProjectFile> projectFiles) {
        for (ProjectFile projectFile : projectFiles) {
            try {
                FileUtils.writeByteArrayToFile(new File(projectFile.getLocation()), projectFile.getContent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
