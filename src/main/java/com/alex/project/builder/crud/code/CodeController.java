package com.alex.project.builder.crud.code;

import com.alex.project.builder.crud.base.BaseController;
import com.alex.project.builder.entity.Code;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/code")
public class CodeController extends BaseController<Code, Long> {

}
