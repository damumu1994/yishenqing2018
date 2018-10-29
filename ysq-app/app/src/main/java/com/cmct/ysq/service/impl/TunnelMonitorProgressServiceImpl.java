package com.cmct.ysq.service.impl;


import com.cmct.base.constant.DeleteStatus;
import com.cmct.base.exception.CmctError;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.exception.Exceptions;
import com.cmct.common.util.ValidateUtil;
import com.cmct.ysq.common.ConstructMethod;
import com.cmct.ysq.mapper.*;
import com.cmct.ysq.model.bo.*;
import com.cmct.ysq.model.po.*;
import com.cmct.ysq.model.vo.*;
import com.cmct.ysq.service.ITunnelMonitorProgressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.cmct.base.exception.CmctError.DATA_ERROR;
import static com.cmct.base.exception.CmctError.PARAM_ERROR;

/**
 * 施工进度service impl
 *
 * @author shen
 */
@Service
public class TunnelMonitorProgressServiceImpl implements ITunnelMonitorProgressService {

    @Autowired
    private TunnelConsProgressMapper tunnelConsProgressMapper;

    @Autowired
    private TunnelProgCdMapper progCdMapper;

    @Autowired
    private TunnelProgPitMapper progPitMapper;

    @Autowired
    private TunnelProgTwoStepMapper progTwoStepMapper;

    @Autowired
    private TunnelProgFullFaceMapper progFullFaceMapper;

    @Autowired
    private TunnelProgThreeStepMapper progThreeStepMapper;

    @Autowired
    private TunnelProgLinerMapper progLinerMapper;

    @Autowired
    private TunnelMonitorMapper tunnelMonitorMapper;

    @Autowired
    private TunnelRecordMapper tunnelRecordMapper;

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

    @Override
    public JsonPage<TunnelProgressBaseVo> getTunnelProgressBaseInfoList(BaseModelBo pageQuery) {
        if (pageQuery == null) {
            pageQuery = new BaseModelBo();
        }

        Page<TunnelProgressBaseVo> page = PageHelper.startPage(pageQuery.getPage(), pageQuery.getRows());
        tunnelConsProgressMapper.getTunnelProgressBaseInfoList();

        return new JsonPage(page);
    }

    @Override
    public void delTunnelMonitorProgress(String constructProgressId, String modifyBy) {

        if (ValidateUtil.paramInvalid(constructProgressId)) {
            throw Exceptions.createException(PARAM_ERROR, "constructProgressId为空");
        }
        tunnelConsProgressMapper.updateByPrimaryKeySelective(TunnelConsProgressPo.builder()
                .constructProgressId(constructProgressId)
                .deleteStatus(1)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .build());
    }


    @Transactional(rollbackOn = Exception.class)
    @Override
    public void updateConstructProgressInfo(String constructProgressId, ConstructProgForUpdateBo updateInfo, String modifyBy) {

        if (ValidateUtil.paramInvalid(constructProgressId) || updateInfo == null) {
            throw Exceptions.createException(PARAM_ERROR, "constructProgressId或者updateInfo为空");
        }

        TunnelConsProgressPo beforeTunnelConsProgressPo = tunnelConsProgressMapper.selectByPrimaryKey(constructProgressId);

        TunnelConsProgressPo tunnelConsProgressTarget = TunnelConsProgressPo.builder().build();
        BeanUtils.copyProperties(beforeTunnelConsProgressPo, tunnelConsProgressTarget);

        String newTunnelConsProgressId = UUID.randomUUID().toString();
        tunnelConsProgressTarget.setConstructProgressId(newTunnelConsProgressId);
        tunnelConsProgressTarget.setDeleteStatus(DeleteStatus.YES.ordinal());
        tunnelConsProgressTarget.setCreateBy(modifyBy);
        tunnelConsProgressTarget.setCreateDate(new Date());
        tunnelConsProgressTarget.setModifyBy(null);
        tunnelConsProgressTarget.setModifyDate(null);

        //插入修改的记录
        tunnelConsProgressMapper.insertSelective(tunnelConsProgressTarget);

        saveTunnelMonitorProgressInfo(modifyBy, beforeTunnelConsProgressPo.getMethod(),
                updateInfo.getProgCdForUpdate(), updateInfo.getProgFullFaceForUpdate(),
                updateInfo.getProgLinerForUpdates(), updateInfo.getProgPitForUpdate(),
                updateInfo.getProgThreeStepForUpdate(), updateInfo.getProgTwoStepForUpdateBo(),
                newTunnelConsProgressId);


        beforeTunnelConsProgressPo.setModifyDate(new Date());
        beforeTunnelConsProgressPo.setModifyBy(modifyBy);
        beforeTunnelConsProgressPo.setValidStatus(1);
        tunnelConsProgressMapper.updateByPrimaryKeySelective(beforeTunnelConsProgressPo);


    }


