package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lxb
 * @Date 2018/8/6 09:51
 * 描述:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("TunnelMsgSend")
public class TunnelMsgSendVo  {
    private String projectName;
    private String holeName;
    private String dir;

    private String msgId;
    private String projectId;
    private String tunnelId;
    private String direction;
    private String hole;
    private String msgType;
    private String constructionFunc;
    private String monitorProjectId;
    private String section;
    private String createBy;
    private Date createDate;
    private String modifyBy;
    private Date modifyDate;
    private Long deleteStatus;
    private Long status;
    private Long handlingWay;
}
