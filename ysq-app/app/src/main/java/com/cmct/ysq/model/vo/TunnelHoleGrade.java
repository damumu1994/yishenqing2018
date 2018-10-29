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
@ApiModel("隧道洞口和围岩级别关系")
public class TunnelHoleGrade {

    @ApiModelProperty("主键id")
    private String holeGradeId;
    @ApiModelProperty("隧道和洞口关系id")
    private String tunnelHoleId;
    @ApiModelProperty("设计围岩级别id")
    private String gradeId;
    @ApiModelProperty("设计围岩级别名称")
    private String gradeName;
    @ApiModelProperty("起始桩号,单位cm")
    private Long pegNoStart;
    @ApiModelProperty("结束桩号,单位cm")
    private Long pegNoEnd;

}
