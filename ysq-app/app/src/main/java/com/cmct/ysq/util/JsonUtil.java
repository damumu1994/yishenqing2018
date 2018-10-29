package com.cmct.ysq.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * FastJson
 *
 * @author Iceman
 */
public class JsonUtil {

    /**
     * 将JSON转成 数组类型对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getArray(String json, Class<T> clazz) {
        List<T> t = null;
        try {
            t = JSON.parseArray(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将java对象转换成json字符串
     *
     * @param obj 准备转换的对象
     * @return json字符串
     * @throws Exception
     */
    public static String getJson(Object obj) {
        String json = "";
        try {
            json = JSON.toJSONString(obj, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 将json字符串转换成java对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = JSON.parseObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 转换成MAP
     *
     * @param json
     * @return
     */
    public static Map getMap(String json) {
        try {
            JSONObject jsonMap = JSONObject.parseObject(json);
            return jsonMap;
        } catch (Exception e) {
            System.err.printf(json);
            return null;
        }

    }


}
