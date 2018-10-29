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
public class TunnelTransVo extends BaseVo {
    @ApiModelProperty("项目名")
    private String projectName;
    @ApiModelProperty("隧道id")
    private String tunnelProId;
    @ApiModelProperty("隧道名")
    private String tunnelName;
    @ApiModelProperty("方向")
    private String paramName;
    @ApiModelProperty("洞口")
    private String paramName2;
    @ApiModelProperty("监测项目")
    private String trans;
}
