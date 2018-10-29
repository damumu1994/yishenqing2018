/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.po.TunnelConsInfoPo;
import com.cmct.ysq.service.TunnelConsInfoService;
import com.cmct.ysq.service.TunnelProService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author lxb
 * @Date 2018/7/20 09:32
 * 描述:施工设计信息
 *//*


@RestController
@RequestMapping(value = "web/tunnelConsInfo")
public class WebTunnelConsInfoController {
    @Autowired
    private TunnelConsInfoService service;
    @Autowired
    private TunnelProService tunnelProService;
    @PostMapping(value = "/add")
    @ApiOperation(value = " 添加洞别", tags = "项目管理")
    public WebResponse addtunnelConsInfo(@RequestParam TunnelConsInfoPo[] bos) {
        if (0!=bos.length)
            return  WebResponse.fail("添加失败");
            return  service.add(bos)?WebResponse.success():WebResponse.fail("添加失败");
    }
    @PostMapping(value = "/getLaneNumList")
    @ApiOperation(value = " 获取围岩等级列表", tags = "项目管理")
*/
/*@ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "param", value = "查询参数", required = true)
})*//*

    public WebResponse getLaneNumList(*/
/*@RequestParam String param*//*
) {
        return WebResponse.success(tunnelProService.getLaneNumList("001005"));
    }
}
*/
