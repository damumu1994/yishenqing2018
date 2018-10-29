/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common;

/**
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public interface HttpResponseParser<T> {

    T parse(String content);

}
