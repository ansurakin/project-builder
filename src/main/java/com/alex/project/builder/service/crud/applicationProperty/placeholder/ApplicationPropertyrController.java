package com.alex.project.builder.service.crud.applicationProperty.placeholder;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.ApplicationProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/applicationProperty")
public class ApplicationPropertyrController extends BaseController<ApplicationProperty, Long> {

}
