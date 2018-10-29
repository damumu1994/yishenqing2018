package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysParamsBo extends BaseModelBo {

    @ApiModelProperty("id")
    private String paramId;
    @ApiModelProperty("参数名")
    private String paramName;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("参数代码")
    private String paramCode;
}
