package com.cmct.ysq.controller.web;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.AddSysUserVo;
import com.cmct.ysq.model.bo.SysUserQueryBo;
import com.cmct.ysq.model.po.SysUserPo;
import com.cmct.ysq.model.vo.SysUserVo;
import com.cmct.ysq.service.ISysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/web/user")
@RestController
public class WebUserController {


    @Autowired
    private ISysUserService sysUserService;


    @ApiOperation(value = "获取系统用户列表", tags = "web用户")
    @GetMapping("/list")
    public WebResponse<JsonPage<SysUserVo>> getSysUserVos(SysUserQueryBo request) {

        return WebResponse.success(sysUserService.getSysUserVos(request));
    }

    @ApiOperation(value = "为用户分配角色", tags = "web用户")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "path", dataType = "String", name = "userId", value = "修改用户角色的用户id", required = true),
                    @ApiImplicitParam(paramType = "body", dataType = "List<String>", name = "roleIds", value = "需要修改为的角色id列表"),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/user-{userId}/roles")
    public WebResponse updateUserRoles(@PathVariable String userId,
                                       @RequestParam String modifyBy,
                                       @RequestBody(required = false) List<String> roleIds) {
        sysUserService.updateUserRoles(userId, roleIds, modifyBy);
        return WebResponse.success();
    }


    @ApiOperation(value = "重置密码", tags = "web用户")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "path", dataType = "String", name = "userId", value = "重置用户的用户id", required = true),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/user-{userId}/init_pwd")
    public WebResponse resetUserPwd(@PathVariable String userId, @RequestParam String modifyBy) {
        sysUserService.resetUserPwd(userId, modifyBy);
        return WebResponse.success();
    }


    @ApiOperation(value = "删除用户", tags = "web用户")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", dataType = "String", name = "userId", value = "重置用户的用户id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/user-{userId}")
    public WebResponse deleteUser(@PathVariable String userId, @RequestParam String modifyBy) {
        sysUserService.deleteUser(userId, modifyBy);
        return WebResponse.success();
    }

    @ApiOperation(value = "新增用户", tags = "web用户")
    @PostMapping("/user-{userId}")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    public WebResponse addUser(@Valid @RequestBody AddSysUserVo newSysUser, @RequestParam String createBy) {
        sysUserService.addNewUser(newSysUser, createBy);
        return WebResponse.success();
    }

    @ApiOperation(value = "修改用户", tags = "web用户")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResponse update(@RequestBody SysUserPo user) throws Exception {
        sysUserService.modify(user);
        return new WebResponse(0, "修改用户成功", null);
    }


}
