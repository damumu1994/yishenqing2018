/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.service.TunnelGeoForcastService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author shen
 *//*

@RestController
@RequestMapping("/tunnelGeoForcast/app")

public class TunnelGeoForcastAppController {
    @Autowired
    private TunnelGeoForcastService service;
    @PostMapping("/query")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "key", value = "id", required = true)})
    @ApiOperation(value = "app详细信息", notes = "条件帅选查询",tags = "地质监测")
    public WebResponse query( String key) throws Exception{
        return WebResponse.success(service.findByPk(key));
    }
    @PostMapping("/getInfoByPk")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "geoForcastId", value = "id", required = true)})
    @ApiOperation(value = "查询(地质预报编辑信息列表)", notes = "查询",tags = "地质监测")
    public WebResponse getInfoByPk( String geoForcastId){
        this.getClass();
        return WebResponse.success(service.getInfofindByPk(geoForcastId));
    }
}
*/
