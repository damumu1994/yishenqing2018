package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_user_link")
public class TunnelUserLinkPo {
  @Id
  private String tunnelUserLinkId;
  private String tunnelId;
  private String userId;
  private String roleId;
  private Long deleteStatus;
  private String createBy;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;


}
