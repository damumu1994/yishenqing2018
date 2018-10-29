package com.cmct.ysq.service.impl;

import com.cmct.ysq.service.TunnelWorkRemindService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * @author lxb
 * @Date 2018/8/3 10:18
 * 描述:  工作提醒
 */
@Service@Transactional
public class TunnelWorkRemindServiceImpl implements TunnelWorkRemindService {
    @Override
    public void addRemind(String remindType, Map<String,Object> map) {
        /**
         * 拱顶下沉  周边收敛  地表沉降 选测项目
         * 我拥抱着爱
         * 刚从梦中醒来
         */
    }

    /**
     * 地质预报 质量检测
     */
    private void geologicalOrQuality(String remindType, Map<String,Object> map){
     switch (remindType){
         //地质预报
         case "":
             break;
             //质量检查
         case "3 b":
             break;
             default:
                 return;
     }
    }
}
