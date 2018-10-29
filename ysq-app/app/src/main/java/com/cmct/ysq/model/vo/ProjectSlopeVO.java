/**
 * Copyright (c) @2017,cmct 版权所有
 */
package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统计分析 项目边坡
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/6/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectSlopeVO {

    @ApiModelProperty("项目id")
    private String projectId;
    @ApiModelProperty("项目名")
    private String projectName;
    @ApiModelProperty("边坡名")
    private String slopeName;
    @ApiModelProperty("边坡类型")
    private String slopeType;
    @ApiModelProperty("边坡数量")
    private Integer slopeNumber;

}
