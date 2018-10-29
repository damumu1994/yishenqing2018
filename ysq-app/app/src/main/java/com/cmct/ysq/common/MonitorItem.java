package com.cmct.ysq.common;


import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * 监测项
 */
public enum MonitorItem {

    /**
     * 监测项目
     */
//    CODE_TUNNEL_MONITOR("monitor"),
    /**
     * 监测项目-掌子面观察
     */
    CODE_TUNNEL_MONITOR_FACE("monitor_face"),
    /**
     * 监测项目-地表沉降
     */
    CODE_TUNNEL_MONITOR_DOWN_FACE("monitor_down_face"),
    /**
     * 监测项目-周边收敛
     */
    CODE_TUNNEL_MONITOR_ROUND_CONVERGENCE("monitor_round_convergence"),
    /**
     * 监测项目-拱顶下沉
     */
    CODE_TUNNEL_MONITOR_DOWN_DOME("monitor_down_dome"),
    /**
     * 监测项目-钢支撑内力
     */
    CODE_TUNNEL_MONITOR_STEEL_INTERNAL_FORCE("monitor_steel_internal_force"),
    /**
     * 监测项目-围岩与初期支护接触压力
     */
    CODE_TUNNEL_MONITOR_SURROUNDING_ROCK_INITIAL_CONTACT_PRESSURE("monitor_surrounding_rock_initial_contact_pressure"),
    /**
     * 监测项目-初期支护内部应力
     */
    CODE_TUNNEL_MONITOR_INITIAL_INTERNAL_STRESS("monitor_initial_internal_stress"),
    /**
     * 监测项目-初期支护与二次衬砌接触压力
     */
    CODE_TUNNEL_MONITOR_INITIAL_SUPPORT_SECONDARY_LINING_CONTACT_PRESSURE("monitor_initial_support_secondary_lining_contact_pressure"),
    /**
     * 监测项目-二次衬砌内部应力
     */
    CODE_TUNNEL_MONITOR_SECONDARY_LINING_INTERNAL_STRESS("monitor_secondary_lining_internal_stress"),
    /**
     * 监测项目-锚杆轴力
     */
    CODE_TUNNEL_MONITOR_ANCHOR_AXIAL_FORCE("monitor_anchor_axial_force"),
    /**
     * 监测项目-围岩内部位移
     */
    CODE_TUNNEL_MONITOR_INTERNAL_DISPLACEMENT_SURROUNDING_ROCK("monitor_internal_displacement_surrounding_rock");

    private String code;

    MonitorItem(String code) {
        this.code = code;
    }

    /**
     * @param code
     * @return
     */
    public static MonitorItem getMonitorItem(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }

        return Arrays.stream(MonitorItem.values())
                .filter(monitorItem -> monitorItem.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public String getCode() {
        return code;
    }
}
