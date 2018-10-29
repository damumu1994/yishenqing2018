package com.cmct.ysq.model.where;


import com.cmct.common.bean.BaseWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TunnelMsgWhere extends BaseWhere {
  private String projectId;
  private String status;
  //----
  @ApiModelProperty("方向")
  private String direction;
    @ApiModelProperty("洞别")
    private String hole;
    @ApiModelProperty("隧道id")
    private String tunnelId;
}
