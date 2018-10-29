package com.cmct.ysq.model.po;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author
 * @email 1
 * @date
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_work_alert")
public class TunnelWorkAlertPo {
@Id
  private String workAlertId;
  private String tunnelId;
  private Long firstLevel;
  private Long secondLevel;
  private Long deleteStatus;
  private String createBy;
  private Double val;
  private Double defVal;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;

}
