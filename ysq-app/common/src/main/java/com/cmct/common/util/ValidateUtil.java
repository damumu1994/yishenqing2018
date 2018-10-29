package com.cmct.common.util;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author shen
 */
public final class ValidateUtil {

    /**
     * 是否是合法的请求参数
     *
     * @param param 参数
     * @return 是否合法
     */
    public static boolean paramInvalid(String param) {
        return StringUtils.isEmpty(param)
                || param.length() != 36
                || !checkIsUuid(param);
    }


    /**
     * 检验是否uuid
     *
     * @param uuidStr
     * @return
     */
    public static boolean checkIsUuid(String uuidStr) {
        try {
            UUID.fromString(uuidStr).toString();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
