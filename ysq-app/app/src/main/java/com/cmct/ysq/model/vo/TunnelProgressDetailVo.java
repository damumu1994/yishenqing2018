package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgressDetailVo {
    @ApiModelProperty("隧道方向")
    private String tunnelDirId;
    @ApiModelProperty("隧道方向名")
    private String tunnelDirName;
    @ApiModelProperty("施工进度信息")
    private TunnelMonitorProgressVo tunnelMonitorProgress;
    @ApiModelProperty("超前地质预报")
    private List<TunnelProgressGeoForcastVo> tunnelProgressGeoForcasts;
    @ApiModelProperty("监测断面桩号")
    private TunnelProgressCrossSectionVo tunnelProgressCrossSection;
    @ApiModelProperty("初期支护质量检查")
    private TunnelProgressQualityCheckVo tunnelIniSupporPQCheck;
    @ApiModelProperty("二次衬砌质量检查")
    private TunnelProgressQualityCheckVo tunnelSecondaryLiningPQCheck;


}
