package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.TunnelInfoBo;
import com.cmct.ysq.model.bo.TunnelProjectBo;
import com.cmct.ysq.service.ProjectService;
import com.cmct.ysq.service.TunnelProService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxb
 * @Date 2018/7/20 09:32
 */

@RestController
@RequestMapping(value = "web/tunnelInfo")
public class WebTunnelInfoController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TunnelProService tunnelProService;

/*    @PostMapping(value = "/add")
    @ApiOperation(value = " 添加隧道", tags = "项目管理")
    public WebResponse getDepartList(TunnelInfoBo bo) {
        return WebResponse.success();
    }

    @PostMapping(value = "/getProjectList")
    @ApiOperation(value = " 获取项目名称(模糊查询)", tags = "项目管理")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "projectName", value = "项目名称", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市编号", required = true)
    })
    public WebResponse getProjectList(@RequestParam String projectName, @RequestParam String cityCode, String userId) {
        return WebResponse.success(projectService.findByprojectNameLike(projectName, cityCode));
    }
    @PostMapping(value = "/getLaneNumList")
    @ApiOperation(value = " 获取车道数列表", tags = "项目管理")
    public WebResponse getLaneNumList(*//*@RequestParam String param*//*) {
        return WebResponse.success(tunnelProService.getLaneNumList("001001"));
    }
    @PostMapping(value = "/getHoleList")
    @ApiOperation(value = " 获取隧道方向列表", tags = "项目管理")
    public WebResponse getHoleList() {
        return WebResponse.success(tunnelProService.getLaneNumList("001003"));
    }
    //tunnel_type
    @PostMapping(value = "/getTunnelTypeList")
    @ApiOperation(value = " 获取隧道形式列表", tags = "项目管理")
    public WebResponse getTunnelTypeList() {
        return WebResponse.success(tunnelProService.getLaneNumList("001002"));
    }
    @PostMapping(value = "/getTunnelSepList")
    @ApiOperation(value = " 获取隧道洞别列表", tags = "项目管理")
    public WebResponse getTunnelSepList() {
        return WebResponse.success(tunnelProService.getLaneNumList("001004"));
    }

    *//**
     * pc端 首页筛选
     * @param bo
     * @return
     *//*
    @PostMapping(value = "/getTunnelListByParam")
    @ApiOperation(value = " 根据参数获取隧道列表", tags = "项目管理")
    public WebResponse getTunnelListByParam(TunnelProjectBo bo) {
        return WebResponse.success(tunnelProService.getTunnelListByParam(bo));
    }
    @PostMapping(value = "/getTunnelHoleList")
    @ApiOperation(value = " 根据隧道获取洞列表", tags = "项目管理")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelId", value = "隧道id", required = true)
    })
    public WebResponse getTunnelHoleList(String tunnelId){
        return WebResponse.success(tunnelProService.getTunnelHoleList(tunnelId));
    }
    @PostMapping(value = "/getCityList")
    @ApiOperation(value = " 获取省份列表", tags = "项目管理")
    public WebResponse getCityList(){
        return WebResponse.success(projectService.getCityList());
    }*/
}
