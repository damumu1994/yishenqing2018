package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * @author shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("断面信息")
public class TunnelCrossSectionVo {

    @ApiModelProperty("断面id")
    private String crossSectionId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("隧道名")
    private String tunnelName;
    @ApiModelProperty("桩号")
    private BigDecimal peg;
    @ApiModelProperty("埋设时间")
    private Date burialTime;
    @ApiModelProperty("方向id")
    private String dirId;
    @ApiModelProperty("方向名")
    private String dirName;
    @ApiModelProperty("洞口id")
    private String tunnelHole;
    @ApiModelProperty("洞口名")
    private String tunnelHoleName;
    @ApiModelProperty("施工方法")
    private Integer method;
    @ApiModelProperty("围岩级别")
    private String level;
    @ApiModelProperty("监测项目id")
    private String monitorType;
    @ApiModelProperty("监测项目名")
    private String monitorTypeName;
    @ApiModelProperty("预留变形值")
    private BigDecimal deformedDeformationValue;
    @ApiModelProperty("允许值")
    private BigDecimal permissibleValue;
    @ApiModelProperty("弹性模量")
    private BigDecimal elasticityModulus;

}
