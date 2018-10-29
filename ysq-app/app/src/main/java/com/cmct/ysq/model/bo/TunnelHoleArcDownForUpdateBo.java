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
 * @date 2018-07-25 08:05:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("修改隧道拱顶下沉")
public class TunnelHoleArcDownForUpdateBo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private String holeArcDownId;
    @ApiModelProperty("监测项目记录id")
    private String recordId;
    @ApiModelProperty("测点")
    private String testPointName;
    @ApiModelProperty("测点编码")
    private String testPointCode;
    @ApiModelProperty("基点名称")
    private String basePointName;
    @ApiModelProperty("测点与基点高差(mm)")
    private BigDecimal height;
    @ApiModelProperty("与第一次差值(mm)")
    private BigDecimal firstValueSub;
    @ApiModelProperty("破坏,0没有破坏，1破坏")
    private Integer destroy;
    @ApiModelProperty("修复,0修复，1没有修复")
    private Integer repaire;
}
