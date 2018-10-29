package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokenVo {
    @ApiModelProperty("认证的响应结果")
    private AuthResponseVo authResponse;
    private SysUserVo sysUser;
}
