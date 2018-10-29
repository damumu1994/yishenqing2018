package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_pro_depart_link")
public class TunnelProDepartLinkPo {
  private String otherId;
  private String tunnelProId;
  private String construction;
  private String consts;
  private String constBlocks;
  private String supervision;
  private String supervisionBlocks;
  private String monitor;
  private String monitorBlocks;
  private String designDep;
  private String otherDep;

}
