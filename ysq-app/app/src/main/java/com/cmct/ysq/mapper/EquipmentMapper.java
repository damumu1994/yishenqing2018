package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.EquipmentPo;
import com.cmct.ysq.model.vo.EquipmentVo;

import java.util.List;

public interface EquipmentMapper extends BaseMapper<EquipmentPo> {

    List<EquipmentVo> getEquipments(EquipmentVo vo);
}
