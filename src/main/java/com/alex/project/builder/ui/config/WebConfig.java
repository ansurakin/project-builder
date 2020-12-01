package com.alex.project.builder.ui.config;

import com.alex.project.builder.domain.entity.Url;
import com.alex.project.builder.service.crud.url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Установка контроллеров UI
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UrlService urlService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        List<Url> list = this.urlService.findAll();

        for (Url item : list) {
            registry.addViewController(item.getUrl())
                    .setViewName("forward:" + item.getPage());
        }

        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
