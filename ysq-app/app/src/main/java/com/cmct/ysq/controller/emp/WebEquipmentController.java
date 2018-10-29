/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.EquipmentPo;
import com.cmct.ysq.model.vo.EquipmentVo;
import com.cmct.ysq.service.IEquipmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("web/equip")
public class WebEquipmentController {

    @Autowired
    private IEquipmentService equipService;

    */
/**
     * 分页查询设备
     *
     * @param vo
     * @return
     *//*

    @ApiOperation(value = "获取设备列表", tags = "设备模块")
    @GetMapping("/list")
    public WebResponse getEquipments(EquipmentVo vo) {
        return equipService.getEquipments(vo);
    }

    */
/**
     * 保存设备
     *
     * @param po
     * @return
     *//*

    @ApiOperation(value = "保存设备", tags = "设备模块")
    @RequestMapping("/saveequipment")
    public WebResponse saveEquipment(@RequestBody EquipmentPo po) {
        return equipService.saveEquipment(po);
    }

    */
/**
     * 删除设备
     *
     * @param equipId
     * @return
     *//*

    @ApiOperation(value = "删除设备", tags = "设备模块")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", dataType = "String", name = "equipId", value = "设备id", required = true)})
    @DeleteMapping("/delequipment/{equipId}")
    public WebResponse delEquipment(@PathVariable String equipId) {
        return equipService.delEquipment(equipId);
    }

}
*/
