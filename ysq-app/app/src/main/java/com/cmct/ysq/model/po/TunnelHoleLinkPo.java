package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_hole_link")
public class TunnelHoleLinkPo {
@Id
  private String tunnelHoleLinkId;
  private String tunnelProId;
  private String paramId;
  private Long deleteStatus;


}
