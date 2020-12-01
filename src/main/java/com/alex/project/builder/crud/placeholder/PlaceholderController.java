package com.alex.project.builder.crud.placeholder;

import com.alex.project.builder.crud.base.BaseController;
import com.alex.project.builder.entity.Placeholder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/placeholder")
public class PlaceholderController extends BaseController<Placeholder, Long> {

}
