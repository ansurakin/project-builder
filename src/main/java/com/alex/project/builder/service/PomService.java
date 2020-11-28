package com.alex.project.builder.service;

import com.alex.project.builder.lib.FileUtil;
import com.alex.project.builder.model.pom.Pom;
import com.alex.project.builder.util.FreemarkerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PomService {

    @Value("classpath:code/pom.ftl")
    private Resource pomFile;

    public String create(Pom pom) {
        String template = FileUtil.fileToString(pomFile);

        Map<String, Object> data = new HashMap<>();
        data.put("pom", pom);

        return FreemarkerUtil.getString(template, data);
    }

}
