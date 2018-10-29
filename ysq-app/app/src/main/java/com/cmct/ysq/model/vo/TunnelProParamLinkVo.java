package com.cmct.ysq.model.vo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TunnelProParamLinkVo {
  private String tunnelProParamLinkId;
  private String tunnelProId;
  private String paramId;
  private Long deleteStatus;
  @ApiModelProperty("名称")
 private  String paramName;
}
