package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取已有的边坡类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlopeTypeVo {

    @ApiModelProperty("项目id")
    private String projectId;
    @ApiModelProperty("项目名")
    private String projectName;
    @ApiModelProperty("边坡名称")
    private String slopeName;
    @ApiModelProperty("边坡类型")
    private String slopeType;
    @ApiModelProperty("路面数量")
    private Integer slopeNumber;

}
