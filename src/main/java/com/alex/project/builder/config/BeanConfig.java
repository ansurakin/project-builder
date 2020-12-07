package com.alex.project.builder.config;

import com.alex.project.builder.domain.model.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfig {

    /* Основной бизнес-объект */
    @Bean
    @SessionScope
    public Project project() {
        return Project.getDefaultInstance();
    }

}
