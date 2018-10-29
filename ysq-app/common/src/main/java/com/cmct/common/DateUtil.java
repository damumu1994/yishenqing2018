/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common;

import com.cmct.common.log.LogUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期、时间工具类
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class DateUtil {

    public static SimpleDateFormat getSimpleDateFormat(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat;
    }

    /**
     * 将时间返回成指定格式的字符串
     *
     * @param date：传入时间 format：日期格式
     * @return 返回值含义的说明
     */
    public static String data2Str(Date date, String format) {
        SimpleDateFormat dateFormat = getSimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 日期格式时间字符串转换成日期
     *
     * @param date：日期字符串 format：日期格式
     * @return 返回值含义的说明
     */
    public static Date str2Date(String date, String format) {
        try {
            SimpleDateFormat dateFormat = getSimpleDateFormat(format);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            LogUtil.error(DateUtil.class, "日期字符串转换错误");
            throw new RuntimeException("日期字符串转换错误");
        }
    }

    /**
     * 获取指定时间的时间戳
     *
     * @param 参数含义的说明
     * @return 返回值含义的说明
     */
    public static long getTimestamp(Date date) throws Exception {
        return date.getTime();
    }

    /**
     * 比较2个日期字符串的大小
     *
     * @param 参数含义的说明
     * @return 如果date1比date2晚返回true 反之返回false
     */
    public static boolean compare(String date1, String date2, String dateFormat) {
        try {
            DateFormat df = getSimpleDateFormat(dateFormat);
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LogUtil.error(DateUtil.class, "日期字符串比较错误");
            throw new RuntimeException("日期字符串比较错误");
        }
    }

    /**
     * 计算两个日期字符串之间的差值（毫秒） 格式为yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param 参数含义的说明
     * @return 返回值含义的说明
     */
    public static long msDiff(String date1, String date2, String dateFormat) {
        try {
            DateFormat df = getSimpleDateFormat(dateFormat);
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            long msDiff = Math.abs(dt1.getTime() - dt2.getTime());
            return msDiff;
        } catch (Exception e) {
            LogUtil.error(DateUtil.class, "日期字符串相差毫秒错误");
            throw new RuntimeException("日期字符串相差毫秒错误");
        }
    }

    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

}
