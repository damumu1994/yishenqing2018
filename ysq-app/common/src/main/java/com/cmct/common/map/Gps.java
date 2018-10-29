/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common.map;

/**
 * 坐标点实体
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class Gps {

    private double lat;
    private double lng;

    public Gps(double lat, double lng) {

        this.lat = lat;
        this.lng = lng;

    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
