package com.cmct.ysq.model.po;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_cfg_way")
public class TunnelCfgWayPo {
@Id
  private String tunnelCfgId;
  private String tunnelId;
  private Long cfgWay;
  private String tunnelProParamLinkId;
  private Long deleteStatus;
  private String createBy;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;



}
