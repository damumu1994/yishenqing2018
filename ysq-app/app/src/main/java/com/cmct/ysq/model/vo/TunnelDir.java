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
@ApiModel("隧道和方向的关系")
public class TunnelDir {
    @ApiModelProperty("主键id")
    private String tunnelDirId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("方向id")
    private String dirId;

}
