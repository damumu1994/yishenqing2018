package com.cmct.ysq.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.util.StringUtils;

import com.cmct.base.exception.CmctError;
import com.cmct.common.exception.Exceptions;
import com.cmct.ysq.StartApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IDUtil {

    /**
     * host
     */
    private static String urlPrefix;


    static {
        urlPrefix = StartApplication.applicationContext.getEnvironment().getProperty("cmct-biis-check.urlPrefix");
        if (StringUtils.isEmpty(urlPrefix)) {
            log.error("错误:{}", "请配置cmct-biis-check.urlPrefix");
            throw Exceptions.createException(CmctError.CONFIG_ERROR);
        }
    }

    public static String getId() {
        // Map<String, String> map = RestHttpRequester.getResult(urlPrefix + "api/id", Map.class);
        return UUID.randomUUID().toString();
    }

    public static List<String> getIds(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(UUID.randomUUID().toString());
        }
        //Map<String, Object> map = RestHttpRequester.getResult(urlPrefix + "api/id/list?count=" + count, Map.class);
        return list;
    }
}
