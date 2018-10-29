package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author shen
 * @date 2018/7/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("标段表")
public class RouteSection {
    @ApiModelProperty("路段ID")
    private String sectionId;
    @ApiModelProperty("所属路线ID")
    private String lineId;
    @ApiModelProperty("标段名")
    private String sectionName;
    @ApiModelProperty("路段状态")
    private String sectionStatus;
    @ApiModelProperty("路段GPS")
    private String sectionGps;
    @ApiModelProperty("创建时间")
    private Date createDate;
    @ApiModelProperty("修改时间")
    private Date updateDate;


}
