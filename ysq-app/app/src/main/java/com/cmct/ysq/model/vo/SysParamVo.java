package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysParamVo {
    @ApiModelProperty("主键id")
    private String paramId;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("参数方法名")
    private String paramName;
    @ApiModelProperty("参数名")
    private String title;
    @ApiModelProperty("参数代码")
    private String paramCode;
    @ApiModelProperty("顺序")
    private Integer paramOrder;
    @ApiModelProperty("父亲参数名")
    private String parentParamName;

    private List<SysParamVo> children;

}
