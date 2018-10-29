package com.cmct.ysq.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_tunnel_inspection_report")
public class TunnelInspectionReportPO {
@Id
private String inspectionReportId;
  private String tunnelId;
  private Long direction;
  private Long hole;
  private String reportNumber;
  private Date checkTime;
  private String startPileNo;
  private String endPileNo;
  private String checkArea;
  private String originalRecordUrl;
  private Date createTime;
  private Date updateTime;
  private String createBy;
  private String updateBy;
  private Long deleteStatus;


}
