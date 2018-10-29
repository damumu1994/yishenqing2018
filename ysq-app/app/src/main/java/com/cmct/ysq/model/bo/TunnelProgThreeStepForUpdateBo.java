package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 施工进度-三台阶法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgThreeStepForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("上台阶起始桩号,单位cm")
    private BigDecimal upStepPegNoStart;
    @ApiModelProperty("上台阶结束桩号,单位cm")
    private BigDecimal upStepPegNoEnd;
    @ApiModelProperty("中台阶起始桩号,单位cm")
    private BigDecimal middleStepPegNoStart;
    @ApiModelProperty("中台阶结束桩号,单位cm")
    private BigDecimal middleStepPegNoEnd;
    @ApiModelProperty("下台阶起始桩号,单位cm")
    private BigDecimal downStepPegNoStart;
    @ApiModelProperty("下台阶结束桩号,单位cm")
    private BigDecimal downStepPegNoEnd;
    @ApiModelProperty("上台阶累计长度,单位cm")
    private BigDecimal upAccumulationLength;
    @ApiModelProperty("中台阶累计长度,单位cm")
    private BigDecimal middleAccumulationLength;
    @ApiModelProperty("下台阶累计长度,单位cm")
    private BigDecimal downAccumulationLength;
    @ApiModelProperty("仰拱隧底起始桩号,单位cm")
    private BigDecimal bottomPegNoStart;
    @ApiModelProperty("仰拱隧底结束桩号,单位cm")
    private BigDecimal bottomPegNoEnd;
    @ApiModelProperty("仰拱隧底累计长度,单位cm")
    private BigDecimal bottomAccumulationLength;
    @ApiModelProperty("二衬累计长度,单位cm")
    private BigDecimal linerAccumulationLength;

}
