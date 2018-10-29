package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 版本查询条件
 *
 * @author losing
 * @Date 2016年9月16日
 * @since v0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("查询")
public class SysVersionQueryBo extends BaseModelBo {

    @ApiModelProperty("版本名")
    private String versionName;

    @ApiModelProperty("0是pad，1是手机查看")
    private Integer type;

}
