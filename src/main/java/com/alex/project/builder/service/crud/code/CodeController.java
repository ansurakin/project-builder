package com.alex.project.builder.service.crud.code;

import com.alex.project.builder.common.crud.BaseController;
import com.alex.project.builder.domain.entity.Code;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/code")
public class CodeController extends BaseController<Code, Long> {

}
