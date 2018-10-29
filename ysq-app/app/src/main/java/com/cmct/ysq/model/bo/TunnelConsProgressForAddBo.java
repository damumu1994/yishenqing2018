package com.cmct.ysq.model.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 隧道施工进度
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 06:08:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("新增施工进度数据")
public class TunnelConsProgressForAddBo {

    @ApiModelProperty("app上传的施工进度id")
    private String constructProgressId;
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("隧道方向id")
    private String tunnelDirId;
    @ApiModelProperty("隧道洞口id")
    private String tunnelHoleId;
    @ApiModelProperty("施工方法：0,全面断法，1，二台阶法，2，三台阶法，3，CD法，4，双层壁导坑法")
    private Integer method;
    @ApiModelProperty("新增施工进度-CD法")
    private TunnelProgCdForUpdateBo progCdForUpdate;
    @ApiModelProperty("新增施工进度-全断面法")
    private TunnelProgFullFaceForUpdateBo progFullFaceForUpdate;
    @ApiModelProperty("新增施工进度-二衬的详细数据")
    private List<TunnelProgLinerForUpdateBo> progLinerForUpdates;
    @ApiModelProperty("新增施工进度-双层壁导坑法")
    private TunnelProgPitForUpdateBo progPitForUpdate;
    @ApiModelProperty("新增施工进度-三台阶法")
    private TunnelProgThreeStepForUpdateBo progThreeStepForUpdate;
    @ApiModelProperty("新增施工进度-二台阶法")
    private TunnelProgTwoStepForUpdateBo progTwoStepForUpdateBo;

}
