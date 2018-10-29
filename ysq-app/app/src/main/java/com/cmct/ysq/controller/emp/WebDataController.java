package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.SysParamForAddBo;
import com.cmct.ysq.model.bo.SysParamForUpdateBo;
import com.cmct.ysq.model.vo.SysParamVo;
import com.cmct.ysq.service.ISysParamsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典管理
 *
 * @author shen
 */
@RestController
@RequestMapping("web/data")
public class WebDataController {

    @Autowired
    private ISysParamsService sysParamsService;

    @GetMapping("/list")
    @ApiOperation(value = "获取系统参数列表", tags = "系统参数模块")
    public WebResponse<List<SysParamVo>> getChkParams() {

        return WebResponse.success(sysParamsService.getSysParams());
    }

    @ApiOperation(value = "修改系统参数", tags = "系统参数模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "sysParamId", value = "系统参数id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/sysParamId-{sysParamId}")
    public WebResponse updateSysParam(@RequestBody SysParamForUpdateBo sysParamForUpdate,
                                      @PathVariable String sysParamId,
                                      @RequestParam String modifyBy) {

        sysParamsService.updateChkParams(sysParamForUpdate, sysParamId, modifyBy);

        return WebResponse.success();
    }

    @ApiOperation(value = "新增系统参数", tags = "系统参数模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    @PostMapping("")
    public WebResponse addSysParam(@RequestBody SysParamForAddBo sysParamForAdd,
                                   @RequestParam String createBy) {

        sysParamsService.saveSysParams(sysParamForAdd, createBy);

        return WebResponse.success();
    }

    @ApiOperation(value = "新增系统参数", tags = "系统参数模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "sysParamId", value = "系统参数id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/sysParamId-{sysParamId}")
    public WebResponse deleteSysParam(@PathVariable String sysParamId,
                                      @RequestParam String modifyBy) {

        sysParamsService.delSysParamInfo(sysParamId, modifyBy);

        return WebResponse.success();
    }


}
