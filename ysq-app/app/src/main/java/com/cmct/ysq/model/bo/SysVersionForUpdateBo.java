
package com.cmct.ysq.model.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SysVersionForUpdateBo {

    @ApiModelProperty("版本名")
    private String versionName;
    @ApiModelProperty("版本编号")
    private String versionCode;
    @ApiModelProperty("版本描述")
    private String versionDescr;
    @ApiModelProperty("版本地址")
    private String versionUrl;
    @ApiModelProperty("pp类型，0是pad，1是查看，默认是0")
    private Integer type;


}
