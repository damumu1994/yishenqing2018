/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 基础条件查询
 *
 * @author losing
 * @Date 2016年8月26日
 * @since v0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseWhere {

    private Integer page = 1;
    private Integer rows = 10;
    private List<Order> orders;

    private String status;
    private String startDate;
    private String endDate;
    private String departPath;
    private Integer moduleType;
    private Integer platformType;

}
