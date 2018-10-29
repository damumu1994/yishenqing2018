package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:04:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("修改地表沉降")
public class TunnelSurfaceDownForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty("地表沉降")
    private String surfaceDownId;
    @ApiModelProperty("监测项目记录id")
    private String recordId;
    @ApiModelProperty("测点号")
    private Integer order;
    @ApiModelProperty("基点号")
    private String baseNo;
    @ApiModelProperty("转点与基点高差")
    private BigDecimal turnBaseValue;
    @ApiModelProperty("测点与转点高差")
    private BigDecimal testTurnValue;
    @ApiModelProperty("测点与基点高差")
    private BigDecimal testBaseValue;
    @ApiModelProperty("与第一次差值")
    private BigDecimal compareFirstValue;
    @ApiModelProperty("破坏,0没有破坏，1破坏")
    private Integer destroy;
    @ApiModelProperty("修复,0修复，1没有修复")
    private Integer repaire;

}
