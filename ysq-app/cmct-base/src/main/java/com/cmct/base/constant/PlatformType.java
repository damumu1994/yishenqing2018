package com.cmct.base.constant;

import java.util.Arrays;

/**
 * <p>
 * 平台类型
 * </p>
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/5/4
 */
public enum PlatformType {

    PAD(1, "平板"), WEB(0, "网页端");

    PlatformType(int platformType, String platformName) {
        this.platformType = platformType;
        this.platformName = platformName;
    }

    public static PlatformType getPlatformType(Integer platformType) throws Exception {

        return Arrays.stream(PlatformType.values())
                .filter(platformType1 -> platformType1.getPlatformType() == platformType)
                .findFirst()
                .orElseThrow(() -> new Exception("没有找到该Module"));
    }

    /**
     *
     */
    private int platformType;

    /**
     *
     */
    private String platformName;


    public int getPlatformType() {
        return platformType;
    }

    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }


    @Override
    public String toString() {
        return "PlatformType{" +
                "platformType=" + platformType +
                ", platformName='" + platformName + '\'' +
                '}';
    }
}
