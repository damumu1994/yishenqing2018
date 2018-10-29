package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.mapper.EquipmentMapper;
import com.cmct.ysq.model.po.EquipmentPo;
import com.cmct.ysq.model.vo.EquipmentVo;
import com.cmct.ysq.service.IEquipmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class EquipmentService implements IEquipmentService {

    @Autowired
    private EquipmentMapper equipMapper;

    @Override
    public WebResponse getEquipments(EquipmentVo vo) {
        Page<EquipmentVo> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        equipMapper.getEquipments(vo);
        return WebResponse.success(new JsonPage(page));
    }

    @Override
    public WebResponse saveEquipment(EquipmentPo po) {
        if (StringUtils.isEmpty(po.getEquipId())) {
            po.setEquipId(UUID.randomUUID().toString());
            po.setCreateDate(new Date());
            equipMapper.insertSelective(po);
        } else {
            po.setModifyDate(new Date());
            equipMapper.updateByPrimaryKeySelective(po);
        }
        return WebResponse.success(null);
    }

    @Override
    public WebResponse delEquipment(String equipId) {
        equipMapper.updateByPrimaryKeySelective(EquipmentPo.builder()
                .equipId(equipId)
                .deleteStatus(DeleteStatus.NO.ordinal())
                .build());
        return WebResponse.success(null);
    }

    @Override
    public WebResponse getEquipByType(EquipmentVo vo) {
        return WebResponse.success(equipMapper.getEquipments(vo));
    }
}
