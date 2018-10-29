package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 1
 */
public class TunnelProgressQualityCheckVo {

    private String id;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
    private Date date;
    @ApiModelProperty("检查项目id")
    private Integer checkTypeId;
    @ApiModelProperty("检查项目名")
    private String checkTypeName;

}
