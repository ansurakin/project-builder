package com.alex.project.builder.crud.code;

import com.alex.project.builder.crud.base.BaseService;
import com.alex.project.builder.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService extends BaseService<Code, Long> {

    @Autowired
    private CodeRepository codeRepository;

    public Code findByKey(String key) {
        return codeRepository.findByKey(key);
    }

}
