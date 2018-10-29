package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.base.exception.CmctError;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.exception.Exceptions;
import com.cmct.common.util.ValidateUtil;
import com.cmct.ysq.common.MonitorItem;
import com.cmct.ysq.mapper.*;
import com.cmct.ysq.model.bo.*;
import com.cmct.ysq.model.po.*;
import com.cmct.ysq.model.vo.*;
import com.cmct.ysq.service.ITunnelMonitorItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 监测项管理service impl
 *
 * @author shen
 */
@Slf4j
@Service
public class TunnelMonitorItemServiceImpl implements ITunnelMonitorItemService {

    @Autowired
    private TunnelRecordMapper tunnelRecordMapper;

    @Autowired
    private TunnelMonitorMapper tunnelMonitorMapper;

    @Autowired
    private TunnelFaceMapper tunnelFaceMapper;

    @Autowired
    private TunnelHoleArcDownMapper tunnelHoleArcDownMapper;

    @Autowired
    private TunnelSurfaceDownMapper tunnelSurfaceDownMapper;

    @Autowired
    private TunnelSurrConMapper tunnelSurrConMapper;

    @Autowired
    private TunnelAxialBoltForceMapper tunnelAxialBoltForceMapper;

    @Autowired
    private TunnelSteelInternalForceMapper tunnelSteelInternalForceMapper;
    @Autowired
    private TunnelInternalStressIniSupportMapper tunnelInternalStressIniSupportMapper;

    @Autowired
    private TunnelInternalTwoStressMapper tunnelInternalTwoStressMapper;

    @Autowired
    private TunnelInternalSurrRockDisplacementMapper tunnelInternalSurrRockDisplacementMapper;

    @Autowired
    private TunnelSurrRockInitialPressureMapper tunnelSurrRockInitialPressureMapper;

    @Autowired
    private TunnelIniSupportTwoPressureMapper tunnelIniSupportTwoPressureMapper;
    @Autowired
    private TunnelRecordFileMapper tunnelRecordFileMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public JsonPage<TunnelMonitorItemBaseVo> getTunnelMonitorItemBaseInfoList(BaseModelBo pageQuery) {

        if (null == pageQuery) {
            pageQuery = new BaseModelBo();
        }

        Page<TunnelMonitorItemBaseVo> page = PageHelper.startPage(pageQuery.getPage(), pageQuery.getRows());
        tunnelRecordMapper.getTunnelMonitorItemBaseInfoList();

        return new JsonPage(page);
    }

    @Override
    public TunnelCrossSectionVo getCrossSection(String monitorItemRecordId) {

        if (ValidateUtil.paramInvalid(monitorItemRecordId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "monitorItemRecordId为空");
        }

        return tunnelMonitorMapper.getCrossSection(monitorItemRecordId);
    }

    @Override
    public void deleteTunnelMonitorItem(String monitorItemRecordId, String modifyBy) {

        if (ValidateUtil.paramInvalid(monitorItemRecordId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "monitorItemRecordId为空");
        }

        tunnelMonitorMapper.updateByPrimaryKeySelective(TunnelMonitorPo.builder()
                .monitorId(monitorItemRecordId)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .deleteStatus(DeleteStatus.NO.ordinal())
                .build());
    }


