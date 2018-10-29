/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 在线更新表
 *
 * @author losing
 * @Date 2016年8月18日
 * @since v0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysVersionVo {

    @ApiModelProperty("版本id")
    private Integer versionId;
    @ApiModelProperty("版本名")
    private String versionName;
    @ApiModelProperty("版本编号")
    private String versionCode;
    @ApiModelProperty("版本描述")
    private String versionDescr;
    @ApiModelProperty("版本地址")
    private String versionUrl;
    @ApiModelProperty("")
    private Date createDate;
    @ApiModelProperty("")
    private Date updateDate;
    @ApiModelProperty("0是pad，1是手机查看")
    private Integer type;


}
