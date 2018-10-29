package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shen
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("修改部门")
public class SysDepartForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门名称")
    private String departName;
    @ApiModelProperty("描述")
    private String departDescr;
    @ApiModelProperty("父部门")
    private String parentId;
    @ApiModelProperty("部门类型id")
    private String typeId;
    @ApiModelProperty("顺序")
    private Integer paramOrder;


}
