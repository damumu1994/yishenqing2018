package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelMonitorItemDataUploadBo implements Serializable {

    @ApiModelProperty("記錄")
    private TunnelRecordForAddBo recordForAdd;
    @ApiModelProperty("修改掌子面")
    private TunnelFaceForUpdateBo faceForUpdate;
    @ApiModelProperty("修改地表沉降")
    private List<TunnelSurfaceDownForUpdateBo> surfaceDownForUpdates;
    @ApiModelProperty("周边收敛")
    private List<TunnelSurrConForUpdateBo> surrConForUpdates;
    @ApiModelProperty("修改隧道拱顶下沉")
    private List<TunnelHoleArcDownForUpdateBo> holeArcDownForUpdates;
    @ApiModelProperty("修改钢支撑内力")
    private List<TunnelSteelInternalForceForUpdateBo> steelInternalForceForUpdates;
    @ApiModelProperty("修改围岩与初期支护接触压力")
    private List<TunnelSurrRockInitialPressureForUpdateBo> surrRockInitialPressureForUpdates;
    @ApiModelProperty("修改初期支护内部应力")
    private List<TunnelInternalStressIniSupportForUpdateBo> internalStressIniSupportForUpdates;
    @ApiModelProperty("修改初期支护与二次衬砌接触压力")
    private List<TunnelIniSupportTwoPressureForUpdateBo> iniSupportTwoPressureForUpdates;
    @ApiModelProperty("修改二次衬砌内部应力")
    private List<TunnelInternalTwoStressForUpdateBo> internalTwoStressForUpdates;
    @ApiModelProperty("修改锚杆轴力")
    private List<TunnelAxialBoltForceForUpdateBo> axialBoltForceForUpdates;
    @ApiModelProperty("修改围岩内部位移")
    private List<TunnelInternalSurrRockDisplacementForUpdateBo> internalSurrRockDisplacementForUpdates;


}
