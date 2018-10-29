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
 * @date 2018-07-25 08:04:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("地表沉降具体采集数据，其他字段参照修改接口")
public class TunnelSurfaceDownVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地表沉降id")
    private String surfaceDownId;
    /**
     * 测点号
     */
    private Integer order;
    /**
     * 基点号
     */
    private String baseNo;
    /**
     * 转点与基点高差
     */
    private BigDecimal turnBaseValue;
    /**
     * 测点与转点高差
     */
    private BigDecimal testTurnValue;
    /**
     * 测点与基点高差
     */
    private BigDecimal testBaseValue;
    /**
     * 与第一次差值
     */
    private BigDecimal compareFirstValue;
    /**
     * 破坏,0没有破坏，1破坏
     */
    private Integer destroy;
    /**
     * 修复,0修复，1没有修复
     */
    private Integer repaire;

}
