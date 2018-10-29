/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.service.ProjectService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app/project")
public class ProjectAppController {
    @Autowired
    private ProjectService service;
    @PostMapping("/getList")
    @ApiOperation(value = "项目列表", notes = "项目列表",tags = "项目管理")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cityCode", value = "城市id", required = true)})

    public WebResponse getList(@RequestParam(required = false) String userId,String cityCode){

        return WebResponse.success(service.getListByCityCode(cityCode));
    }
    @PostMapping("/getListLike")
    @ApiOperation(value = "项目列表(模糊查询)", notes = "项目列表",tags = "项目管理")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "param", value = "查询参数", required = true)})
    public WebResponse getListLike(@RequestParam(required = false) String userId,String param){
        return WebResponse.success(service.projectListeLikeNam(param));
    }
}
*/