    @Override
    public JsonPage<TunnelConstructProgHisVo> getConstructProgressHisInfo(String constructProgressId, BaseModelBo hisQuery) {

        if (ValidateUtil.paramInvalid(constructProgressId)) {
            throw Exceptions.createException(PARAM_ERROR, "constructProgressId为空");
        }

        if (null == hisQuery) {
            hisQuery = new BaseModelBo();
        }
        TunnelConsProgressPo beforeTunnelConsProgressPo = tunnelConsProgressMapper.selectByPrimaryKey(constructProgressId);

        if (null == beforeTunnelConsProgressPo) {
            throw Exceptions.createException(DATA_ERROR, "检测记录不存在");
        }

        List<String> hisConstructProgressIds = tunnelConsProgressMapper.getHisConsProgressList(beforeTunnelConsProgressPo.getHisCode());
        Page<TunnelConstructProgHisVo> page = PageHelper.startPage(hisQuery.getPage(), hisQuery.getRows());

        switch (ConstructMethod.getConstructMethod(beforeTunnelConsProgressPo.getMethod())) {
            case THREE_STEP:


                List<TunnelProgThreeStepVo> progThreeSteVos = progThreeStepMapper.getConstructProgressHisInfo(hisConstructProgressIds);

                return new JsonPage(progThreeSteVos
                        .stream()
                        .map(tunnelConstructProgHisVo -> TunnelConstructProgHisVo.builder()
                                .method(beforeTunnelConsProgressPo.getMethod())
                                .progThreeStep(tunnelConstructProgHisVo)
                                .progLiners(progLiners(tunnelConstructProgHisVo.getPrgId()))
                                .build())
                        .collect(Collectors.toList()), page.getPageNum(), page.getPages(), page.getTotal());
            case FULL_FACE:
                List<TunnelProgFullFaceVo> progFullFaceVos = progFullFaceMapper.getConstructProgressHisInfo(hisConstructProgressIds);
                return new JsonPage(progFullFaceVos
                        .stream()
                        .map(progFullFaceVo -> TunnelConstructProgHisVo.builder()
                                .method(beforeTunnelConsProgressPo.getMethod())
                                .progFullFace(progFullFaceVo)
                                .progLiners(progLiners(progFullFaceVo.getConsProgId()))

                                .build())
                        .collect(Collectors.toList()), page.getPageNum(), page.getPages(), page.getTotal());
            case TWO_STEP:
                List<TunnelProgTwoStepVo> progTwoStepVos = progTwoStepMapper.getConstructProgressHisInfo(hisConstructProgressIds);

                return new JsonPage(progTwoStepVos
                        .stream()
                        .map(progTwoStepVo -> TunnelConstructProgHisVo.builder()
                                .method(beforeTunnelConsProgressPo.getMethod())
                                .progTwoStep(progTwoStepVo)
                                .progLiners(progLiners(progTwoStepVo.getPrgId()))

                                .build())
                        .collect(Collectors.toList()), page.getPageNum(), page.getPages(), page.getTotal());
            case PIT:
                List<TunnelProgPitVo> progPitVos = progPitMapper.getConstructProgressHisInfo(hisConstructProgressIds);

                return new JsonPage(progPitVos
                        .stream()
                        .map(progPitVo -> TunnelConstructProgHisVo.builder()
                                .method(beforeTunnelConsProgressPo.getMethod())
                                .progPitVo(progPitVo)
                                .progLiners(progLiners(progPitVo.getPrgId()))

                                .build())
                        .collect(Collectors.toList()), page.getPageNum(), page.getPages(), page.getTotal());

            case CD:
                List<TunnelProgCdVo> progCdVos = progCdMapper.getConstructProgressHisInfo(hisConstructProgressIds);

                return new JsonPage(progCdVos
                        .stream()
                        .map(progCdVo -> TunnelConstructProgHisVo.builder()
                                .method(beforeTunnelConsProgressPo.getMethod())
                                .progCd(progCdVo)
                                .progLiners(progLiners(progCdVo.getPrgId()))

                                .build())
                        .collect(Collectors.toList()), page.getPageNum(), page.getPages(), page.getTotal());

            default:
                break;

        }
        return new JsonPage<>();
    }

