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
@ApiModel("系统参数表，沿用桥梁的，就是后台配置的一些字典数据，他是把所有的揉在一起的，用paramCode来区分")
public class SysParam {
    @ApiModelProperty("参数ID")
    private String paramId;
    @ApiModelProperty("参数名")
    private String paramName;
    @ApiModelProperty("参数CODE")
    private String paramCode;
    @ApiModelProperty("父参数ID")
    private String parentId;
    @ApiModelProperty("参数状态")
    private String paramStatus;
    @ApiModelProperty("参数顺序号")
    private Integer paramOrder;
}
