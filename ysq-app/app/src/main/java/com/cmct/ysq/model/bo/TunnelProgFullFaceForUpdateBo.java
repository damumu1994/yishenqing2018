package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 施工进度-全断面法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgFullFaceForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("掌子面起始桩号,单位cm")
    private BigDecimal facePegNoStart;
    @ApiModelProperty("掌子面结束桩号,单位cm")
    private BigDecimal facePegNoEnd;
    @ApiModelProperty("掌子面累计长度,单位cm")
    private BigDecimal faceAccumulaLength;
    @ApiModelProperty("仰拱隧底起始桩号,单位cm")
    private BigDecimal bottomPegNoStart;
    @ApiModelProperty("仰拱隧底结束桩号,单位cm")
    private BigDecimal bottomPegNoEnd;
    @ApiModelProperty("仰拱隧底累计长度,单位cm")
    private BigDecimal bottomAccumulationLength;
    @ApiModelProperty("二衬累计长度,单位cm")
    private BigDecimal linerAccumulationLength;

}
