package com.alex.project.builder.service.crud.code;

import com.alex.project.builder.common.crud.BaseRepository;
import com.alex.project.builder.domain.entity.Code;

public interface CodeRepository extends BaseRepository<Code, Long> {

    Code findByKey(String key);

}
