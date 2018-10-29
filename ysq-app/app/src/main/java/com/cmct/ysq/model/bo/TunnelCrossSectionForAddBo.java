package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 隧道施工进度
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 06:08:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("新增施工进度数据")
public class TunnelCrossSectionForAddBo {

    @ApiModelProperty("断面id，app生成")
    private String monitorId;
    @ApiModelProperty("隧道")
    private String tunnelId;
    @ApiModelProperty("洞口")
    private String tunnelHole;
    @ApiModelProperty("桩号")
    private BigDecimal peg;
    @ApiModelProperty("监测项目")
    private String monitorType;
    @ApiModelProperty("埋设时间")
    private Date burialTime;
    @ApiModelProperty("设计埋深")
    private BigDecimal burialDepth;
    @ApiModelProperty("施工方法")
    private String method;
    @ApiModelProperty("围岩级别")
    private String level;
    @ApiModelProperty("预留变形值")
    private BigDecimal deformedDeformationValue;
    @ApiModelProperty("允许值")
    private BigDecimal permissibleValue;
    @ApiModelProperty("弹性模量")
    private BigDecimal elasticityModulus;

}
