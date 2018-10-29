package com.cmct.ysq.controller.emp;

import com.cmct.common.web.WebResponse;
import com.cmct.ysq.model.bo.TunnelCrossSectionForAddBo;
import com.cmct.ysq.model.bo.TunnelDataUploadBo;
import com.cmct.ysq.service.ITunnelMonitorProgressService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 数据传输
 */
@Slf4j
@RestController
@RequestMapping(value = "/app/monitor")
public class TunnelMonitorProgressController {

    @Autowired
    private ITunnelMonitorProgressService tunnelMonitorProgressService;

/*    @PostMapping("")
    @ApiOperation(value = "上传", tags = "APP数据传输")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "createBy", value = "新增人", required = true)})
    public WebResponse postMonitorDataInfo(@RequestBody TunnelDataUploadBo dataUploads,
                                           @RequestParam String createBy) {
        tunnelMonitorProgressService.postMonitorDataInfo(dataUploads, createBy);
        return WebResponse.success();
    }*/

    //TODO 权限问题
  /*  @GetMapping("")
    @ApiOperation(value = "下载", tags = "APP数据传输")
    public WebResponse postCrossSectionInfo(@RequestBody List<TunnelCrossSectionForAddBo> crossSectionForAdds,
                                            String createBy) {
//        tunnelMonitorProgressService.postCrossSectionInfo(crossSectionForAdds, createBy);
        return WebResponse.success();
    }*/


//    @PostMapping("/crossSection")
//    @ApiOperation(value = "上传监测数据", tags = "APP数据传输")
//    public WebResponse postMonitorDataInfo(@RequestBody List<TunnelCrossSectionForAddBo> crossSectionForAdds,
//                                           String createBy) {
//        tunnelMonitorProgressService.postCrossSectionInfo(crossSectionForAdds, createBy);
//        return WebResponse.success();
//    }

//    @PostMapping("/getTunnelPro")
//    @ApiOperation(value = "隧道信息", notes = "隧道信息", tags = "隧道")
//    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelProId", value = "隧道id", required = true)})
//    public WebResponse getTunnelProInfo(String tunnelProId) {
//        return WebResponse.success(service.getTunnelInfo(tunnelProId));
//    }
//
//    @PostMapping("/getTunnelInfoLink")
//    @ApiOperation(value = "根据项目id获取隧道方向", notes = "隧道信息", tags = "隧道")
//    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelProId", value = "隧道id", required = true)})
//    public WebResponse getTunnelInfoLink(String tunnelProId) {
//        return WebResponse.success(service.getListbytunnelId(tunnelProId));
//    }
//
//    @PostMapping("/getTunnelHoleLink")
//    @ApiOperation(value = "根据项目id获取隧道洞别", notes = "隧道信息", tags = "隧道")
//    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "tunnelId", value = "隧道id", required = true)})
//    public WebResponse getTunnelHoleLink(String tunnelId) {
//        return WebResponse.success(service.getTunnelHoleList(tunnelId));
//    }
//
//    /**
//     * 根据条件筛选 pad-shuju chakan
//     *
//     * @param holeBo
//     * @return
//     */
//    @PostMapping("/getListByParams")
//    @ApiOperation(value = "pad 数据传输", notes = "隧道信息", tags = "隧道")
//    public WebResponse getListByParams(TunnelTransBo holeBo) {
//        return WebResponse.success(service.findListByTunnelTransBo(holeBo));
//    }
//
//    @PostMapping("/getTunnelMonitoringInformation")
//    @ApiOperation(value = "app 数据查看端 监测信息", notes = "隧道信息", tags = "隧道")
//    public WebResponse getTunnelMonitoringInformation(TunnelTransBo holeBo) {
//        return WebResponse.success(service.getTunnelMonitoringInformation(holeBo));
//    }
}
