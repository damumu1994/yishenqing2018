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
@Table(name = "t_tunnel_project")
public class TunnelProjectPo {
@Id
  private String projectId;
  private String projectName;
  private String cityCode;
  private String createBy;
  private Date createDate;
  private String modifyBy;
  private Date modifyDate;
  private Long deleteStatus;
}
