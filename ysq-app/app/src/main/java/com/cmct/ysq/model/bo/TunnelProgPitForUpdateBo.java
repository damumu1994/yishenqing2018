package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 施工进度-双层壁导坑法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgPitForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("左侧壁1起始桩号,单位cm")
    private BigDecimal leftWallOnePegNoStart;
    @ApiModelProperty("左侧壁1结束桩号,单位cm")
    private BigDecimal leftWallOnePegNoEnd;
    @ApiModelProperty("侧壁2起始桩号,单位cm")
    private BigDecimal leftWallTwoPegNoStart;
    @ApiModelProperty("左侧壁2结束桩号,单位cm")
    private BigDecimal leftWallTwoPegNoEnd;
    @ApiModelProperty("侧壁3起始桩号,单位cm")
    private BigDecimal rightWallThreePegNoStart;
    @ApiModelProperty("右侧壁3结束桩号,单位cm")
    private BigDecimal rightWallThreePegNoEnd;
    @ApiModelProperty("右侧壁4起始桩号,单位cm")
    private BigDecimal rightWallFourPegNoStart;
    @ApiModelProperty("右侧壁4结束桩号,单位cm")
    private BigDecimal rightWallFourPegNoEnd;
    @ApiModelProperty("中间部5起始桩号,单位cm")
    private BigDecimal middleWallFivePegNoStart;
    @ApiModelProperty("中间部5结束桩号,单位cm")
    private BigDecimal middleWallFivePegNoEnd;
    @ApiModelProperty("中间部6起始桩号,单位cm")
    private BigDecimal middleWallSixPegNoStart;
    @ApiModelProperty("中间部6结束桩号,单位cm")
    private BigDecimal middleWallSixPegNoEnd;
    @ApiModelProperty("左侧壁1累计长度,单位cm")
    private BigDecimal leftWallOneAccumulationLength;
    @ApiModelProperty("左侧壁2累计长度,单位cm")
    private BigDecimal leftWallTwoAccumulationLength;
    @ApiModelProperty("右侧壁3累计长度,单位cm")
    private BigDecimal rightWallThreeAccumulationLength;
    @ApiModelProperty("右侧壁4累计长度,单位cm")
    private BigDecimal rightWallFourAccumulationLength;
    @ApiModelProperty("中间部5累计长度,单位cm")
    private BigDecimal middleWallFiveAccumulationLength;
    @ApiModelProperty("中间部6累计长度,单位cm")
    private BigDecimal middleWallSixAccumulationLength;
    @ApiModelProperty("仰拱隧底起始桩号,单位cm")
    private BigDecimal bottomPegNoStart;
    @ApiModelProperty("仰拱隧底结束桩号,单位cm")
    private BigDecimal bottomPegNoEnd;
    @ApiModelProperty("仰拱隧底累计长度,单位cm")
    private BigDecimal bottomAccumulationLength;
    @ApiModelProperty("二衬累计长度,单位cm")
    private BigDecimal linerAccumulationLength;

}
