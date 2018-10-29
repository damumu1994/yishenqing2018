/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.BaseModelBo;
import com.cmct.ysq.model.bo.TunnelMonitorItemForUpdateBo;
import com.cmct.ysq.model.vo.TunnelCrossSectionVo;
import com.cmct.ysq.model.vo.TunnelMonitorItemBaseVo;
import com.cmct.ysq.model.vo.TunnelMonitorItemNeweastInfoVo;
import com.cmct.ysq.service.ITunnelMonitorItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

*/
/**
 * 数据查看/监控量测/监测项目
 *
 * @author shen
 * @date 2018/7/24
 *//*

@RestController
@RequestMapping("web/monitor/item")
public class WebTunnelMonitorItemController {

    @Autowired
    private ITunnelMonitorItemService tunnelMonitorItemService;


    @GetMapping(value = "/list")
    @ApiOperation(value = " 获取监测项目列表", tags = "监控量测/监测项目")
    public WebResponse<JsonPage<TunnelMonitorItemBaseVo>> getTunnelProgressBaseInfoList(BaseModelBo pageQuery) {
        return WebResponse.success(tunnelMonitorItemService.getTunnelMonitorItemBaseInfoList(pageQuery));
    }


    @GetMapping("/monitorItemRecordId-{monitorItemRecordId}/crossSection")
    @ApiOperation(value = "获取断面信息", tags = "监控量测/监测项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "monitorItemRecordId", value = "监测项目记录id", required = true)})
    public WebResponse<TunnelCrossSectionVo> getCrossSection(@PathVariable String monitorItemRecordId) {

        return WebResponse.success(tunnelMonitorItemService.getCrossSection(monitorItemRecordId));
    }


    @ApiOperation(value = "删除监测项目", tags = "监控量测/监测项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "monitorItemRecordId", value = "监测项目记录id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/monitorItemRecordId-{monitorItemRecordId}")
    public WebResponse deleteTunnelMonitorItem(@PathVariable String monitorItemRecordId, @RequestParam String modifyBy) {

        tunnelMonitorItemService.deleteTunnelMonitorItem(monitorItemRecordId, modifyBy);

        return WebResponse.success();
    }


    */
/**
     * @param monitorItemRecordId
     * @param updateInfo
     * @param modifyBy
     * @return
     *//*

    @ApiOperation(value = "修改监测项目", tags = "监控量测/监测项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "monitorItemRecordId", value = "监测项目记录id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/monitorItemRecordId-{monitorItemRecordId}")
    public WebResponse updateTunnelMonitorItem(@PathVariable String monitorItemRecordId,
                                               @RequestBody TunnelMonitorItemForUpdateBo updateInfo,
                                               @RequestParam String modifyBy) {

        tunnelMonitorItemService.updateTunnelMonitorItem(monitorItemRecordId, updateInfo, modifyBy);

        return WebResponse.success();
    }


    @ApiOperation(value = "获取最新监测", tags = "监控量测/监测项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "monitorItemRecordId", value = "监测项目记录id", required = true)})
    @GetMapping("/monitorItemRecordId-{monitorItemRecordId}/neweastMonitorItemInfo")
    public WebResponse<List<TunnelMonitorItemNeweastInfoVo>> getNeweastMonitorItemInfo(@PathVariable String monitorItemRecordId) {

        return WebResponse.success(tunnelMonitorItemService.getNeweastMonitorItemInfo(monitorItemRecordId));
    }

//
//    @ApiOperation(value = "修改施工进度", tags = "监控量测/施工进度")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "path", dataType = "String", name = "constructProgressId", value = "施工进度id", required = true),
//            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
//    @PutMapping("/constructProgressId-{constructProgressId}")
//    public WebResponse updateConstructProgressInfo(@PathVariable String constructProgressId,
//                                                   @RequestBody ConstructProgForUpdateBo updateInfo,
//                                                   @RequestParam String modifyBy) {
//
//        tunnelMonitorProgressService.updateConstructProgressInfo(constructProgressId, updateInfo, modifyBy);
//
//        return WebResponse.success();
//    }
//
//    @ApiOperation(value = "获取历史施工进度", tags = "监控量测/施工进度")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "path", dataType = "String", name = "constructProgressId", value = "施工进度id", required = true)})
//    @GetMapping("/constructProgressId-{constructProgressId}")
//    public WebResponse<JsonPage<TunnelConstructProgHisVo>> getConstructProgressHisInfo(@PathVariable String constructProgressId, BaseModelBo hisQuery) {
//
//        return WebResponse.success(tunnelMonitorProgressService.getConstructProgressHisInfo(constructProgressId, hisQuery));
//    }


}
*/
