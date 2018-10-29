package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 10:00:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("检测记录")
public class TunnelRecordForAddBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String recordId;
    @ApiModelProperty("桩号")
    private BigDecimal peg;
    @ApiModelProperty("监测项目id")
    private String monitorId;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("温度")
    private BigDecimal temprature;
    @ApiModelProperty("掌子面距离")
    private BigDecimal faceDistance;

}
