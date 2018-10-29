package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("施工进度基本信息")
public class TunnelProgressBaseVo {

    @ApiModelProperty("施工进度id")
    private String constructProgressId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("方向id")
    private String tunnelDirId;
    @ApiModelProperty("洞口id")
    private String tunnelHoleId;
    @ApiModelProperty("隧道名")
    private String tunnelName;
    @ApiModelProperty("方向名")
    private String dirName;
    @ApiModelProperty("洞名")
    private String holdName;
    @ApiModelProperty("记录时间")
    private Long createDate;
    @ApiModelProperty("施工方法：0,全面断法，1，二台阶法，2，三台阶法，3，CD法，4，双层壁导坑法")
    private Integer method;
}
