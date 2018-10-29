/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.TunnelGeoForcastPO;
import com.cmct.ysq.model.where.TunnelGeoForcastWhere;
import com.cmct.ysq.service.TunnelGeoForcastService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

*/
/**
 * @author shen
 *//*

@RestController
@RequestMapping("/tunnelGeoForcast")

public class TunnelGeoForcastController {
    @Autowired
    private TunnelGeoForcastService service;
    @GetMapping("/query")
    @ApiOperation(value = "查询", notes = "条件帅选查询",tags = "地质监测")
    public WebResponse query( TunnelGeoForcastWhere bo) throws Exception{
        return WebResponse.success(service.paramsQuery(bo));
    }
    @PostMapping ("/add")
    @ApiOperation(value = "添加", notes = "添加",tags = "地质监测")
    public WebResponse add(@RequestBody TunnelGeoForcastPO[] pos){

        service.add(pos);
        return WebResponse.success();
    }

    @GetMapping("/del")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "geoForcastId", value = "id", required = true)})
    @ApiOperation(value = "删除", notes = "删除",tags = "地质监测")
    public WebResponse del(@RequestParam String geoForcastId){
        TunnelGeoForcastPO po=new TunnelGeoForcastPO();
        po.setGeoForcastId(geoForcastId);
        service.del(po);
        return WebResponse.success();
    }
    @GetMapping("/update")
    @ApiOperation(value = "修改", notes = "修改",tags = "地质监测")
    public WebResponse update(@RequestBody String geoForcastId){
        return WebResponse.success();
    }
    //----------------------------分割线------------------------
    @PostMapping("/getInfoByPk")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "geoForcastId", value = "id", required = true)})
    @ApiOperation(value = "查询(地质预报编辑信息列表)", notes = "查询",tags = "地质监测")
    public WebResponse getInfoByPk( String geoForcastId){
         this.getClass();
        return WebResponse.success(service.getInfofindByPk(geoForcastId));
    }
}
*/