    @Transactional(rollbackOn = Exception.class)
    @Override
    public void updateTunnelMonitorItem(String monitorItemRecordId, TunnelMonitorItemForUpdateBo updateInfo,
                                        String modifyBy) {

        if (ValidateUtil.paramInvalid(monitorItemRecordId) || updateInfo == null) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "monitorItemRecordId或者updateInfo无效");
        }

        TunnelRecordPo preTunnelRecordPo = tunnelRecordMapper.selectByPrimaryKey(monitorItemRecordId);

        if (preTunnelRecordPo == null || null == preTunnelRecordPo.getDeleteStatus()
                || preTunnelRecordPo.getDeleteStatus() != 0) {
            throw Exceptions.createException(CmctError.DATA_ERROR, "监测项无效");
        }

        TunnelRecordPo newTunnelRecordPo = TunnelRecordPo.builder().build();

        BeanUtils.copyProperties(preTunnelRecordPo, newTunnelRecordPo);

        String newRecordId = UUID.randomUUID().toString();
        newTunnelRecordPo.setRecordId(newRecordId);
        newTunnelRecordPo.setCreateBy(modifyBy);
        newTunnelRecordPo.setCreateDate(new Date());
        newTunnelRecordPo.setRemark(updateInfo.getRemark());


        //1.新增新修改的断面信息
        tunnelRecordMapper.insertSelective(newTunnelRecordPo);
        //2.插入数据
        String methodCode = tunnelMonitorMapper.getMonitorItemMethod(preTunnelRecordPo.getMonitorId());

        if (StringUtils.isEmpty(methodCode)) {
            log.error("methodCode为空");
            throw Exceptions.createException(CmctError.CONFIG_ERROR, "监测项的编码为空");
        }

        switch (MonitorItem.getMonitorItem(methodCode)) {
            case CODE_TUNNEL_MONITOR_FACE:
                if (null == updateInfo.getFaceForUpdate()) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "掌子面观察数据为空");
                }
                TunnelFacePo newTunnelFaceTargetPo = TunnelFacePo.builder().build();
                BeanUtils.copyProperties(updateInfo.getFaceForUpdate(), newTunnelFaceTargetPo);

                newTunnelFaceTargetPo.setFaceId(UUID.randomUUID().toString());
                newTunnelFaceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                newTunnelFaceTargetPo.setCreateBy(modifyBy);
                newTunnelFaceTargetPo.setCreateDate(new Date());
                newTunnelFaceTargetPo.setRecordId(newRecordId);
                tunnelFaceMapper.insertSelective(newTunnelFaceTargetPo);
                break;
            case CODE_TUNNEL_MONITOR_DOWN_DOME:

                List<TunnelHoleArcDownForUpdateBo> holeArcDownForUpdates = updateInfo.getHoleArcDownForUpdates();
                if (CollectionUtils.isEmpty(holeArcDownForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "拱顶下沉数据为空");
                }

                holeArcDownForUpdates.forEach(tunnelHoleArcDownForUpdateBo -> {
                    TunnelHoleArcDownPo newTunnelHoleArcDownTargetPo = TunnelHoleArcDownPo.builder().build();
                    BeanUtils.copyProperties(tunnelHoleArcDownForUpdateBo, newTunnelHoleArcDownTargetPo);
                    newTunnelHoleArcDownTargetPo.setHoleArcDownId(UUID.randomUUID().toString());
                    newTunnelHoleArcDownTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelHoleArcDownTargetPo.setCreateBy(modifyBy);
                    newTunnelHoleArcDownTargetPo.setCreateDate(new Date());
                    newTunnelHoleArcDownTargetPo.setRecordId(newRecordId);
                    tunnelHoleArcDownMapper.insertSelective(newTunnelHoleArcDownTargetPo);
                });

                break;
            case CODE_TUNNEL_MONITOR_DOWN_FACE:

                List<TunnelSurfaceDownForUpdateBo> surfaceDownForUpdates = updateInfo.getSurfaceDownForUpdates();
                if (CollectionUtils.isEmpty(surfaceDownForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "地表沉降数据为空");
                }

                surfaceDownForUpdates.forEach(tunnelSurfaceDownForUpdateBo -> {
                    TunnelSurfaceDownPo newTunnelSurfaceDownTargetPo = TunnelSurfaceDownPo.builder().build();
                    BeanUtils.copyProperties(tunnelSurfaceDownForUpdateBo, newTunnelSurfaceDownTargetPo);
                    newTunnelSurfaceDownTargetPo.setSurfaceDownId(UUID.randomUUID().toString());
                    newTunnelSurfaceDownTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelSurfaceDownTargetPo.setCreateBy(modifyBy);
                    newTunnelSurfaceDownTargetPo.setCreateDate(new Date());
                    newTunnelSurfaceDownTargetPo.setRecordId(newRecordId);
                    tunnelSurfaceDownMapper.insertSelective(newTunnelSurfaceDownTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_ROUND_CONVERGENCE:

                List<TunnelSurrConForUpdateBo> surrConForUpdates = updateInfo.getSurrConForUpdates();
                if (CollectionUtils.isEmpty(surrConForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "周边收敛数据为空");
                }

                surrConForUpdates.forEach(surrConForUpdateBo -> {
                    TunnelSurrConPo newTunnelSurrConTargetPo = TunnelSurrConPo.builder().build();
                    BeanUtils.copyProperties(surrConForUpdateBo, newTunnelSurrConTargetPo);
                    newTunnelSurrConTargetPo.setSurrConId(UUID.randomUUID().toString());
                    newTunnelSurrConTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelSurrConTargetPo.setCreateBy(modifyBy);
                    newTunnelSurrConTargetPo.setCreateDate(new Date());
                    newTunnelSurrConTargetPo.setRecordId(newRecordId);
                    tunnelSurrConMapper.insertSelective(newTunnelSurrConTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_ANCHOR_AXIAL_FORCE:


                List<TunnelAxialBoltForceForUpdateBo> axialBoltForceForUpdates = updateInfo.getAxialBoltForceForUpdates();
                if (CollectionUtils.isEmpty(axialBoltForceForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "锚杆轴力数据为空");
                }

                axialBoltForceForUpdates.forEach(axialBoltForceForUpdateBo -> {
                    TunnelAxialBoltForcePo newTunnelAxialBoltForceTargetPo = TunnelAxialBoltForcePo.builder().build();
                    BeanUtils.copyProperties(axialBoltForceForUpdateBo, newTunnelAxialBoltForceTargetPo);
                    newTunnelAxialBoltForceTargetPo.setSurrRockInitialPressureIid(UUID.randomUUID().toString());
                    newTunnelAxialBoltForceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelAxialBoltForceTargetPo.setCreateBy(modifyBy);
                    newTunnelAxialBoltForceTargetPo.setCreateDate(new Date());
                    newTunnelAxialBoltForceTargetPo.setRecordId(newRecordId);
                    tunnelAxialBoltForceMapper.insertSelective(newTunnelAxialBoltForceTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_STEEL_INTERNAL_FORCE:

                List<TunnelSteelInternalForceForUpdateBo> steelInternalForceForUpdates = updateInfo.getSteelInternalForceForUpdates();
                if (CollectionUtils.isEmpty(steelInternalForceForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "钢支撑内力数据为空");
                }

                steelInternalForceForUpdates.forEach(steelInternalForceForUpdateBo -> {
                    TunnelSteelInternalForcePo newTunnelSteelInternalForceTargetPo = TunnelSteelInternalForcePo.builder().build();
                    BeanUtils.copyProperties(steelInternalForceForUpdateBo, newTunnelSteelInternalForceTargetPo);
                    newTunnelSteelInternalForceTargetPo.setSteelInternalForceId(UUID.randomUUID().toString());
                    newTunnelSteelInternalForceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelSteelInternalForceTargetPo.setCreateBy(modifyBy);
                    newTunnelSteelInternalForceTargetPo.setCreateDate(new Date());
                    newTunnelSteelInternalForceTargetPo.setRecordId(newRecordId);
                    tunnelSteelInternalForceMapper.insertSelective(newTunnelSteelInternalForceTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_INITIAL_INTERNAL_STRESS:

                List<TunnelInternalStressIniSupportForUpdateBo> internalStressIniSupportForUpdates =
                        updateInfo.getInternalStressIniSupportForUpdates();
                if (CollectionUtils.isEmpty(internalStressIniSupportForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "初期支护内部应力数据为空");
                }

                internalStressIniSupportForUpdates.forEach(internalStressIniSupportForUpdateBo -> {
                    TunnelInternalStressIniSupportPo newTunnelInternalStressIniSupportTargetPo =
                            TunnelInternalStressIniSupportPo.builder().build();
                    BeanUtils.copyProperties(internalStressIniSupportForUpdateBo, newTunnelInternalStressIniSupportTargetPo);
                    newTunnelInternalStressIniSupportTargetPo.setSurrRockInitialPressureId(UUID.randomUUID().toString());
                    newTunnelInternalStressIniSupportTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelInternalStressIniSupportTargetPo.setCreateBy(modifyBy);
                    newTunnelInternalStressIniSupportTargetPo.setCreateDate(new Date());
                    newTunnelInternalStressIniSupportTargetPo.setRecordId(newRecordId);
                    tunnelInternalStressIniSupportMapper.insertSelective(newTunnelInternalStressIniSupportTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_SECONDARY_LINING_INTERNAL_STRESS:

                List<TunnelInternalTwoStressForUpdateBo> internalTwoStressForUpdates = updateInfo.getInternalTwoStressForUpdates();

                if (CollectionUtils.isEmpty(internalTwoStressForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "二次衬砌内部应力数据为空");
                }

                internalTwoStressForUpdates.forEach(internalTwoStressForUpdateBo -> {
                    TunnelInternalTwoStressPo newTunnelInternalTwoStressTargetPo = TunnelInternalTwoStressPo.builder().build();
                    BeanUtils.copyProperties(internalTwoStressForUpdateBo, newTunnelInternalTwoStressTargetPo);
                    newTunnelInternalTwoStressTargetPo.setSurrRockInitialPressureIid(UUID.randomUUID().toString());
                    newTunnelInternalTwoStressTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelInternalTwoStressTargetPo.setCreateBy(modifyBy);
                    newTunnelInternalTwoStressTargetPo.setCreateDate(new Date());
                    newTunnelInternalTwoStressTargetPo.setRecordId(newRecordId);
                    tunnelInternalTwoStressMapper.insertSelective(newTunnelInternalTwoStressTargetPo);
                });

                break;
            case CODE_TUNNEL_MONITOR_INTERNAL_DISPLACEMENT_SURROUNDING_ROCK:

                List<TunnelInternalSurrRockDisplacementForUpdateBo> internalSurrRockDisplacementForUpdates =
                        updateInfo.getInternalSurrRockDisplacementForUpdates();

                if (CollectionUtils.isEmpty(internalSurrRockDisplacementForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "围岩内部位移数据为空");
                }

                internalSurrRockDisplacementForUpdates.forEach(internalSurrRockDisplacementForUpdateBo -> {
                    TunnelInternalSurrRockDisplacementPo newTunnelInternalSurrRockDisplacementTargetPo =
                            TunnelInternalSurrRockDisplacementPo.builder().build();
                    BeanUtils.copyProperties(internalSurrRockDisplacementForUpdateBo, newTunnelInternalSurrRockDisplacementTargetPo);
                    newTunnelInternalSurrRockDisplacementTargetPo.setInternalSurrRockDisplacementId(UUID.randomUUID().toString());
                    newTunnelInternalSurrRockDisplacementTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelInternalSurrRockDisplacementTargetPo.setCreateBy(modifyBy);
                    newTunnelInternalSurrRockDisplacementTargetPo.setCreateDate(new Date());
                    newTunnelInternalSurrRockDisplacementTargetPo.setRecordId(newRecordId);
                    tunnelInternalSurrRockDisplacementMapper.insertSelective(newTunnelInternalSurrRockDisplacementTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_SURROUNDING_ROCK_INITIAL_CONTACT_PRESSURE:

                List<TunnelSurrRockInitialPressureForUpdateBo> surrRockInitialPressureForUpdates =
                        updateInfo.getSurrRockInitialPressureForUpdates();

                if (CollectionUtils.isEmpty(surrRockInitialPressureForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "围岩与初期支护接触压力数据为空");
                }

                surrRockInitialPressureForUpdates.forEach(surrRockInitialPressureForUpdateBo -> {
                    TunnelSurrRockInitialPressurePo newTunnelSurrRockInitialPressureTargetPo =
                            TunnelSurrRockInitialPressurePo.builder().build();
                    BeanUtils.copyProperties(surrRockInitialPressureForUpdateBo, newTunnelSurrRockInitialPressureTargetPo);
                    newTunnelSurrRockInitialPressureTargetPo.setSurrRockInitialPressureId(UUID.randomUUID().toString());
                    newTunnelSurrRockInitialPressureTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelSurrRockInitialPressureTargetPo.setCreateBy(modifyBy);
                    newTunnelSurrRockInitialPressureTargetPo.setCreateDate(new Date());
                    newTunnelSurrRockInitialPressureTargetPo.setRecordId(newRecordId);
                    tunnelSurrRockInitialPressureMapper.insertSelective(newTunnelSurrRockInitialPressureTargetPo);
                });
                break;
            case CODE_TUNNEL_MONITOR_INITIAL_SUPPORT_SECONDARY_LINING_CONTACT_PRESSURE:
                List<TunnelIniSupportTwoPressureForUpdateBo> iniSupportTwoPressureForUpdates =
                        updateInfo.getIniSupportTwoPressureForUpdates();

                if (CollectionUtils.isEmpty(iniSupportTwoPressureForUpdates)) {
                    throw Exceptions.createException(CmctError.PARAM_ERROR, "初期支护与二次衬砌接触压力数据为空");
                }

                iniSupportTwoPressureForUpdates.forEach(iniSupportTwoPressureForUpdateBo -> {
                    TunnelIniSupportTwoPressurePo newTunnelIniSupportTwoPressureTargetPo =
                            TunnelIniSupportTwoPressurePo.builder().build();
                    BeanUtils.copyProperties(iniSupportTwoPressureForUpdateBo, newTunnelIniSupportTwoPressureTargetPo);
                    newTunnelIniSupportTwoPressureTargetPo.setIniSupportTwoPressureId(UUID.randomUUID().toString());
                    newTunnelIniSupportTwoPressureTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelIniSupportTwoPressureTargetPo.setCreateBy(modifyBy);
                    newTunnelIniSupportTwoPressureTargetPo.setCreateDate(new Date());
                    newTunnelIniSupportTwoPressureTargetPo.setRecordId(newRecordId);
                    tunnelIniSupportTwoPressureMapper.insertSelective(newTunnelIniSupportTwoPressureTargetPo);
                });
                break;

            default:
                log.error("methodCode错误:{}", methodCode);
                throw Exceptions.createException(CmctError.CONFIG_ERROR, "监测项的编码配置错误");

        }

        //3.设置以前的检测项目无效
        preTunnelRecordPo.setValidStatus(1);
        preTunnelRecordPo.setModifyBy(modifyBy);
        preTunnelRecordPo.setModifyDate(new Date());
        tunnelRecordMapper.updateByPrimaryKey(preTunnelRecordPo);

        //修改断面信息
        if (ValidateUtil.paramInvalid(preTunnelRecordPo.getMonitorId())) {
            log.error("数据错误:实体：preTunnelRecordPo：{}中的断面id为空");
            throw Exceptions.createException(CmctError.SYS_ERROR);
        }

        tunnelMonitorMapper.updateByPrimaryKeySelective(TunnelMonitorPo.builder()
                .modifyDate(new Date())
                .modifyBy(modifyBy)
                .burialTime(updateInfo.getBurialTime())
                .burialDepth(updateInfo.getBurialDepth())
                .method(updateInfo.getMethod())
                .level(updateInfo.getLevel())
                .deformedDeformationValue(updateInfo.getDeformedDeformationValue())
                .permissibleValue(updateInfo.getPermissibleValue())
                .elasticityModulus(updateInfo.getElasticityModulus())
                .build());

        if (CollectionUtils.isEmpty(updateInfo.getFiles())) {
            return;
        }

        updateInfo.getFiles()
                .parallelStream()
                .forEach(fileBo -> tunnelRecordFileMapper.insertSelective(TunnelRecordFilePo.builder()
                        .recordFileId(UUID.randomUUID().toString())
                        .recordId(newRecordId)
                        .fileType(null == fileBo.getFileType() ? null : fileBo.getFileType() + "")
                        .linkUrl(fileBo.getLinkUrl())
                        .fileName(fileBo.getFileName())
                        .createDate(new Date())
                        .prefix(fileBo.getPrefix())
                        .suffix(fileBo.getSuffix())
                        .deleteStatus(DeleteStatus.YES.ordinal())
                        .createBy(modifyBy)
                        .build()));


    }

    @Override
    public List<TunnelMonitorItemNeweastInfoVo> getNeweastMonitorItemInfo(String monitorItemRecordId) {

        if (ValidateUtil.paramInvalid(monitorItemRecordId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "monitorItemRecordId无效");
        }

        List<TunnelRecordPo> historyRecordPos = tunnelRecordMapper.getHisrotyTunnelMonitorItemInfoList(monitorItemRecordId);

        if (CollectionUtils.isEmpty(historyRecordPos)) {
            return null;
        }

        return historyRecordPos.parallelStream()
                .map(tunnelRecordPo -> {

                    String methodCode = tunnelMonitorMapper.getMonitorItemMethod(tunnelRecordPo.getMonitorId());

                    if (StringUtils.isEmpty(methodCode)) {
                        log.error("methodCode为空");
                        throw Exceptions.createException(CmctError.CONFIG_ERROR, "监测项的编码为空");
                    }

                    TunnelMonitorItemNeweastInfoVo tunnelMonitorItemNeweastInfoVo = new TunnelMonitorItemNeweastInfoVo();

                    Example ex = null;
                    switch (MonitorItem.getMonitorItem(methodCode)) {
                        case CODE_TUNNEL_MONITOR_INITIAL_SUPPORT_SECONDARY_LINING_CONTACT_PRESSURE:

                            ex = new Example(TunnelIniSupportTwoPressurePo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelIniSupportTwoPressurePo> tunnelIniSupportTwoPressurePos = tunnelIniSupportTwoPressureMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelIniSupportTwoPressurePos) ? 0 : tunnelIniSupportTwoPressurePos.size());

                            if (CollectionUtils.isEmpty(tunnelIniSupportTwoPressurePos)) {
                                break;
                            }
                            tunnelMonitorItemNeweastInfoVo.setTunnelIniSupportTwoPressures(tunnelIniSupportTwoPressurePos.parallelStream()
                                    .map(tunnelIniSupportTwoPressurePo -> {
                                        TunnelIniSupportTwoPressureVo iniSupportTwoPressureVo = TunnelIniSupportTwoPressureVo.builder().build();

                                        BeanUtils.copyProperties(tunnelIniSupportTwoPressurePo, iniSupportTwoPressureVo);
                                        return iniSupportTwoPressureVo;
                                    }).collect(Collectors.toList()));


                            break;
                        case CODE_TUNNEL_MONITOR_SURROUNDING_ROCK_INITIAL_CONTACT_PRESSURE:

                            ex = new Example(TunnelSurrRockInitialPressurePo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelSurrRockInitialPressurePo> tunnelSurrRockInitialPressurePos = tunnelSurrRockInitialPressureMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelSurrRockInitialPressurePos) ? 0 : tunnelSurrRockInitialPressurePos.size());

                            if (CollectionUtils.isEmpty(tunnelSurrRockInitialPressurePos)) {
                                break;
                            }
                            tunnelMonitorItemNeweastInfoVo.setTunnelSurrRockInitialPressures(tunnelSurrRockInitialPressurePos.parallelStream()
                                    .map(tunnelSurrRockInitialPressurePo -> {
                                        TunnelSurrRockInitialPressureVo surrRockInitialPressureVo = TunnelSurrRockInitialPressureVo.builder().build();

                                        BeanUtils.copyProperties(tunnelSurrRockInitialPressurePo, surrRockInitialPressureVo);
                                        return surrRockInitialPressureVo;
                                    }).collect(Collectors.toList()));


                            break;
                        case CODE_TUNNEL_MONITOR_INTERNAL_DISPLACEMENT_SURROUNDING_ROCK:

                            ex = new Example(TunnelInternalSurrRockDisplacementPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelInternalSurrRockDisplacementPo> tunnelInternalSurrRockDisplacementPos =
                                    tunnelInternalSurrRockDisplacementMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelInternalSurrRockDisplacementPos) ? 0 : tunnelInternalSurrRockDisplacementPos.size());

                            if (CollectionUtils.isEmpty(tunnelInternalSurrRockDisplacementPos)) {
                                break;
                            }
                            tunnelMonitorItemNeweastInfoVo.setTunnelInternalSurrRockDisplacements(tunnelInternalSurrRockDisplacementPos.parallelStream()
                                    .map(tunnelInternalSurrRockDisplacementPo -> {
                                        TunnelInternalSurrRockDisplacementVo internalSurrRockDisplacementVo = TunnelInternalSurrRockDisplacementVo.builder().build();

                                        BeanUtils.copyProperties(tunnelInternalSurrRockDisplacementPo, internalSurrRockDisplacementVo);
                                        return internalSurrRockDisplacementVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_SECONDARY_LINING_INTERNAL_STRESS:

                            ex = new Example(TunnelInternalTwoStressPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelInternalTwoStressPo> tunnelInternalSurrRockDisplacementPos1 =
                                    tunnelInternalTwoStressMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelInternalSurrRockDisplacementPos1) ? 0 : tunnelInternalSurrRockDisplacementPos1.size());

                            if (CollectionUtils.isEmpty(tunnelInternalSurrRockDisplacementPos1)) {
                                break;
                            }
                            tunnelMonitorItemNeweastInfoVo.setTunnelInternalTwoStresss(tunnelInternalSurrRockDisplacementPos1.parallelStream()
                                    .map(tunnelInternalTwoStressPo -> {
                                        TunnelInternalTwoStressVo internalTwoStressVo = TunnelInternalTwoStressVo.builder().build();

                                        BeanUtils.copyProperties(tunnelInternalTwoStressPo, internalTwoStressVo);
                                        return internalTwoStressVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_INITIAL_INTERNAL_STRESS:
                            ex = new Example(TunnelInternalStressIniSupportPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelInternalStressIniSupportPo> tunnelInternalStressIniSupportPos =
                                    tunnelInternalStressIniSupportMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelInternalStressIniSupportPos) ? 0 : tunnelInternalStressIniSupportPos.size());

                            if (CollectionUtils.isEmpty(tunnelInternalStressIniSupportPos)) {
                                break;
                            }
                            tunnelMonitorItemNeweastInfoVo.setTunnelInternalStressIniSupports(tunnelInternalStressIniSupportPos.parallelStream()
                                    .map(tunnelInternalStressIniSupportPo -> {
                                        TunnelInternalStressIniSupportVo internalStressIniSupportVo = TunnelInternalStressIniSupportVo.builder().build();

                                        BeanUtils.copyProperties(tunnelInternalStressIniSupportPo, internalStressIniSupportVo);
                                        return internalStressIniSupportVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_STEEL_INTERNAL_FORCE:

                            ex = new Example(TunnelSteelInternalForcePo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelSteelInternalForcePo> tunnelSteelInternalForcePos =
                                    tunnelSteelInternalForceMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelSteelInternalForcePos) ? 0 : tunnelSteelInternalForcePos.size());

                            if (CollectionUtils.isEmpty(tunnelSteelInternalForcePos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelSteelInternalForces(tunnelSteelInternalForcePos.parallelStream()
                                    .map(tunnelSteelInternalForcePo -> {
                                        TunnelSteelInternalForceVo steelInternalForceVo = TunnelSteelInternalForceVo.builder().build();

                                        BeanUtils.copyProperties(tunnelSteelInternalForcePo, steelInternalForceVo);
                                        return steelInternalForceVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_ANCHOR_AXIAL_FORCE:

                            ex = new Example(TunnelAxialBoltForcePo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelAxialBoltForcePo> tunnelAxialBoltForcePos =
                                    tunnelAxialBoltForceMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelAxialBoltForcePos) ? 0 : tunnelAxialBoltForcePos.size());

                            if (CollectionUtils.isEmpty(tunnelAxialBoltForcePos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelAxialBoltForces(tunnelAxialBoltForcePos.parallelStream()
                                    .map(tunnelAxialBoltForcePo -> {
                                        TunnelAxialBoltForceVo axialBoltForceVo = TunnelAxialBoltForceVo.builder().build();

                                        BeanUtils.copyProperties(tunnelAxialBoltForcePo, axialBoltForceVo);
                                        return axialBoltForceVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_ROUND_CONVERGENCE:

                            ex = new Example(TunnelSurrConPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelSurrConPo> tunnelSurrConPos =
                                    tunnelSurrConMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelSurrConPos) ? 0 : tunnelSurrConPos.size());

                            if (CollectionUtils.isEmpty(tunnelSurrConPos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelSurrCons(tunnelSurrConPos.parallelStream()
                                    .map(tunnelSurrConPo -> {
                                        TunnelSurrConVo surrConVo = TunnelSurrConVo.builder().build();

                                        BeanUtils.copyProperties(tunnelSurrConPo, surrConVo);
                                        return surrConVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_DOWN_FACE:
                            ex = new Example(TunnelSurfaceDownPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelSurfaceDownPo> tunnelSurfaceDownPos =
                                    tunnelSurfaceDownMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelSurfaceDownPos) ? 0 : tunnelSurfaceDownPos.size());

                            if (CollectionUtils.isEmpty(tunnelSurfaceDownPos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelSurfaceDownss(tunnelSurfaceDownPos.parallelStream()
                                    .map(tunnelSurfaceDownPo -> {
                                        TunnelSurfaceDownVo surfaceDownVo = TunnelSurfaceDownVo.builder().build();

                                        BeanUtils.copyProperties(tunnelSurfaceDownPo, surfaceDownVo);
                                        return surfaceDownVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_DOWN_DOME:
                            ex = new Example(TunnelHoleArcDownPo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelHoleArcDownPo> tunnelHoleArcDownPos =
                                    tunnelHoleArcDownMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelHoleArcDownPos) ? 0 : tunnelHoleArcDownPos.size());

                            if (CollectionUtils.isEmpty(tunnelHoleArcDownPos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelHoleArcDowns(tunnelHoleArcDownPos.parallelStream()
                                    .map(tunnelHoleArcDownPo -> {
                                        TunnelHoleArcDownVo holeArcDownVo = TunnelHoleArcDownVo.builder().build();

                                        BeanUtils.copyProperties(tunnelHoleArcDownPo, holeArcDownVo);
                                        return holeArcDownVo;
                                    }).collect(Collectors.toList()));
                            break;
                        case CODE_TUNNEL_MONITOR_FACE:
                            ex = new Example(TunnelFacePo.class);
                            ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                                    .andEqualTo("recordId", tunnelRecordPo.getRecordId());
                            List<TunnelFacePo> tunnelFacePos =
                                    tunnelFaceMapper.selectByExample(ex);

                            constructBaseInfo(tunnelMonitorItemNeweastInfoVo, tunnelRecordPo,
                                    CollectionUtils.isEmpty(tunnelFacePos) ? 0 : tunnelFacePos.size());

                            if (CollectionUtils.isEmpty(tunnelFacePos)) {
                                break;
                            }

                            tunnelMonitorItemNeweastInfoVo.setTunnelFaces(tunnelFacePos.parallelStream()
                                    .map(tunnelFacePo -> {
                                        TunnelFaceVo faceVo = TunnelFaceVo.builder().build();

                                        BeanUtils.copyProperties(tunnelFacePo, faceVo);
                                        return faceVo;
                                    }).collect(Collectors.toList()));
                            break;
                        default:
                            break;
                    }

                    return tunnelMonitorItemNeweastInfoVo;
                }).collect(Collectors.toList());
    }

    /**
     * @param baseInfo
     * @param tunnelRecordPo
     */
    private void constructBaseInfo(TunnelMonitorItemNeweastInfoVo baseInfo, TunnelRecordPo tunnelRecordPo, int count) {
        if (tunnelRecordPo == null) {
            return;
        }
        if (baseInfo == null) {
            baseInfo = TunnelMonitorItemNeweastInfoVo.builder().build();
        }

        baseInfo.setRemark(tunnelRecordPo.getRemark());
        baseInfo.setCreateDate(tunnelRecordPo.getCreateDate());
        baseInfo.setCreateBy(tunnelRecordPo.getCreateBy());

        if (!ValidateUtil.paramInvalid(tunnelRecordPo.getCreateBy())) {
            SysUserPo createByUser = sysUserMapper.selectByPrimaryKey(tunnelRecordPo.getCreateBy());

            if (createByUser != null) {
                baseInfo.setAccount(createByUser.getUsername());
            }
        }

        baseInfo.setTemprature(tunnelRecordPo.getTemprature());
        baseInfo.setFaceDistance(tunnelRecordPo.getFaceDistance());
        baseInfo.setCount(count);

        Example ex = new Example(TunnelRecordFilePo.class);
        ex.createCriteria().andEqualTo("deleteStatus", DeleteStatus.YES.ordinal())
                .andEqualTo("recordId", tunnelRecordPo.getRecordId());
        baseInfo.setFiles(Optional.ofNullable(tunnelRecordFileMapper.selectByExample(ex))
                .orElse(new ArrayList<>())
                .parallelStream()
                .map(tunnelRecordFilePo -> {

                    FileVo fileVo = new FileVo();
                    fileVo.setFileId(tunnelRecordFilePo.getRecordFileId());
                    fileVo.setFileName(tunnelRecordFilePo.getFileName());
                    fileVo.setFileType(null == tunnelRecordFilePo.getFileType() ?
                            null : Integer.valueOf(tunnelRecordFilePo.getFileType()));
                    fileVo.setLinkUrl(tunnelRecordFilePo.getLinkUrl());
                    fileVo.setPrefix(tunnelRecordFilePo.getPrefix());
                    fileVo.setSuffix(tunnelRecordFilePo.getSuffix());
                    return fileVo;
                }).collect(Collectors.toList()));
    }


}
