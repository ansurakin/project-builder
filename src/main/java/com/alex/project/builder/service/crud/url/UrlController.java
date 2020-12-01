package com.alex.project.builder.service.crud.url;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.Url;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/url")
public class UrlController extends BaseController<Url, Long> {

}
