package com.cmct.ysq.model.bo;

import com.cmct.ysq.model.po.TunnelCheckItemPO;
import com.cmct.ysq.model.po.TunnelInspectionReportPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("检测记录表")
public class TunnelInspectionReportBO   {
    private TunnelInspectionReportPO tunnelInspectionReportPO;
    @ApiModelProperty("添加检查项")
    private List<TunnelCheckItemPO> tunnelCheckItemPOS;
    private String tunnelProId;
    @ApiModelProperty("隧道名称")
    private String tunnelName;
}
