/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.TunnelCfgWayPo;
import com.cmct.ysq.model.po.TunnelReportLinkPo;
import com.cmct.ysq.model.po.TunnelUserLinkPo;
import com.cmct.ysq.model.po.TunnelWorkAlertPo;
import com.cmct.ysq.service.TunnelCfgService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author lxb
 * @Date 2018/7/24 16:53
 * 描述:
 *//*

@RestController
@RequestMapping(value = "/tunnel/cfg")
public class TunnelConfigurationController {
    @Autowired
    private TunnelCfgService service;
    @ApiOperation(value = "获取单位类型列表", tags = "隧道配置")
    @PostMapping(value = "/getdepartTypeList")
    */
/**
     * 后面优化一下  带用户信息
     *//*

    public WebResponse getdepartTypeList() {
        return WebResponse.success(service.getdepartTypeList("003003"));
    }
    @ApiOperation(value = "获取单位列表", tags = "隧道配置")
    @PostMapping(value = "/getdepartList")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "typeId", value = "单位类型", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "param", value = "查询参数", required = true)
    })
    public WebResponse getdepartList(String typeId,String param) {
        return WebResponse.success(service.getDepartListLikeByDepartName(typeId, param));
    }
    @ApiOperation(value = "添加隧道人员配置", tags = "隧道配置")
    @PostMapping(value = "/addTunnelUserLink")
    public WebResponse addTunnelUserLink(TunnelUserLinkPo po) {
        service.addTunnelUserLink(po);
        return WebResponse.success();
    }

    @ApiOperation(value = "添加隧道提醒", tags = "隧道配置")
    @PostMapping(value = "/addTunnelWorkAlert")
    public WebResponse addTunnelWorkAlert(TunnelWorkAlertPo po) {
        service.addTunnelWorkAlert(po);
        return WebResponse.success();
    }

    @ApiOperation(value = "添加隧道配置类型", tags = "隧道配置")
    @PostMapping(value = "/addTunnelCfgWay")
    public WebResponse addTunnelCfgWay(TunnelCfgWayPo po) {
        service.addTunnelCfgWay(po);
        return WebResponse.success();
    }
    @ApiOperation(value = "添加报告模板选择", tags = "隧道配置")
    @PostMapping(value = "/addTunnelReportLink")
    public WebResponse addTunnelReportLink(TunnelReportLinkPo po) {
        service.addTunnelReportLink(po);
        return WebResponse.success();
    }
}
*/
