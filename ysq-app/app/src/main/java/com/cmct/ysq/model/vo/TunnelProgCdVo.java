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
 * @date 2018-07-24 07:17:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("施工进度-cd历史纪录，字段说明参照修改接口")
public class TunnelProgCdVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("施工进度-CD法id")
    private String tunnelProgCdId;
    @ApiModelProperty("施工进度id,将来删除")
    private String prgId;
    /**
     * 左侧壁1起始桩号,单位cm
     */
    private BigDecimal leftWallOnePegNoStart;
    /**
     * 左侧壁1结束桩号,单位cm
     */
    private BigDecimal leftWallOnePegNoEnd;
    /**
     * 左侧壁2起始桩号,单位cm
     */
    private BigDecimal leftWallTwoPegNoStart;
    /**
     * 左侧壁2结束桩号,单位cm
     */
    private BigDecimal leftWallTwoPegNoEnd;
    /**
     * 左侧壁3起始桩号,单位cm
     */
    private BigDecimal leftWallThreePegNoStart;
    /**
     * 左侧壁3结束桩号,单位cm
     */
    private BigDecimal leftWallThreePegNoEnd;
    /**
     * 右侧壁1起始桩号,单位cm
     */
    private BigDecimal rightWallOnePegNoStart;
    /**
     * 侧壁1结束桩号,单位cm
     */
    private BigDecimal rightWallOnePegNoEnd;
    /**
     * 右侧壁2起始桩号,单位cm
     */
    private BigDecimal rightWallTwoPegNoStart;
    /**
     * 右侧壁2结束桩号,单位cm
     */
    private BigDecimal rightWallTwoPegNoEnd;
    /**
     * 右侧壁3起始桩号,单位cm
     */
    private BigDecimal rightWallThreePegNoStart;
    /**
     * 右侧壁3结束桩号,单位cm
     */
    private BigDecimal rightWallThreePegNoEnd;
    /**
     * 左侧壁1累计长度,单位cm
     */
    private BigDecimal leftWallOneAccumulationLength;
    /**
     * 左侧壁2累计长度,单位cm
     */
    private BigDecimal leftWallTwoAccumulationLength;
    /**
     * 左侧壁3累计长度,单位cm
     */
    private BigDecimal leftWallThreeAccumulationLength;
    /**
     * 右侧壁1累计长度,单位cm
     */
    private BigDecimal rightWallOneAccumulationLength;
    /**
     * 右侧壁2累计长度,单位cm
     */
    private BigDecimal rightWallTwoAccumulationLength;
    /**
     * 右侧壁3累计长度,单位cm
     */
    private BigDecimal rightWallThreeAccumulationLength;
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
    @ApiModelProperty("记录人id")
    private String createBy;
    @ApiModelProperty("记录人账号")
    private String createByAccount;
    @ApiModelProperty("记录时间")
    private Date createDate;

}
