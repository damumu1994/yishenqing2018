package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("隧道围岩级别信息")
public class TunnelSurInfoVo {
    @ApiModelProperty("围岩级别")
    private String levelId;
    @ApiModelProperty("围岩级别名")
    private String levelName;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
}
