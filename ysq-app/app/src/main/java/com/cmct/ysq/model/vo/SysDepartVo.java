package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shen
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysDepartVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Id")
    private String departId;
    @ApiModelProperty("部门名称")
    private String departName;
    @ApiModelProperty("描述")
    private String departDescr;
    @ApiModelProperty("父部门")
    private String parentId;
    @ApiModelProperty("创建人")
    private String createBy;
    @ApiModelProperty("修改人")
    private String modifyBy;
    @ApiModelProperty("部门类型id")
    private String typeId;
    @ApiModelProperty("部门类型名称")
    private String typeName;
    @ApiModelProperty("创建时间")
    private Date createDate;
    @ApiModelProperty("修改时间")
    private Date modifyDate;
    @ApiModelProperty("顺序")
    private Integer paramOrder;

}
