package com.cmct.ysq.model.bo;


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
@ApiModel("修改施工进度")
public class ConstructProgForUpdateBo {

    @ApiModelProperty("修改施工进度-CD法")
    private TunnelProgCdForUpdateBo progCdForUpdate;
    @ApiModelProperty("修改施工进度-全断面法")
    private TunnelProgFullFaceForUpdateBo progFullFaceForUpdate;
    @ApiModelProperty("修改施工进度-二衬的详细数据")
    private List<TunnelProgLinerForUpdateBo> progLinerForUpdates;
    @ApiModelProperty("修改施工进度-双层壁导坑法")
    private TunnelProgPitForUpdateBo progPitForUpdate;
    @ApiModelProperty("修改施工进度-三台阶法")
    private TunnelProgThreeStepForUpdateBo progThreeStepForUpdate;
    @ApiModelProperty("修改施工进度-二台阶法")
    private TunnelProgTwoStepForUpdateBo progTwoStepForUpdateBo;
}
