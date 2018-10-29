/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.util;

import com.cmct.common.bean.Order;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 对象工具类
 *
 * @author losing
 * @Date 2016年8月14日
 * @since v0.1
 */
public class ObjUtil {

    /**
     * 自动判断字符还是对象
     *
     * @param
     * @return 返回值含义的说明
     */
    public static boolean isNull(Object o) {
        if (o instanceof String) {
            return isStrBlank(o.toString());
        } else {
            return isObjNull(o);
        }
    }

    /**
     * 自动判断字符还是对象
     *
     * @param
     * @return 返回值含义的说明
     */
    public static boolean isNotNull(Object o) {
        if (o instanceof String) {
            return isStrNotBlank(o.toString());
        } else {
            return isObjNotNull(o);
        }
    }

    /**
     * 判断字符串为空 不能判断空格换页符
     *
     * @param
     * @return 为空 true
     */
    public static boolean isStrEmpty(String s) {
        return StringUtils.isEmpty(s);
    }

    /**
     * 判断字符串为空 可以判断空格换页符
     *
     * @param
     * @return 为空 true
     */
    public static boolean isStrBlank(String s) {
        return StringUtils.isBlank(s);
    }

    /**
     * 判断字符串不为空 不能判断空格换页符
     *
     * @param
     * @return 不为空 true
     */
    public static boolean isStrNotEmpty(String s) {
        return StringUtils.isNotEmpty(s);
    }

    /**
     * 判断字符串不为空 可以判断空格换页符
     *
     * @param
     * @return 不为空 true
     */
    public static boolean isStrNotBlank(String s) {
        return StringUtils.isNotBlank(s);
    }

    /**
     * 判断对象为空
     *
     * @param
     * @return 为空 true
     */
    public static boolean isObjNull(Object o) {
        return null == o;
    }

    /**
     * 判断对象不为空
     *
     * @param
     * @return 不为空 true
     */
    public static boolean isObjNotNull(Object o) {
        return null != o;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getWhereBean(Map<String, String> param, Class<?> clazz) throws Exception {
        Object value = null;
        Class<?>[] paramTypes = new Class[1];
        // 创建实例
        Object obj = clazz.newInstance();
        Field[] f = clazz.getDeclaredFields();
        List<Field[]> flist = new ArrayList<Field[]>();
        flist.add(f);

        Class<?> superClazz = clazz.getSuperclass();
        while (superClazz != null) {
            f = superClazz.getDeclaredFields();
            flist.add(f);
            superClazz = superClazz.getSuperclass();
        }

        for (Field[] fields : flist) {
            for (Field field : fields) {
                String fieldName = field.getName();
                if ("orders".equals(fieldName)) {
                    if (param.containsKey("sidx")) {
                        List<Order> list = new ArrayList<Order>();
                        list.add(new Order(param.get("sidx"), param.get("sord")));

                        paramTypes[0] = field.getType();
                        Method method = null;
                        // 调用相应对象的set方法
                        StringBuffer methodName = new StringBuffer("set");
                        methodName.append(fieldName.substring(0, 1).toUpperCase());
                        methodName.append(fieldName.substring(1, fieldName.length()));

                        method = clazz.getMethod(methodName.toString(), paramTypes);
                        method.invoke(obj, list);
                    }
                } else {
                    value = param.get(fieldName);
                    if (isNotNull(value)) {
                        paramTypes[0] = field.getType();
                        Method method = null;
                        // 调用相应对象的set方法
                        StringBuffer methodName = new StringBuffer("set");
                        methodName.append(fieldName.substring(0, 1).toUpperCase());
                        methodName.append(fieldName.substring(1, fieldName.length()));

                        method = clazz.getMethod(methodName.toString(), paramTypes);
                        method.invoke(obj, ConvertUtil.getValue(value.toString(), fieldName, paramTypes[0]));
                    }
                }
            }
        }
        return (T) obj;
    }

}
