package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("施工进度历史记录")
public class TunnelConstructProgHisVo implements Serializable {

    @ApiModelProperty("施工方法")
    private Integer method;
    @ApiModelProperty("cd法")
    private TunnelProgCdVo progCd;
    @ApiModelProperty("二台阶法")
    private TunnelProgTwoStepVo progTwoStep;
    @ApiModelProperty("三台阶法")
    private TunnelProgThreeStepVo progThreeStep;
    @ApiModelProperty("双层壁导坑法")
    private TunnelProgPitVo progPitVo;
    @ApiModelProperty("二衬")
    private List<TunnelProgLinerVo> progLiners;
    @ApiModelProperty("全断面法历史纪录")
    private TunnelProgFullFaceVo progFullFace;
}
