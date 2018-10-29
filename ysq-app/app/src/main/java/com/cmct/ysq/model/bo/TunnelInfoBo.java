package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TunnelInfoBo extends BaseModelBo {
    private String tunnelProId;
    @ApiModelProperty("隧道名称")
    private String tunnelName;
    private String sectionId;
    @ApiModelProperty("项目id")
    private String projectId;
    @ApiModelProperty("城市id")
    private String cityCode;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("车道数")
    private String laneNum;
    @ApiModelProperty("隧道形式id")
    private String tunnelType;
    @ApiModelProperty("工程地质概括id")
    private String des;
    @ApiModelProperty("施工开始时间")
    private Date beginDate;
    @ApiModelProperty("其他信息")
    private String otherInfo;
    @ApiModelProperty("左洞进口桩号")
    private BigDecimal leftHoleStart;
    @ApiModelProperty("左洞出口桩号")
    private BigDecimal leftHoleEnd;
    @ApiModelProperty("右洞进口桩号")
    private BigDecimal rightHoleStart;
    @ApiModelProperty("右洞出口桩号")
    private BigDecimal rightHoleEnd;
    @ApiModelProperty("洞别,")
    private String holes;
    @ApiModelProperty("隧道方向")
    private  String tunnelDirection;
    //  other
    @ApiModelProperty("建设单位")
    private String construction;
    @ApiModelProperty("施工单位")
    private String consts;
    @ApiModelProperty("施工标段")
    private String constBlocks;
    @ApiModelProperty("监理单位")
    private String supervision;
    @ApiModelProperty("监理标段")
    private String supervisionBlocks;
    @ApiModelProperty("监测单位")
    private String monitor;
    @ApiModelProperty("监测标段")
    private String monitorBlocks;
    //设计单位  其他相关单位
    private String designDep;
    private String otherDep;
   // end other
    private BigDecimal mainHoleStart;
    private BigDecimal mainHoleEnd;
    private BigDecimal guideHoleStart;
    private BigDecimal guideHoleEnd;
    private Long deleteStatus;
    private String createBy;
    private String modifyBy;
    private Date createDate;
    private Date modifyDate;
}
