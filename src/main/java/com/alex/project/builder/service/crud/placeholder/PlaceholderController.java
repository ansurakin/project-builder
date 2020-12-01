package com.alex.project.builder.service.crud.placeholder;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.Placeholder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/placeholder")
public class PlaceholderController extends BaseController<Placeholder, Long> {

}
