
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
 * 在线更新表
 *
 * @author losing
 * @Date 2016年8月18日
 * @since v0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_tunnel_warn")
public class TunnelWarnPo {
@Id
  private String warnId;
  private String tunnelId;
  private String levelId;
  private Long monitorType;
  private Long warnType;
  private Double changeSpeedUpperLimit;
  private Double changeSpeedLowerLimit;
  private Long logicOperation;
  private Double nowMonitorValueUpperLimit;
  private Double nowMonitorValueLowerLimit;
  private Double val;
  private Long deleteStatus;
  private String createBy;
  private String modifyBy;
  private Date createDate;
  private Date modifyDate;


}
