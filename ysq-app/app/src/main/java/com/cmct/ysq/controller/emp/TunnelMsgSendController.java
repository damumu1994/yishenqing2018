/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.TunnelMsgSend;
import com.cmct.ysq.service.TunnelMsgSendService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

*/
/**
 * @author lxb
 * @Date 2018/7/24 16:53
 * 描述:  消息发送
 *//*

@RestController
@RequestMapping(value = "/tunnel/msg/send")
public class TunnelMsgSendController {
    @Autowired
    private TunnelMsgSendService sendService;
    @PutMapping("/save")
    @ApiOperation(value = "发送消息", notes = "",tags = "消息模块")
    public WebResponse save(@RequestBody TunnelMsgSend tunnelMsgSend) throws Exception{
        sendService.save(tunnelMsgSend);
        return WebResponse.success();
    }
    @PostMapping ("/getList")
    @ApiOperation(value = "根据用户查询发送消息", notes = "",tags = "消息模块")
    public WebResponse query( String userId){
        return WebResponse.success(sendService.getList(userId));
    }
}
*/
