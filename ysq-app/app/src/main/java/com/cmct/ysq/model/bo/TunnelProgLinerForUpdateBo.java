package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 施工进度-二衬的详细数据
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgLinerForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("二衬起始桩号,单位cm")
    private BigDecimal facePegNoStart;
    @ApiModelProperty("二衬结束桩号,单位cm")
    private BigDecimal facePegNoEnd;


}
