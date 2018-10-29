/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.BaseModelBo;
import com.cmct.ysq.model.bo.ConstructProgForUpdateBo;
import com.cmct.ysq.model.vo.TunnelConstructProgHisVo;
import com.cmct.ysq.model.vo.TunnelProgressBaseVo;
import com.cmct.ysq.service.ITunnelMonitorProgressService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

*/
/**
 * 数据查看/监控量测/施工进度
 *
 * @author shen
 * @date 2018/7/24
 *//*

@RestController
@RequestMapping("web/monitor/progress")
public class WebTunnelProgressController {

    @Autowired
    private ITunnelMonitorProgressService tunnelMonitorProgressService;


    @GetMapping(value = "/list")
    @ApiOperation(value = " 获取施工进度列表", tags = "监控量测/施工进度")
    public WebResponse<JsonPage<TunnelProgressBaseVo>> getTunnelProgressBaseInfoList(BaseModelBo pageQuery) {
        return WebResponse.success(tunnelMonitorProgressService.getTunnelProgressBaseInfoList(pageQuery));
    }


    @ApiOperation(value = "删除施工进度", tags = "监控量测/施工进度")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "constructProgressId", value = "施工进度id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/constructProgressId-{constructProgressId}")
    public WebResponse deleteconstructProgress(@PathVariable String constructProgressId, @RequestParam String modifyBy) {

        tunnelMonitorProgressService.delTunnelMonitorProgress(constructProgressId, modifyBy);

        return WebResponse.success();
    }

    @ApiOperation(value = "修改施工进度", tags = "监控量测/施工进度")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "constructProgressId", value = "施工进度id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/constructProgressId-{constructProgressId}")
    public WebResponse updateConstructProgressInfo(@PathVariable String constructProgressId,
                                                   @RequestBody ConstructProgForUpdateBo updateInfo,
                                                   @RequestParam String modifyBy) {

        tunnelMonitorProgressService.updateConstructProgressInfo(constructProgressId, updateInfo, modifyBy);

        return WebResponse.success();
    }

    @ApiOperation(value = "获取历史施工进度", tags = "监控量测/施工进度")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "constructProgressId", value = "施工进度id", required = true)})
    @GetMapping("/constructProgressId-{constructProgressId}")
    public WebResponse<JsonPage<TunnelConstructProgHisVo>> getConstructProgressHisInfo(@PathVariable String constructProgressId, BaseModelBo hisQuery) {

        return WebResponse.success(tunnelMonitorProgressService.getConstructProgressHisInfo(constructProgressId, hisQuery));
    }


}
*/
