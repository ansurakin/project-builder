package com.alex.project.builder.service;

import com.alex.project.builder.crud.code.CodeService;
import com.alex.project.builder.model.pom.Pom;
import com.alex.project.builder.util.FreemarkerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PomService {

    public static final String KEY_POM = "pom.xml";

    @Autowired
    private CodeService codeService;

    public byte[] getBytes(Pom pom) {
        String template = codeService.findByKey(KEY_POM).getText();

        Map<String, Object> data = new HashMap<>();
        data.put("pom", pom);

        return FreemarkerUtil.getString(template, data).getBytes();
    }

}
