package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 08:04:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("MSG")
public class TunnelMsgVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("主键")
    private String msgId;
    /**
     * 施工方法
     */
    private String projectName;
    private String tunnelName;
    private String holeName;
    private String directionName;
    private String createBy;
    private Date createDate;
    private Long status;

}
