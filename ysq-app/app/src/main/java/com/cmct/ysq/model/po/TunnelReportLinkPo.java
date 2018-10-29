package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_tunnel_report_link")
public class TunnelReportLinkPo {

  private String reportTunnelLinkId;
  private String tunnelId;
  private String reportId;
  private Long deleteStatus;
  private String createBy;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;

}
