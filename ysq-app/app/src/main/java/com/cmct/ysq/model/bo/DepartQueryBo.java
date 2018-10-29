package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author shen
 */
@ApiModel("单位查询")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartQueryBo extends BaseModelBo {

    @ApiModelProperty("部门类型")
    private String typeId;
    @ApiModelProperty("部门名称")
    private String departName;
}
