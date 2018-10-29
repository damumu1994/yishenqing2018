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
public class TunnelMonitorProgressVo {

    @ApiModelProperty("主洞开挖（最新掌子面）")
    private BigDecimal faceDistance;
    @ApiModelProperty("最新仰拱/隧底")
    private BigDecimal invertedArchOrTunnelBottom;
    @ApiModelProperty("最新二次衬砌桩号")
    private BigDecimal facePegNoEnd;
}
