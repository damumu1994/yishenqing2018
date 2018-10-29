/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.where.TunnelInspectionReportWhere;
import com.cmct.ysq.service.TunnelCheckItemService;
import com.cmct.ysq.service.TunnelInspectionReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * app  查看
 *//*

@RestController
@RequestMapping(value = "/app/tunnelInspectionReport")
public class TunnelInspectionReportAppController {
    @Autowired
    private TunnelInspectionReportService service;
    @Autowired
    private TunnelCheckItemService checkItemService;
@PostMapping("/query")
@ApiOperation(value = "查询", notes = "条件帅选查询",tags = "质量检查")
    public WebResponse paramsQuery(TunnelInspectionReportWhere where){

    return WebResponse.success(service.paramsByQuery(where));
}
    @PostMapping("/query/getInfo")
    @ApiOperation(value = "查询具体信息", notes = "条件帅选查询",tags = "质量检查")
    public WebResponse paramsQueryInfo(String key){

        return WebResponse.success(checkItemService.getInfoByFk(key));
    }

}
*/
