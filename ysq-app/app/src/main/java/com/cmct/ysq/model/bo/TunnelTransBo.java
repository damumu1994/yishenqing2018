package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lxb
 * @Date 2018/7/26 09:53
 * 描述:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("pad端查询表")
public class TunnelTransBo extends BaseModelBo {
    @NotEmpty(message = "隧道id不能为空")
    @ApiModelProperty("隧道id")
    private String tunnelId;
    @ApiModelProperty("隧道方向id")
    private String tunnelProParamLinkId;
    @ApiModelProperty("隧道洞口方向")
    private String tunnelHoleLinkId;
    @ApiModelProperty("监测项目")
    private String monitoringProject;
}
