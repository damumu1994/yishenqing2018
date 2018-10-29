package com.cmct.ysq.model.bo;

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
public class SysParamForAddBo extends BaseModelBo {

    @ApiModelProperty("参数名")
    private String paramName;
    @ApiModelProperty("参数代码")
    private String paramCode;
    @ApiModelProperty("顺序")
    private Integer paramOrder;
    @ApiModelProperty("父节点id")
    private String parentId;
    @ApiModelProperty("子节点")
    private List<SysParamForAddBo> childrens;
    @ApiModelProperty("描述")
    private String des;
}
