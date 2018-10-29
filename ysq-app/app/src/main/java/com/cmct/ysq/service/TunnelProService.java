package com.cmct.ysq.service;

import com.cmct.ysq.model.bo.TunnelInfoBo;
import com.cmct.ysq.model.bo.TunnelProjectBo;
import com.cmct.ysq.model.bo.TunnelTransBo;
import com.cmct.ysq.model.vo.*;

import java.util.List;
import java.util.Map;

/**
 * create by Administrator
 */
public interface TunnelProService {
    /**
     * 获取该项目下所有隧道列表
     * @param projectId
     * @return
     */
    List<Map<String,Object>> getList(String projectId);

    TunnelInfoVo getTunnelInfo(String tunnelProId);

    /**
     * 添加隧道基本信息
     * @param bo
     */
    void save(TunnelInfoBo bo);

    /**
     * 获取列表
     * @return
     */
    List<SysParamVo> getLaneNumList(String param);

    /**
     * 根据条件筛选
     * @param bo
     */
    List<Map<String,Object>> getTunnelListByParam(TunnelProjectBo bo);

    /**
     * 得到洞列表
     * @param tunnelId
     * @return
     */
    List<Map<String,Object>> getTunnelHoleList(String tunnelId);
    /**
     * 根据隧道id获取隧道方向
     *
     * @return
     */
    List<TunnelProParamLinkVo> getListbytunnelId(String tunnelId);

    /**
     * pad 筛选
     * @param bo
     * @return
     */
    List<TunnelTransVo> findListByTunnelTransBo(TunnelTransBo bo);
    List<TunnelTrans2Vo>  getTunnelMonitoringInformation(TunnelTransBo bo);
}
