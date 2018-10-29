/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.bean.JsonPage;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.DepartQueryBo;
import com.cmct.ysq.model.bo.SysDepartForAddBo;
import com.cmct.ysq.model.bo.SysDepartForUpdateBo;
import com.cmct.ysq.model.vo.SysDepartVo;
import com.cmct.ysq.service.ISysDepartService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


*/
/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 *//*

@RequestMapping("web/depart")
@RestController
public class WebDepartController {

    @Autowired
    private ISysDepartService sysDepartService;

    @ApiOperation(value = "获取部门列表", tags = "部门模块")
    @GetMapping("/list")
    public WebResponse<JsonPage<SysDepartVo>> getDepartList(DepartQueryBo departQuery) {

        return WebResponse.success(sysDepartService.getDepartList(departQuery));

    }

    @ApiOperation(value = "修改部门", tags = "部门模块")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", dataType = "String", name = "departId", value = "部门id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @PutMapping("/departId-{departId}")
    public WebResponse updateDepart(@PathVariable String departId,
                                    @RequestBody SysDepartForUpdateBo sysDepartForUpdate,
                                    @RequestParam String modifyBy) {
        sysDepartService.updateDepart(departId, sysDepartForUpdate, modifyBy);
        return WebResponse.success();

    }

    @ApiOperation(value = "新增部门", tags = "部门模块")
    @ApiImplicitParams(
            {@ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    @PostMapping("")
    public WebResponse addDepart(@RequestParam String createBy,
                                 @RequestBody SysDepartForAddBo sysDepartForAdd) {
        sysDepartService.addDepart(sysDepartForAdd, createBy);
        return WebResponse.success();
    }


    @ApiOperation(value = "删除部门", tags = "部门模块")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", dataType = "String", name = "departId", value = "修改的部门id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "modifyBy", value = "修改人", required = true)})
    @DeleteMapping("/departId-{departId}")
    public WebResponse deleteDepart(@PathVariable String departId, @RequestParam String modifyBy) {
        sysDepartService.deleteDepart(departId, modifyBy);
        return WebResponse.success();
    }


}
*/
