package com.cmct.ysq.service;

import com.cmct.ysq.model.po.*;
import com.cmct.ysq.model.vo.SysDepartVo;
import com.cmct.ysq.model.vo.SysParamVo;

import java.util.List;

/**
 * @author lxb
 * @Date 2018/7/24 11:29
 * 描述:
 */
public interface TunnelCfgService {
    /**
     * 添加隧道提醒
     * @param po
     */
   void  addTunnelWorkAlert(TunnelWorkAlertPo po);

    /**
     * 添加隧道配置类型
     */
  void addTunnelCfgWay(TunnelCfgWayPo po);

    /**
     * 添加隧道人员配置
     * @param po
     */
  void addTunnelUserLink(TunnelUserLinkPo po);

    /**
     * 添加预警规则配置
     * @param po
     */
  void  addTunnelWarn(TunnelWarnPo po);

    /**
     * 添加报告模板选择
     * @param po
     */
  void addTunnelReportLink(TunnelReportLinkPo po);

    /**
     * 获取单位类型列表
     * @return
     */
 List<SysParamVo> getdepartTypeList(String param);
    /**
     * 根据 typeId  name  模糊查询
     * @param typeId
     * @param departName
     * @return
     */
    List<SysDepartVo> getDepartListLikeByDepartName(String typeId, String departName);
}
