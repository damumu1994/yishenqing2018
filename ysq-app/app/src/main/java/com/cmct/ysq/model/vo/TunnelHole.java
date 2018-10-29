package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author shen
 * @date 2018/7/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("隧道和洞口的关系")
public class TunnelHole {
    @ApiModelProperty("主键id")
    private String tunnelHoleId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("洞口id")
    private String holeId;
}
