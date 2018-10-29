/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.bean;

/**
 * 排序实体
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class Order {

    private String direction;// 升序/倒序
    private String field;// 字段

    public Order() {
    }

    public Order(String field, String direction) {
        this.direction = direction;
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
