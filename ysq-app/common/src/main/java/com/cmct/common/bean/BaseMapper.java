/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.bean;

import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, Serializable, InsertOrUpdateMapper<T> {

    @InsertProvider(type = AgrivoSpecialProvider.class, method = "dynamicSQL")
    int replace(T t);


}
