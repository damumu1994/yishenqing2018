package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("最新监测监测项目信息")
public class TunnelMonitorItemNeweastInfoVo {


    @ApiModelProperty("多媒体")
    private List<FileVo> files;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("录入时间")
    private Date createDate;
    @ApiModelProperty("录入userId")
    private String createBy;
    @ApiModelProperty("录入账号")
    private String account;
    @ApiModelProperty("温度")
    private BigDecimal temprature;
    @ApiModelProperty("量测次数")
    private Integer count;
    @ApiModelProperty("与掌子面距离")
    private BigDecimal faceDistance;

    @ApiModelProperty("掌子面详情")
    private List<TunnelFaceVo> tunnelFaces;
    @ApiModelProperty("地表沉降详情")
    private List<TunnelSurfaceDownVo> tunnelSurfaceDownss;
    @ApiModelProperty("周边收敛详情")
    private List<TunnelSurrConVo> tunnelSurrCons;
    @ApiModelProperty("隧道拱顶下沉详情")
    private List<TunnelHoleArcDownVo> tunnelHoleArcDowns;
    @ApiModelProperty("钢支撑内力详情")
    private List<TunnelSteelInternalForceVo> tunnelSteelInternalForces;
    @ApiModelProperty("围岩与初期支护接触压力详情")
    private List<TunnelSurrRockInitialPressureVo> tunnelSurrRockInitialPressures;
    @ApiModelProperty("初期支护内部应力详情")
    private List<TunnelInternalStressIniSupportVo> tunnelInternalStressIniSupports;
    @ApiModelProperty("初期支护与二次衬砌接触压力详情")
    private List<TunnelIniSupportTwoPressureVo> tunnelIniSupportTwoPressures;
    @ApiModelProperty("二次衬砌内部应力详情")
    private List<TunnelInternalTwoStressVo> tunnelInternalTwoStresss;
    @ApiModelProperty("锚杆轴力详情")
    private List<TunnelAxialBoltForceVo> tunnelAxialBoltForces;
    @ApiModelProperty("围岩内部位移详情")
    private List<TunnelInternalSurrRockDisplacementVo> tunnelInternalSurrRockDisplacements;


}
