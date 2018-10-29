package com.cmct.ysq.service;

import com.cmct.ysq.model.vo.TunnelProgressVo;
import com.cmct.ysq.model.vo.TunnelSurInfoVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 1
 */
public interface ITunnelProgressChartService {

    /**
     * 获取进度图
     *
     * @param userId
     * @return
     */
    List<TunnelProgressVo> getTunnelProgresss(String userId);


    /**
     * 获取围岩级别
     *
     * @param tunnelId
     * @return
     */
    List<TunnelSurInfoVo> getTunnelSurInfos(String tunnelId);


    /**
     * 获取最新的二衬数据
     *
     * @param linearId    二衬id
     * @param tunnelDirId 隧道id
     * @return 最新二衬数据
     */
    BigDecimal getNeweastLinear(String linearId, String tunnelDirId);
}
