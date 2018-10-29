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
/**
 * 项目列表筛选类
 */
public class TunnelProjectBo extends BaseModelBo {
    public static String PARAMS_TYPE_TUNNEL = "1";
    @ApiModelProperty("隧道名称")
    private String tunnelName;
    private String sectionName;
    @ApiModelProperty("项目名")
    private String projectId;
    public static String PARAMS_TYPE_PROJECT = "2";
    @ApiModelProperty(value = "参数类型 1 隧道参数 2项目参数", required = true)
    private String paramType;
}
