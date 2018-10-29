package com.cmct.ysq.common;


import java.util.Arrays;

/**
 * 施工方法
 */
public enum ConstructMethod {


    /**
     * 0,全面断法
     */
    FULL_FACE,

    /**
     * 1，二台阶法
     */
    TWO_STEP,

    /**
     * 2，三台阶法
     */
    THREE_STEP,

    /**
     * 3，CD法
     */
    CD,

    /**
     * 4，双层壁导坑法
     */
    PIT;

    /**
     * 获取施工方法
     *
     * @param method
     * @return
     */
    public static ConstructMethod getConstructMethod(Integer method) {
        if (method == null) {
            return null;
        }

        return Arrays.stream(ConstructMethod.values())
                .filter(constructMethod -> method.intValue() == constructMethod.ordinal())
                .findFirst()
                .orElse(null);

    }

}
