package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_msg_send")
public class TunnelMsgSend {

  private String msgSendId;
  private String smgId;
  private String createBy;
  private Date sendDate;
  private String modifyBy;
  private Date modifyDate;
  private Long deleteStatus;
  private String sendTo;
}
