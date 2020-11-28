package com.alex.project.builder.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class FreemarkerUtil {

    public static String getString(String templateText, Object data) {
        Configuration cfg = new Configuration();
        Template template = null;
        try {
            template = new Template("template", templateText, cfg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Writer writer = new StringWriter();
        try {
            template.process(data, writer);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

}
