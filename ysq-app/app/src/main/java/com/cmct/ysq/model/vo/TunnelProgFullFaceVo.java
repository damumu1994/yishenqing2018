package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
@ApiModel(" 施工进度-全断面法历史纪录，其他字段说明参照修改接口")
public class TunnelProgFullFaceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("全断面法id")
    private String tunnelProgFullFace;
    @ApiModelProperty("施工进度id,将来删除")
    private String consProgId;
    /**
     * 掌子面起始桩号,单位cm
     */
    private BigDecimal facePegNoStart;
    /**
     * 掌子面结束桩号,单位cm
     */
    private BigDecimal facePegNoEnd;
    /**
     * 掌子面累计长度,单位cm
     */
    private BigDecimal faceAccumulaLength;
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
    @Column
    @ApiModelProperty("记录时间")
    private Date createDate;
    @ApiModelProperty("记录人")
    private String createBy;
    @ApiModelProperty("记录人账号")
    private String createByAccount;

}
