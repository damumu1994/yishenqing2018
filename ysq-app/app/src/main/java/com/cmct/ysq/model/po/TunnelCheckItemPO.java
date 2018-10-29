package com.cmct.ysq.model.po;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Table(name = "t_tunnel_check_item")
public class TunnelCheckItemPO {
  @Id
  private String checkItemId;
  private String inspectionReportId;
  private String check_project; //检查项
  private String checkResult;
  private String checkConclusion;
  private String remake;
  private Long sendErrorMsg;
  private Date createTime;
  private Long deleteStatus;
}
