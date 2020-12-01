package com.alex.project.builder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FreemarkerConfig {

    @Bean
    public freemarker.template.Configuration freemarkerConfiguration() {
        return new freemarker.template.Configuration();
    }

}
