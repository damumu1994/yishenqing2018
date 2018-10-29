/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.TunnelInspectionReportBO;
import com.cmct.ysq.model.po.TunnelInspectionReportPO;
import com.cmct.ysq.model.where.TunnelInspectionReportWhere;
import com.cmct.ysq.service.TunnelInspectionReportService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tunnelInspectionReport")
public class TunnelInspectionReportController {
    @Autowired
    private TunnelInspectionReportService service;
@PostMapping("/query")
@ApiOperation(value = "查询", notes = "条件帅选查询",tags = "质量检查")
    public WebResponse paramsQuery(TunnelInspectionReportWhere where){

    return WebResponse.success(service.paramsByQuery(where));
}
@PostMapping("/add")
@ApiOperation(value = "添加", notes = "添加",tags = "质量检查")
public WebResponse add(@RequestBody TunnelInspectionReportBO bo)
{
    service.add(bo);
    return WebResponse.success();
}
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "model",tags = "质量检查")
    public WebResponse update(@RequestBody(required = false) TunnelInspectionReportPO po){
        return WebResponse.success();
    }
    @PostMapping("/del/{inspectionReportId}")
    @ApiOperation(value = "删除", notes = "pk",tags = "质量检查")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "inspectionReportId", value = "主键", required = true)})
    public WebResponse del(@PathVariable String inspectionReportId){
        return WebResponse.success();
    }
    //TunnelInspectionReport2VO
  @PostMapping("/dit")
    @ApiOperation(value = "获取详情", notes = "获取详情",tags = "质量检查")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "inspectionReportId", value = "主键", required = true)})
    public WebResponse dit(@RequestParam String inspectionReportId){
      System.out.println(inspectionReportId);
        return WebResponse.success(service.dit(inspectionReportId));
    }
    //---------------------------------------------------
    @PostMapping("/getInspectionArea")
    @ApiOperation(value = "获取检查部位", notes = "add",tags = "质量检查")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true)})
    public WebResponse getInspectionArea( String inspectionReportId){
        return WebResponse.success(service.getInspectionArea("002"));
    }
    @PostMapping("/getCheckProject")
    @ApiOperation(value = "根据检查部位获取检查项目", notes = "add",tags = "质量检查")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "checkarea", value = "检查部位", required = true)})
    public WebResponse getCheckProject( String checkarea){
        return WebResponse.success(service.getInspectionArea(checkarea));
    }
}
*/
