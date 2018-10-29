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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("路线表")
public class RouteLine {
    @ApiModelProperty("路线ID")
    private String lineId;
    @ApiModelProperty("路线名")
    private String lineName;
    @ApiModelProperty("路线状态")
    private String lineStatus;
    @ApiModelProperty("路线GPS")
    private String lineGps;
    @ApiModelProperty("创建时间")
    private Date createDate;
    @ApiModelProperty("修改时间")
    private Date updateDate;

}
