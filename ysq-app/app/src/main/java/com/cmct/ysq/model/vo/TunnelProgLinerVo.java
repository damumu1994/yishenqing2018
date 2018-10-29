package com.cmct.ysq.model.vo;

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
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("施工进度-二衬的详细数据历史纪录，其他字段说明请参照修改接口")
public class TunnelProgLinerVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("二衬的详细数据id")
    private String progLinerId;
    @ApiModelProperty("所属的进度记录id,将来删除")
    private String prgRecordId;
    /**
     * 二衬起始桩号,单位cm
     */
    private BigDecimal facePegNoStart;
    /**
     * 二衬结束桩号,单位cm
     */
    private BigDecimal facePegNoEnd;

}
