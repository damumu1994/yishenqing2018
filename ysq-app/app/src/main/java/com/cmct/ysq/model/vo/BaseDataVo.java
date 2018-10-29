package com.cmct.ysq.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author shen
 * @date 2018/7/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("基础数据下载封装实体")
public class BaseDataVo {

    @ApiModelProperty("所有的路线（项目）")
    private List<RouteLine> lines;
    @ApiModelProperty("所有的施工标段")
    private List<RouteSection> sections;
    @ApiModelProperty("所有的隧道")
    private List<Tunnel> tunnels;
    @ApiModelProperty("所有的系统参数")
    private List<SysParam> sysParams;
    @ApiModelProperty("隧道和洞口关系")
    private List<TunnelHole> tunnelHoles;
    @ApiModelProperty("隧道和方向关系")
    private List<TunnelDir> tunnelDirs;
    @ApiModelProperty("隧道洞口和围岩级别关系")
    private List<TunnelHoleGrade> tunnelHoleGrades;

}
