package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TunnelInspectionReportVO /*extends TunnelInspectionReportPO*/ {
    @ApiModelProperty("检查项id")
    private String inspectionReportId;
    @ApiModelProperty("隧道名称")
    private String   tunnelName;
    @ApiModelProperty("检查结果")
    private String checkResult;
    @ApiModelProperty("结论")
    private String checkConclusion;
    @ApiModelProperty("备注")
    private String remake;
    @ApiModelProperty("检查项id")
    private String checkItemId;
    @ApiModelProperty("检查时间")
    private Date checkTime;
    @ApiModelProperty("起始桩号")
   private String startPileNo;
    @ApiModelProperty("结束桩号")
    private String endPileNo;
    @ApiModelProperty("检查部位")
    private String checkAreaName;
    @ApiModelProperty("检查项")
    private String checkProjectName;
    @ApiModelProperty("洞口")
    private String holeName;
    @ApiModelProperty("方向")
    private String directionName;

}
