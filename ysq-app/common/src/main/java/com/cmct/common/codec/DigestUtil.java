/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.codec;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具类
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class DigestUtil {
    /**
     * 指定字符串生成md5摘要的hex表示
     *
     * @param data 字符串
     * @return String md5的hex
     */
    public static String md5Hex(String data) {
        return DigestUtils.md5Hex(data);
    }

    /**
     * 指定字符串md5加上salt生成的md5 hex
     *
     * @param data 原始字符串
     * @param salt salt值
     * @return String md5的hex
     */
    public static String md5HexWithSalt(String data, String salt) {
        return DigestUtils.md5Hex(data + salt);
    }
}