    @Override
    public List<TunnelProgLinerVo> progLiners(String constructProgressId) {

        if (ValidateUtil.paramInvalid(constructProgressId)) {
            return null;
        }

        Example ex = new Example(TunnelProgLinerPo.class);
        ex.createCriteria().andEqualTo("deleteStatus", 0)
                .andEqualTo("prgRecordId", constructProgressId);
        List<TunnelProgLinerPo> progLinerPos = progLinerMapper.selectByExample(ex);
        if (CollectionUtils.isEmpty(progLinerPos)) {
            return null;
        }


        return progLinerPos.stream()
                .map(tunnelProgLinerPo -> TunnelProgLinerVo.builder()
                        .progLinerId(tunnelProgLinerPo.getProgLinerId())
                        .prgRecordId(tunnelProgLinerPo.getPrgRecordId())
                        .facePegNoStart(tunnelProgLinerPo.getFacePegNoStart())
                        .facePegNoEnd(tunnelProgLinerPo.getFacePegNoEnd())
                        .build())
                .collect(Collectors.toList());

    }


    @Transactional(rollbackOn = Exception.class)
    @Override
    public void postMonitorDataInfo(TunnelDataUploadBo dataUploads, String createBy) {

        if (dataUploads == null) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "dataUploads为空");
        }

        if (!CollectionUtils.isEmpty(dataUploads.getConsProgressForAdds())) {
            dataUploads.getConsProgressForAdds().parallelStream()
                    .forEach(tunnelConsProgressForAddBo -> {

                        TunnelConsProgressPo newTunnelConsProgressTargetPo = TunnelConsProgressPo.builder().build();
                        BeanUtils.copyProperties(tunnelConsProgressForAddBo, newTunnelConsProgressTargetPo);
                        newTunnelConsProgressTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                        newTunnelConsProgressTargetPo.setCreateBy(createBy);
                        newTunnelConsProgressTargetPo.setCreateDate(new Date());
                        newTunnelConsProgressTargetPo.setValidStatus(0);
                        newTunnelConsProgressTargetPo.setHisCode(UUID.randomUUID().toString());
                        tunnelConsProgressMapper.insertSelective(newTunnelConsProgressTargetPo);


                        saveTunnelMonitorProgressInfo(createBy, tunnelConsProgressForAddBo.getMethod(),
                                tunnelConsProgressForAddBo.getProgCdForUpdate(), tunnelConsProgressForAddBo.getProgFullFaceForUpdate(),
                                tunnelConsProgressForAddBo.getProgLinerForUpdates(), tunnelConsProgressForAddBo.getProgPitForUpdate(),
                                tunnelConsProgressForAddBo.getProgThreeStepForUpdate(), tunnelConsProgressForAddBo.getProgTwoStepForUpdateBo(),
                                newTunnelConsProgressTargetPo.getConstructProgressId());


                    });
        }

        if (!CollectionUtils.isEmpty(dataUploads.getCrossSectionForAdds())) {
            postCrossSectionInfo(dataUploads.getCrossSectionForAdds(), createBy);
        }

        if (!CollectionUtils.isEmpty(dataUploads.getMonitorItemDataUploads())) {

            for (TunnelMonitorItemDataUploadBo monitorItemDataUploadBo : dataUploads.getMonitorItemDataUploads()) {
                if (null == monitorItemDataUploadBo.getRecordForAdd()
                        || ValidateUtil.paramInvalid(monitorItemDataUploadBo.getRecordForAdd().getMonitorId())) {
                    continue;
                }

                TunnelRecordPo newTunnelRecordTargetPo = TunnelRecordPo.builder().build();
                BeanUtils.copyProperties(monitorItemDataUploadBo.getRecordForAdd(), newTunnelRecordTargetPo);
                newTunnelRecordTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                newTunnelRecordTargetPo.setCreateBy(createBy);
                newTunnelRecordTargetPo.setCreateDate(new Date());
                newTunnelRecordTargetPo.setValidStatus(0);
                newTunnelRecordTargetPo.setHisCode(UUID.randomUUID().toString());

                tunnelRecordMapper.insertSelective(newTunnelRecordTargetPo);

                if (null != monitorItemDataUploadBo.getFaceForUpdate()) {
                    TunnelFacePo newTunnelFaceTargetPo = TunnelFacePo.builder().build();
                    BeanUtils.copyProperties(monitorItemDataUploadBo.getFaceForUpdate(), newTunnelFaceTargetPo);

                    newTunnelFaceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                    newTunnelFaceTargetPo.setCreateBy(createBy);
                    newTunnelFaceTargetPo.setCreateDate(new Date());
                    tunnelFaceMapper.insertSelective(newTunnelFaceTargetPo);
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getHoleArcDownForUpdates())) {
                    monitorItemDataUploadBo.getHoleArcDownForUpdates()
                            .parallelStream().forEach(tunnelHoleArcDownForUpdateBo -> {
                        TunnelHoleArcDownPo newTunnelHoleArcDownTargetPo = TunnelHoleArcDownPo.builder().build();
                        BeanUtils.copyProperties(tunnelHoleArcDownForUpdateBo, newTunnelHoleArcDownTargetPo);
                        newTunnelHoleArcDownTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                        newTunnelHoleArcDownTargetPo.setCreateBy(createBy);
                        newTunnelHoleArcDownTargetPo.setCreateDate(new Date());
                        tunnelHoleArcDownMapper.insertSelective(newTunnelHoleArcDownTargetPo);
                    });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getSurfaceDownForUpdates())) {
                    monitorItemDataUploadBo.getSurfaceDownForUpdates().
                            parallelStream()
                            .forEach(tunnelSurfaceDownForUpdateBo -> {
                                TunnelSurfaceDownPo newTunnelSurfaceDownTargetPo = TunnelSurfaceDownPo.builder().build();
                                BeanUtils.copyProperties(tunnelSurfaceDownForUpdateBo, newTunnelSurfaceDownTargetPo);
                                newTunnelSurfaceDownTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelSurfaceDownTargetPo.setCreateBy(createBy);
                                newTunnelSurfaceDownTargetPo.setCreateDate(new Date());
                                tunnelSurfaceDownMapper.insertSelective(newTunnelSurfaceDownTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getSurrConForUpdates())) {
                    monitorItemDataUploadBo.getSurrConForUpdates()
                            .parallelStream()
                            .forEach(surrConForUpdateBo -> {
                                TunnelSurrConPo newTunnelSurrConTargetPo = TunnelSurrConPo.builder().build();
                                BeanUtils.copyProperties(surrConForUpdateBo, newTunnelSurrConTargetPo);
                                newTunnelSurrConTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelSurrConTargetPo.setCreateBy(createBy);
                                newTunnelSurrConTargetPo.setCreateDate(new Date());
                                tunnelSurrConMapper.insertSelective(newTunnelSurrConTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getAxialBoltForceForUpdates())) {
                    monitorItemDataUploadBo.getAxialBoltForceForUpdates()
                            .parallelStream()
                            .forEach(axialBoltForceForUpdateBo -> {
                                TunnelAxialBoltForcePo newTunnelAxialBoltForceTargetPo = TunnelAxialBoltForcePo.builder().build();
                                BeanUtils.copyProperties(axialBoltForceForUpdateBo, newTunnelAxialBoltForceTargetPo);
                                newTunnelAxialBoltForceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelAxialBoltForceTargetPo.setCreateBy(createBy);
                                newTunnelAxialBoltForceTargetPo.setCreateDate(new Date());
                                tunnelAxialBoltForceMapper.insertSelective(newTunnelAxialBoltForceTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getSteelInternalForceForUpdates())) {
                    monitorItemDataUploadBo.getSteelInternalForceForUpdates()
                            .parallelStream()
                            .forEach(steelInternalForceForUpdateBo -> {
                                TunnelSteelInternalForcePo newTunnelSteelInternalForceTargetPo = TunnelSteelInternalForcePo.builder().build();
                                BeanUtils.copyProperties(steelInternalForceForUpdateBo, newTunnelSteelInternalForceTargetPo);
                                newTunnelSteelInternalForceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelSteelInternalForceTargetPo.setCreateBy(createBy);
                                newTunnelSteelInternalForceTargetPo.setCreateDate(new Date());
                                tunnelSteelInternalForceMapper.insertSelective(newTunnelSteelInternalForceTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getInternalStressIniSupportForUpdates())) {

                    monitorItemDataUploadBo.getInternalStressIniSupportForUpdates()
                            .parallelStream()
                            .forEach(internalStressIniSupportForUpdateBo -> {
                                TunnelInternalStressIniSupportPo newTunnelInternalStressIniSupportTargetPo =
                                        TunnelInternalStressIniSupportPo.builder().build();
                                BeanUtils.copyProperties(internalStressIniSupportForUpdateBo, newTunnelInternalStressIniSupportTargetPo);
                                newTunnelInternalStressIniSupportTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelInternalStressIniSupportTargetPo.setCreateBy(createBy);
                                newTunnelInternalStressIniSupportTargetPo.setCreateDate(new Date());
                                tunnelInternalStressIniSupportMapper.insertSelective(newTunnelInternalStressIniSupportTargetPo);
                            });
                }


                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getInternalTwoStressForUpdates())) {

                    monitorItemDataUploadBo.getInternalTwoStressForUpdates()
                            .parallelStream()
                            .forEach(internalTwoStressForUpdateBo -> {
                                TunnelInternalTwoStressPo newTunnelInternalTwoStressTargetPo = TunnelInternalTwoStressPo.builder().build();
                                BeanUtils.copyProperties(internalTwoStressForUpdateBo, newTunnelInternalTwoStressTargetPo);
                                newTunnelInternalTwoStressTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelInternalTwoStressTargetPo.setCreateBy(createBy);
                                newTunnelInternalTwoStressTargetPo.setCreateDate(new Date());
                                tunnelInternalTwoStressMapper.insertSelective(newTunnelInternalTwoStressTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getInternalSurrRockDisplacementForUpdates())) {
                    monitorItemDataUploadBo.getInternalSurrRockDisplacementForUpdates()
                            .parallelStream()
                            .forEach(internalSurrRockDisplacementForUpdateBo -> {
                                TunnelInternalSurrRockDisplacementPo newTunnelInternalSurrRockDisplacementTargetPo =
                                        TunnelInternalSurrRockDisplacementPo.builder().build();
                                BeanUtils.copyProperties(internalSurrRockDisplacementForUpdateBo, newTunnelInternalSurrRockDisplacementTargetPo);
                                newTunnelInternalSurrRockDisplacementTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelInternalSurrRockDisplacementTargetPo.setCreateBy(createBy);
                                newTunnelInternalSurrRockDisplacementTargetPo.setCreateDate(new Date());
                                tunnelInternalSurrRockDisplacementMapper.insertSelective(newTunnelInternalSurrRockDisplacementTargetPo);
                            });
                }

                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getSurrRockInitialPressureForUpdates())) {
                    monitorItemDataUploadBo.getSurrRockInitialPressureForUpdates()
                            .parallelStream()
                            .forEach(surrRockInitialPressureForUpdateBo -> {
                                TunnelSurrRockInitialPressurePo newTunnelSurrRockInitialPressureTargetPo =
                                        TunnelSurrRockInitialPressurePo.builder().build();
                                BeanUtils.copyProperties(surrRockInitialPressureForUpdateBo, newTunnelSurrRockInitialPressureTargetPo);
                                newTunnelSurrRockInitialPressureTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                                newTunnelSurrRockInitialPressureTargetPo.setCreateBy(createBy);
                                newTunnelSurrRockInitialPressureTargetPo.setCreateDate(new Date());
                                tunnelSurrRockInitialPressureMapper.insertSelective(newTunnelSurrRockInitialPressureTargetPo);
                            });
                }


                if (!CollectionUtils.isEmpty(monitorItemDataUploadBo.getIniSupportTwoPressureForUpdates())) {
                    monitorItemDataUploadBo.getIniSupportTwoPressureForUpdates()
                            .parallelStream().forEach(iniSupportTwoPressureForUpdateBo -> {
                        TunnelIniSupportTwoPressurePo newTunnelIniSupportTwoPressureTargetPo =
                                TunnelIniSupportTwoPressurePo.builder().build();
                        BeanUtils.copyProperties(iniSupportTwoPressureForUpdateBo, newTunnelIniSupportTwoPressureTargetPo);
                        newTunnelIniSupportTwoPressureTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                        newTunnelIniSupportTwoPressureTargetPo.setCreateBy(createBy);
                        newTunnelIniSupportTwoPressureTargetPo.setCreateDate(new Date());
                        tunnelIniSupportTwoPressureMapper.insertSelective(newTunnelIniSupportTwoPressureTargetPo);
                    });
                }

            }
        }


    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void postCrossSectionInfo(List<TunnelCrossSectionForAddBo> crossSectionForAdds, String createBy) {
        if (CollectionUtils.isEmpty(crossSectionForAdds) || ValidateUtil.paramInvalid(createBy)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "crossSectionForAdds或者createBy为空");
        }

        crossSectionForAdds.parallelStream()
                .forEach(tunnelCrossSectionForAddBo -> {

                    TunnelMonitorPo newTunnelMonitorTargetPo = TunnelMonitorPo.builder().build();
                    BeanUtils.copyProperties(tunnelCrossSectionForAddBo, newTunnelMonitorTargetPo);

                    newTunnelMonitorTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());

                    newTunnelMonitorTargetPo.setCreateBy(createBy);
                    newTunnelMonitorTargetPo.setCreateDate(new Date());
                    tunnelMonitorMapper.insertSelective(newTunnelMonitorTargetPo);
                });


    }


    private void saveTunnelMonitorProgressInfo(String createBy,
                                               Integer method,
                                               TunnelProgCdForUpdateBo progCdForUpdate,
                                               TunnelProgFullFaceForUpdateBo progFullFaceForUpdate,
                                               List<TunnelProgLinerForUpdateBo> progLinerForUpdates,
                                               TunnelProgPitForUpdateBo progPitForUpdate,
                                               TunnelProgThreeStepForUpdateBo progThreeStepForUpdate,
                                               TunnelProgTwoStepForUpdateBo progTwoStepForUpdateBo,
                                               String newConstructProgressId) {
        switch (ConstructMethod.getConstructMethod(method)) {
            case CD:

                TunnelProgCdPo tunnelProgCdTargetPo = TunnelProgCdPo.builder().build();
                BeanUtils.copyProperties(progCdForUpdate, tunnelProgCdTargetPo);
                tunnelProgCdTargetPo.setCreateBy(createBy);
                tunnelProgCdTargetPo.setCreateDate(new Date());
                tunnelProgCdTargetPo.setPrgId(newConstructProgressId);
                tunnelProgCdTargetPo.setTunnelProgCdId(UUID.randomUUID().toString());
                tunnelProgCdTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                progCdMapper.insertSelective(tunnelProgCdTargetPo);

                break;
            case PIT:

                TunnelProgPitPo tunnelProgPitTargetPo = TunnelProgPitPo.builder().build();
                BeanUtils.copyProperties(progPitForUpdate, tunnelProgPitTargetPo);

                tunnelProgPitTargetPo.setCreateBy(createBy);
                tunnelProgPitTargetPo.setCreateDate(new Date());
                tunnelProgPitTargetPo.setPrgId(newConstructProgressId);
                tunnelProgPitTargetPo.setPrgPitId(UUID.randomUUID().toString());
                tunnelProgPitTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                progPitMapper.insertSelective(tunnelProgPitTargetPo);

                break;
            case TWO_STEP:


                TunnelProgTwoStepPo tunnelProgTwoStepTargetPo = TunnelProgTwoStepPo.builder().build();
                BeanUtils.copyProperties(progTwoStepForUpdateBo, tunnelProgTwoStepTargetPo);


                tunnelProgTwoStepTargetPo.setCreateBy(createBy);
                tunnelProgTwoStepTargetPo.setCreateDate(new Date());
                tunnelProgTwoStepTargetPo.setPrgId(newConstructProgressId);
                tunnelProgTwoStepTargetPo.setPrgTwoStepId(UUID.randomUUID().toString());
                tunnelProgTwoStepTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                progTwoStepMapper.insertSelective(tunnelProgTwoStepTargetPo);

                break;
            case FULL_FACE:


                TunnelProgFullFacePo tunnelProgFullFaceTargetPo = TunnelProgFullFacePo.builder().build();

                BeanUtils.copyProperties(progFullFaceForUpdate, tunnelProgFullFaceTargetPo);

                tunnelProgFullFaceTargetPo.setCreateBy(createBy);
                tunnelProgFullFaceTargetPo.setCreateDate(new Date());
                tunnelProgFullFaceTargetPo.setConsProgId(newConstructProgressId);
                tunnelProgFullFaceTargetPo.setTunnelProgFullFace(UUID.randomUUID().toString());
                tunnelProgFullFaceTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
                progFullFaceMapper.insertSelective(tunnelProgFullFaceTargetPo);


                break;
            case THREE_STEP:

                TunnelProgThreeStepPo tunnelProgThreeStepTargetInfo = TunnelProgThreeStepPo.builder().build();

                BeanUtils.copyProperties(progThreeStepForUpdate, tunnelProgThreeStepTargetInfo);

                tunnelProgThreeStepTargetInfo.setCreateBy(createBy);
                tunnelProgThreeStepTargetInfo.setCreateDate(new Date());
                tunnelProgThreeStepTargetInfo.setPrgId(newConstructProgressId);
                tunnelProgThreeStepTargetInfo.setPrgThreeStepId(UUID.randomUUID().toString());
                tunnelProgThreeStepTargetInfo.setDeleteStatus(DeleteStatus.YES.ordinal());
                progThreeStepMapper.insertSelective(tunnelProgThreeStepTargetInfo);

                break;

            default:
                break;


        }

        if (CollectionUtils.isEmpty(progLinerForUpdates)) {
            return;
        }
        //新增二衬数据
        progLinerForUpdates
                .parallelStream()
                .forEach(tunnelProgLinerForUpdateBo ->
                        progLinerMapper.insertSelective(TunnelProgLinerPo.builder()
                                .progLinerId(UUID.randomUUID().toString())
                                .prgRecordId(newConstructProgressId)
                                .facePegNoStart(tunnelProgLinerForUpdateBo.getFacePegNoStart())
                                .facePegNoEnd(tunnelProgLinerForUpdateBo.getFacePegNoEnd())
                                .deleteStatus(DeleteStatus.YES.ordinal())
                                .createBy(createBy)
                                .createDate(new Date())
                                .build())
                );
    }


}
