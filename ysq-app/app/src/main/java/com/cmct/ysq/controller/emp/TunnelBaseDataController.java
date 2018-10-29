/*
package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.vo.BaseDataVo;
import com.cmct.ysq.model.vo.TunnelProgressVo;
import com.cmct.ysq.service.ITunnelProgressChartService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


*/
/**
 * 数据传输
 *//*

@Slf4j
@RestController
@RequestMapping(value = "/app/data")
public class TunnelBaseDataController {

    @Autowired
    private ITunnelProgressChartService tunnelProgressChartService;

    @GetMapping("/progressChart")
    @ApiOperation(value = "获取施工及监测进度图", tags = "APP基础数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "userId", value = "用户id", required = true)})
    public WebResponse<List<TunnelProgressVo>> getTunnelProgresss(@RequestParam String userId) {
        return WebResponse.success(tunnelProgressChartService.getTunnelProgresss(userId));
    }

    */
/**
     * todo 还未实现
     *//*

    @GetMapping("/base")
    @ApiOperation(value = "下载隧道采集需要的基础数据", tags = "APP基础数据")
    public WebResponse<BaseDataVo> getBasicData() {
        return WebResponse.success(null);
    }


}
*/
