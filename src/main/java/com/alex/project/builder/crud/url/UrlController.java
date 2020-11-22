package com.alex.project.builder.crud.url;

import com.alex.project.builder.crud.base.BaseController;
import com.alex.project.builder.entity.Url;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/url")
public class UrlController extends BaseController<Url, Long> {

}
