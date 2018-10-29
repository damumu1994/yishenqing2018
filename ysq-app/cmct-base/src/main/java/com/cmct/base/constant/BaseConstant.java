/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.base.constant;

/**
 * 静态参数
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class BaseConstant {

    /********************** root *************************/
    public static final String ROOT = "/";

    public static final String STATUS_YES = "1";
    public static final String STATUS_DESTROY = "2";
    public static final String STATUS_FINISHED = "8";
    public static final String STATUS_STARTED = "9";

    /********************** time format *************************/

    /********************** sex *************************/
    public static final String SEX_FEMALE = "0";
    public static final String SEX_MALE = "1";
    public static final String SEX_UNKNOWN = "2";
    /********************** sex *************************/


    /********************** password *************************/
    public static final String INIT_PASSWORD = "123456";
    /********************** password *************************/


    /********************** resource *************************/
    public static final String RESOURCE_MENU = "0";
    public static final String RESOURCE_BUTTON = "1";
    /********************** resource *************************/

    public static final String PHOTO_NOT_FOUND =
            "http://biis.oss-cn-shanghai.aliyuncs.com/common/not_find.png";
    public static final String DEFAULT_AVATERS_MALE =
            "http://biis.oss-cn-shanghai.aliyuncs.com/user/avatars/default/male.jpg";
    public static final String DEFAULT_AVATERS_FEMALE =
            "http://biis.oss-cn-shanghai.aliyuncs.com/user/avatars/default/female.jpg";


    /********************** 报告类型 *************************/
    public static final String REPORT_TYPE_CHECK = "0";//定期检测报告
    public static final String REPORT_TYPE_RECORD = "1";//原始记录

}
