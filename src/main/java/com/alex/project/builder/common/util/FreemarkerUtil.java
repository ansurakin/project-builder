package com.alex.project.builder.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class FreemarkerUtil {

    public static String getString(Configuration configuration, String templateText, Object data) {
        Template template = null;
        try {
            template = new Template("template", templateText, configuration);
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
