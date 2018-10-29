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
@ApiModel("施工进度-双层壁导坑法历史纪录，其他字段请参照修改接口")
public class TunnelProgPitVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("施工进度-双层壁导坑法id")
    private String prgPitId;
    @ApiModelProperty("施工进度id，供调试")
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
     * 右侧壁3起始桩号,单位cm
     */
    private BigDecimal rightWallThreePegNoStart;
    /**
     * 右侧壁3结束桩号,单位cm
     */
    private BigDecimal rightWallThreePegNoEnd;
    /**
     * 右侧壁4起始桩号,单位cm
     */
    private BigDecimal rightWallFourPegNoStart;
    /**
     * 右侧壁4结束桩号,单位cm
     */
    private BigDecimal rightWallFourPegNoEnd;
    /**
     * 中间部5起始桩号,单位cm
     */
    private BigDecimal middleWallFivePegNoStart;
    /**
     * 中间部5结束桩号,单位cm
     */
    private BigDecimal middleWallFivePegNoEnd;
    /**
     * 中间部6起始桩号,单位cm
     */
    private BigDecimal middleWallSixPegNoStart;
    /**
     * 中间部6结束桩号,单位cm
     */
    private BigDecimal middleWallSixPegNoEnd;
    /**
     * 左侧壁1累计长度,单位cm
     */
    private BigDecimal leftWallOneAccumulationLength;
    /**
     * 左侧壁2累计长度,单位cm
     */
    private BigDecimal leftWallTwoAccumulationLength;
    /**
     * 右侧壁3累计长度,单位cm
     */
    private BigDecimal rightWallThreeAccumulationLength;
    /**
     * 右侧壁4累计长度,单位cm
     */
    private BigDecimal rightWallFourAccumulationLength;
    /**
     * 中间部5累计长度,单位cm
     */
    private BigDecimal middleWallFiveAccumulationLength;
    /**
     * 中间部6累计长度,单位cm
     */
    private BigDecimal middleWallSixAccumulationLength;
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
    @ApiModelProperty("创建人账号")
    private String createByAccount;
    @ApiModelProperty("记录时间")
    private Date createDate;

}
