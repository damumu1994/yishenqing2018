package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lxb
 * @Date 2018/7/26 09:53
 * 描述:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelTrans2Vo extends BaseVo {
    @ApiModelProperty("隧道id")
    private String tunnelProId;
    @ApiModelProperty("方向")
    private String paramName;
    @ApiModelProperty("洞口")
    private String paramName2;
}
