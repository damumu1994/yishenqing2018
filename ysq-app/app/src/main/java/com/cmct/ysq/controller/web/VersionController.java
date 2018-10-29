/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.ysq.controller.web;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.SysVersionForAddBo;
import com.cmct.ysq.model.bo.SysVersionForUpdateBo;
import com.cmct.ysq.model.bo.SysVersionQueryBo;
import com.cmct.ysq.model.vo.SysVersionVo;
import com.cmct.ysq.service.SysVersionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 版本Controller
 *
 * @author losing
 * @Date 2016年9月16日
 * @since v0.1
 */
@RestController
@RequestMapping("/web/version")
public class VersionController {

    @Autowired
    private SysVersionService versionService;

    @ApiOperation(value = "获取版本列表", tags = "版本模块")
    @GetMapping(value = "/list")
    public WebResponse page(SysVersionQueryBo sysVersionQuery) {
        JsonPage<SysVersionVo> sysVersionVoJsonPage = versionService.page(sysVersionQuery);
        return WebResponse.success(sysVersionVoJsonPage);
    }

    @ApiOperation(value = "新增版本", tags = "版本模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public WebResponse save(@RequestBody SysVersionForAddBo sysVersionForAdd, String createBy) {
        versionService.save(sysVersionForAdd, createBy);
        return WebResponse.success();
    }

    @ApiOperation(value = "修改版本", tags = "版本模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "versionId", value = "版本id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping(value = "/versionId-{versionId}")
    public WebResponse update(@RequestBody SysVersionForUpdateBo sysVersionForUpdate,
                              @RequestParam String modifyBy,
                              @PathVariable String versionId) throws Exception {
        versionService.update(sysVersionForUpdate, modifyBy, versionId);
        return WebResponse.success();
    }


    @ApiOperation(value = "删除版本", tags = "版本模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "versionId", value = "版本id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @RequestMapping(value = "/versionId-{versionId}", method = RequestMethod.DELETE)
    public WebResponse remove(@PathVariable String versionId, @RequestParam String modifyBy) {
        versionService.remove(versionId, modifyBy);
        return WebResponse.success();
    }

}
