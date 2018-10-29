/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.TunnelReporterForAddBo;
import com.cmct.ysq.model.bo.TunnelReporterForQueryBo;
import com.cmct.ysq.model.bo.TunnelReporterForUpdateBo;
import com.cmct.ysq.model.vo.TunnelReporterVo;
import com.cmct.ysq.service.TunnelReporterService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


*/
/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 *//*

@RestController
@RequestMapping("web/report")
public class WebReporterController {

    @Autowired
    private TunnelReporterService tunnelReporterService;

    @ApiOperation(value = "分页获取报告列表", tags = "报告模块")
    @GetMapping("/list")
    public WebResponse<JsonPage<TunnelReporterVo>> getReportList(TunnelReporterForQueryBo query) {

        return WebResponse.success(tunnelReporterService.getReportPage(query));
    }

    @ApiOperation(value = "修改报告", tags = "报告模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "reporterId", value = "报告模板id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/repoprt-{reporterId}")
    public WebResponse updateReport(@RequestBody TunnelReporterForUpdateBo reporterForUpdateBo,
                                    @PathVariable("reporterId") String reporterId,
                                    @RequestParam String modifyBy) {

        tunnelReporterService.updateReport(reporterForUpdateBo, reporterId, modifyBy);
        return WebResponse.success();
    }


    @PostMapping("")
    @ApiOperation(value = "新增报告", tags = "报告模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "reporterId", value = "报告模板id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    public WebResponse saveReport(@RequestBody TunnelReporterForAddBo reporterForAdd,
                                  @RequestParam String createBy) {

        tunnelReporterService.saveReport(reporterForAdd, createBy);

        return WebResponse.success();
    }

    //TODO
    @ApiOperation(value = "删除报告", tags = "报告模块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "reporterId", value = "报告模板id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/report-{reportId}")
    public WebResponse deleteReport(@PathVariable String reportId, @RequestParam String modifyBy) {

        tunnelReporterService.deleteReport(reportId, modifyBy);

        return WebResponse.success();
    }

}
*/
