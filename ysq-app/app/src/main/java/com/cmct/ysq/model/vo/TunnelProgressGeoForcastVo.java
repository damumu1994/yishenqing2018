package com.cmct.ysq.model.vo;

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
public class TunnelProgressGeoForcastVo {

    private String id;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
    @ApiModelProperty("预报方法id")
    private String methodId;
    private String methodName;
    @ApiModelProperty("预报围岩级别id")
    private String levelId;
    private String levelName;
}
