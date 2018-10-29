package com.cmct.ysq.service;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.EquipmentPo;
import com.cmct.ysq.model.vo.EquipmentVo;

/**
 * @@author shen
 */
public interface IEquipmentService {

    /**
     * 分页查询设备
     *
     * @param vo
     * @return
     */
    WebResponse getEquipments(EquipmentVo vo);

    /**
     * 保存设备
     *
     * @param po
     * @return
     */
    WebResponse saveEquipment(EquipmentPo po);

    /**
     * 删除设备
     *
     * @param equipId
     * @return
     */
    WebResponse delEquipment(String equipId);

    /**
     * 根据专业查询设备
     *
     * @param vo
     * @return
     */
    WebResponse getEquipByType(EquipmentVo vo);
}
