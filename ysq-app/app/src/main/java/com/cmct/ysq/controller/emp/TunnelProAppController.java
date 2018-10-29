/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.TunnelTransBo;
import com.cmct.ysq.service.TunnelProService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app/unnelPro")
public class TunnelProAppController {
    @Autowired
    private TunnelProService service;

    @PostMapping("/getList")
    @ApiOperation(value = "隧道列表", notes = "隧道列表",tags = "隧道")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "projectId", value = "项目id", required = true)})
    public WebResponse getList(String projectId){
        return WebResponse.success(service.getList(projectId));
    }

    @PostMapping("/getTunnelPro")
    @ApiOperation(value = "隧道信息", notes = "隧道信息",tags = "隧道")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelProId", value = "隧道id", required = true)})
    public WebResponse getTunnelProInfo(String tunnelProId){
        return WebResponse.success(service.getTunnelInfo(tunnelProId));
    }

    @PostMapping("/getTunnelInfoLink")
    @ApiOperation(value = "根据项目id获取隧道方向", notes = "隧道信息",tags = "隧道")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelProId", value = "隧道id", required = true)})
    public WebResponse getTunnelInfoLink(String tunnelProId){
        return WebResponse.success(service.getListbytunnelId(tunnelProId));
    }
    @PostMapping("/getTunnelHoleLink")
    @ApiOperation(value = "根据项目id获取隧道洞别", notes = "隧道信息",tags = "隧道")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelId", value = "隧道id", required = true)})
    public WebResponse getTunnelHoleLink(String tunnelId){
        return WebResponse.success(service.getTunnelHoleList(tunnelId));
    }

    */
/**
     * 根据条件筛选 pad-shuju chakan
     * @param holeBo
     * @return
     *//*

    @PostMapping("/getListByParams")
    @ApiOperation(value = "pad 数据传输", notes = "隧道信息",tags = "隧道")
    public WebResponse getListByParams(TunnelTransBo holeBo){
        return WebResponse.success(service.findListByTunnelTransBo(holeBo));
    }
    @PostMapping("/getTunnelMonitoringInformation")
    @ApiOperation(value = "app 数据查看端 监测信息", notes = "隧道信息",tags = "隧道")
    public WebResponse getTunnelMonitoringInformation(TunnelTransBo holeBo){
        return WebResponse.success(service.getTunnelMonitoringInformation(holeBo));
    }
}
*/
