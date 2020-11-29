package com.alex.project.builder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public freemarker.template.Configuration freemarkerConfiguration() {
        return new freemarker.template.Configuration();
    }

}
