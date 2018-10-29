package com.cmct.ysq.model.where;


import com.cmct.common.bean.BaseWhere;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class TunnelGeoForcastWhere extends BaseWhere {
  // private String geoForcastId;
    private String forcastMethod;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
    private Long error;
  //----
  @ApiModelProperty("方向")
  private String direction;
    @ApiModelProperty("洞别")
    private String hole;
    @ApiModelProperty("隧道id")
    private String tunnelId;
}
