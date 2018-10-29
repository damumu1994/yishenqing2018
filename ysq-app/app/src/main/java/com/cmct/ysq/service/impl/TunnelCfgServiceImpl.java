package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.*;
import com.cmct.ysq.model.po.*;
import com.cmct.ysq.model.vo.SysDepartVo;
import com.cmct.ysq.model.vo.SysParamVo;
import com.cmct.ysq.service.TunnelCfgService;
import com.cmct.ysq.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author lxb
 * @Date 2018/7/24 11:31
 * 描述:
 */
@Service
@Transactional
public class TunnelCfgServiceImpl implements TunnelCfgService {
    @Autowired
    private TunnelWorkAlertMappper tunnelWorkAlertMappper;
    @Autowired
    private TunnelUserLinkMapper tunnelUserLinkMapper;
    @Autowired
    private TunnelWarnMapper tunnelWarnMapper;
    @Autowired
    private TunnelReportLinkMapper tunnelReportLinkMapper;
    @Autowired
    private TunnelCfgWayMapper tunnelCfgWayMapper;
    @Autowired
    private SysParamMapper sysParamMapper;
    @Autowired
    private SysDepartMapper sysDepartMapper;
    @Override
    public void addTunnelWorkAlert(TunnelWorkAlertPo po) {
        po.setWorkAlertId(IDUtil.getId());
        po.setDeleteStatus(0L);
        po.setCreateDate(new Date());
        //tunnelWorkAlertMappper.save(po);
        tunnelWorkAlertMappper.insertOrUpdateSelective(po);
    }

    @Override
    public void addTunnelCfgWay(TunnelCfgWayPo po) {
        po.setTunnelCfgId(IDUtil.getId());
        po.setCreateDate(new Date());
        po.setDeleteStatus(0L);
        tunnelCfgWayMapper.insertOrUpdateSelective(po);
    }

    @Override
    public void addTunnelUserLink(TunnelUserLinkPo po) {
        po.setTunnelUserLinkId(IDUtil.getId());
        po.setDeleteStatus(0L);
        po.setCreateDate(new Date());
        tunnelUserLinkMapper.insertOrUpdateSelective(po);
    }

    @Override
    public void addTunnelWarn(TunnelWarnPo po) {
        po.setWarnId(IDUtil.getId());
        po.setCreateDate(new Date());
        po.setDeleteStatus(0L);
        tunnelWarnMapper.insertOrUpdateSelective(po);
    }

    @Override
    public void addTunnelReportLink(TunnelReportLinkPo po) {
        po.setDeleteStatus(0L);
        po.setReportTunnelLinkId(IDUtil.getId());
        po.setCreateDate(new Date());
        tunnelReportLinkMapper.insertOrUpdateSelective(po);
    }

    @Override
    public List<SysParamVo> getdepartTypeList(String param) {
        return sysParamMapper.getLaneNumList(param);
    }

    @Override
    public List<SysDepartVo> getDepartListLikeByDepartName(String typeId, String departName) {
        return sysDepartMapper.getDepartListLikeByDepartName(typeId,departName);
    }
}
