package com.cmct.ysq.service.impl;

import com.cmct.common.exception.Exceptions;
import com.cmct.common.util.ValidateUtil;
import com.cmct.ysq.mapper.SysParamMapper;
import com.cmct.ysq.model.bo.SysParamForAddBo;
import com.cmct.ysq.model.bo.SysParamForUpdateBo;
import com.cmct.ysq.model.bo.SysParamsBo;
import com.cmct.ysq.model.po.SysParamPo;
import com.cmct.ysq.model.vo.SysParamVo;
import com.cmct.ysq.service.ISysParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.*;

import static com.cmct.base.exception.CmctError.PARAM_ERROR;

/**
 * <p>
 * 检测参数 服务实现类
 * </p>
 *
 * @author shen
 * @since 2018-05-21
 */
@Transactional(rollbackOn = Exception.class)
@Service
public class SysParamsServiceImpl implements ISysParamsService {

    @Autowired
    private SysParamMapper sysParamMapper;

    public static void getTree(List<SysParamVo> result, List<SysParamVo> paveChkParamVos) {

        for (SysParamVo paveChkParamVo : paveChkParamVos) {

            if (StringUtils.isEmpty(paveChkParamVo.getParentId())) {
                result.add(paveChkParamVo);
                //开始循环去获取子树

                searchChildren(paveChkParamVo, paveChkParamVos);

            }
        }

    }

    public static void searchChildren(SysParamVo parent, List<SysParamVo> totalSet) {
        totalSet.stream()
                .forEach(paveChkParamVo -> {
                    if (paveChkParamVo != null && parent.getParamId().equalsIgnoreCase(paveChkParamVo.getParentId())) {
                        if (null == parent.getChildren()) {
                            parent.setChildren(new ArrayList<>());
                        }
                        parent.getChildren().add(paveChkParamVo);
                        searchChildren(paveChkParamVo, totalSet);
                    }
                });
    }

    @Override
    public List<SysParamVo> getSysParams() {

        List<SysParamVo> paveChkParamVos = sysParamMapper.getSysParams();
        List<SysParamVo> result = new ArrayList<>();
        getTree(result, paveChkParamVos);
        return result;
    }

    @Override
    public SysParamVo getChkParamDetail(SysParamsBo bo) {
        return sysParamMapper.getSysParamDetail(bo);
    }

    //todo
    @Override
    public void saveSysParams(SysParamForAddBo bo, String createBy) {

        if (bo == null) {
            throw Exceptions.createException(PARAM_ERROR, "SysParamsBo为空");
        }


        String parenId = UUID.randomUUID().toString();
        sysParamMapper.insertSelective(SysParamPo.builder()
                .paramId(parenId)
                .paramName(bo.getParamName())
                .paramCode(bo.getParamCode())
                .parentId(bo.getParentId())
                .paramOrder(bo.getParamOrder())
                .createBy(createBy)
                .createDate(new Date())
                .deleteStatus(0)
                .des(bo.getDes())
                .build());

        if (StringUtils.isEmpty(bo.getChildrens())) {
            return;
        }

        bo.getChildrens()
                .stream()
                .forEach(sysParamForAddBo ->
                        sysParamMapper.insertSelective(SysParamPo.builder()
                                .paramId(UUID.randomUUID().toString())
                                .paramName(sysParamForAddBo.getParamName())
                                .paramCode(sysParamForAddBo.getParamCode())
                                .parentId(parenId)
                                .paramOrder(sysParamForAddBo.getParamOrder())
                                .createBy(createBy)
                                .createDate(new Date())
                                .des(sysParamForAddBo.getDes())
                                .deleteStatus(0)
                                .build()));


    }

    @Override
    public void updateChkParams(SysParamForUpdateBo bo,
                                String modifyBy, String sysParamId) {

        if (bo == null) {
            throw Exceptions.createException(PARAM_ERROR, "SysParamForUpdateBo为空");
        }

        if (ValidateUtil.paramInvalid(sysParamId)) {
            throw Exceptions.createException(PARAM_ERROR, "sysParamId为空");
        }

        sysParamMapper.updateByPrimaryKeySelective(SysParamPo.builder()
                .paramId(sysParamId)
                .paramName(bo.getParamName())
                .paramCode(bo.getParamCode())
                .paramOrder(bo.getParamOrder())
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .build());
    }

    @Override
    public SysParamVo getChkParamDetail(String chkParamId) {
        if (ValidateUtil.paramInvalid(chkParamId)) {
            throw Exceptions.createException(PARAM_ERROR, "chkParamId参数无效");
        }

        return Optional.ofNullable(sysParamMapper.selectByPrimaryKey(chkParamId))
                .filter(sysParamPo -> sysParamPo.getDeleteStatus() == 0)
                .map(sysParamPo -> SysParamVo.builder()
                        .paramId(sysParamPo.getParamId())
                        .parentId(sysParamPo.getParentId())
                        .title(sysParamPo.getParamName())
                        .paramCode(sysParamPo.getParamCode())
                        .paramOrder(sysParamPo.getParamOrder())
                        .build())
                .orElse(null);
    }


    //todo
    @Override
    public void delSysParamInfo(String sysParamId, String modifyBy) {
        if (ValidateUtil.paramInvalid(sysParamId)) {
            throw Exceptions.createException(PARAM_ERROR, "sysParamId不能为空");
        }
        sysParamMapper.updateByPrimaryKeySelective(SysParamPo.builder()
                .paramId(sysParamId)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .deleteStatus(1)
                .build());
    }


}
