/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.bean;

import com.github.pagehelper.Page;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class JsonPage<T> {

    private List<T> rows;
    private int page;//当前页
    private int total;//总页数
    private Long records;//总条数

    public JsonPage() {
    }

    /**
     * 通过Page生成JsonPage
     *
     * @param page
     */
    public JsonPage(Page<T> page) {
        this.rows = page.getResult();
        this.page = page.getPageNum();
        this.total = page.getPages();
        this.records = page.getTotal();
    }

    /**
     * 通过List生成JsonPage
     *
     * @param rows
     * @param page
     * @param total
     * @param records
     */
    public JsonPage(List<T> rows, int page, int total, Long records) {
        this.rows = rows;
        this.page = page;
        this.total = total;
        this.records = records;
    }


}
