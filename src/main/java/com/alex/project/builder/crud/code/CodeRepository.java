package com.alex.project.builder.crud.code;

import com.alex.project.builder.crud.base.BaseRepository;
import com.alex.project.builder.entity.Code;

public interface CodeRepository extends BaseRepository<Code, Long> {

    Code findByKey(String key);

}
