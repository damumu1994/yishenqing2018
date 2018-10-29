package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelReporterVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("报告模板主键")
    private String reporterId;
    @ApiModelProperty("报告模板请求地址")
    private String url;
    @ApiModelProperty("报告模板名称")
    private String fileName;
    @ApiModelProperty("报告模板描述")
    private String des;
    @ApiModelProperty("类型,0,日报1,周报,2月报,3地质预报,4质量检查报告")
    private Integer type;
    @ApiModelProperty("部门名")
    private String departId;
    @ApiModelProperty("部门名")
    private String departName;


}
