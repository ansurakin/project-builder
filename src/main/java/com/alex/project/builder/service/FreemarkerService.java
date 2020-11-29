package com.alex.project.builder.service;

import com.alex.project.builder.util.FreemarkerUtil;
import org.springframework.stereotype.Service;

@Service
public class FreemarkerService {

    public byte[] getBytes(String template, Object data) {
        return FreemarkerUtil.getString(template, data).getBytes();
    }

}
