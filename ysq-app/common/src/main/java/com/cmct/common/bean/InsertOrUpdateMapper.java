package com.cmct.common.bean;

import org.apache.ibatis.annotations.InsertProvider;

/**
 * @author Administrator
 */
public interface InsertOrUpdateMapper<T>  {
    /**
     * @param record
     * @return
     */
    @InsertProvider(type = InsertOrUpdateProvider.class, method = "dynamicSQL")
    int insertOrUpdateSelective(T record);
}
