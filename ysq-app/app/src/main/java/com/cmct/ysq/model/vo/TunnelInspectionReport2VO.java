package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TunnelInspectionReport2VO {
    @ApiModelProperty("隧道id")
    private String inspectionReportId;
    @ApiModelProperty("隧道名称")
    private String   tunnelName;
    @ApiModelProperty("隧道方向")
    private Long direction;
    @ApiModelProperty("洞口(0左洞 1右洞)")
    private Long hole;
    @ApiModelProperty("检查时间")
    private Date checkTime;
    @ApiModelProperty("检查部位")
    private Long checkArea;
    @ApiModelProperty("检查项目")
    private String checkItem;
    @ApiModelProperty("菜单")
    private Node node;
}
