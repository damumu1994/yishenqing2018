package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_info")
public class TunnelInfoPo {
@Id
  private String tunnelProId;
  private String tunnelName;
  private String sectionId;
  private String projectId;
  private String address;
  private String laneNum;
  private String tunnelType;
  private String des;
  private Date beginDate;
  private String otherInfo;
  private BigDecimal leftHoleStart;
  private BigDecimal leftHoleEnd;
  private BigDecimal rightHoleStart;
  private BigDecimal rightHoleEnd;
  private BigDecimal mainHoleStart;
  private BigDecimal mainHoleEnd;
  private BigDecimal guideHoleStart;
  private BigDecimal guideHoleEnd;
  private Long deleteStatus;
  private String createBy;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;

}
