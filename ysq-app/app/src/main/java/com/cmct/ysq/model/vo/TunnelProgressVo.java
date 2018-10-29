package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProgressVo {
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("隧道名称")
    private String tunnelName;
    @ApiModelProperty("洞口类别id")
    private String holeId;
    private String holeName;
    @ApiModelProperty("隧道围岩信息")
    private List<TunnelSurInfoVo> tunnelSurInfos;
    @ApiModelProperty("进度图详情数据")
    private List<TunnelProgressDetailVo> tunnelProgressDetails;
}
