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
@ApiModel("隧道实体")
public class Tunnel {
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("所属施工标段id")
    private String sectionId;
    @ApiModelProperty("隧道名称")
    private String tunnelName;
    @ApiModelProperty("隧道位置")
    private String tunnelLocation;

}
