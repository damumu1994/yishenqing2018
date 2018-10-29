package com.cmct.ysq.service;

import java.util.Map;

/**
 * @author lxb
 * @Date 2018/8/3 10:17
 * 描述:工作提醒类
 */
public interface TunnelWorkRemindService {
    void addRemind(String remindType, Map<String,Object>map);
}
