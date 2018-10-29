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
public class SysParamForUpdateBo extends BaseModelBo {

    @ApiModelProperty("参数名")
    private String paramName;
    @ApiModelProperty("参数代码")
    private String paramCode;
    @ApiModelProperty("顺序")
    private Integer paramOrder;
}
