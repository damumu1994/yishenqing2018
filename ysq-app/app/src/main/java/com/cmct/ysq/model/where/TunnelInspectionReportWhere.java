package com.cmct.ysq.model.where;


import com.cmct.common.bean.BaseWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TunnelInspectionReportWhere extends BaseWhere {
    @ApiModelProperty("起始桩号")
    private String startPileNo;
    @ApiModelProperty("结束桩号")
    private String endPileNo;
    @ApiModelProperty("检查部位")
    private String checkArea;
    @ApiModelProperty("检查项")
    private String checkProject;
    @ApiModelProperty("是否只查看异常信息  1 0")
    private String checkConclusion;
    @ApiModelProperty("方向")
    private String direction;
    @ApiModelProperty("洞别")
    private String hole;
    @ApiModelProperty("隧道id")
    private String tunnelId;
}
