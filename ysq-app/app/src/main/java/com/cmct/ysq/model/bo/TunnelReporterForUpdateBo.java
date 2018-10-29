package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelReporterForUpdateBo {

    @ApiModelProperty("报告模板请求地址")
    private String url;
    @ApiModelProperty("报告模板名称")
    private String fileName;
    @ApiModelProperty("报告模板描述")
    private String des;
    @ApiModelProperty("类型,0,日报1,周报,2月报,3地质预报,4质量检查报告")
    private Integer type;
    @ApiModelProperty("部门id")
    private String departId;

}
