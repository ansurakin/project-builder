package com.alex.project.builder.service;

import com.alex.project.builder.util.FreemarkerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreemarkerService {

    @Autowired
    private freemarker.template.Configuration configuration;

    public byte[] getBytes(String template, Object data) {
        return FreemarkerUtil.getString(configuration, template, data).getBytes();
    }

}
