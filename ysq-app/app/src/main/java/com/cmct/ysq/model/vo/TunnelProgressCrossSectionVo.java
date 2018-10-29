package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgressCrossSectionVo {

    @ApiModelProperty("地表沉降剩余数量")
    private Integer surfaceDownLeftCount;
    @ApiModelProperty("地表沉降")
    private List<BigDecimal> surfaceDowns;
    @ApiModelProperty("周边位移")
    private List<BigDecimal> surrCons;
    @ApiModelProperty("拱顶下沉/拱顶沉降")
    private List<BigDecimal> holeArcDowns;
    @ApiModelProperty("选测项目")
    private List<BigDecimal> options;
    @ApiModelProperty("选测项目剩余数量")
    private Integer optionsLeftCount;
}
