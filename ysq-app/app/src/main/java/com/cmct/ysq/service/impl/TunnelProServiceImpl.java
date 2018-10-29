package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.*;
import com.cmct.ysq.model.bo.TunnelInfoBo;
import com.cmct.ysq.model.bo.TunnelProjectBo;
import com.cmct.ysq.model.bo.TunnelTransBo;
import com.cmct.ysq.model.po.TunnelDepartLinkPo;
import com.cmct.ysq.model.po.TunnelHoleLinkPo;
import com.cmct.ysq.model.po.TunnelInfoPo;
import com.cmct.ysq.model.po.TunnelProParamLinkPo;
import com.cmct.ysq.model.vo.*;
import com.cmct.ysq.service.TunnelProService;
import com.cmct.ysq.util.IDUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * create by Administrator
 */
@Service
@Transactional
public class TunnelProServiceImpl implements TunnelProService {
    @Autowired
    private TunnelInfoMapper mapper;
    @Autowired
    private SysDepartMapper sysDepartMapper;
    @Autowired
    private TunnelProParamLinkMapper tunnelProParamLinkMapper;
    @Autowired
    private SysParamMapper sysParamMapper;
    @Autowired
    private TunnelHoleLinkMappper tunnelHoleLinkMappper;
    @Autowired
    private TunnelDepartLinkMapper tunnelDepartLinkMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Map<String, Object>> getList(String projectId) {
        return mapper.getList(projectId);
    }

    @Override
    public TunnelInfoVo getTunnelInfo(String tunnelProId) {

        String[] arr = null;
        StringBuffer sb = new StringBuffer();
        TunnelInfoVo vo = mapper.getTunnelInfo(tunnelProId);
        vo.setConstruction(query(vo.getConstruction()));
        vo.setSupervision(query(vo.getSupervision()));
        vo.setMonitor(query(vo.getMonitor()));
        String consts = vo.getConsts();
        if (consts.contains(",")) {
            arr = consts.split(",");
            for (String s : arr)
                sb.append(query(s));
        }
        vo.setConsts(sb.toString());
        //隧道方向 list
        List<TunnelProParamLinkVo> lists = tunnelProParamLinkMapper.getList(tunnelProId);
        if (lists != null) vo.setTunnelDirection(lists);
        //
        vo.setLaneNum(query2(vo.getLaneNum()));
        return vo;
    }

    @Override
    public void save(TunnelInfoBo bo) {
        String tunnelProId = IDUtil.getId();
        String contains = ",";
        //隧道方向
        if (this.checkContains(bo.getTunnelDirection(), contains)) {
            String[] arr = bo.getTunnelDirection().split(contains);
            for (String s : arr) {
                tunnelProParamLinkMapper.insert(TunnelProParamLinkPo.builder()
                        .tunnelProParamLinkId(IDUtil.getId())
                        .deleteStatus(0L)
                        .tunnelProId(tunnelProId)
                        .paramId(s)
                        .build());
            }
        }
        //隧道洞别  tunnelHoleLinkMappper
        if (this.checkContains(bo.getHoles(), contains)) {
            String[] arr = bo.getHoles().split(contains);
            for (String s : arr) {
                tunnelHoleLinkMappper.insertOrUpdateSelective(TunnelHoleLinkPo.builder()
                        .tunnelHoleLinkId(IDUtil.getId())
                        .deleteStatus(0L)
                        .paramId(s)
                        .tunnelProId(tunnelProId).build());
            }
        }
        //单位  tunnelDepartLinkMapper
        tunnelDepartLinkMapper.insertOrUpdateSelective(TunnelDepartLinkPo.builder()
                .construction(bo.getConstruction())
                .consts(bo.getConsts())
                .constBlocks(bo.getConstBlocks())
                .supervision(bo.getSupervision())
                .supervisionBlocks(bo.getSupervisionBlocks())
                .monitor(bo.getMonitor())
                .monitorBlocks(bo.getMonitorBlocks())
                .otherId(IDUtil.getId())
                .designDep(bo.getDesignDep())
                .otherDep(bo.getOtherDep())
                .build());
        //最后主体
        mapper.insert(TunnelInfoPo.builder()
                .address(bo.getAddress())//cityCode
                .beginDate(bo.getBeginDate())
                .createBy(bo.getCreateBy())
                .createDate(new Date())
                .deleteStatus(0L)
                .des(bo.getDes())
                .guideHoleEnd(bo.getGuideHoleEnd())
                .guideHoleStart(bo.getGuideHoleStart())
                .leftHoleEnd(bo.getLeftHoleEnd())
                .leftHoleStart(bo.getLeftHoleStart())
                .mainHoleEnd(bo.getMainHoleEnd())
                .mainHoleStart(bo.getMainHoleStart())
                .otherInfo(bo.getOtherInfo())
                .projectId(bo.getProjectId())
                .rightHoleEnd(bo.getRightHoleEnd())
                .rightHoleStart(bo.getRightHoleStart())
                .sectionId(bo.getSectionId())
                .tunnelName(bo.getTunnelName())
                .tunnelProId(tunnelProId)
                .tunnelType(bo.getTunnelType())
                .build());
    }

    @Override
    public List<SysParamVo> getLaneNumList(String param) {
        return sysParamMapper.getLaneNumList(param);
    }

    @Override
    public List<Map<String, Object>> getTunnelListByParam(TunnelProjectBo bo) {

        if (StringUtils.isEmpty(bo.getParamType())) {
            return null;
        }
        if (bo.getParamType().equals(TunnelProjectBo.PARAMS_TYPE_PROJECT)) {
            if (bo.getSectionName() == null) {
                bo.setSectionName("");
            }
            return projectMapper.findByprojectNameLikeList(bo.getSectionName());
        }
        if (bo.getParamType().equals(TunnelProjectBo.PARAMS_TYPE_TUNNEL)) {
            if (bo.getTunnelName() == null) {
                bo.setTunnelName("");
            }
            return mapper.getListByTunnelNameLike(bo.getTunnelName());
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> getTunnelHoleList(String tunnelId) {
        return tunnelHoleLinkMappper.findByTunnelId(tunnelId);
    }

    @Override
    public List<TunnelProParamLinkVo> getListbytunnelId(String tunnelId) {
        return tunnelProParamLinkMapper.getList(tunnelId);
    }

    @Override
    public List<TunnelTransVo> findListByTunnelTransBo(TunnelTransBo bo) {
        return mapper.findListByTunnelTransBo(bo);
    }

    @Override
    public List<TunnelTrans2Vo> getTunnelMonitoringInformation(TunnelTransBo bo) {
        return mapper.getTunnelMonitoringInformation(bo);
    }

    /**
     * 工具方法  ALL
     *
     * @param key
     * @return
     */
    private String query(String key) {
        return sysDepartMapper.selectByPrimaryKey(key).getDepartName();
    }

    private String query2(String key) {
        return sysParamMapper.selectByPrimaryKey(key).getParamName();
    }

    /**
     * @param param    数据源
     * @param contains 检查参数
     * @return
     */
    private Boolean checkContains(String param, String contains) {
        if (null == param) return false;
        return param.contains(contains);
        // return consts.split(",");
    }
}
