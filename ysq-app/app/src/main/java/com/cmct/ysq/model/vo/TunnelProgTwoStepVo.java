package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("施工进度-二台阶法，其他字段请参照修改接口")
public class TunnelProgTwoStepVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("施工进度-二台阶法id")
    private String prgTwoStepId;
    @ApiModelProperty("施工进度id，供调试")
    private String prgId;
    /**
     * 上台阶起始桩号,单位cm
     */
    private BigDecimal upStepPegNoStart;
    /**
     * 上台阶结束桩号,单位cm
     */
    private BigDecimal upStepSegNoNd;
    /**
     * 下台阶起始桩号,单位cm
     */
    private BigDecimal downStepPegNoStart;
    /**
     * 下台阶结束桩号,单位cm
     */
    private BigDecimal downStepPegNoEnd;
    /**
     * 上台阶累计长度,单位cm
     */
    private BigDecimal upAccumulationLength;
    /**
     * 下台阶累计长度,单位cm
     */
    private BigDecimal downAccumulationLength;
    /**
     * 仰拱隧底起始桩号,单位cm
     */
    private BigDecimal bottomPegNoStart;
    /**
     * 仰拱隧底结束桩号,单位cm
     */
    private BigDecimal bottomPegNoEnd;
    /**
     * 仰拱隧底累计长度,单位cm
     */
    private BigDecimal bottomAccumulationLength;
    /**
     * 二衬累计长度,单位cm
     */
    private BigDecimal linerAccumulationLength;
    @ApiModelProperty("创建人")
    private String createBy;
    @ApiModelProperty("记录时间")
    private Date createDate;
    @ApiModelProperty("创建人账号")
    private String createByAccount;
}
