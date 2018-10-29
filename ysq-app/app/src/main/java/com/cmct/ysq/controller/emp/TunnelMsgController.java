/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.TunnelMsg;
import com.cmct.ysq.model.where.TunnelMsgWhere;
import com.cmct.ysq.service.TunnelMsgService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

*/
/**
 * @author lxb
 * @Date 2018/7/24 16:53
 * 描述:
 *//*

@RestController
@RequestMapping(value = "/tunnel/msg")
public class TunnelMsgController {
    @Autowired
    TunnelMsgService service;
    @PostMapping ("/getList")
    @ApiOperation(value = "查询", notes = "分页查询",tags = "消息模块")
    public WebResponse query( TunnelMsgWhere bo) throws Exception{
        return WebResponse.success(service.paramsQuery(bo));
    }
    @PutMapping("/edit")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "status", value = "预警状态(0未处理,1已处理)", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "msgId", value = "pk", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "handlingWay", value = "处理方式(1发送消息 2忽略 )", required = true)})
    @ApiOperation(value = "修改(忽略)", notes = "修改状态",tags = "消息模块")
    public WebResponse  edit(@RequestParam String msgId, @RequestParam String status,@RequestParam String handlingWay,@RequestParam String userId) throws Exception{
        service.edit(msgId, status, handlingWay, userId);
        return WebResponse.success();
    }
    @PutMapping("/save")
    @ApiOperation(value = "新增", notes = "新增",tags = "消息模块")
    public WebResponse  save(@RequestBody TunnelMsg tunnelMsg) throws Exception{
        service.save(tunnelMsg);
        return WebResponse.success();
    }
}
*/
