package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * @author shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("监测项目基本信息")
public class TunnelMonitorItemBaseVo {

    @ApiModelProperty("监测项目记录id")
    private String monitorItemRecordId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("方向id")
    private String tunnelDirId;
    @ApiModelProperty("洞口id")
    private String tunnelHoleId;
    @ApiModelProperty("隧道名")
    private String tunnelName;
    @ApiModelProperty("方向名")
    private String dirName;
    @ApiModelProperty("洞名")
    private String holdName;
    @ApiModelProperty("记录时间")
    private Long createDate;
    @ApiModelProperty("监测项目")
    private String monitorItemId;
    @ApiModelProperty("监测项目名")
    private String monitorItemName;
    @ApiModelProperty("监测项目编码")
    private String monitorItemCode;
    @ApiModelProperty("桩号")
    private BigDecimal peg;
}
