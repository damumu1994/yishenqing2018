package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_msg")
public class TunnelMsg {

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
