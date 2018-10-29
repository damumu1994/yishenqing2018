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
 * @date 2018-07-24 07:17:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("修改施工进度-CD法")
public class TunnelProgCdForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty("左侧壁1起始桩号,单位cm")
    private BigDecimal leftWallOnePegNoStart;
    @ApiModelProperty("左侧壁1结束桩号,单位cm")
    private BigDecimal leftWallOnePegNoEnd;
    @ApiModelProperty("左侧壁2起始桩号,单位cm")
    private BigDecimal leftWallTwoPegNoStart;
    @ApiModelProperty("左侧壁2结束桩号,单位cm")
    private BigDecimal leftWallTwoPegNoEnd;
    @ApiModelProperty("左侧壁3起始桩号,单位cm")
    private BigDecimal leftWallThreePegNoStart;
    @ApiModelProperty("左侧壁3结束桩号,单位cm")
    private BigDecimal leftWallThreePegNoEnd;
    @ApiModelProperty("右侧壁1起始桩号,单位cm")
    private BigDecimal rightWallOnePegNoStart;
    @ApiModelProperty("侧壁1结束桩号,单位cm")
    private BigDecimal rightWallOnePegNoEnd;
    @ApiModelProperty("右侧壁2起始桩号,单位cm")
    private BigDecimal rightWallTwoPegNoStart;
    @ApiModelProperty("右侧壁2结束桩号,单位cm")
    private BigDecimal rightWallTwoPegNoEnd;
    @ApiModelProperty("右侧壁3起始桩号,单位cm")
    private BigDecimal rightWallThreePegNoStart;
    @ApiModelProperty("右侧壁3结束桩号,单位cm")
    private BigDecimal rightWallThreePegNoEnd;
    @ApiModelProperty("左侧壁1累计长度,单位cm")
    private BigDecimal leftWallOneAccumulationLength;
    @ApiModelProperty("左侧壁2累计长度,单位cm")
    private BigDecimal leftWallTwoAccumulationLength;
    @ApiModelProperty("左侧壁3累计长度,单位cm")
    private BigDecimal leftWallThreeAccumulationLength;
    @ApiModelProperty("右侧壁1累计长度,单位cm")
    private BigDecimal rightWallOneAccumulationLength;
    @ApiModelProperty("右侧壁2累计长度,单位cm")
    private BigDecimal rightWallTwoAccumulationLength;
    @ApiModelProperty("右侧壁3累计长度,单位cm")
    private BigDecimal rightWallThreeAccumulationLength;
    @ApiModelProperty("仰拱隧底起始桩号,单位cm")
    private BigDecimal bottomPegNoStart;
    @ApiModelProperty("仰拱隧底结束桩号,单位cm")
    private BigDecimal bottomPegNoEnd;
    @ApiModelProperty("仰拱隧底累计长度,单位cm")
    private BigDecimal bottomAccumulationLength;
    @ApiModelProperty("二衬累计长度,单位cm")
    private BigDecimal linerAccumulationLength;


}
